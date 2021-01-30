public class ShipEnemy extends Enemy {
    public ShipEnemy(int health, int positionX, int positionY) {
        super(health, positionX, positionY);
        set_shape("V");
    }

    public ShotEnemy shoot() {
        ShotEnemy gun = new ShotEnemy(get_positionX(), get_positionY() );
        return gun;
    }

}
