public class Map {
    private int _distanceX;
    private int _distanceY;

    public Map(int X, int Y){
        _distanceX = X;
        _distanceY = Y;
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

    public void getMap() {

        for (int i = 0; i < get_distanceY(); i ++){
            System.out.println();
            for (int j = 0; j < get_distanceX(); j ++){
                System.out.print("X");
            }
        }

    }
}
