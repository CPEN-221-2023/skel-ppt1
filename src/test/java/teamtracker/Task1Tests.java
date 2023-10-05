package teamtracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Tests {
    @Test
    void test1() {
        TeamTracker team = new TeamTracker("");
        team.addResult('W');
        assertEquals(1, team.totalGamesPlayed());
    }

    @Test
    void test2() {
        TeamTracker team = new TeamTracker("");
        team.addResult("WLD");
        assertEquals(3, team.totalGamesPlayed());
    }

    @Test
    void test3() {
        TeamTracker team = new TeamTracker("WWL");
        assertEquals(2.0/3, team.fractionOfWins());
    }

    @Test
    void test4() {
        TeamTracker team = new TeamTracker("WWL");
        assertEquals(1.0/3, team.fractionOfLosses());
    }

    @Test
    void test5() {
        TeamTracker team = new TeamTracker("WDL");
        assertEquals(1.0/3, team.fractionOfDraws());
    }

    @Test
    void test6() {
        TeamTracker team = new TeamTracker("WWLDD");
        assertEquals(5, team.totalGamesPlayed());
    }
}
