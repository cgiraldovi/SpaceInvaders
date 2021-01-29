public class ShotEnemy extends Shot{
    public ShotEnemy(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    void move() {
        set_positionY(get_positionY() +1);
    }

    public ShotEnemy shoot() {
        ShotEnemy gun = new ShotEnemy(get_positionX(), get_positionY() + 1);
        return gun;
    }

}
