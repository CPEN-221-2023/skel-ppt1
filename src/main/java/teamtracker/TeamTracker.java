package teamtracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A datatype that represents a team's win/loss/draw history,
 * with operations to obtain different statistics related to
 * the team's peformance.
 *
 * @author CPEN 221 Team
 */
public class TeamTracker {

    private Level currentLevel;
    private int bestIntLevel = 15;
    private int currentIntLevel = 15;
    private int currentPoints;
    private int currentWinStreak;
    private int currentLossStreak;

    private int totalGames;
    private int totalWins;
    private int totalLosses;
    private int totalDraws;
    private ArrayList<Integer> points = new ArrayList<>();
    private Map<Integer, Integer> winsByLevel = new HashMap<>();
    private Map<Integer, Integer> lossesByLevel = new HashMap<>();
    private Map<Integer, Integer> drawsByLevel = new HashMap<>();

    private ArrayList<Game> games = new ArrayList<>();

    /**
     * Create a new TeamTracker with a given history of win/loss/draws
     *
     * @param teamHistory the win/loss/draw history of the team, does not contain characters other than 'W', 'L' and 'D'
     */
    public TeamTracker(String teamHistory) {
        this.currentLevel = convertIntToLevel(currentIntLevel);
        this.addResult(teamHistory);
    }

    private static int convertLevelToInt(Level l) {
        return ((l.getDivision() - 1) * 4 + (l.getBracket() - 1));
    }

    private static Level convertIntToLevel(int l) {
        return new Level(l / 4 + 1, l % 4 + 1);
    }

    public List<Game> getAllGames() {
        return new ArrayList<>(games);
    }

    /**
     * Add the result of the most recent game to the TeamTracker
     *
     * @param result is one of 'W', 'L', 'D'
     */
    public void addResult(char result) {
        games.add(new Game(result, currentLevel));

        switch (result) {
            case 'W':
                totalWins++;
                points.add(2);
                currentPoints = currentPoints < 5 ? currentPoints + 2 : 0;
                currentWinStreak += 1;
                currentLossStreak = 0;
                winsByLevel.put(currentIntLevel, winsByLevel.getOrDefault(currentIntLevel, 0) + 1);
                break;
            case 'L':
                totalLosses++;
                points.add(-1);
                currentPoints = currentPoints > 0 ? currentPoints - 1 : 0;
                currentWinStreak = 0;
                currentLossStreak += 1;
                lossesByLevel.put(currentIntLevel,
                    lossesByLevel.getOrDefault(currentIntLevel, 0) + 1);
                break;
            case 'D':
                totalDraws++;
                points.add(0);
                currentWinStreak = 0;
                currentLossStreak = 0;
                drawsByLevel.put(currentIntLevel,
                    drawsByLevel.getOrDefault(currentIntLevel, 0) + 1);
                break;
            default:
                throw new IllegalArgumentException("Invalid game result");
        }

        totalGames++;

        if (currentWinStreak == 3 && currentIntLevel > 0) {
            currentIntLevel -= 1;
            if (currentIntLevel < bestIntLevel) {
                bestIntLevel = currentIntLevel;
            }
            currentLevel = convertIntToLevel(currentIntLevel);
            currentPoints = 0;
            currentWinStreak = 0;
        }

        if ((currentLossStreak == 3 && currentIntLevel % 4 != 3) ||
            (currentLossStreak == 5 && currentIntLevel < 15)) {
            currentIntLevel += 1;
            currentLevel = convertIntToLevel(currentIntLevel);
            currentPoints = 0;
            currentLossStreak = 0;
        }
    }

    /**
     * Add a sequence of recent results to the TeamTracker
     *
     * @param results is the sequence of recent results, with the first character representing the result of the earliest game not recorded, and does not contain characters other than 'W', 'L', 'D'
     */
    public void addResult(String results) {
        for (int i = 0; i < results.length(); i++) {
            this.addResult(results.charAt(i));
        }
    }

    /**
     * Returns the fraction of games won (out of the total played games)
     *
     * @return the fraction of games won (out of the total played games)
     */
    public double fractionWins() {
        return (1.0 * totalWins) / totalGames;
    }

