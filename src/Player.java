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


    public Shot shoot() {
            Shot gun = new Shot(get_positionX(), get_positionY() -1);
            return gun;
        }


}
