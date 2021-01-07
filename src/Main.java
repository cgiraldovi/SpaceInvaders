import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Enemy enemigo1 =  new Enemy("Y",3);
        Player jugador = new Player("H",3);
        Map mapa = new Map(10,5);
        mapa.getMap();
    }
}
