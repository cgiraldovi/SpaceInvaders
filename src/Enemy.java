public class Enemy extends Ship {
    public boolean comparador;

    public Enemy(int health, int positionX, int positionY) {
        super(health);
        _positionX = positionX + 2;
        _positionY = positionY;
        set_shape("Y");
        comparador = true;
    }


    @Override
    public void set_positionX(int positionX) { _positionX = positionX;}

    @Override
    public void set_positionY(int positionY) {
        _positionY = positionY;
    }

    public void move(Map map) {

                if (comparador){
                    if (get_positionX() == map.get_distanceX()-1) {
                        set_positionY(get_positionY() + 1);
                        set_positionX(get_positionX() +1);
                        comparador = false;
                    }
                }

                if (!comparador){
                    if (get_positionX() == 0) {
                        set_positionY(get_positionY()+1);
                        set_positionX(get_positionX() -1);
                        comparador = true;
                    }
                }

                if (comparador) {
                    set_positionX(get_positionX()+1);
                } else {
                    set_positionX(get_positionX()-1);
                }
    }
}
