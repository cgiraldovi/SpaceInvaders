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

            if(comparador){
                _positionY ++;
            }
            if(comparador){
              _positionX ++;
            }
            comparador = false;

        } else if(get_positionX() == 1){

            if(!comparador){
            _positionY ++;}
            if(!comparador){
                _positionX --;
            }
            comparador = true;
        }

        if (comparador){
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
