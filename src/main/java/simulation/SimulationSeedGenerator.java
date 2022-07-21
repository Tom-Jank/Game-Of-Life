/*
This class is responsible for generating the seed of a simulation (initial value of an array)
 */
package main.java.simulation;

import main.java.interfaces.SimulData;
import java.util.Random;

public class SimulationSeedGenerator implements SimulData {
    protected static void createFieldsArr(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                fieldsArr[i][j] = 0;
            }
        }
    }
    protected static void generateRandomFieldsArr(){
        Random rand = new Random();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                fieldsArr[i][j] = rand.nextInt(2);
            }
        }
    }
    protected static void createAliveNeighbours(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                aliveNeighbours[i][j] = 0;
            }
        }
    }
}
