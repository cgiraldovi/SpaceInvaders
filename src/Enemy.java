public class Enemy extends Ship {

    public Enemy(int health, int positionX, int positionY) {
        super(health);
        set_positionX(positionX);
        set_positionY(positionY);
        set_shape("Y");

    }

    @Override
    public void move(String movimiento, Map mapa) {

    }

    @Override
    public void set_positionX(int positionX) {

    }

    @Override
    public void set_positionY(int positionY) {

    }

    @Override
    public void shoot() {
    }
}
