import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Human {
    private String name;
    private int age;
    private int height;
    private int weight;
    private int quantityOfMovement;
    private String  sex;

    public Human() {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj imie");
        name = in.nextLine();
        System.out.println("Jesteś kobietą czy mężczyzną");
        sex = in.nextLine();
        System.out.println("Podaj wiek");
        age = in.nextInt();
        System.out.println("Podaj wzrost w centymetrach");
        height = in.nextInt();
        System.out.println("Podaj wagę w kilogramach");
        weight = in.nextInt();
        System.out.println("Wybierz odpowiadajaca dla Ciebie aktywność fizyczną - poziom ruchu w ciągu dnia bez treningów");
        System.out.println("1 - brak aktywności, praca siedząca");
        System.out.println("2 - niska aktywność (praca siedząca i 1-2 treningi w tygodniu)");
        System.out.println("3 - średnia aktywność (praca siedząca i treningi 3-4 razy w tygodniu)");
        System.out.println("4 - wysoka aktywność (praca fizyczna i 3-4 treningi w tygodniu)");
        System.out.println("5 - bardzo wysoka aktywność (zawodowi sportowcy, osoby codziennie trenujące)");
        quantityOfMovement = in.nextInt();
    }

    public static void main(String[] args) throws FileNotFoundException {
    Human anna = new Human();
    System.out.println(anna);
    double bmi = anna.calculateBMI();
    anna.toJudgeBMI( bmi);
    anna.calculateBMR();
    anna.calculateCPM();

    anna.saveToTxt(anna);

     }

     public void saveToTxt (Human txt) throws FileNotFoundException {
         PrintWriter save = new PrintWriter("Human.txt");
         save.print(txt);
         save.close();
     }

    public void saveIntegerToTxt (int txt) throws FileNotFoundException {
        PrintWriter save = new PrintWriter("Human.txt");
        save.print(txt);
        save.close();
    }

    @Override
     public String toString() {
        return ("Imie: " + this.name +
                ", płeć: " + this.sex + "\n" +
                " Wiek: " + this.age + " lat, wzrost: " + this.height + " cm, waga: " + this.weight + " kg." + "\n" +
                "Aktywnosc fizyczna " + quantityOfMovement + "\n");
     }

    public double calculateCPM() {
        double bmr;
        String first = sex.substring(0,1);
        String women = "k";
        if ( first.equals(women)) {
            bmr = 655 + 9.6 * weight + 1.8 * height - 4.7 * age;
        } else {
            bmr = 66 + 13.7 * weight + 5 * height - 6.76 * age;
        }

        double cpm;
         switch (quantityOfMovement) {
             case 1:
                 cpm = 1.2 * bmr;
                 break;
             case 2:
                 cpm = 1.4 * bmr;
                 break;
             case 3:
                 cpm = 1.6 * bmr;
                 break;
             case 4:
                 cpm = 1.8 * bmr;
                 break;
             default:
                 cpm = 2.2 * bmr;
                 break;
         }
         System.out.printf("Dobowe zapotrzebowanie kaloryczne (CPM) %8.1f", cpm);
         System.out.println();
         return cpm;
         }

    public  double calculateBMR() {
        double bmr;
        String first = sex.substring(0,1);
        String men = "m";
        if ( first.equals(men)) {
            bmr = 66 + 13.7 * weight + 5 * height - 6.76 * age;
        } else {
            bmr = 655 + 9.6 * weight + 1.8 * height - 4.7 * age;
        }
        System.out.printf("Podstawowego zapotrzebowania kalorycznego (BMR) metodą Harrisa-Benedicta %8.1f", bmr);
        System.out.println();
        return bmr;
    }

    public double calculateBMI () {
        double bmi =  this.weight/((this.height* 0.01)*(this.height *0.01));
        System.out.printf("WKaskaźnik masy ciała (BMI) wynosi %6.1f", bmi);
        System.out.println();
        return bmi;
    }

    public void toJudgeBMI (double bmi) {
        System.out.printf("Współczynnik BMI wynosi %8.2f i  to oznacza: ", bmi);

        if (bmi<16) {
            System.out.println("wygłodzenie");
        } else {
            if (16 <= bmi  && bmi < 17){
                System.out.println("wychudzenie");
            } else {
                if (17 <= bmi && bmi < 18.5) {
                    System.out.println("niedowaga");
                } else {
                    if (18.5 <= bmi && bmi < 25) {
                        System.out.println("wartość prawidłowa");
                    } else {
                        if ((25 <= bmi) && (bmi < 30)) {
                            System.out.println("nadwaga");
                            } else {
                                if (30 <= bmi && bmi< 35) {
                                    System.out.println("I stopien otylosci");
                                } else {
                                    if (35 <= bmi && bmi < 40) {
                                        System.out.println("II stopień otyłości");
                                    } else {
                                        System.out.println("III stopień otyłośi");
                                    }
                                }


                        }
                    }
                }

            }
        }

    }


}
