import java.util.Scanner;

public class GameEngine {
    public static Scanner entrada = new Scanner(System.in);
    public static Map _mapa;
    public static Enemy[] _enemies;
    public static Player _jugador;
    public static Shot[] _guns;
    public static Boolean _game = true;
    public static int _gunCont =0;

    public void game(){
        while(true){
            _mapa = new Map(26, 8);
            _enemies = new Enemy[11];
            _jugador = new Player(1, _mapa.get_distanceX(), _mapa.get_distanceY());
            _guns = new Shot[20];

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



            System.out.println("Bienvendio a esta mecha de juego");
            System.out.println("Moverse hacia la izquierda: a");
            System.out.println("Moverse hacia la derecha: d");
            System.out.println("Disparar: o");
            System.out.println("Salir de la partida: exit");
            System.out.println("Si desea no hacer ninguna accion, pulse cualquier otra tecla");
            System.out.println();
            System.out.println("desea comenzar con el juego?");
            System.out.println();
            System.out.println("Y: Si");
            System.out.println("N: No");

            System.out.println();

            String option = entrada.next();
            if (option.equalsIgnoreCase("y")) {
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
                    if (!_game){
                        break;
                    }

                }
            } else if (option.equalsIgnoreCase("n")){
                break;
            }
        }

    }

    public void play() {

        getMap();
        information();
        controlPanel();
        enemyMove();
        gunMove();

    }

    public void enemyMove(){
        for (Enemy  enemy : _enemies){
            if (enemy != null){
            enemy.move(_mapa);}
        }
    }

    public static void gunMove() {
        for (Shot gun : _guns) {
            if (gun != null)
                gun.move();

        }
    }

    public String controlPanel(){
        String option = entrada.next();

        if(option.equalsIgnoreCase("a")){
            _jugador.moveLeft();
            _jugador.move(_mapa);
        } else if(option.equalsIgnoreCase("d")){
            _jugador.moveRight();
            _jugador.move(_mapa);
        } else if(option.equalsIgnoreCase("exit")){
            _game = false;
        } else if (option.equalsIgnoreCase("o")) {
            if (_gunCont < _guns.length) {
                _guns[_gunCont] = _jugador.shoot();
            }
            _gunCont++;
        }
        return option;
    }




    public void getMap() {

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
                                        _mapa._matriz[_guns[k].get_positionY()][_guns[k].get_positionX()] = "X";
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

        if (cont == _enemies.length){
            comparator = true;
        }

        return comparator;
    }

    public static void information(){
        int contadorBalas = 0;
        int contadorEnemigo = 0;
        for (Enemy enemigo: _enemies){
            if (enemigo != null){
                contadorEnemigo ++;
            }
        }
        if (_guns.length - _gunCont > 0){
            contadorBalas = _guns.length - _gunCont;
        }

        System.out.println();
        System.out.println("Cantidad de balas disponibles: " + (contadorBalas) );
        System.out.println("Cantidad de enemigos vivos: " + (contadorEnemigo));
    }




}
