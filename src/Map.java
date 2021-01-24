public class Map {
    private int _distanceX;
    private int _distanceY;
    private String[][] _matriz;

    public Map(int X, int Y){
        set_distanceX(X);
        set_distanceY(Y);
        _matriz = new String[Y][X];
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

    public String[][] get_matriz() {
        return _matriz;
    }

    public void createMap(){
        for (int j = 0; j < _distanceY; j ++){
            for (int i = 0; i < _distanceX; i ++){
                _matriz[j][i] = ".";
            }
        }



    }




}
