import java.util.Scanner;

public class Main {
    public static Scanner entrada = new Scanner(System.in);
    public static Map _mapa = new Map(11, 5);
    public static Enemy _enemigo1 = new Enemy(1, _mapa.get_distanceX(), 1);
    public static Player _jugador = new Player(1, _mapa.get_distanceX(), _mapa.get_distanceY());
    public static Shot[] _guns = new Shot[9];
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

        Map mapa1 = new Map(11,5);
        mapa1.createMap();

        for (String[] i : mapa1.get_matriz()) {
            for (String j : i){
                System.out.print(j);
            }
            System.out.println();
        }

    }

    public static void movimientoJugador() {
        String movimiento = entrada.next();
        if (movimiento.equals("a")) {
            _jugador._positionX--;
        } else if (movimiento.equals("d")) {
            _jugador._positionX++;
        } else if (movimiento.equals("o")) {
            _guns[_contador] = _jugador.shoot();
            if (_contador < _guns.length - 1) {
                _contador++;
            }
        }

        if (_jugador.get_positionX() > _mapa.get_distanceX()) {
            _jugador._positionX--;
        } else if (_jugador.get_positionX() < 1) {
            _jugador._positionX++;
        }

    }

    public static void movimientoEnemigo() {

        if (_enemigo1 != null) {
            if (_enemigo1.get_positionX() == _mapa.get_distanceX()) {
                if (_enemigo1.comparador) {
                    _enemigo1._positionY++;
                }
                if (_enemigo1.comparador) {
                    _enemigo1._positionX++;
                }
                _enemigo1.comparador = false;

            } else if (_enemigo1.get_positionX() == 1) {

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

        for (int j = 1; j <= _mapa.get_distanceY(); j++) {
            System.out.println();
            for (int i = 1; i <= _mapa.get_distanceX(); i++) {

                if (j == _jugador.get_positionY() && i == _jugador.get_positionX()) {
                    System.out.print(_jugador.get_shape());
                } else if (_enemigo1 != null) {
                    if (j == _enemigo1.get_positionY() && i == _enemigo1.get_positionX()) {
                        System.out.print(_enemigo1.get_shape());
                    } else {
                        System.out.print(".");
                    }
                } else {
                    System.out.print(".");
                }

                for (Shot gun : _guns) {
                    if (gun != null) {
                        if (_enemigo1 != null) {
                            if (_enemigo1.get_positionX() == gun.get_positionX() && _enemigo1.get_positionY() == gun.get_positionY()) {
                                _enemigo1 = null;
                                gun = null;
                            }
                        }
                    }
                    if (gun != null) {
                        if (j == gun.get_positionY() && i == gun.get_positionX()) {
                            System.out.print(gun.get_forma());
                        }
                    }

                }

            }
        }
        System.out.println();
    }


    public static void movimientoBala() {
        for (Shot gun : _guns) {
            if (gun != null)
                gun._positionY--;
        }
    }

}
