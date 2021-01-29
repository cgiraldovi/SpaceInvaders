public class ShotPlayer extends Shot{
    public ShotPlayer(int positionX, int positionY) {
        super(positionX, positionY+1);
    }

    @Override
    void move() {
        set_positionY(get_positionY() -1);
    }
}
