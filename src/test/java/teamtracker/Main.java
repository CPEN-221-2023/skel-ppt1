package teamtracker;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rng = new Random();
        int numGames = rng.nextInt(30) + 36;

        StringBuilder teamHistory = new StringBuilder();

        for (int i = 0; i < numGames; i++) {
            int outcome = rng.nextInt(4);
            switch (outcome) {
                case 0:
                case 1:
                    teamHistory.append('W'); break;
                case 2: teamHistory.append('L'); break;
                case 3: teamHistory.append('D');
            }
        }

        System.out.println(teamHistory);

    }

}
