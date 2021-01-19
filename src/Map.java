public class Map {
    private int _distanceX;
    private int _distanceY;

    public Map(int X, int Y){

        set_distanceX(X);
        set_distanceY(Y);
    }

    public int get_distanceX() {
        return _distanceX;
    }

    public int get_distanceY() {
        return _distanceY;
    }

    public void set_distanceX(int distanceX) {
        _distanceX = distanceX;
    }

    public void set_distanceY(int distanceY) {
        _distanceY = distanceY;
    }

}
