import java.util.*;

public class Main {

    public static void main(String[] args) {
        int epic = 0;
        int legendary = 0;
        int number = 0;
        Random card = new Random();
        char goAgain = 'y';

        while (goAgain == 'y') {
            for (int i = 0; i < 5; i++) {
                if (legendary == 195) {
                    number = 100;
                } else if (epic == 35) {
                    number = 97;
                } else if (i == 0) {
                    number = card.nextInt(27) + 73;
                } else {
                    number = card.nextInt(100) + 1;
                }

                if (number < 73) {
                    System.out.println("common");
                    legendary++;
                    epic++;
                } else if (number > 72 && number < 95) {
                    System.out.println("rare!");
                    legendary++;
                    epic++;
                } else if (number > 94 && number < 99) {
                    System.out.println("EPIC!");
                    legendary++;
                    epic = 0;
                } else {
                    System.out.println("L E G E N D A R Y ! ! !");
                    legendary = 0;
                }
            }
            Scanner scan = new Scanner(System.in);
            goAgain = scan.next().charAt(0);
        }
    }
}
