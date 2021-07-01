package cfh.ray.model.csg;

import cfh.ray.math.Ray;

public class Sphere extends Node {

    @Override
    protected Hit traceNode(Ray ray) {
        var t = analytic(ray);
        
        // TODO Auto-generated method stub
        switch (t.length) {
            case 2:
                var u = ray.direction().size();
                var s = (t[1]-t[0]) * u / 2;
                var c = (int) Math.min(s * 255, 255);
                return new Hit(t[0], c * 0x010101);
            default:
                return null;
        }
    }

    static double[] analytic(Ray ray) {
        var a = ray.direction().dot(ray.direction());
        var b = 2 * ray.direction().dot(ray.position());
        var c = ray.position().dot(ray.position()) - 1;
        return solve(a, b, c);
    }
    
    static double[] solve(double a, double b, double c) {
        assert a > 0;
        var d = b*b - 4*a*c;
        if (d < 0) return new double[] { };
        else if (d == 0) return new double[] { -b / (2*a) };
        else {
            var dd = Math.sqrt(d);
            return new double[] {
                    (-b - dd) / (2*a),
                    (-b + dd) / (2*a)
            };
        }
    }
    
    @Override
    public String toString() {
        return "Sphere " + super.toString();
    }
}
