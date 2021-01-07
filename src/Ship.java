abstract class Ship {
    private String _shape;
    private int _health;

    public Ship (String forma, int health){
        _shape = forma;
        _health = health;
    }

    public int get_health() {
        return _health;
    }

    public String get_shape() {
        return _shape;
    }

    public void set_shape(String Forma) {
        _shape = Forma;
    }

    public void set_health(int health) {
        _health = health;

    }
    public abstract void shoot();
}
