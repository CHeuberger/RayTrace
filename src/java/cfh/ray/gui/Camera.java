package cfh.ray.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Objects;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

import cfh.ray.math.Ray;
import cfh.ray.math.Vector;

public class Camera extends JPanel {

    private final Model model;
    private final BufferedImage image;
    
    private Vector position;
    private Vector direction;
    private Vector up;
    private Vector right;
    
    private TraceWorker worker = null;
    
    public Camera(Model model, int width, int height) {
        this.model = Objects.requireNonNull(model);
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        clearImage();
    }

    public Camera position(Vector v) {
        position = v;
        return this;
    }
    
    public Camera direction(Vector dir, Vector up) {
        return direction(dir, up, dir.cross(up));
    }
    
    public Camera direction(Vector dir, Vector up, Vector right) {
        this.direction = dir;
        this.up = up;
        this.right = right;
        return this;
    }
    
    private void clearImage() {
        var g = image.createGraphics();
        try {
            g.setBackground(Color.DARK_GRAY);
            g.clearRect(0, 0, image.getWidth(), image.getHeight());
        } finally {
            g.dispose();
        }
    }
    
    public synchronized void trace() {
        if (worker == null) {
            clearImage();
            worker = new TraceWorker();
            worker.execute();
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(), image.getHeight());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    private class TraceWorker extends SwingWorker<Void, Void> {

        private final Void[] EMPTY = new Void[0];
        
        @Override
        protected Void doInBackground() throws Exception {
            var w = image.getWidth() / 2;
            var h = image.getHeight() / 2;
            for (var y = -h; y < h; y++) {
                var du = up.mult((double)y/h);
                for (var x = -w; x < w; x++) {
                    var dr = right.mult((double)x/w);
                    var dir = direction.add(du).add(dr);
//                    System.out.println(position + "    " + ray);
                    var rgb = model.trace(new Ray(position, dir));
                    image.setRGB(w+x, h-y-1, rgb);
                }
                publish(EMPTY);
            }
            return null;
        }
        
        @Override
        protected void process(List<Void> chunks) {
            repaint();
        }
        
        @Override
        protected void done() {
            try {
                get();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            worker = null;
        }
    }
}
