package main.java;

public class DrawingSimulProgress {
    public static void drawGeneration(int[][] fieldsArr) {
        for (int[] ints : fieldsArr) {
            for (int anInt : ints) {
                if(anInt == 0)
                    System.out.print("░" + " ");
                else
                    System.out.print("█" + " ");//▄█
//                System.out.print(anInt);
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
