 import java.util.*;

//idea use dictionary instead of a matrix w dictionary you can give a name to all 9 points and check if "tr & mr & br" are equall

class Ttt{
    private String [] top = new String[4];
    private String [] topm = new String[4];
    private String [] botm = new String[4];
    private String [] bot = new String[4];
    private String[][] grid = new String[][]{top,topm,botm,bot};

    public Ttt(){
        top[0] = "A\t";
        topm[0] = "B\t";
        botm[0] = "C\t";

        bot[0] = "\t";
        bot[1]=" 1\t\t";
        bot[2]=" 2\t\t";
        bot[3] = " 3\t\t";

    }
    public boolean add(String place,String X_or_O){
        row = place.substring.(0,1)
    }


    @Override
    public String toString() {
        String big = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!(grid[i][j] == null))
                    big += ""+grid[i][j]+" ";
                else
                    big += "null\t ";

            }
            big += "\n";

        }
        return big;

    }
}


public class Main {
    public static void main(String[] args) {

    Ttt x = new Ttt();
        System.out.println(x.toString());;





    }
}