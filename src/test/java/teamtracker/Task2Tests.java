package teamtracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Task2Tests {
    @Test
    void test1() {
        TeamTracker team1 = new TeamTracker("");
        Level level1 = team1.getCurrentLevel();
        assertEquals(4, level1.getDivision());
        assertEquals(4, level1.getBracket());
    }

    @Test
    void test2() {
        TeamTracker team1 = new TeamTracker("WWWW");
        Level level1 = team1.getCurrentLevel();
        assertEquals(4, level1.getDivision());
        assertEquals(3, level1.getBracket());
    }

    @Test
    void test3() {
        TeamTracker team1 = new TeamTracker("");
        TeamTracker team2 = new TeamTracker("");
        assertEquals(team2, team1);
    }

    @Test
    void test4() {
        TeamTracker team1 = new TeamTracker("WWWW");
        TeamTracker team2 = new TeamTracker("WWWW");
        assertEquals(team2, team1);
    }

    @Test
    void test6() {
        TeamTracker team1 = new TeamTracker("WWWW");
        TeamTracker team2 = new TeamTracker("LLL");
        assertNotEquals(team2, team1);
    }

    @Test
    void test7() {
        TeamTracker team1 = new TeamTracker("WWWW");
        team1.addResult('L');
        TeamTracker expectedTeam = new TeamTracker("WWWL");
        assertEquals(expectedTeam, team1);
    }
}
