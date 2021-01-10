import java.util.Scanner;
public class Main {
    public static Scanner entrada = new Scanner(System.in);

    public static void main (String[] args){

        System.out.println("Escriba la distancia horizontal y vertical del mapa");
        Map mapa = new Map( entrada.nextInt(), entrada.nextInt());
        Enemy enemigo1 =  new Enemy(3, 1, 1);
        Player jugador = new Player(3, mapa.get_distanceX(),mapa.get_distanceY());

        while(true){
            mapa.getMap(jugador, enemigo1);
            jugador.play(mapa);
            enemigo1.play(mapa);
        }
    }




}
