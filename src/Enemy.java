public class Enemy extends Ship {
    private boolean comparador = true;

    public Enemy(int health, int positionX, int positionY) {
        super(health);
        set_positionX(positionX);
        set_positionY(positionY);
        set_shape("Y");
    }

    public boolean move(Map mapa){
       if(get_positionX() == mapa.get_distanceX()){
           return false;
       } else if(get_positionX() == 1){
           return true;
       }
       else {return true;}
    }


    @Override
    public void play(Map mapa) {
        if(get_positionX() == mapa.get_distanceX()){
            comparador = false;
        }
        if(get_positionX() == 1){
            comparador = true;
        }
        if(comparador){
            _positionX ++;
        } else {
            _positionX --;
        }



    }

    @Override
    public void set_positionX(int positionX) {
        _positionX = positionX;
    }

    @Override
    public void set_positionY(int positionY) {
        _positionY = positionY;
    }

    @Override
    public void shoot() {
    }
}
