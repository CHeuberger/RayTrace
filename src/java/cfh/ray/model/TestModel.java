package cfh.ray.model;

import java.awt.Color;
import java.awt.Rectangle;

import cfh.ray.gui.Model;
import cfh.ray.math.Ray;

public class TestModel implements Model {

    private final Rectangle r = new Rectangle(-50, -50, 100, 100);
    
    @Override
    public int trace(Ray ray) {
        return r.contains(ray.direction().y(), ray.direction().z()) ? Color.WHITE.getRGB() : 0;
    }
}
