public class Player extends Ship{


    public Player(String forma, int health) {
        super(forma, health);
    }

    @Override
    public void set_positionX(int X) {
        _positionX = X/2;
    }

    @Override
    public void set_positionY(int Y) {
        _positionY = Y;
    }

    @Override
    public void shoot() {}
}
