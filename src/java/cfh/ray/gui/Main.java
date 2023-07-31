package cfh.ray.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import cfh.ray.math.Vector;
import cfh.ray.model.csg.CSGModel;
import cfh.ray.model.csg.Cube;
import cfh.ray.model.csg.Sphere;
import cfh.ray.model.csg.Union;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main()::initGUI);
    }
    
    private final Model model;
    
    private Main() {
        model = createModel();
    }
    
    private Model createModel() {
        var root = switch (231) {
            case 110 -> new Sphere();
            case 111 -> new Sphere().rotateZ(Math.PI/2);
            case 120 -> new Union(new Sphere(), new Sphere().translate(1, 0, 0));
            case 121 -> new Union(new Sphere(), new Sphere().rotateZ(Math.PI/2).translate(1, 0, 0));
            case 130 -> new Union(
                new Sphere(), 
                new Union(
                    new Sphere().translate(1, 0, 0), 
                    new Sphere().translate(0, 1, -0.7)));
            case 210 -> new Cube();
            case 221 -> new Cube().rotateX(Math.PI/2);
            case 222 -> new Cube().rotateX(Math.PI);
            case 223 -> new Cube().rotateX(-Math.PI/2);
            case 224 -> new Cube().rotateY(Math.PI/2);
            case 226 -> new Cube().rotateY(-Math.PI/2);
            case 230 -> new Union(new Sphere(), new Cube().translate(0, 0, -0.7));
            case 231 -> new Union(new Sphere(), new Cube().translate(0, 0, -0.7)).rotateY(0.8);
            default  -> throw new IllegalArgumentException("not yet implemented");
        };
        return new CSGModel(root);
    }
    
    private void initGUI() {
        var camera = new Camera(model, 400, 400)
            .position(new Vector(0, 0, 2))
            .direction(new Vector(0, 0, -1), new Vector(0, 1, 0), new Vector(1, 0, 0));
        
        var frame = new JFrame();
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.add(camera);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        SwingUtilities.invokeLater(() -> camera.trace());
    }
}
