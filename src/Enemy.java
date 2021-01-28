public class Enemy extends Ship {
    private boolean _comparator;

    public Enemy(int health, int positionX, int positionY) {
        super(health);
        _positionX = positionX;
        _positionY = positionY;
        set_shape("Y");
        _comparator = true;
    }


    @Override
    public void set_positionX(int positionX) { _positionX = positionX;}

    @Override
    public void set_positionY(int positionY) {
        _positionY = positionY;
    }

    public void move(Map map) {

                if (_comparator){
                    if (get_positionX() >= map.get_distanceX()-1) {
                        set_positionY(get_positionY() + 1);
                        set_positionX(get_positionX() +1);
                        _comparator = false;
                    }
                }

                if (!_comparator){
                    if (get_positionX() <= 0) {
                        set_positionY(get_positionY()+1);
                        set_positionX(get_positionX() -1);
                        _comparator = true;
                    }
                }

                if (_comparator) {
                    set_positionX(get_positionX()+1);
                } else {
                    set_positionX(get_positionX()-1);
                }
    }
}