    /**
     * Returns the fraction of games lost (out of the total played games)
     *
     * @return the fraction of games lost (out of the total played games)
     */
    public double fractionLosses() {
        return (1.0 * totalLosses) / totalGames;
    }

    /**
     * Returns the fraction of games drawn (out of the total played games)
     *
     * @return the fraction of games drawn (out of the total played games)
     */
    public double fractionDraws() {
        return (1.0 * totalDraws) / totalGames;
    }

    /**
     * Returns the total number of games played
     *
     * @return the total number of games played
     */
    public int totalGamesPlayed() {
        return totalGames;
    }

    /**
     * Returns the current level (Division, Bracket) that the team is playing at
     *
     * @return the current level the team is playing at
     */
    public Level getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Returns a sequence that represents the points won across all games played so far
     *
     * @return a sequence that represents the points won across all games played so far, , with the first entry corresponding to the earliest game and the last entry corresponding to the most recent game
     */
    public List<Integer> getPointsHistory() {
        return new ArrayList<>(points);
    }

    /**
     * Returns the fraction of games won at the specified level
     *
     * @param level is a level in [(Division = 4, Bracket = 4), ..., (Division = 1, Bracket = 1)]
     * @return the fraction of games won at the specified level
     */
    public double fractionWinsAtLevel(Level level) {
        int levelInt = convertLevelToInt(level);
        int w = winsByLevel.getOrDefault(levelInt, 0);
        int l = lossesByLevel.getOrDefault(levelInt, 0);
        int d = drawsByLevel.getOrDefault(levelInt, 0);

        if (w + l + d == 0) {
            return 0.0;
        }

        return (1.0 * w) / (w + l + d);
    }

    /**
     * Returns the fraction of games lost at the specified level
     *
     * @param level is a level in [(Division = 4, Bracket = 4), ..., (Division = 1, Bracket = 1)]
     * @return the fraction of games lost at the specified level
     */
    public double fractionLossesAtLevel(Level level) {
        int levelInt = convertLevelToInt(level);
        int w = winsByLevel.getOrDefault(levelInt, 0);
        int l = lossesByLevel.getOrDefault(levelInt, 0);
        int d = drawsByLevel.getOrDefault(levelInt, 0);

        if (w + l + d == 0) {
            return 0.0;
        }

        return (1.0 * l) / (w + l + d);
    }

    /**
     * Returns the fraction of games drawn at the specified level
     *
     * @param level is a level in [(Division = 4, Bracket = 4), ..., (Division = 1, Bracket = 1)]
     * @return the fraction of games drawn at the specified level
     */
    public double fractionDrawsAtLevel(Level level) {
        int levelInt = convertLevelToInt(level);
        int w = winsByLevel.getOrDefault(levelInt, 0);
        int l = lossesByLevel.getOrDefault(levelInt, 0);
        int d = drawsByLevel.getOrDefault(levelInt, 0);

        if (w + l + d == 0) {
            return 0.0;
        }

        return (1.0 * d) / (w + l + d);
    }

    /**
     * Return true if this team and the other team have similar records at each common level they have played at. Similarity is defined as having the same fraction (+/- 0.01) of games won/lost/drawn at each common level the teams have played at.
     *
     * @param other represents the game history of another team
     * @return true if this team and the other team have similar records at each common level they have played at
     */
    public boolean similar(TeamTracker other) {
        double[] deltaW = new double[16];
        double[] deltaL = new double[16];

        int highestLevel = Math.min(this.bestIntLevel, other.bestIntLevel);

        for (int i = highestLevel; i < 16; i++) {
            Level level = convertIntToLevel(i);
            deltaW[i] =
                Math.abs(this.fractionWinsAtLevel(level) - other.fractionWinsAtLevel(level));
            deltaL[i] =
                Math.abs(this.fractionLossesAtLevel(level) - other.fractionLossesAtLevel(level));
        }

        for (int i = 0; i < 16; i++) {
            if (deltaW[i] > 0.01) {
                return false;
            }
            if (deltaL[i] > 0.01) {
                return false;
            }
        }

        return true;
    }

}
