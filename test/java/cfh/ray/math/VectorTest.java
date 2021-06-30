package cfh.ray.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VectorTest {
    
    @Test
    void testVector() {
        var vector = new Vector();
        
        assertEquals(0, vector.x());
        assertEquals(0, vector.y());
        assertEquals(0, vector.z());
    }

    @Test
    void testVectorDoubleDoubleDouble() {
        var vector = new Vector(1, -20, 300);
        
        assertEquals(  1, vector.x());
        assertEquals(-20, vector.y());
        assertEquals(300, vector.z());
    }

    @Test
    void testVectorVector() {
        var vector1 = new Vector(100, 20, 3);
        var vector2 = new Vector(vector1);
        
        assertEquals(false, vector1 == vector2);
        assertEquals(true, vector1.equals(vector2));
    }

    @Test
    void testX() {
        // tested in constructor tests
    }

    @Test
    void testY() {
        // tested in constructor tests
    }

    @Test
    void testZ() {
        // tested in constructor tests
    }

    @Test
    void testSize() {
        assertEquals(0.0, new Vector().size());
        assertEquals(1.0, new Vector(1, 0, 0).size());
        assertEquals(2.0, new Vector(0, 2, 0).size());
        assertEquals(3.0, new Vector(0, 0, 3).size());
        assertEquals(7.0, new Vector(2, 3, 6).size());
    }

    @Test
    void testAdd() {
        var vector = new Vector();
        
        assertEquals(new Vector(10, 0, 0), vector = vector.add(new Vector(10, 0, 0)));
        assertEquals(new Vector(10, 200, 0), vector = vector.add(new Vector(0, 200, 0)));
        assertEquals(new Vector(10, 200, 3_000), vector = vector.add(new Vector(0, 0, 3_000)));
        assertEquals(new Vector(), vector.add(new Vector(-10, -200, -3_000)));
    }

    @Test
    void testMult() {
        var vector = new Vector(1, -2, 3);
        
        assertEquals(new Vector(10, -20, 30), vector = vector.mult(10));
        assertEquals(new Vector(-5, 10, -15), vector = vector.mult(-0.5));
    }
    
    @Test
    void testDot() {
        var zero = new Vector();
        var x = new Vector(1, 0, 0);
        var y = new Vector(0, 1, 0);
        var xz = new Vector(3, 0, 4);
        var vector = new Vector(2, 3, 6);
        
        assertEquals(0, zero.dot(zero));
        assertEquals(0, zero.dot(x));
        assertEquals(0, x.dot(y));
        assertEquals(0, y.dot(zero));
        
        assertEquals(3, xz.dot(x));
        assertEquals(3, x.dot(xz));
        assertEquals(0, xz.dot(y));
        assertEquals(0, y.dot(xz));
        assertEquals(25, xz.dot(xz));
        
        assertEquals(2, vector.dot(x));
        assertEquals(3, y.dot(vector));
        assertEquals(49, vector.dot(vector));
        
        assertEquals(0.5+10+250, new Vector(1, 10, 100).dot(new Vector(0.5, 1.0, 2.5)));
    }
    
    @Test
    void testCross() {
        assertEquals(new Vector( 0,  0,  1), new Vector( 1,  0,  0).cross(new Vector( 0,   1,  0)));
        assertEquals(new Vector( 0,  0, -2), new Vector( 0,  1,  0).cross(new Vector( 2,   0,  0)));
        assertEquals(new Vector( 0,  3,  0), new Vector(-1,  0,  0).cross(new Vector( 0,   0,  3)));
        assertEquals(new Vector( 0, -4,  0), new Vector( 0,  0,  2).cross(new Vector(-2,   0,  0)));
        assertEquals(new Vector(-5,  0,  0), new Vector( 0,  0, 10).cross(new Vector( 0, 0.5,  0)));
        assertEquals(new Vector( 6,  0,  0), new Vector( 0, -3,  0).cross(new Vector( 0,   0, -2)));
    }
    

    @Test
    void testEqualsObject() {
        var zero = new Vector();
        assertEquals(true, zero.equals(zero));
        assertEquals(true, zero.equals(new Vector(zero)));
        assertEquals(false, zero.equals(new Vector(1, 0, 0)));
        assertEquals(false, zero.equals(new Vector(0, 2, 0)));
        assertEquals(false, zero.equals(new Vector(0, 0, 3)));
    }
    
    @Test
    void testHashCode() {
        var zero = new Vector();
        assertEquals(zero.hashCode(), zero.hashCode());
        assertEquals(zero.hashCode(), new Vector(zero).hashCode());
        assertNotEquals(zero.hashCode(), new Vector(1,  0,   0).hashCode());
        assertNotEquals(zero.hashCode(), new Vector(0, -1,   0).hashCode());
        assertNotEquals(zero.hashCode(), new Vector(0,  0, 0.3).hashCode());
    }
}
