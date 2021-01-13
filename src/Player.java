import java.util.Scanner;

public class Player extends Ship{
    Scanner entrada = new Scanner(System.in);


    public Player(int health, int positionX, int positionY) {
        super(health);
        set_positionX(positionX);
        set_positionY(positionY);
        set_shape("H");
    }


    public void move(String movimiento) {
        if(movimiento.equals("a")){
            _positionX --;
        }else if (movimiento.equals("d")){
            _positionX ++;
        } else if(movimiento.equals(" ")){
            shoot();
        }
    }

    @Override
    public void play(Map mapa) {
        String opcion = entrada.next();
        move(opcion);
        if(opcion.equals(" ")){
            shoot();
        }
         else if(get_positionX() > mapa.get_distanceX()){
            _positionX --;
        }
        else if(get_positionX() < 1){
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
    public void shoot() {
    }



}
