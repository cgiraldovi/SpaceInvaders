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

    public void getMap(Player jugador) {

        for (int j = 1; j <= get_distanceY(); j ++){
            System.out.println();
            for (int i = 1; i <= get_distanceX(); i ++){
                if (j == jugador.get_positionY() && i == jugador.get_positionX()){
                    System.out.print(jugador.get_shape());
                } else {
                    System.out.print(".");
                }
            }
        }
        System.out.println();
    }
}
