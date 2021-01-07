abstract class Ship {
    private String _shape;
    private int _health;
    private int _positionX;
    private int _positionY;

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

    public int get_positionX() {
        return _positionX;
    }

    public int get_positionY() {
        return _positionY;
    }

    public void set_positionX(int positionX) {
        _positionX = positionX;
    }

    public void set_positionY(int positionY) {
        _positionY = positionY;
    }

    public abstract void shoot();
}
