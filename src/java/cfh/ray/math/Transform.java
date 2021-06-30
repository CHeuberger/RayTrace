package cfh.ray.math;

import java.util.Formatter;

public class Transform {

    private final double[][] matrix = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1} };
    
    public Transform() {
    }
    
    public Transform(Transform other) {
        for (var i = 0; i < 4; i++) {
            for (var j = 0; j < 4; j++) {
                this.matrix[i][j] = other.matrix[i][j];
            }
        }
    }
    
    public Transform translate(double x, double y, double z) {
        matrix[0][3] += x;
        matrix[1][3] += y;
        matrix[2][3] += z;
        return this;
    }
    
    public Transform rotatePosX(double alpha) {
        var s = Math.sin(alpha);
        var c = Math.cos(alpha);
        for (var i = 0; i < 4; i++) {
            var v1 = c * matrix[i][1] + s * matrix[i][2];
            var v2 = c * matrix[i][2] - s * matrix[i][1];
            matrix[i][1] = v1;
            matrix[i][2] = v2;
        }
        return this;
    }
    
    public Transform rotatePosY(double alpha) {
        // TODO
        return this;
    }
    
    public Transform rotatePosZ(double alpha) {
        // TODO
        return this;
    }
    
    public Vector apply(Vector vector) {
        var result = new Vector();
        for (var i = 0; i < 4; i++) {
            double v = 0;
            for (var j = 0; j < 4; j++) {
                v += matrix[i][j] * vector.values[j];
            }
            result.values[i] = v;
        }
        for (var i = 0; i < 4; i++) {
            result.values[i] /= result.values[3];
        }
        return result;
    }
    
    @Override
    public String toString() {
        String symbols= "⎡⎢⎣⎤⎥⎦";
        try (var builder = new Formatter()) {
            builder.format("%s ", symbols.charAt(0));
            for (var j = 0; j < 4; j++) {
                builder.format("%5.2f ", matrix[0][j]);
            }
            builder.format("%s%n", symbols.charAt(3));
            for (var i = 1; i < 3; i++) {
                builder.format("%s ", symbols.charAt(1));
                for (var j = 0; j < 4; j++) {
                    builder.format("%5.2f ", matrix[i][j]);
                }
                builder.format("%s%n", symbols.charAt(4));
            }
            builder.format("%s ", symbols.charAt(2));
            for (var j = 0; j < 4; j++) {
                builder.format("%5.2f ", matrix[3][j]);
            }
            builder.format("%s", symbols.charAt(5));
            return builder.toString();
        }
    }
}
