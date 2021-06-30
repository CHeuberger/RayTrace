package cfh.ray.model;

import java.awt.Color;
import java.awt.Rectangle;

import cfh.ray.gui.Model;
import cfh.ray.math.Vector;

public class TestModel implements Model {

    private final Rectangle r = new Rectangle(-50, -50, 100, 100);
    
    @Override
    public int trace(Vector position, Vector ray) {
        return r.contains(ray.y(), ray.z()) ? Color.WHITE.getRGB() : 0;
    }
}
