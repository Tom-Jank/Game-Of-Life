public class GameLogic {


    int [][]fieldsArr = {{0,0,0,0},{0,1,1,1},{0,0,1,0},{0,0,1,0}}; //1 represents who is alived
    int [][]aliveNeighbours = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

    public void game(){
        fillAliveNaighbours();
        generateNewGeneration();
    }


    //function which count how many alive neighbours every field has
    private void fillAliveNaighbours(){
        //check how many alive neighbours has and count it
        // this long eight if checks that we are not out of range
        for(int i = 0; i < fieldsArr.length; i++){
            for(int j = 0; j < fieldsArr[i].length; j++){

                //check top left neighbour
                if((i-1 >=0 && j-1 >=0) && (i-1 < fieldsArr.length && j-1 < fieldsArr[i].length)){
                    if(fieldsArr[i-1][j-1] == 1) {
                        aliveNeighbours[i][j] += 1;
                    }
                }
                //check top middle neighbour
                if((i-1 >=0 && j >=0) && (i-1 < fieldsArr.length && j < fieldsArr[i].length)){
                    if(fieldsArr[i-1][j] == 1) {
                        aliveNeighbours[i][j] += 1;
                    }
                }
                //check top right neighbour
                if((i-1 >=0 && j+1 >=0) && (i-1 < fieldsArr.length && j+1 < fieldsArr[i].length)){
                    if(fieldsArr[i-1][j+1] == 1) {
                        aliveNeighbours[i][j] += 1;
                    }
                }
                //check middle left neighbour
                if((i >=0 && j-1 >=0) && (i < fieldsArr.length && j-1 < fieldsArr[i].length)){
                    if(fieldsArr[i][j-1] == 1) {
                        aliveNeighbours[i][j] += 1;
                    }
                }
                //check middle right neighbour
                if((i >=0 && j+1 >=0) && (i < fieldsArr.length && j+1 < fieldsArr[i].length)){
                    if(fieldsArr[i][j+1] == 1) {
                        aliveNeighbours[i][j] += 1;
                    }
                }
                //check bottom left neighbour
                if((i+1 >=0 && j-1 >=0) && (i+1 < fieldsArr.length && j-1 < fieldsArr[i].length)){
                    if(fieldsArr[i+1][j-1] == 1) {
                        aliveNeighbours[i][j] += 1;
                    }
                }
                //check bottom middle neighbour
                if((i+1 >=0 && j >=0) && (i+1 < fieldsArr.length && j < fieldsArr[i].length)){
                    if(fieldsArr[i+1][j] == 1) {
                        aliveNeighbours[i][j] += 1;
                    }
                }
                //check bottom right neighbour
                if((i+1 >=0 && j+1 >=0) && (i+1 < fieldsArr.length && j+1 < fieldsArr[i].length)){
                    if(fieldsArr[i+1][j+1] == 1) {
                        aliveNeighbours[i][j] += 1;
                    }
                }

            }
        }
        System.out.println("===============Tablica z liczbą żywych sąsiadów===============");
        for(int i = 0; i < fieldsArr.length; i++){
            for(int j = 0; j < fieldsArr[i].length; j++){
                System.out.print(aliveNeighbours[i][j] + "  ");
            }
            System.out.println();
        }
    }

    //function which base on aliveNeihbours array decide which fields will be alive in new generation
    private void generateNewGeneration(){

        System.out.println("===============Stara Generacja===============");
        for(int i = 0; i < fieldsArr.length; i++){
            for(int j = 0; j < fieldsArr[i].length; j++){
                System.out.print(fieldsArr[i][j] + "  ");
            }
            System.out.println();
        }

        for(int i = 0; i < fieldsArr.length; i++){
            for(int j = 0; j < fieldsArr[i].length; j++){

                //Każda żywa komórka z mniej niż dwoma żywymi sąsiadami umiera w kolejnej generacji z powodu wyludnienia,
                if(fieldsArr[i][j] == 1 && aliveNeighbours[i][j] < 2){
                    fieldsArr[i][j] = 0;
                }
                //każda żywa komórka z dwoma lub trzema żywymi sąsiadami jest w stanie przetrwać do następnej generacji,
                else if(fieldsArr[i][j] == 1 && (aliveNeighbours[i][j] == 2 || aliveNeighbours[i][j] ==3 )){
                    //nothing change, alive field is still alive
                }
                //każda żywa komórka z więcej niż trzema żywymi sąsiadami umiera w kolejnej generacji z powodu przeludnienia,
                else if(fieldsArr[i][j] == 1 && aliveNeighbours[i][j] > 3){
                    fieldsArr[i][j] = 0;
                }
                //każda martwa komórka z dokładnie trzema żywymi sąsiadami staje się żywa w kolejnej generacji.
                else if(fieldsArr[i][j] == 0 && aliveNeighbours[i][j] == 3){
                    fieldsArr[i][j] = 1;
                }
            }
        }

        System.out.println("===============Nowa Generacja===============");
        for(int i = 0; i < fieldsArr.length; i++){
            for(int j = 0; j < fieldsArr[i].length; j++){
                System.out.print(fieldsArr[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
