public class Enemy extends Ship {
    private boolean comparador = true;

    public Enemy(int health, int positionX, int positionY) {
        super(health);
        set_positionX(positionX);
        set_positionY(positionY);
        set_shape("Y");
    }


    @Override
    public void play(Map mapa) {
        if(get_positionX() == mapa.get_distanceX()){
            comparador = false;
            _positionY ++;
        }
        if(get_positionX() == 1){
            comparador = true;
            _positionY ++;
        }
        if(comparador){
            _positionX ++;
        } else {
            _positionX --;
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
    public void shoot() {
    }
}
