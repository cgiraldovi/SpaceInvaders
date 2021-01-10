public class Player extends Ship{


    public Player(int health, int positionX, int positionY) {
        super(health);
        set_positionX(positionX);
        set_positionY(positionY);
        set_shape("H");
    }


    @Override
    public void move(String movimiento, Map mapa) {
        if(movimiento.equals("a")){
            _positionX --;
        }else if (movimiento.equals("d")){
            _positionX ++;
        }
    }

    @Override
    public void set_positionX(int positionX) {
        _positionX = positionX/2 + 1;
    }

    @Override
    public void set_positionY(int positionY) {
        _positionY = positionY;
    }

    @Override
    public void shoot() {}
}
