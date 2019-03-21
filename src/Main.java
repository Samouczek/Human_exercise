import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);
        System.out.println("Z ilu osób ma się składać lista?");
        int numberPersons = scaner.nextInt();


        Human ewa = new Human();
        System.out.println(ewa);
        double ewaBmi = ewa.calculateBMI();
        ewa.toJudgeBMI(ewaBmi);
        ewa.calculateBMR();
        ewa.calculateCPM();

    }
    /*
    public ArrayList savePersons(int numberPersons) {
        List<String> listPersons = new ArrayList<String>();
    }
    */
}

