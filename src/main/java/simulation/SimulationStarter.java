/*
This class is responsible for running the simulation.
 */
package simulation;

import java.util.Scanner;

public class SimulationStarter {

    public static void runningSimulation(){
        GameLogic game = new GameLogic();
        int generations = 0;
        Scanner scan = new Scanner(System.in);
        while(true){
            generations++;
            if(generations % 10 == 0){
                System.out.print("Continue for next 10 generations or Stop?(c/s): ");
                String answer = scan.nextLine();
                if(answer.equals("s")){
                    break;
                }
                else if(!answer.equals("c")){
                    System.out.println("Wrong input, Program will contiune and again ask you after 10 generations");
                }
            }
            game.game();
        }
    }

}