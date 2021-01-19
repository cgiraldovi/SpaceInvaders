import java.util.Scanner;

public class Main {
    public static Scanner entrada = new Scanner(System.in);
    public static Map _mapa = new Map(11, 6);
    public static Enemy _enemigo1 = new Enemy(1, _mapa.get_distanceX(), 1);
    public static Player _jugador = new Player(1, _mapa.get_distanceX(), _mapa.get_distanceY());

    public static void main(String[] args) {
        while (true) {
            play(_jugador, _mapa, _enemigo1);
        }
    }

    public static void play(Player jugador, Map mapa, Enemy enemigo) {
        getMap();
        movimientoJugador();
        movimientoEnemigo();
    }

    public static void movimientoJugador(){
        String movimiento = entrada.next();
        if (movimiento.equals("a")) {
            _jugador._positionX--;
        } else if (movimiento.equals("d")) {
            _jugador._positionX++;
        } else if (movimiento.equals(" ")){

        }





        if(_jugador.get_positionX() > _mapa.get_distanceX()){
            _jugador._positionX --;
        } else if(_jugador.get_positionX() < 1){
            _jugador._positionX ++;
        }

    }

    public static void movimientoEnemigo(){
        if(_enemigo1.get_positionX() == _mapa.get_distanceX()){
            if(_enemigo1.comparador){
                _enemigo1._positionY ++;
            }
            if(_enemigo1.comparador){
                _enemigo1._positionX ++;
            }
            _enemigo1.comparador = false;

        } else if(_enemigo1.get_positionX() == 1){

            if(!_enemigo1.comparador){
                _enemigo1._positionY ++;}
            if(!_enemigo1.comparador){
                _enemigo1._positionX --;
            }
            _enemigo1.comparador = true;
        }

        if (_enemigo1.comparador){
            _enemigo1._positionX ++;
        } else {
            _enemigo1._positionX --;
        }
    }

    public static void getMap(){

        for (int j = 1; j <= _mapa.get_distanceY(); j ++){
            System.out.println();
            for (int i = 1; i <= _mapa.get_distanceX(); i ++){
                if (j == _jugador.get_positionY() && i == _jugador.get_positionX()){
                    System.out.print(_jugador.get_shape());
                } else if(j == _enemigo1.get_positionY() && i == _enemigo1.get_positionX()){
                    System.out.print(_enemigo1.get_shape());
                } else {
                    System.out.print(".");
                }
            }
        }
        System.out.println();
    }


}
