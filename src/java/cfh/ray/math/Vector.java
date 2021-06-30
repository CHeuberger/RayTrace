package cfh.ray.math;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Vector {
    
    final double[] values = {0, 0, 0, 1};
    
    public Vector() {
    }
    
    public Vector(double x, double y, double z) {
        values[0] = x;
        values[1] = y;
        values[2] = z;
    }
    
    public Vector(Vector other) {
        assert other.values[3] == 1;
        for (var i = 0; i < 4; i++) {
            this.values[i] = other.values[i];
        }
    }
    
    public double x() {
        assert values[3] == 1;
        return values[0];
    }
    
    public double y() {
        assert values[3] == 1;
        return values[1];
    }
    
    public double z() {
        assert values[3] == 1;
        return values[2];
    }
    
    public double size() {
        assert values[3] == 1;
        return Math.sqrt(values[0]*values[0] + values[1]*values[1] + values[2]*values[2]);
    }
    
    public Vector add(Vector other) {
        assert this.values[3] == 1;
        assert other.values[3] == 1;
        var result = new Vector();
        for (var i = 0; i < 3; i++) {
            result.values[i] = this.values[i] + other.values[i];
        }
        return result;
    }
    
    public Vector mult(double scalar) {
        assert values[3] == 1;
        var result = new Vector();
        for (var i = 0; i < 3; i++) {
            result.values[i] = values[i] * scalar;
        }
        return result;
    }
    
    public double dot(Vector other) {
        assert values[3] == 1;
        assert other.values[3] == 1;
        return values[0]*other.values[0] + values[1]*other.values[1] + values[2]*other.values[2];
    }
    
    public Vector cross(Vector other) {
        assert values[3] == 1;
        assert other.values[3] == 1;
        var x = values[1]*other.values[2] - values[2]*other.values[1];
        var y = values[2]*other.values[0] - values[0]*other.values[2];
        var z = values[0]*other.values[1] - values[1]*other.values[0];
        return new Vector(x, y, z);
    }
    
    @Override
    public int hashCode() {
        assert values[3] == 1;
        return Arrays.hashCode(values);
    }
    
    @Override
    public boolean equals(Object obj) {
        assert values[3] == 1;
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var other = (Vector) obj;
        assert other.values[3] == 1;
        return IntStream.range(0,  3).allMatch(i -> values[i]==other.values[i]);
    }
    
    @Override
    public String toString() {
        assert values[3] == 1;
        return String.format("<%.2f,%.2f,%.2f>", values[0], values[1], values[2]);
    }
}
