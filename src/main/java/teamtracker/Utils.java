package teamtracker;

import java.util.List;

/**
 * Utility class for working with multiple TeamTracker instances
 */

public class Utils {

    /**
     * Return the maximum number of games that team1 and team2 could have
     * played against each other
     *
     * @param team1 is not null
     * @param team2 is not null
     * @return the maximum number of games that team1 and team2 could have
     * played against each other
     */
    public static int computeMostJointGames(TeamTracker team1, TeamTracker team2) {
        List<Game> games1 = team1.getAllGames();
        List<Game> games2 = team2.getAllGames();

        int[][] memo = new int[games1.size()][games2.size()];
        for (int i = 0; i < games1.size(); i++) {
            for (int j = 0; j < games2.size(); j++) {
                memo[i][j] = -1;
            }
        }

        return computeMostJointGames(games1, games2, games1.size() - 1, games2.size() - 1, memo);
    }

    /**
     * Helper method for recursive solution
     * @param games1
     * @param games2
     * @param n1
     * @param n2
     * @param memo
     * @return
     */
    private static int computeMostJointGames(List<Game> games1, List<Game> games2,
                                             int n1, int n2,
                                             int[][] memo) {

        if (n1 < 0 || n2 < 0) {
            return 0;
        }

        if (memo[n1][n2] != -1) {
            return memo[n1][n2];
        }

        int count1 = 0, count2, count3;
        if (games1.get(n1).isCompatible(games2.get(n2))) {
            count1 = 1 + computeMostJointGames(games1, games2, n1 - 2, n2 - 2, memo);
        }
        count2 = computeMostJointGames(games1, games2, n1 - 1, n2, memo);
        count3 = computeMostJointGames(games1, games2, n1, n2 - 1, memo);
        memo[n1][n2] = Math.max(count1, Math.max(count2, count3));
        return memo[n1][n2];
    }
}
