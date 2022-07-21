/*
This class is responsible for running the simulation.
 */
package main.java.simulation;

public class SimulationStarter {
    public static void runningSimulation() {
        GameLogic game = new GameLogic();
        for (int i=0; i<=30; i++) {
            game.game();
        }
    }
}
