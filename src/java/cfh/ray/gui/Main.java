package cfh.ray.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import cfh.ray.math.Vector;
import cfh.ray.model.csg.CSGModel;
import cfh.ray.model.csg.Sphere;

public class Main {

    public static void main(String[] args) {
        new Main();
    }
    
    private final Model model;
    
    private Main() {
        model = createModel();
        SwingUtilities.invokeLater(this::initGUI);
    }
    
    private Model createModel() {
        var sphere = switch (0) {
            case 0 -> new Sphere();
            default -> throw new IllegalArgumentException("not yet implemented");
        };
        return new CSGModel(sphere);
    }
    
    private void initGUI() {
        var camera = new Camera(model, 200, 200)
            .position(new Vector(-2, 0, 0))
            .direction(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
        
        var frame = new JFrame();
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.add(camera);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        SwingUtilities.invokeLater(() -> camera.trace());
    }
}
