public class ShipEnemy extends Enemy {
    private ShotEnemy[] _guns = new ShotEnemy[10];
    public static int length_gunsEnemy = 10;
    private int cont =0;


    public ShipEnemy(int health, int positionX, int positionY) {
        super(health, positionX, positionY);
        set_shape("V");
    }

    public void shoot() {
        if (cont < _guns.length){
            _guns[cont] = new ShotEnemy(get_positionX(), get_positionY() );
            cont ++;
        }

    }

    public ShotEnemy[] get_guns() {
        return _guns;
    }
}
