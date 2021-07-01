package cfh.ray.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RayTest {

    @Test
    void testRay() {
        var ray = new Ray(new Vector(1, 2, 3), new Vector(-4, -5, -6));
        
        assertEquals(new Vector(1, 2, 3), ray.position());
        assertEquals(new Vector(-4, -5, -6), ray.direction());
    }
    
    @Test
    void testRayRay() {
        var ray = new Ray(new Vector(1, 2, 3), new Vector(-4, -5, -6));
        var clone = new Ray(ray);
        
        assertNotSame(ray, clone);
        
        assertEquals(new Vector(1, 2, 3), clone.position());
        assertEquals(new Vector(-4, -5, -6), clone.direction());
    }
    
    @Test
    void testEquals() {
        var ray = new Ray(new Vector(1, 2, 3), new Vector(-4, -5, -6));
        var clone = new Ray(ray);
        
        assertEquals(ray, ray);

        assertEquals(new Ray(new Vector(1, 2, 3), new Vector(-4, -5, -6)), ray);
        
        assertNotSame(ray, clone);
        assertEquals(ray, clone);
    }
}
