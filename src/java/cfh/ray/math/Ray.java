package cfh.ray.math;

public record Ray(Vector position, Vector direction) {

    public Ray {
    }
    
    public Ray(Ray ray) {
        this(ray.position, ray.direction);
    }
}
