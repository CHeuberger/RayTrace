package cfh.ray.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransformTest {

    @Test
    void testTransform() {
        var test = new Transform();
        
        assertEquals(new Vector( 1,  0,  0), test.apply(new Vector( 1,  0,  0)));
        assertEquals(new Vector( 0, -2,  0), test.apply(new Vector( 0, -2,  0)));
        assertEquals(new Vector( 0,  0,  3), test.apply(new Vector( 0,  0,  3)));
    }

    @Test
    void testTransformTransform() {
        var test = new Transform(new Transform().translate(1, 20, 300));
        
        assertEquals(new Vector( 2, 20, 300), test.apply(new Vector( 1,  0,  0)));
        assertEquals(new Vector( 1, 18, 300), test.apply(new Vector( 0, -2,  0)));
        assertEquals(new Vector( 1, 20, 303), test.apply(new Vector( 0,  0,  3)));
    }

    @Test
    void testTranslate() {
        var zero = new Vector();
        var test = new Transform();
        
        assertEquals(new Vector(0, 0, 0), test.apply(zero));

        test.translate(-10, 0, 0);
        assertEquals(new Vector(-10, 0, 0), test.apply(zero));
        assertEquals(new Vector(0, 0, 0), zero);
        
        test.translate(20, 20, 0);
        assertEquals(new Vector(10, 20, 0), test.apply(zero));
        assertEquals(new Vector(0, 0, 0), zero);
        
        test.translate(0, 0, 30);
        assertEquals(new Vector(10, 20, 30), test.apply(zero));
        assertEquals(new Vector(0, 0, 0), zero);
    }

    @Test
    void testRotatePosX() {
        var x = new Vector(10,  0,  0);
        var y = new Vector( 0, 20,  0);
        var z = new Vector( 0,  0, 30);
        var test = new Transform();
        
        test.rotatePosX(0);
        assertEquals(x, test.apply(x));
        assertEquals(y, test.apply(y));
        assertEquals(z, test.apply(z));
        
        test.rotatePosX(Math.PI/2);
        assertEquals(x, test.apply(x));
        assertEquals(new Vector(0, 0, 20).toString(), test.apply(y).toString());
        assertEquals(new Vector(0, -30, 0).toString(), test.apply(z).toString());

        assertEquals(new Vector(10,  0,  0), x);
        assertEquals(new Vector( 0, 20,  0), y);
        assertEquals(new Vector( 0,  0, 30), z);
    }

    @Test
    void testRotatePosY() {
        fail("Not yet implemented");
    }

    @Test
    void testRotatePosZ() {
        fail("Not yet implemented");
    }

    @Test
    void testAply() {
        // tested by other methods
    }
}
