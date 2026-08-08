import java.util.*;

//idea use dictionary instead of a matrix w dictionary you can give a name to all 9 points and check if "tr & mr & br" are equall

class Ttt{
    //Notes: orignally did regualr java list but since it is not collection i cant turn it into a set.
    // i want it too be a set because set's can remove duplicates
    private ArrayList<String> top = new ArrayList<>(3);
    private ArrayList<String> bot = new ArrayList<>(3);
    private ArrayList<String> pDia = new ArrayList<>(3);
    private ArrayList<String> nDia = new ArrayList<>(3);
    private ArrayList<String> mid = new ArrayList<>(3);
    private ArrayList<ArrayList<String>> grid = new ArrayList<>(3);
    static int filled_spcs =0; //idk why i have this

    public Ttt(){
        for (int i = 0; i < 3; i++) {
            //gives all of the lists something to add too for toString()
            top.add("Null\t");
            mid.add("Null\t");
            bot.add("Null\t");
        }

        grid.add(top);
        grid.add(mid);
        grid.add(bot);

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
        //grid[row][column] = X_or_O+"\t\t";

        grid.get(row).set(column,X_or_O+"\t\t");
        nDia.set(0,bot.get(0));
        pDia.set(1,mid.get(1));
        pDia.set(2,top.get(2));

        nDia.set(0,top.get(0));
        nDia.set(1,mid.get(1));
        nDia.set(2,top.get(2));
        return true;

    }

    @Override
    public String toString() {
        //if ((grid[i][j] != null)) line 55
        String ttt_str = ""; //this will put all the strings together
        String [] abc = {"a","b","c"};

        for (int i = 0; i < 3 ; i++) {
            ttt_str += abc[i] + "\t";
            for (int j = 0; j < 3; j++) {

                if (grid.get(i).get(j) != null)
                    ttt_str += ""+grid.get(i).get(j)+" ";
                else
                    ttt_str += "null\t ";

            }
            ttt_str += "\n";
        }

        String nums = "\t1\t\t 2\t\t 3 \n" ; //add's top row of numbers
        ttt_str = nums+ttt_str;
        return ttt_str;

    }

    public boolean check(){
        //horizontal checks
        Set<String> tops = new HashSet<>(top);
        Set<String> mids = new HashSet<>(mid);
        Set<String> bots = new HashSet<>(bot);
        Set<String> pDias = new HashSet<>(pDia);
        Set<String> nDias = new HashSet<>(nDia);
        //if any of the above have a duplicate that means taht they are false

        if ((tops.size() < 2) || (mids.size() < 2) || (bots.size() < 2) || (pDias.size() < 2) || (nDias.size() < 2)){
            return true;
        }

        return false;
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