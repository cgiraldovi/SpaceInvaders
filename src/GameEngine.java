import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine {
    public static Scanner entrada = new Scanner(System.in);
    public static Map _map;
    public static Enemy[] _enemies;
    public static Player _player;
    public static ShotPlayer[] _gunsPlayer;
    public static ShotEnemy[] _gunsEnemy;
    public static Boolean _gaming = true;
    public static int _gunPlayerCont;
    public static int _gunEnemyCont;
    public static int _points;

    public void game() {
        while (true) {
            _map = new Map(26, 10);
            _enemies = new Enemy[10];
            _player = new Player(1, _map.get_distanceX(), _map.get_distanceY());
            _gunsPlayer = new ShotPlayer[20];
            _gunsEnemy = new ShotEnemy[100];
            _gaming = true;
            _gunPlayerCont = 0;
            _gunEnemyCont = 0;


            enemiesInitializer();
            menu();
            String option = entrada.next();
            if (option.equalsIgnoreCase("y")) {
                while (true) {
                    play();
                    badEnding();
                    if (!_gaming) {
                        break;
                    }
                    goodEnding();
                    if (!_gaming) {
                        break;
                    }
                }
            } else if (option.equalsIgnoreCase("n")) {
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

    public void enemyMove() {
        for (Enemy enemy : _enemies) {
            if (enemy != null) {
                enemy.move(_map);

                int numero = (int) (Math.random() * 10) + 1;
                if (enemy instanceof ShipEnemy) {
                    if (numero % 5 == 0) {
                        if (_gunEnemyCont < _gunsEnemy.length) {
                            _gunsEnemy[_gunEnemyCont] = ((ShipEnemy) enemy).shoot();
                        }
                    }
                }
            }

            _gunEnemyCont++;

        }
    }


    public void gunMove() {
        for (ShotPlayer gun : _gunsPlayer) {
            if (gun != null)
                gun.move();
        }
        for (ShotEnemy gun : _gunsEnemy) {
            if (gun != null)
                gun.move();
        }

    }

    public String controlPanel() {
        String option = entrada.next();

        if (option.equalsIgnoreCase("a")) {
            _player.moveLeft();
            _player.move(_map);
        } else if (option.equalsIgnoreCase("d")) {
            _player.moveRight();
            _player.move(_map);
        } else if (option.equalsIgnoreCase("exit")) {
            _gaming = false;
        } else if (option.equalsIgnoreCase("o")) {
            if (_gunPlayerCont < _gunsPlayer.length) {
                _gunsPlayer[_gunPlayerCont] = _player.shoot();
            }
            _gunPlayerCont++;
        }
        return option;
    }


    public void getMap() {

        _map.createMap();

        for (int j = 0; j < _map.get_distanceY(); j++) {
            for (int i = 0; i < _map.get_distanceX(); i++) {
                if (j == _player.get_positionY() && i == _player.get_positionX()) {
                    _map.set_matriz(j, i, _player.get_shape());
                }

                for (int e = 0; e < _enemies.length; e++) {
                    if (_enemies[e] != null) {
                        if (j == _enemies[e].get_positionY() && i == _enemies[e].get_positionX()) {
                            _map.set_matriz(j, i, _enemies[e].get_shape());
                        }
                    }
                }
                for (int gunPlayer = 0; gunPlayer < _gunsPlayer.length; gunPlayer++) {
                    for (int gunEnemy = 0; gunEnemy < _gunsEnemy.length; gunEnemy++) {
                        for (int enemy = 0; enemy < _enemies.length; enemy++) {





                            if (_gunsEnemy[gunEnemy] != null && _gunsPlayer[gunPlayer] != null && _enemies[enemy] != null) {

                                if (_enemies[enemy].get_positionX() == _gunsPlayer[gunPlayer].get_positionX() && _enemies[enemy].get_positionY() == _gunsPlayer[gunPlayer].get_positionY()) {
                                    if (_enemies[enemy].get_health() - _gunsPlayer[gunPlayer].get_damage() == 0) {
                                        if (_enemies[enemy] instanceof Meteorite) {
                                            _points += 150;
                                        } else if (_enemies[enemy] instanceof ShipEnemy) {
                                            _points += 300;
                                        }
                                        _enemies[enemy] = null;
                                        _map.set_matriz(_gunsPlayer[gunPlayer].get_positionY(), _gunsPlayer[gunPlayer].get_positionX(), "X");

                                    } else if (_enemies[enemy].get_health() > _gunsPlayer[gunPlayer].get_damage()) {
                                        _enemies[enemy].set_health(_enemies[enemy].get_health() - _gunsPlayer[gunPlayer].get_damage());
                                    }
                                    _gunsPlayer[gunPlayer] = null;
                                } else if (_gunsEnemy[gunEnemy].get_positionX() == _gunsPlayer[gunPlayer].get_positionX() && _gunsEnemy[gunEnemy].get_positionY() == _gunsPlayer[gunPlayer].get_positionY()) {
                                    _map.set_matriz(_gunsPlayer[gunPlayer].get_positionY(), _gunsPlayer[gunPlayer].get_positionX(), "X");
                                    _map.set_matriz(_gunsEnemy[gunEnemy].get_positionY(), _gunsEnemy[gunEnemy].get_positionX(), "X");
                                    _gunsEnemy[gunEnemy] = null;
                                    _gunsPlayer[gunPlayer] = null;

                                } else if (_gunsEnemy[gunEnemy].get_positionX() == _gunsPlayer[gunPlayer].get_positionX() && (_gunsEnemy[gunEnemy].get_positionY() - 1) == _gunsPlayer[gunPlayer].get_positionY()) {
                                    _map.set_matriz(_gunsPlayer[gunPlayer].get_positionY(), _gunsPlayer[gunPlayer].get_positionX(), "X");
                                    _map.set_matriz(_gunsEnemy[gunEnemy].get_positionY(), _gunsEnemy[gunEnemy].get_positionX(), "X");
                                    _gunsEnemy[gunEnemy] = null;
                                    _gunsPlayer[gunPlayer] = null;
                                }


                            }
                            if (_gunsPlayer[gunPlayer] != null) {
                                if (j == _gunsPlayer[gunPlayer].get_positionY() && i == _gunsPlayer[gunPlayer].get_positionX()) {
                                    _map.set_matriz(j, i, _gunsPlayer[gunPlayer].get_shape());
                                }
                            }

                            if (_gunsEnemy[gunEnemy] != null) {
                                if (j == _gunsEnemy[gunEnemy].get_positionY() && i == _gunsEnemy[gunEnemy].get_positionX()) {
                                    _map.set_matriz(j, i, _gunsEnemy[gunEnemy].get_shape());
                                }
                            }

                            if (_gunsEnemy[gunEnemy] != null) {
                                if (j == _gunsEnemy[gunEnemy].get_positionY() && i == _gunsEnemy[gunEnemy].get_positionX()) {
                                    _map.set_matriz(j, i, _gunsEnemy[gunEnemy].get_shape());
                                }
                            }



                        }
                    }

                }
            }


        }


        _map.showMap();

    }


    public void badEnding() {
        for (Enemy enemigo : _enemies) {
            if (enemigo != null) {
                if (enemigo.get_positionY() == _map.get_distanceY() - 1) {
                    _gaming = false;
                    break;
                }
            }
        }
        if (!_gaming) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Felicidades, has perdido, haber estudiado");
            System.out.println();
            System.out.println();
        }
    }

    public void goodEnding() {
        int cont = 0;
        for (Enemy enemigo : _enemies) {
            if (enemigo == null) {
                cont++;
            }
        }
        if (cont == _enemies.length) {
            _gaming = false;
        }
        if (!_gaming) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Felicidades, has ganado, se nota que has estudiado");
            System.out.println();
            System.out.println();
        }
    }

    public void information() {
        int contadorBalas = 0;
        int contadorEnemigo = 0;
        for (Enemy enemigo : _enemies) {
            if (enemigo != null) {
                contadorEnemigo++;
            }
        }

        if (_gunsPlayer.length - _gunPlayerCont > 0) {
            contadorBalas = _gunsPlayer.length - _gunPlayerCont;
        }

        System.out.println();
        System.out.println("Cantidad de balas disponibles: " + (contadorBalas));
        System.out.println("Cantidad de enemigos vivos: " + (contadorEnemigo));
        System.out.println("Puntos: " + _points);
    }

    public void menu() {
        System.out.println();
        System.out.println("Bienvendio a esta mecha de juego");
        System.out.println("Moverse hacia la izquierda: a");
        System.out.println("Moverse hacia la derecha: d");
        System.out.println("Disparar: o");
        System.out.println("Salir de la partida: exit");
        System.out.println("Si desea no hacer ninguna accion, pulse cualquier otra tecla");
        System.out.println();
        System.out.println("Desea comenzar con el juego?");
        System.out.println();
        System.out.println("Y: Si");
        System.out.println("N: No");
        System.out.println();
    }

    public void enemiesInitializer() {
        int posX = -2;
        int posY = 0;
        Boolean contY = true;
        for (int i = 0; i < _enemies.length; i++) {
            posX = posX + 4;
            if (posX >= _map.get_distanceX()) {
                if (contY) {
                    contY = false;
                    posX = 3;
                } else {
                    contY = true;
                    posX = 2;
                }
                posY = posY + 2;

            }
            if (i % 5 == 0) {
                _enemies[i] = new ShipEnemy(2, posX, posY);
            } else {
                _enemies[i] = new Meteorite(1, posX, posY);
            }
        }
    }


}
