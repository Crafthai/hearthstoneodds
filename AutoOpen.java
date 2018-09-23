import java.util.*;

public class AutoOpen {

    public static void main(String[] args) {

        double numCommon = 0;
        double numRare = 0;
        double numEpic = 0;
        double numLegendary = 0;
        int legendaryIn;
        int threeLegendaryInPacks = 0;
        int fourLegendaryInPacks = 0;
        int fiveLegendaryInPacks = 0;
        int epic = 0;
        int epicTimer = 0;
        int legendary = 0;
        int legendaryTimer = 0;
        int number = 0;
        char goAgain = 'y';
        Random card = new Random();

        int k = 0;
        int cards = 0;
        while (goAgain == 'y') {

            Scanner scan = new Scanner(System.in);
            System.out.println("how many packs??");
            int packs = scan.nextInt();

            for (int j = 0; j < packs; j++) {
                legendaryIn = 0;
                for (int i = 0; i < 5; i++) {
                    if (legendary == 195) {
                        number = 100;
                        legendaryTimer++;
                    } else if (epic == 35) {
                        number = 97;
                        epicTimer++;
                    } else if (i == 0) {
                        System.out.println("pack #" + (k + 1));
                        number = card.nextInt(30) + 270;
                    } else {
                        number = card.nextInt(300) + 1;
                    }

                    if (number < 270) {
                        System.out.println("common");
                        numCommon++;
                        legendary++;
                        epic++;
                    } else if (number > 269 && number < 294) {
                        System.out.println("rare!");
                        numRare++;
                        legendary++;
                        epic++;
                    } else if (number > 293 && number < 299) {
                        System.out.println("EPIC!");
                        numEpic++;
                        legendary++;
                        epic = 0;
                    } else {
                        System.out.println("L E G E N D A R Y ! ! !");
                        numLegendary++;
                        legendaryIn++;
                        legendary = 0;
                    }

                    if (i == 4) {
                        System.out.println("\n");
                    }
                    cards++;
                }
                k++;
                switch (legendaryIn) {
                    case 3:
                        threeLegendaryInPacks++;
                        break;
                    case 4:
                        fourLegendaryInPacks++;
                        break;
                    case 5:
                        fiveLegendaryInPacks++;
                        break;
                    default:
                        break;
                }
            }
            System.out.println("percentage of commons: " + ((numCommon / cards) * 100) + "%" +
                    "\npercentage of rares: " + ((numRare / cards) * 100) + "%" +
                    "\npercentage of epics: " + ((numEpic / cards) * 100) + "%" +
                    "\npercentage of legendaries: " + ((numLegendary / cards) * 100) + "%" +
                    "\nnumber of epics hit by pity timer: " + epicTimer +
                    "\nnumber of legendaries hit by pity timer: " + legendaryTimer);
            System.out.println("\nnumber of times with 3 legendaries in a pack: " + threeLegendaryInPacks +
                    "\nnumber of times with 4 legendaries in a pack: " + fourLegendaryInPacks +
                    "\nnumber of times with 5 legendaries in a pack: " + fiveLegendaryInPacks);
            System.out.println("\nnumber of epics: " + numEpic +
                    "\nnumber of legendaries: " + numLegendary);

            System.out.println("\nWould you like to open more packs? Enter y to continue or any other letter to quit");
            goAgain = scan.next().charAt(0);
        }
    }
}
