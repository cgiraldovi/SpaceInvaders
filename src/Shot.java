public class Shot {
    private String _forma = "o";
    private int _damage;
    protected int _positionX;
    protected int _positionY;

    public Shot(int positionX, int positionY) {
        set_positionX(positionX-1);
        set_positionY(positionY + 1);
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

    public String get_forma() {
        return _forma;
    }

}
