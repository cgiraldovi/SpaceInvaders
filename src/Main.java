import java.util.Scanner;
public class Main {
    public static Scanner entrada = new Scanner(System.in);

    public static void main (String[] args){
        Enemy enemigo1 =  new Enemy("Y",3);
        Player jugador = new Player("H",3);

        System.out.println("Escriba la distancia horizontal y verticall del mapa");
        Map mapa = new Map(entrada.nextInt(), entrada.nextInt());

        mapa.getMap();
        System.out.println(enemigo1.get_shape());
        System.out.println(jugador.get_shape());
    }
}
