/*
This class is responsible for working on already running simulation and creating new life.
 */

package simulation;

import interfaces.SimulData;
import drawing.DrawingSimulProgress;

public class GameLogic implements SimulData {

    GameLogic(){
        SimulationSeedGenerator.createFieldsArr();
        SimulationSeedGenerator.generateRandomFieldsArr();
    }
    public void game(){
        SimulationSeedGenerator.createAliveNeighbours();
        fillAliveNeighbours();
        generateNewGeneration();
    }

    //function which count how many alive neighbours every field has. Unable to extract.
    private void fillAliveNeighbours(){
        //check how many alive neighbours has and count it
        // this long eight if checks that we are not out of range
        for(int i = 0; i < SimulData.fieldsArr.length; i++){
            for(int j = 0; j < SimulData.fieldsArr[i].length; j++){
                //check top left neighbour
                if((i-1 >=0 && j-1 >=0) && (i-1 < SimulData.fieldsArr[i].length && j-1 < SimulData.fieldsArr[i].length)){
                    if(SimulData.fieldsArr[i-1][j-1] == 1) {
                        SimulData.aliveNeighbours[i][j] += 1;
                    }
                }
                //check top middle neighbour
                if(i - 1 >= 0 && i-1 < SimulData.fieldsArr[i].length && j < SimulData.fieldsArr[i].length){
                    if(SimulData.fieldsArr[i-1][j] == 1) {
                        SimulData.aliveNeighbours[i][j] += 1;
                    }
                }
                //check top right neighbour
                if((i-1 >=0) && (i-1 < SimulData.fieldsArr[i].length && j+1 < SimulData.fieldsArr[i].length)){
                    if(SimulData.fieldsArr[i-1][j+1] == 1) {
                        SimulData.aliveNeighbours[i][j] += 1;
                    }
                }
                //check middle left neighbour
                if(j - 1 >= 0 && i < SimulData.fieldsArr[i].length && j - 1 < SimulData.fieldsArr[i].length){
                    if(SimulData.fieldsArr[i][j-1] == 1) {
                        SimulData.aliveNeighbours[i][j] += 1;
                    }
                }
                //check middle right neighbour
                if(i < SimulData.fieldsArr[i].length && j + 1 < SimulData.fieldsArr[i].length){
                    if(SimulData.fieldsArr[i][j+1] == 1) {
                        SimulData.aliveNeighbours[i][j] += 1;
                    }
                }
                //check bottom left neighbour
                if((j-1 >= 0) && (i+1 < SimulData.fieldsArr.length && j-1 < SimulData.fieldsArr[i].length)){
                    if(SimulData.fieldsArr[i+1][j-1] == 1) {
                        SimulData.aliveNeighbours[i][j] += 1;
                    }
                }
                //check bottom middle neighbour
                if((i+1 < SimulData.fieldsArr.length && j < SimulData.fieldsArr[i].length)){
                    if(SimulData.fieldsArr[i+1][j] == 1) {
                        SimulData.aliveNeighbours[i][j] += 1;
                    }
                }
                //check bottom right neighbour
                if((i+1 < SimulData.fieldsArr.length && j+1 < SimulData.fieldsArr[i].length)){
                    if(SimulData.fieldsArr[i+1][j+1] == 1) {
                        SimulData.aliveNeighbours[i][j] += 1;
                    }
                }

            }
        }
    }

    //function which base on aliveNeihbours array decide which fields will be alive in new generation
    private void generateNewGeneration(){
        DrawingSimulProgress.drawGeneration(SimulData.fieldsArr);

        for(int i = 0; i < SimulData.fieldsArr.length; i++){
            for(int j = 0; j < SimulData.fieldsArr[i].length; j++){

                //Każda żywa komórka z mniej niż dwoma żywymi sąsiadami umiera w kolejnej generacji z powodu wyludnienia,
                if(SimulData.fieldsArr[i][j] == 1 && SimulData.aliveNeighbours[i][j] < 2){
                    SimulData.fieldsArr[i][j] = 0;
                }
                /*
                    każda żywa komórka z dwoma lub trzema żywymi sąsiadami jest w stanie przetrwać do następnej generacji,
                    else if(fieldsArr[i][j] == 1 && (aliveNeighbours[i][j] == 2 || aliveNeighbours[i][j] ==3 )){
                        nothing change, alive field is still alive
                    }

                 */

                //każda żywa komórka z więcej niż trzema żywymi sąsiadami umiera w kolejnej generacji z powodu przeludnienia,

                else if(SimulData.fieldsArr[i][j] == 1 && SimulData.aliveNeighbours[i][j] > 3){

                        SimulData.fieldsArr[i][j] = 0;

                }

                //każda martwa komórka z dokładnie trzema żywymi sąsiadami staje się żywa w kolejnej generacji.
                else if(SimulData.fieldsArr[i][j] == 0 && SimulData.aliveNeighbours[i][j] == 3){
                    SimulData.fieldsArr[i][j] = 1;
                }
            }
        }
    }
}
