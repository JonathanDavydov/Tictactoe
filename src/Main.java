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
            pDia.add("Null\t");
            nDia.add("Null\t");
        }

        grid.add(top);
        grid.add(mid);
        grid.add(bot);

    }

    public boolean add(String place,String x_or_o) {
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

        grid.get(row).set(column,x_or_o+"\t\t");
        pDia.set(0,bot.get(0));
        pDia.set(1,mid.get(1));
        pDia.set(2,top.get(2));

        nDia.set(0,bot.get(0));
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

    public boolean check(String x_or_o){
        //horizontal checks
        Set<String> tops = new HashSet<>(top);
        Set<String> mids = new HashSet<>(mid);
        Set<String> bots = new HashSet<>(bot);
        Set<String> pDias = new HashSet<>(pDia);
        Set<String> nDias = new HashSet<>(nDia);
        //if any of the above have a duplicate that means that they are false


        // i need to check vertically and i need check if the symbol exists
        boolean horizontal_checks = (tops.size() < 2 && tops.contains(x_or_o)) || (mids.size() < 2 && mids.contains(x_or_o)) || (bots.size() < 2 && bots.contains(x_or_o));
        boolean dia_checks =(pDias.size() < 2 && pDias.contains(x_or_o)) || (nDias.size() < 2 && nDias.contains(x_or_o));


        if (horizontal_checks || dia_checks){
            return true;
        }

        return false;
    }


}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ttt x = new Ttt();
        String place;
        String x_or_o = "X";


        System.out.println(x.toString());;

        while(true){
            if (x.check(x_or_o)){
                System.out.println("blank Win!!");
                break;
            }

//            System.out.println("Do you want to continue?");
//            if (scanner.nextBoolean() == false){
//                break;
//            }
//            scanner.nextLine(); // gets rid of the space after the bool

            System.out.println("where does "+x_or_o+" go? ");
            place = scanner.next();



            x.add(place,x_or_o);
            System.out.println(x.toString());

            if (x_or_o == "X")
                x_or_o = "O";
            else
                x_or_o= "X";
        }

    }
}