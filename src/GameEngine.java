import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine {
    public static Scanner entrada = new Scanner(System.in);
    public static Map _map;
    public static Enemy[] _enemies;
    public static Player _player;
    public static ArrayList<Shot> _guns = new ArrayList<>();
    public static Shot[] _gunsPlayer;
    public static Boolean _gaming = true;
    public static int _gunCont;
    public static int _points;

    public void game(){
        while(true){
            _map = new Map(26, 6);
            _enemies = new Enemy[10];
            _player = new Player(1, _map.get_distanceX(), _map.get_distanceY());
            _gunsPlayer = new Shot[20];
            _gaming = true;
            _gunCont = 0;


            enemiesInitializer();
            menu();
            String option = entrada.next();
            if (option.equalsIgnoreCase("y")) {
                while (true) {
                    play();
                    badEnding();
                    if (!_gaming){
                        break;
                    }
                    goodEnding();
                    if (!_gaming){
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
            enemy.move(_map);}
        }
    }



    public void gunMove() {
        for (Shot gun : _gunsPlayer) {
            if (gun != null)
                gun.move();
        }
    }

    public String controlPanel(){
        String option = entrada.next();

        if(option.equalsIgnoreCase("a")){
            _player.moveLeft();
            _player.move(_map);
        } else if(option.equalsIgnoreCase("d")){
            _player.moveRight();
            _player.move(_map);
        } else if(option.equalsIgnoreCase("exit")){
            _gaming = false;
        } else if (option.equalsIgnoreCase("o")) {
            if (_gunCont < _gunsPlayer.length) {
                _gunsPlayer[_gunCont] = _player.shoot();
            }
            _gunCont++;
        }
        return option;
    }




    public void getMap() {

        _map.createMap();

        for (int j = 0; j < _map.get_distanceY(); j++) {
            for (int i = 0; i < _map.get_distanceX(); i++) {
                if (j == _player.get_positionY() && i == _player.get_positionX()) {
                    _map.set_matriz(j,i, _player.get_shape());
                }

                for (int e = 0; e < _enemies.length; e++) {
                    if (_enemies[e] != null) {
                        if (j == _enemies[e].get_positionY() && i == _enemies[e].get_positionX()) {
                            _map.set_matriz(j,i,_enemies[e].get_shape());
                        }
                    }
                }
                for (int k = 0; k < _gunsPlayer.length; k++) {

                    for (int l = 0; l < _enemies.length; l++) {

                        if (_gunsPlayer[k] != null) {
                            if (_enemies[l] != null) {
                                if (_enemies[l].get_positionX() == _gunsPlayer[k].get_positionX()
                                        && _enemies[l].get_positionY() == _gunsPlayer[k].get_positionY()) {
                                    if (_enemies[l].get_health() - _gunsPlayer[k].get_damage() == 0) {

                                        if (_enemies[l] instanceof Meteorite){
                                            _points += 150;
                                        } else if (_enemies[l] instanceof ShipEnemy){
                                            _points += 300;
                                        }
                                        _enemies[l] = null;
                                        _map.set_matriz(_gunsPlayer[k].get_positionY(), _gunsPlayer[k].get_positionX(),"X");



                                    } else if(_enemies[l].get_health() > _gunsPlayer[k].get_damage()){
                                        _enemies[l].set_health(_enemies[l].get_health() - _gunsPlayer[k].get_damage());
                                    }
                                    _gunsPlayer[k] = null;

                                }
                            }
                        }

                        if (_gunsPlayer[k] != null) {
                            if (j == _gunsPlayer[k].get_positionY() && i == _gunsPlayer[k].get_positionX()) {
                                _map.set_matriz(j,i, _gunsPlayer[k].get_shape());
                            }
                        }
                    }


                }

            }


        }


        _map.showMap();

    }



    public void badEnding(){
        for (Enemy enemigo: _enemies){
            if (enemigo != null){
                if (enemigo.get_positionY() == _map.get_distanceY()-1){
                    _gaming = false;
                    break;
                }
            }
        }
        if (!_gaming){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Felicidades, has perdido, haber estudiado");
        System.out.println();
        System.out.println();}
    }

    public void goodEnding(){
        int cont = 0;
        for (Enemy enemigo: _enemies){
            if (enemigo == null){
                cont ++;
            }
        }
        if (cont == _enemies.length){
            _gaming = false;
        }
        if (!_gaming){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Felicidades, has ganado, se nota que has estudiado");
            System.out.println();
            System.out.println();
        }
    }

    public void information(){
        int contadorBalas = 0;
        int contadorEnemigo = 0;
        for (Enemy enemigo: _enemies){
            if (enemigo != null){
                contadorEnemigo ++;
            }
        }

        if (_gunsPlayer.length - _gunCont > 0){
            contadorBalas = _gunsPlayer.length - _gunCont;
        }

        System.out.println();
        System.out.println("Cantidad de balas disponibles: " + (contadorBalas) );
        System.out.println("Cantidad de enemigos vivos: " + (contadorEnemigo));
        System.out.println("Puntos: " + _points);
    }

    public void menu(){
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

    public void enemiesInitializer(){
        int posX = -2;
        int posY = 0;
        Boolean contY = true;
        for (int i = 0; i < _enemies.length; i++) {
            posX = posX + 4;
            if (posX >= _map.get_distanceX()){
                if (contY){
                    contY = false;
                    posX = 3;
                } else {
                    contY = true;
                    posX = 2;
                }
                posY = posY +2;

            }
            if (i%3==0){
                _enemies[i] = new ShipEnemy(2,posX,posY);
            } else {
                _enemies[i] = new Meteorite(1, posX, posY);
            }
        }
    }


}
