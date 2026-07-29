 import java.util.*;

//idea use dictionary instead of a matrix w dictionary you can give a name to all 9 points and check if "tr & mr & br" are equall

class Ttt{
    private String [] top = new String[3];
    private String [] mid = new String[3];
    private String [] bot = new String[3];
    private String[][] grid = new String[][]{top,mid,bot};
    static int filled_spcs =0;

    public Ttt(){
        /*
        top[0] = "A\t";
        mid[0] = "B\t";
        bot[0] = "C\t";

        bot[0] = "\t";
        bot[1]=" 1\t\t";
        bot[2]=" 2\t\t";
        bot[3] = " 3\t\t";
*/
    }

    public boolean add(String place,String X_or_O) {
        String vertical = place.substring(0, 1).toUpperCase();   // vert = each row/a
        String horizontal = place.substring(1, 2); // hori = each column/1
        int column = Integer.parseInt(horizontal);
        int row;
        // place should look like a1,a2,a3,b1,b2 ect..

        if (vertical == "A"){
            row =0 ;
        } else if (vertical == "B") {
            row = 1;
        } else if (vertical == "C") {
            row =2;
        }
        else{
            return false;
        }

        grid[row][column] = X_or_O;
        
        return true;

    }



    @Override
    public String toString() {
        String big = "";
        for (int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
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