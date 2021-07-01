package cfh.ray.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransformTest {

    @Test
    void testTransform() {
        var transform = new Transform();
        var ray = new Ray(new Vector(1, 0, 0), new Vector(0, 1, 0));
        
        assertEquals(ray, transform.reverse(ray));
    }

    @Test
    void testTransformTransform() {
        fail("Not yet implemented");
    }

    @Test
    void testTranslate() {
        var transform = new Transform();
        var ray = new Ray(new Vector(1, 0, 0), new Vector(0, 1, 0));
        
        transform.translate(0, 0, 0);
        assertEquals(ray, transform.reverse(ray));
        
        transform.translate(1, 2, 4);
        var expected = new Ray(new Vector(0, -2, -4), ray.direction());
        assertEquals(expected, transform.reverse(ray));
    }

    @Test
    void testRotateX() {
        var transform = new Transform();
        var ray = new Ray(new Vector(0, 0, 2), new Vector(0, 3, 0));
        Ray test;
        
        transform.rotateX(0);
        assertEquals(ray, transform.reverse(ray));
        
        transform.rotateX(Math.PI/2);
        test = transform.reverse(ray);
        assertEquals( 0, test.position().x(), 1e-4);
        assertEquals( 2, test.position().y(), 1e-4);
        assertEquals( 0, test.position().z(), 1e-4);
        assertEquals( 0, test.direction().x(), 1e-4);
        assertEquals( 0, test.direction().y(), 1e-4);
        assertEquals(-3, test.direction().z(), 1e-4);
        
        transform.rotateX(Math.PI/2);
        test = transform.reverse(ray);
        assertEquals( 0, test.position().x(), 1e-4);
        assertEquals( 0, test.position().y(), 1e-4);
        assertEquals(-2, test.position().z(), 1e-4);
        assertEquals( 0, test.direction().x(), 1e-4);
        assertEquals(-3, test.direction().y(), 1e-4);
        assertEquals( 0, test.direction().z(), 1e-4);
    }

    @Test
    void testRotateY() {
        fail("Not yet implemented");
    }

    @Test
    void testRotateZ() {
        fail("Not yet implemented");
    }
    
    @Test
    void testReverse() {
        // TODO tested above ?
        fail("Not yet implemented");
    }
}
