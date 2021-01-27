public class Player extends Ship {
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


    public Shot shoot() {
        Shot gun = new Shot(get_positionX(), get_positionY() - 1);
        return gun;
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

}
