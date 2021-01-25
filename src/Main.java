import java.util.Scanner;

public class Main {
    public static Scanner entrada = new Scanner(System.in);
    public static Map _mapa = new Map(25, 4);
    public static Enemy _enemigo1 = new Enemy(1, _mapa.get_distanceX(), 0);
    public static Enemy[] _enemies = new Enemy[11];
    public static Player _jugador = new Player(1, _mapa.get_distanceX(), _mapa.get_distanceY());
    public static Shot[] _guns = new Shot[30];
    public static int _contador = 0;



    public static void main(String[] args) {

        int cont = 0;
        for (int i = 0; i < _enemies.length; i++) {
            int posX = cont;
            int posY;
            if (i % 2 == 0) {
                posY = 0;
            } else {
                posY = 1;
            }
            _enemies[i] = new Enemy(1, posX, posY);
        cont = cont +2;
        }

        while(true){
            System.out.println("Bienvendio a esta mecha de juego");
            System.out.println();
            System.out.println("desea comenzar con el juego?");
            System.out.println("Y: Si");
            System.out.println("N: No");

            String option = entrada.next();
            if (option.equals("y")) {
                while (true) {
                    play();
                    if (badEnding()){
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("Felicidades, has perdido, haber estudiado");
                        System.out.println();
                        System.out.println();
                        break;
                    }
                    if (goodEnding()){
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("Felicidades, has ganado, se nota que has estudiado");
                        System.out.println();
                        System.out.println();
                        break;
                    }
                }
            } else if (option.equals("n")){
                break;
            }
            return;
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
        }else if (movimiento.equals("o")) {
            if (_contador < _guns.length) {
                _guns[_contador] = _jugador.shoot();
            }
            _contador++;
        } 

        if (_jugador.get_positionX() > _mapa.get_distanceX() - 1) {
            _jugador._positionX--;
        } else if (_jugador.get_positionX() < 0) {
            _jugador._positionX++;
        }

    }

    public static void movimientoEnemigo() {

        for (int i = 0; i < _enemies.length; i++) {
            if (_enemies[i] != null) {
                if (_enemies[i].get_positionX() == _mapa.get_distanceX()-1) {
                    if (_enemies[i].comparador) {
                        _enemies[i]._positionY++;
                    }
                    if (_enemies[i].comparador) {
                        _enemies[i]._positionX++;
                    }
                    _enemies[i].comparador = false;

                } else if (_enemies[i].get_positionX() == 0) {

                    if (!_enemies[i].comparador) {
                        _enemies[i]._positionY++;
                    }
                    if (!_enemies[i].comparador) {
                        _enemies[i]._positionX--;
                    }
                    _enemies[i].comparador = true;
                }

                if (_enemies[i].comparador) {
                    _enemies[i]._positionX++;
                } else {
                    _enemies[i]._positionX--;
                }

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

                for (int e = 0; e < _enemies.length; e++) {
                    if (_enemies[e] != null) {
                        if (j == _enemies[e].get_positionY() && i == _enemies[e].get_positionX()) {
                            _mapa._matriz[j][i] = _enemies[e].get_shape();
                        }
                    }
                }


                for (int k = 0; k < _guns.length; k++) {

                    for (int l = 0; l < _enemies.length; l++) {

                        if (_guns[k] != null) {
                            if (_enemies[l] != null) {
                                if (_enemies[l].get_positionX() == _guns[k].get_positionX()
                                        && _enemies[l].get_positionY() == _guns[k].get_positionY()) {
                                    if (_enemies[l].get_health() - _guns[k].get_damage() == 0) {
                                        _enemies[l] = null;
                                    }
                                    _guns[k] = null;
                                }
                            }
                        }

                        if (_guns[k] != null) {
                            if (j == _guns[k].get_positionY() && i == _guns[k].get_positionX()) {
                                _mapa._matriz[j][i] = _guns[k].get_forma();
                            }
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

    public static Boolean badEnding(){
        Boolean comparator = false;
        for (Enemy enemigo: _enemies){
            if (enemigo != null){
                if (enemigo.get_positionY() == _mapa.get_distanceY()-1){
                    comparator = true;
                    break;
                }
            }
        }
        return comparator;
    }

    public static Boolean goodEnding(){
        Boolean comparator = false;
        int cont = 0;
        for (Enemy enemigo: _enemies){
            if (enemigo == null){
                cont ++;
            }
        }

        if (cont == _enemies.length-1){
            comparator = true;
        }

        return comparator;
    }



}
