package cfh.ray.model.csg;

import cfh.ray.math.Transform;
import cfh.ray.math.Vector;

public abstract class Node {

    private final Transform transform = new Transform();
    
    public final Hit trace(Vector position, Vector ray) {
        return traceNode(position, ray);
    }
    
    protected abstract Hit traceNode(Vector position, Vector ray);
    
    @Override
    public String toString() {
        return transform.toString();
    }
}
