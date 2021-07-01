package cfh.ray.model.csg;

import cfh.ray.gui.Model;
import cfh.ray.math.Ray;

public class CSGModel implements Model {

    private final Node root;
    
    public CSGModel(Node root) {
        this.root = root;
    }
    
    @Override
    public int trace(Ray ray) {
        var hit = root.trace(ray);
        return hit == null || hit.t() <=0 ? 0 : hit.rgb();
    }

}
