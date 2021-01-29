abstract class Shot {
    protected String _shape = "o";
    protected int _damage = 1;
    protected int _positionX;
    protected int _positionY;

    public Shot(int positionX, int positionY) {
        set_positionX(positionX);
        set_positionY(positionY);
    }

    public void set_positionY(int positionY) {
        _positionY = positionY;
    }

    public void set_positionX(int positionX) {
        _positionX = positionX;
    }

    public int get_positionY() {
        return _positionY;
    }

    public int get_positionX() {
        return _positionX;
    }

    public int get_damage() {
        return _damage;
    }

    public String get_shape() {
        return _shape;
    }

    abstract void move();


}
