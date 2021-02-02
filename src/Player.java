public class Player extends Ship {
    private ShotPlayer[] _gunsPlayer = new ShotPlayer[20];
    public static int cont = 0;

    public Player(int health, int positionX, int positionY) {
        super(health);
        _positionX = positionX / 2;
        _positionY = positionY - 1;
        set_shape("H");
    }


    @Override
    public void set_positionX(int positionX) {
        _positionX = positionX;
    }

    @Override
    public void set_positionY(int positionY) {
        _positionY = positionY;
    }


    public void shoot() {
        if (cont < _gunsPlayer.length){
            _gunsPlayer[cont] = new ShotPlayer(get_positionX(), get_positionY() - 1);
            cont++;
        }

    }

    public void moveLeft() {
        set_positionX(get_positionX() - 1);
    }

    public void moveRight() {
        set_positionX(get_positionX() + 1);
    }

    public void move(Map map) {
        if (get_positionX() > map.get_distanceX() - 1) {
            set_positionX(get_positionX() - 1);
        } else if (get_positionX() < 0) {
            set_positionX(get_positionX() + 1);
        }
    }

    public ShotPlayer[] get_gunsPlayer() {
        return _gunsPlayer;
    }

}
