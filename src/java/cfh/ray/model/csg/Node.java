package cfh.ray.model.csg;

import cfh.ray.math.Ray;
import cfh.ray.math.Transform;

public abstract class Node {

    private final Transform transform = new Transform();

    public final Hit trace(Ray ray) {
        var rr = transform.reverse(ray);
        return traceNode(rr);
    }
    
    protected abstract Hit traceNode(Ray ray);
    
    public Node translate(double x, double y, double z) {
        transform.translate(x, y, z);
        return this;
    }
    
    public Node rotateX(double alpha) {
        transform.rotateX(alpha);
        return this;
    }
    
    public Node rotateZ(double alpha) {
        transform.rotateZ(alpha);
        return this;
    }
    
    @Override
    public String toString() {
        return transform.toString();
    }
}
