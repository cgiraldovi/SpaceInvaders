public class Shot {
    private String _forma = "o";
    private int _damage;
    private int _positionX;
    private int _positionY;

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

    public String get_forma() {
        return _forma;
    }

    public void play(){

    }
}
