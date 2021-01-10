import java.util.Scanner;
public class Main {
    public static Scanner entrada = new Scanner(System.in);

    public static void main (String[] args){

        System.out.println("Escriba la distancia horizontal y vertical del mapa");
        Map mapa = new Map(entrada.nextInt(), entrada.nextInt());
        Enemy enemigo1 =  new Enemy(3, mapa.get_distanceX(), mapa.get_distanceY());
        Player jugador = new Player(3, mapa.get_distanceX(),mapa.get_distanceY());

        while(true){
            juego(jugador, mapa);
        }
    }

    public static void juego(Player jugador, Map mapa){
        mapa.getMap(jugador);
        jugador.move(entrada.next());
        if(jugador.get_positionX() > mapa.get_distanceX()){
           jugador._positionX --;
        }
        else if(jugador.get_positionX() < 1){
            jugador._positionX ++;
        }
    }


}
