import java.util.*;

public class AutoOpen {

    public static void main(String[] args) {

        //variables
        double numCommon = 0;
        double goldCommon = 0;
        double numRare = 0;
        double goldRare = 0;
        double numEpic = 0;
        double goldEpic = 0;
        double numLegendary = 0;
        double goldLegendary = 0;
        int bestScore = 0;
        int bestPack = 0;
        int totalDust = 0;
        int legendaryIn;
        int score;
        int threeLegendaryInPacks = 0;
        int fourLegendaryInPacks = 0;
        int fiveLegendaryInPacks = 0;
        int epic = 0;
        int epicTimer = 0;
        int legendary = 0;
        int legendaryTimer = 0;
        int number = 0;
        int gold = 0;
        char goAgain = 'y';
        Random card = new Random();

        int k = 0;
        int cards = 0;
        while (goAgain == 'y') {

            Scanner scan = new Scanner(System.in);
            System.out.println("how many packs??");
            int packs = scan.nextInt();

            //beginning of session loop
            for (int j = 0; j < packs; j++) {
                legendaryIn = 0;
                score = 0;
                //beginning of pack loop
                for (int i = 0; i < 5; i++) {

                    //pity timer check
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

                    //prints the card you got
                    if (number < 270) {
                        gold = card.nextInt(47);
                        if (gold == 23) {
                            System.out.println("golden common");
                            goldCommon++;
                            score = score + 50;
                        } else {
                            System.out.println("common");
                        }
                        numCommon++;
                        legendary++;
                        epic++;
                        score = score + 5;

                    } else if (number > 269 && number < 294) {
                        gold = card.nextInt(16);
                        if (gold == 8) {
                            System.out.println("golden rare!");
                            goldRare++;
                            score = score + 100;
                        } else {
                            System.out.println("rare!");
                        }
                        numRare++;
                        legendary++;
                        epic++;
                        score = score + 20;

                    } else if (number > 293 && number < 299) {
                        gold = card.nextInt(16);
                        if (gold == 8) {
                            System.out.println("GOLDEN EPIC!");
                            goldEpic++;
                            score = score + 400;
                        } else {
                            System.out.println("EPIC!");
                        }
                        numEpic++;
                        legendary++;
                        epic = 0;
                        score = score + 100;

                    } else {
                        gold = card.nextInt(11);

                        if (gold == 8) {
                            System.out.println("WAAAAHHHHH   G O L D E N   L E G E N D A R Y ! ! !");
                            goldLegendary++;
                            score = score + 1600;
                        } else {
                            System.out.println("L E G E N D A R Y!!!!");
                        }
                        numLegendary++;
                        legendaryIn++;
                        legendary = 0;
                        score = score + 400;
                    }

                    //breaks line after a pack for readability
                    if (i == 4) {
                        System.out.println("\n");
                    }
                    //cards in pack counter
                    cards++;
                }
                //total card counter
                k++;

                //stores the total amount of dust from this pack opening session
                totalDust = totalDust + score;

                //stores what the best score was and what pack # it was
                if (score > bestScore) {
                    bestScore = score;
                    bestPack = k;
                }

                //how many legendaries per pack
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
            System.out.println("\npercentage of gold commons (out of normal cards): " + ((goldCommon / numCommon) * 100) + "%" +
                    "\npercentage of gold rares: " + ((goldRare / numRare) * 100) + "%" +
                    "\npercentage of gold epics: " + ((goldEpic / numEpic) * 100) + "%" +
                    "\npercentage of golden legendaries: " + ((goldLegendary / numLegendary) * 100) + "%");
            System.out.println("\nnumber of times with 3 legendaries in a pack: " + threeLegendaryInPacks +
                    "\nnumber of times with 4 legendaries in a pack: " + fourLegendaryInPacks +
                    "\nnumber of times with 5 legendaries in a pack: " + fiveLegendaryInPacks);
            System.out.println("\nnumber of epics: " + numEpic +
                    "\nnumber of legendaries: " + numLegendary);
            System.out.println("The best pack opened was pack # " + bestPack +
                    "\nand the score was " + bestScore);
            System.out.println("\nTotal dust gained: " + totalDust);

            System.out.println("\nWould you like to open more packs? Enter y to continue or any other letter to quit");
            goAgain = scan.next().charAt(0);
        }
    }
}
