public class ShipEnemy extends Enemy {
    public ShipEnemy(int health, int positionX, int positionY) {
        super(health, positionX, positionY);
        set_shape("V");
    }
}
