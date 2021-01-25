public class Enemy extends Ship {
    public boolean comparador;

    public Enemy(int health, int positionX, int positionY) {
        super(health);
        set_positionX(positionX);
        set_positionY(positionY);
        set_shape("Y");
        comparador = true;
    }


    @Override
    public void set_positionX(int positionX) {
        _positionX = positionX + 2;
    }

    @Override
    public void set_positionY(int positionY) {
        _positionY = positionY;
    }

}
