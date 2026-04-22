 import java.util.*;

//idea use dictionary instead of a matrix w dictionary you can give a name to all 9 points and check if "tr & mr & br" are equall

class Ttt{
    private String [] top = new String[4];
    private String [] topm = new String[4];
    private String [] botm = new String[4];
    private String [] bot = new String[4];
    private String[][] grid = new String[][]{top,topm,botm,bot};
    static int filled_spcs =0;

    public Ttt(){
        top[0] = "A\t";
        topm[0] = "B\t";
        botm[0] = "C\t";

        bot[0] = "\t";
        bot[1]=" 1\t\t";
        bot[2]=" 2\t\t";
        bot[3] = " 3\t\t";

    }

    public boolean add(String place,String X_or_O) {
        String vertical = place.substring(0, 1).toUpperCase();   // vert = each row/a
        String horizontal = place.substring(1, 2); // hori = each column/1


        for (int i = 1; i < 3; i++) {
            if (bot[i].trim().equals(horizontal)){
                //System.out.println("is equal "+ i+" ");
                for (int j = 0; j < 3; j++) {

                   // Object t = grid[j][0];
                  //  System.out.println(t);
                    if (grid[j][0].trim().equals(vertical)) {
                        //System.out.println("is equal "+ j+" ");
                        grid[j][i] = X_or_O;
                        System.out.println(grid[j][i]);
                        break;
                    }
                }

            }

        }
       return true;

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

        x.add("a1","x");
        System.out.println(x.toString());;


    }
}