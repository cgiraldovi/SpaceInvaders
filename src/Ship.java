abstract class Ship {
    protected String _shape;
    protected int _health;
    protected int _positionX;
    protected int _positionY;

    public Ship (int health){
        set_health(health);
    }

    public int get_health() {
        return _health;
    }

    public String get_shape() {
        return _shape;
    }

    public void set_shape(String shape) {
        _shape = shape;
    }

    public void set_health(int health) {
        _health = health;
    }

    public int get_positionX() {
        return _positionX;
    }

    public int get_positionY() {
        return _positionY;
    }

    public abstract void set_positionX(int positionX);

    public abstract void set_positionY(int positionY);

    public abstract void shoot();
}
