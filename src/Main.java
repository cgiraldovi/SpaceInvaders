import java.util.Scanner;

public class Main {
    public static Scanner entrada = new Scanner(System.in);
    public static Map _mapa = new Map(11, 5);
    public static Enemy _enemigo1 = new Enemy(1, _mapa.get_distanceX(), 0);
    public static Player _jugador = new Player(1, _mapa.get_distanceX(), _mapa.get_distanceY());
    public static Shot[] _guns = new Shot[5];
    public static int _contador = 0;

    public static void main(String[] args) {
        System.out.println("Bienvendio a esta mecha de juego");
        System.out.println();
        System.out.println("desea comenzar con el juego?");
        System.out.println("Y: Si");
        System.out.println("N: No");

        String option = entrada.next();
        if (option.equals("y")) {
            while (true) {
                play();
            }
        }


    }

    public static void play() {
        getMap();
        movimientoJugador();
        movimientoEnemigo();
        movimientoBala();
    }

    public static void movimientoJugador() {
        String movimiento = entrada.next();
        if (movimiento.equals("a")) {
            _jugador._positionX--;
        } else if (movimiento.equals("d")) {
            _jugador._positionX++;
        } else if (movimiento.equals("o")) {
            if (_contador < _guns.length){
                _guns[_contador] = _jugador.shoot();
            }
            _contador ++;
        }

        if (_jugador.get_positionX() > _mapa.get_distanceX() - 1) {
            _jugador._positionX--;
        } else if (_jugador.get_positionX() < 0) {
            _jugador._positionX++;
        }

    }

    public static void movimientoEnemigo() {

        if (_enemigo1 != null) {
            if (_enemigo1.get_positionX() == _mapa.get_distanceX() - 1) {
                if (_enemigo1.comparador) {
                    _enemigo1._positionY++;
                }
                if (_enemigo1.comparador) {
                    _enemigo1._positionX++;
                }
                _enemigo1.comparador = false;

            } else if (_enemigo1.get_positionX() == 0) {

                if (!_enemigo1.comparador) {
                    _enemigo1._positionY++;
                }
                if (!_enemigo1.comparador) {
                    _enemigo1._positionX--;
                }
                _enemigo1.comparador = true;
            }

            if (_enemigo1.comparador) {
                _enemigo1._positionX++;
            } else {
                _enemigo1._positionX--;
            }

        }


    }

    public static void getMap() {

        _mapa.createMap();

        for (int j = 0; j < _mapa.get_distanceY(); j++) {
            for (int i = 0; i < _mapa.get_distanceX(); i++) {
                if (j == _jugador.get_positionY() && i == _jugador.get_positionX()) {
                    _mapa._matriz[j][i] = _jugador.get_shape();
                }
                if (_enemigo1 != null) {
                    if (j == _enemigo1.get_positionY() && i == _enemigo1.get_positionX()) {
                        _mapa._matriz[j][i] = _enemigo1.get_shape();
                    }
                }


                for (int k = 0; k < _guns.length; k ++){
                    if (_guns[k] != null){
                        if (_enemigo1 != null){
                            if (_enemigo1.get_positionX() == _guns[k].get_positionX()
                                && _enemigo1.get_positionY() == _guns[k].get_positionY()){
                                if (_enemigo1.get_health() - _guns[k].get_damage() == 0){
                                    _enemigo1 = null;
                                }
                                _guns[k] = null;
                            }
                        }
                    }

                    if (_guns[k] != null){
                        if (j == _guns[k].get_positionY() && i == _guns[k].get_positionX()){
                            _mapa._matriz[j][i] = _guns[k].get_forma();
                        }
                    }

                }
            }
        }

        _mapa.showMap();
    }

    public static void movimientoBala() {
        for (Shot gun : _guns) {
            if (gun != null)
                gun._positionY--;
        }
    }

}
