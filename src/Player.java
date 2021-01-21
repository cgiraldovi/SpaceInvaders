public class Player extends Ship {
    public Player(int health, int positionX, int positionY) {
        super(health);
        set_positionX(positionX);
        set_positionY(positionY);
        set_shape("H");
    }


    @Override
    public void set_positionX(int positionX) {
        _positionX = positionX / 2 + 1;
    }

    @Override
    public void set_positionY(int positionY) {
        _positionY = positionY;
    }


    public void shoot(Shot gun) {
            gun._positionX = get_positionX();
            gun._positionY = get_positionY()+1;
        }


}
