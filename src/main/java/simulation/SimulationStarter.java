/*
This class is responsible for running the simulation.
 */
package main.java.simulation;

import java.io.IOException;

public class SimulationStarter {
    public static void runningSimulation() throws IOException {
        GameLogic game = new GameLogic();
        for (int i=0; i<=30; i++) {
            game.game();
        }
    }
}
