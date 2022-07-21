package main.java;

import java.io.IOException;
import java.util.Scanner;

public class SimulationStarter {
    public static void runningSimulation() throws IOException {
        GameLogic game = new GameLogic();
        for (int i=0; i<=30; i++) {
            game.game();
        }
    }
}
