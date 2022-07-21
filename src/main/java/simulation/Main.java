package main.java.simulation;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            SimulationStarter.runningSimulation();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}