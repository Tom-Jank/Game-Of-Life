/*
This interface contains information regarding simulation parameters (eg: size of an array)
 */

package main.resources;
public interface SimulData {
    int n = 7;
    int [][]fieldsArr = new int[n][n];      //1 represents alive cell
    int [][]aliveNeighbours = new int[n][n];
}
