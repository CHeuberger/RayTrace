package cfh.ray.model.csg;

import cfh.ray.gui.Model;
import cfh.ray.math.Vector;

public class CSGModel implements Model {

    private final Node root;
    
    public CSGModel(Node root) {
        this.root = root;
    }
    
    @Override
    public int trace(Vector position, Vector ray) {
        return root.trace(position, ray);
    }

}
