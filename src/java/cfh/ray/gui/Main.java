package cfh.ray.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import cfh.ray.math.Vector;
import cfh.ray.model.csg.CSGModel;
import cfh.ray.model.csg.Sphere;
import cfh.ray.model.csg.Union;

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
        var sphere = switch (21) {
            case 10 -> new Sphere();
            case 11 -> new Sphere().rotateZ(Math.PI/2);
            case 20 -> new Union(new Sphere(), new Sphere().translate(1, 0, 0));
            case 21 -> new Union(new Sphere(), new Sphere().rotateZ(Math.PI/2).translate(1, 0, 0));
            case 30-> new Union(new Sphere(), 
                                new Union(new Sphere().translate(1, 0, 0), 
                                          new Sphere().translate(0, 1, -0.7)));
            default -> throw new IllegalArgumentException("not yet implemented");
        };
        return new CSGModel(sphere);
    }
    
    private void initGUI() {
        var camera = new Camera(model, 200, 200)
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
