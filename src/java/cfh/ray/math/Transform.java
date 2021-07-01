package cfh.ray.math;

public class Transform {

    private static final int X = 0;
    private static final int Y = 1;
    private static final int Z = 2;
    
    private final double[] translation = {0, 0, 0};
    private final double[][] rotation = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1},
    };
    
    public Transform() {
    }
    
    public Transform(Transform other) {
        System.arraycopy(other.translation, 0, this.translation, 0, other.translation.length);
        for (var i = 0; i < other.rotation.length; i++) {
            System.arraycopy(other.translation, 0, this.translation, 0, other.translation.length);
        }
    }
    
    public Transform translate(double x, double y, double z) {
        translation[X] += x;
        translation[Y] += y;
        translation[Z] += z;
        return this;
    }
    
    public Transform rotateX(double alpha) {
        var s = Math.sin(alpha);
        var c = Math.cos(alpha);
        for (var i = 0; i < rotation.length; i++) {
            var y = c * rotation[i][Y] + s * rotation[i][Z];
            var z = c * rotation[i][Z] - s * rotation[i][Y];
            rotation[i][Y] = y;
            rotation[i][Z] = z;
        }
        return this;
    }
    
    public Transform rotateY(double alpha) {
        var s = Math.sin(alpha);
        var c = Math.cos(alpha);
        for (var i = 0; i < rotation.length; i++) {
            var x = c * rotation[i][X] + s * rotation[i][Z];
            var z = c * rotation[i][Z] - s * rotation[i][X];
            rotation[i][X] = x;
            rotation[i][Z] = z;
        }
        return this;
    }
    
    public Transform rotateZ(double alpha) {
        var s = Math.sin(alpha);
        var c = Math.cos(alpha);
        for (var i = 0; i < rotation.length; i++) {
            var x = c * rotation[i][X] + s * rotation[i][Y];
            var y = c * rotation[i][Y] - s * rotation[i][X];
            rotation[i][X] = x;
            rotation[i][Y] = y;
        }
        return this;
    }

    public Ray reverse(Ray ray) {
        var p = ray.position().coords;
        var d = ray.direction().coords;
        var p1 = new double[p.length];
        var d1 = new double[d.length];
        for (var i = 0; i < rotation.length; i++) {
            for (var j = 0; j < p.length; j++) {
                p1[i] += (p[j]-translation[j]) * rotation[j][i];
                d1[i] += d[j] * rotation[j][i];
            }
//            p1[i] -= translation[i];
        }
        return new Ray(new Vector(p1[X], p1[Y], p1[Z]), new Vector(d1[X], d1[Y], d1[Z]));
    }

    @Override
    public String toString() {
        return translation + "\n" + rotation;
    }
}
