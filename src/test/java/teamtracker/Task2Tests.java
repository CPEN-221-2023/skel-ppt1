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
        assertEquals(team2.getCurrentLevel(), team1.getCurrentLevel());
    }

    @Test
    void test4() {
        TeamTracker team1 = new TeamTracker("WWWW");
        TeamTracker team2 = new TeamTracker("WWWW");
        assertEquals(team2.getCurrentLevel(), team1.getCurrentLevel());
    }

    @Test
    void test6() {
        TeamTracker team1 = new TeamTracker("WWWW");
        TeamTracker team2 = new TeamTracker("LLL");
        assertNotEquals(team2.getCurrentLevel(), team1.getCurrentLevel());
    }

    @Test
    void test7() {
        TeamTracker team1 = new TeamTracker("WWWW");
        team1.addResult('L');
        TeamTracker expectedTeam = new TeamTracker("WWWL");
        assertEquals(expectedTeam.getCurrentLevel(), team1.getCurrentLevel());
    }

    @Test
    void test8() {
        TeamTracker team1 = new TeamTracker("WWWLLLW");
        TeamTracker team2 = new TeamTracker("L");
        assertEquals(team1.getCurrentLevel(), team2.getCurrentLevel());
    }

    @Test
    void test9() {
        TeamTracker team1 = new TeamTracker("WWWWWWWWWWWWLLL");
        TeamTracker team2 = new TeamTracker("WWWWWWWWW");
        assertNotEquals(team1.getCurrentLevel(), team2.getCurrentLevel());
    }

    @Test
    void test10() {
        TeamTracker team1 = new TeamTracker("WWWWWWWWWWWWLLLLLW");
        TeamTracker team2 = new TeamTracker("WWWWWWWWW");
        assertEquals(team1.getCurrentLevel(), team2.getCurrentLevel());
    }

    @Test
    void test11() {
        TeamTracker team1 = new TeamTracker("WWDWDWLLLLLWLWLWWWWLWWWDWLLWWDWDLWWLLWLWDLWDWWWWWDWD");
        assertEquals(new Level(4, 1), team1.getCurrentLevel());
    }

    @Test
    void test12() {
        TeamTracker team2 = new TeamTracker("WWDWDWLLLLLWLWLWWWWLWWWDWLLWWDWDLWWLLWLWDLWDWWWWWDWDWWWDDWWWWWWDDLWWWWWW");
        assertEquals(new Level(2, 4), team2.getCurrentLevel());
    }
}
