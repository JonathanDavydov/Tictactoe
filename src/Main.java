 import java.util.*;

class Ttt{
    private char [] top = new char[4];
    private char [] topm = new char[4];
    private char [] botm = new char[4];
    private char [] bot = new char[4];
    private char[][] grid = new char[][]{top,topm,botm,bot};

    public Ttt(){}


    @Override
    public String toString() {
        String big = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!(grid[i][j] == 0))
                    big += ""+grid[i][j]+", ";
                else
                    big += "null, ";

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