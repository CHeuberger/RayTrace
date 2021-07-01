package cfh.ray.model.csg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cfh.ray.math.Ray;
import cfh.ray.math.Vector;

class CubeTest {

    @Test
    void testTraceNode() {
        var cube = new Cube();
        Hit hit;
        
        hit = cube.traceNode(new Ray(new Vector(5, 0, 0), new Vector(1, 0, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(5, 0, 0), new Vector(0, 1, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(5, 0, 0), new Vector(0, -1, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(5, 0, 0), new Vector(0, 0, 1)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(5, 0, 0), new Vector(0, 0, -1)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(5, 0, 0), new Vector(-1, 0, 0)));
        assertNotNull(hit);
        assertEquals(4.0, hit.t(), 1e-4);
        assertNotEquals(0, hit.rgb());
        
        
        hit = cube.traceNode(new Ray(new Vector(-5, 0, 0), new Vector(-1, 0, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(-5, 0, 0), new Vector(0, 1, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(-5, 0, 0), new Vector(0, -1, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(-5, 0, 0), new Vector(0, 0, 1)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(-5, 0, 0), new Vector(0, 0, -1)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(-5, 0, 0), new Vector(1, 0, 0)));
        assertNotNull(hit);
        assertEquals(4.0, hit.t(), 1e-4);
        assertNotEquals(0, hit.rgb());
        
        
        hit = cube.traceNode(new Ray(new Vector(0, 5, 0), new Vector(1, 0, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(0, 5, 0), new Vector(-1, 0, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(0, 5, 0), new Vector(0, 1, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(0, 5, 0), new Vector(0, 0, 1)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(0, 5, 0), new Vector(0, 0, -1)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(0, 5, 0), new Vector(0, -1, 0)));
        assertNotNull(hit);
        assertEquals(4.0, hit.t(), 1e-4);
        assertNotEquals(0, hit.rgb());
        
        
        hit = cube.traceNode(new Ray(new Vector(0, 0, 5), new Vector(1, 0, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(0, 0, 5), new Vector(-1, 0, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(0, 0, 5), new Vector(0, 1, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(0, 0, 5), new Vector(0, -1, 0)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(0, 0, 5), new Vector(0, 0, 1)));
        assertEquals(null, hit);
        
        hit = cube.traceNode(new Ray(new Vector(0, 0, 5), new Vector(0, 0, -1)));
        assertNotNull(hit);
        assertEquals(4.0, hit.t(), 1e-4);
        assertNotEquals(0, hit.rgb());
        
        
        hit = cube.traceNode(new Ray(new Vector(-2, 0.99, 0), new Vector(1, 0, 0)));
        assertNotNull(hit);
        assertEquals(1.0, hit.t(), 1e-4);
        assertNotEquals(0, hit.rgb());
        
        hit = cube.traceNode(new Ray(new Vector(-2, -0.99, 0), new Vector(1, 0, 0)));
        assertNotNull(hit);
        assertEquals(1.0, hit.t(), 1e-4);
        assertNotEquals(0, hit.rgb());
        
        hit = cube.traceNode(new Ray(new Vector(-2, 0, 0.99), new Vector(1, 0, 0)));
        assertNotNull(hit);
        assertEquals(1.0, hit.t(), 1e-4);
        assertNotEquals(0, hit.rgb());
        
        hit = cube.traceNode(new Ray(new Vector(-2, 0, -0.99), new Vector(1, 0, 0)));
        assertNotNull(hit);
        assertEquals(1.0, hit.t(), 1e-4);
        assertNotEquals(0, hit.rgb());
        
        hit = cube.traceNode(new Ray(new Vector(-2, 0, 0), new Vector(1, 0.99, 0)));
        assertNotNull(hit);
        assertEquals(1.0, hit.t(), 1e-4);
        assertNotEquals(0, hit.rgb());
        
        hit = cube.traceNode(new Ray(new Vector(-2, 0, 0), new Vector(1, 0, -0.99)));
        assertNotNull(hit);
        assertEquals(1.0, hit.t(), 1e-4);
        assertNotEquals(0, hit.rgb());
    }
}
