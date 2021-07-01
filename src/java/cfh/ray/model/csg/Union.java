package cfh.ray.model.csg;

import java.util.Objects;

import cfh.ray.math.Ray;

public class Union extends Node {

    private final Node node1;
    private final Node node2;
    
    public Union(Node node1, Node node2) {
        this.node1 = Objects.requireNonNull(node1);
        this.node2 = Objects.requireNonNull(node2);
    }
    
    @Override
    protected Hit traceNode(Ray ray) {
        var hit1 = node1.trace(ray);
        var hit2 = node2.trace(ray);
        if (hit1 == null) {
            return hit2;
        }
        if (hit2 == null) {
            return hit1;
        }
        return hit1.t() < hit2.t() ? hit1 : hit2;
    }

}
