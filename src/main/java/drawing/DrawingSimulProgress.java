/*
This class is responsible for drawing simulation progress in console.
 */

package main.java.drawing;

public class DrawingSimulProgress {
    public static void drawGeneration(int[][] fieldsArr) {
        System.out.println("==============================");
        for (int[] ints : fieldsArr) {
            for (int anInt : ints) {
                if(anInt == 0)
                    System.out.print("░" + " ");
                else
                    System.out.print("█" + " ");
            }
            System.out.println();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
