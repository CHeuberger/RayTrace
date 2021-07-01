package cfh.ray.model.csg;

import java.awt.Color;

import cfh.ray.math.Ray;

public class Cube extends Node {

    @Override
    protected Hit traceNode(Ray ray) {
        var p = ray.position();
        var d = ray.direction();

        double t = Double.NaN;
        int rgb = 0;
        
        if (d.x() != 0) {
            var tx = (p.x() + Math.signum(d.x())) / -d.x();
            var y = p.y() + tx * d.y();
            var z = p.z() + tx * d.z();
            if (tx > 0 && -1 <= y && y <= 1 && -1 <= z && z <= 1) {
                t = tx;
                rgb = (d.x() > 0 ? Color.RED : Color.CYAN).getRGB();
            }
        }
        
        if (d.y() != 0) {
            var ty = (p.y() + Math.signum(d.y())) / -d.y();
            var x = p.x() + ty * d.x();
            var z = p.z() + ty * d.z();
            if (ty > 0 && -1 <= x && x <= 1 && -1 <= z && z <= 1 && !(ty >= t)) {  // checking NaN
                t = ty;
                rgb = (d.y() > 0 ? Color.GREEN : Color.MAGENTA).getRGB();
            }
        }
        
        if (d.z() != 0) {
            var tz = (p.z() + Math.signum(d.z())) / -d.z();
            var x = p.x() + tz * d.x();
            var y = p.y() + tz * d.y();
            if (tz > 0 && -1 <= x && x <= 1 && -1 <= y && y <= 1 && !(tz >= t)) {  // checking NaN
                t = tz;
                rgb = (d.z() > 0 ? Color.BLUE : Color.YELLOW).getRGB();
            }
        }
        
        return Double.isNaN(t) ? null : new Hit(t, rgb);
    }
}
