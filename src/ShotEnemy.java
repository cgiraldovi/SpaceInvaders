public class ShotEnemy extends Shot{
    public ShotEnemy(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    void move() {
        set_positionY(get_positionY() +1);
    }



}
