import java.util.Scanner;

import static java.lang.Math.random;

/*
    Author: Fabi
 */
public class Main {
    public static void main(String[] args) {
        CoinGame coin = new CoinGame();
        coin.einsatz();
        coin.gameLoop();
    }
}