package cfh.ray.model.csg;

public record Hit(double t, int rgb) {

    public Hit {
        assert t > 0;
    }
}
