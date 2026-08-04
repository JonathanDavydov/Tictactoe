import java.util.*;

//idea use dictionary instead of a matrix w dictionary you can give a name to all 9 points and check if "tr & mr & br" are equall

class Ttt{
    private String [] top = new String[3];
    private String [] mid = new String[3];
    private String [] bot = new String[3];
    private String [] pDia = new String[3]; // the point of these is so that i can avoid checking by going [1],[1] , [2],[2]
    private String [] nDia = new String[3];
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
        place = place.toUpperCase();
        String vertical = place.substring(0, 1);   // vert = each row/a
        String horizontal = place.substring(1, 2); // hori = each column/1
        int column = Integer.parseInt(horizontal)-1;
        int row;
        // place should look like a1,a2,a3,b1,b2 ect..

        if (vertical.equals("A")){
            row =0 ;
        } else if (vertical.equals("B")) {
            row = 1;
        } else if (vertical.equals("C")) {
            row =2;
        }
        else{
            return false;
        }

        grid[row][column] = X_or_O+"\t\t";
        return true;

    }



    @Override
    public String toString() {
        String ttt_str = ""; //this will put all the strings together
        String [] abc = {"a","b","c"};

        for (int i = 0; i < 3 ; i++) {
            ttt_str += abc[i] + "\t";
            for (int j = 0; j < 3; j++) {
                if ((grid[i][j] != null))
                    ttt_str += ""+grid[i][j]+" ";
                else
                    ttt_str += "null\t ";

            }
            ttt_str += "\n";
        }

        String nums = "\t1\t\t 2\t\t 3 \n" ;
        ttt_str = nums+ttt_str;
        return ttt_str;

    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ttt x = new Ttt();

        boolean continue_check = true;
        String place;
        String x_or_o;


        System.out.println(x.toString());;

        while(true){
            System.out.println("Do you want to continue?");
            if (scanner.nextBoolean() == false){
                break;
            }
            scanner.nextLine();

            System.out.println("Where");
            place = scanner.next();
            System.out.println("what");
            x_or_o = scanner.next();


            x.add(place,x_or_o);
            System.out.println(x.toString());
        }

    }
}