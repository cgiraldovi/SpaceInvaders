public class Enemy extends Ship {


    public Enemy(String forma, int health) {
        super(forma, health);
    }

    @Override
    public void set_positionX(int X) {
        _positionX = X;
    }

    @Override
    public void set_positionY(int Y) {
        _positionY = Y;
    }

    @Override
    public void shoot() {
    }
}
