package cfh.ray.math;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Vector {
    
    private static final int X = 0;
    private static final int Y = 1;
    private static final int Z = 2;
    
    final double[] coords = {0, 0, 0};
    
    public Vector() {
    }
    
    public Vector(double x, double y, double z) {
        coords[X] = x;
        coords[Y] = y;
        coords[Z] = z;
    }
    
    public Vector(Vector other) {
        System.arraycopy(other.coords, 0, this.coords, 0, other.coords.length);
    }
    
    public double x() {
        return coords[X];
    }
    
    public double y() {
        return coords[Y];
    }
    
    public double z() {
        return coords[Z];
    }
    
    public double size() {
        return Math.sqrt(dot(this));
    }
    
    public Vector add(Vector other) {
        var result = new Vector();
        for (var i = 0; i < result.coords.length; i++) {
            result.coords[i] = this.coords[i] + other.coords[i];
        }
        return result;
    }
    
    public Vector sub(Vector other) {
        var result = new Vector();
        for (var i = 0; i < result.coords.length; i++) {
            result.coords[i] = this.coords[i] - other.coords[i];
        }
        return result;
    }
    
    public Vector add(double x, double y, double z) {
        return new Vector(coords[X]+x, coords[Y]+y, coords[Z]+z);
    }
    
    public Vector mult(double scalar) {
        var result = new Vector();
        for (var i = 0; i < result.coords.length; i++) {
            result.coords[i] = coords[i] * scalar;
        }
        return result;
    }
    
    public double dot(Vector other) {
        return this.coords[X]*other.coords[X] + this.coords[Y]*other.coords[Y] + this.coords[Z]*other.coords[Z];
    }
    
    public Vector cross(Vector other) {
        var x = coords[Y]*other.coords[Z] - coords[Z]*other.coords[Y];
        var y = coords[Z]*other.coords[X] - coords[X]*other.coords[Z];
        var z = coords[X]*other.coords[Y] - coords[Y]*other.coords[X];
        return new Vector(x, y, z);
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(coords);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var other = (Vector) obj;
        return IntStream.range(0,  this.coords.length).allMatch(i -> this.coords[i]==other.coords[i]);
    }
    
    @Override
    public String toString() {
        return String.format("<%.2f,%.2f,%.2f>", coords[X], coords[Y], coords[Z]);
    }
}
