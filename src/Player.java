public class Player extends Ship {
    Shot[] guns = new Shot[9];
    static int cont = 0;

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


    public void shoot() {
        if (cont <= guns.length) {
            guns[cont] = new Shot(get_positionX(), get_positionY());
            cont++;
        }
    }


}
