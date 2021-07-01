package cfh.ray.math;

import java.util.Formatter;

public class Matrix {

    private static final String symbols= "⎡⎢⎣⎤⎥⎦";
    
    private final double[][] values = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
    };
    
    public Matrix() {
    }

    public Matrix(Matrix other) {
        for (var i = 0; i < other.values.length; i++) {
            for (var j = 0; j < 3; j++) {
                this.values[i][j] = other.values[i][j];
            }
        }
    }
    
    @Override
    public String toString() {
        try (var builder = new Formatter()) {
            builder.format("%s ", symbols.charAt(0));
            for (var j = 0; j < 4; j++) {
                builder.format("%5.2f ", values[0][j]);
            }
            builder.format("%s%n", symbols.charAt(3));
            for (var i = 1; i < 3; i++) {
                builder.format("%s ", symbols.charAt(1));
                for (var j = 0; j < 4; j++) {
                    builder.format("%5.2f ", values[i][j]);
                }
                builder.format("%s%n", symbols.charAt(4));
            }
            builder.format("%s ", symbols.charAt(2));
            for (var j = 0; j < 4; j++) {
                builder.format("%5.2f ", values[3][j]);
            }
            builder.format("%s", symbols.charAt(5));
            return builder.toString();
        }
    }
}
