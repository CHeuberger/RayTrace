package cfh.ray.model.csg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cfh.ray.math.Ray;
import cfh.ray.math.Vector;

class SphereTest {
    
    @Test
    void testSolve() {
        assertArrayEquals(new double[] { }, Sphere.solve(2, 0, 2));
        assertArrayEquals(new double[] { 2 }, Sphere.solve(1, -4, 4));
        assertArrayEquals(new double[] { -2, 1 }, Sphere.solve(1, 1, -2));
        assertArrayEquals(new double[] { 0, 2 }, Sphere.solve(2, -4, 0));
        assertArrayEquals(new double[] { 1/3d, 1/2d }, Sphere.solve(3, -2.5, 0.5));
    }
    
    @Test
    void testTraceNode() {
        fail("Not yet implemented");
    }

    @Test
    void testAnalytic() {
        var sphere = new Sphere();
        assertArrayEquals(new double[] { }, sphere.analytic(new Ray(new Vector(-5, 0, 0), new Vector(0, 1, 0))));
        assertArrayEquals(new double[] { }, sphere.analytic(new Ray(new Vector(-5, 0, 0), new Vector(0, 0, 1))));
        assertArrayEquals(new double[] { }, sphere.analytic(new Ray(new Vector(-5, 0, 0), new Vector(1, 0, 1))));

        assertArrayEquals(new double[] {5}, sphere.analytic(new Ray(new Vector(-5,  1,  0), new Vector(1, 0, 0))));
        assertArrayEquals(new double[] {5}, sphere.analytic(new Ray(new Vector(-5, -1,  0), new Vector(1, 0, 0))));
        assertArrayEquals(new double[] {5}, sphere.analytic(new Ray(new Vector(-5,  0,  1), new Vector(1, 0, 0))));
        assertArrayEquals(new double[] {5}, sphere.analytic(new Ray(new Vector(-5,  0, -1), new Vector(1, 0, 0))));
        
        assertArrayEquals(new double[] {4, 6}, sphere.analytic(new Ray(new Vector(-5, 0, 0), new Vector(1, 0, 0))));
        assertArrayEquals(new double[] {2, 3}, sphere.analytic(new Ray(new Vector(-5, 0, 0), new Vector(2, 0, 0))));
        assertArrayEquals(new double[] {-1, 1}, sphere.analytic(new Ray(new Vector(0, 0, 0), new Vector(1, 0, 0))));
        assertArrayEquals(new double[] {-1, 1}, sphere.analytic(new Ray(new Vector(0, 0, 0), new Vector(0, 1, 0))));
        assertArrayEquals(new double[] {-1, 1}, sphere.analytic(new Ray(new Vector(0, 0, 0), new Vector(0, 0, 1))));
    }

    @Test
    void testTrace() {
        fail("Not yet implemented");
    }

}
