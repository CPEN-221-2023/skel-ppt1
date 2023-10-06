package teamtracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Tests {

    @Test
    public void test1() {
        TeamTracker teamA = new TeamTracker("WLL");
        TeamTracker teamB = new TeamTracker("LWW");
        assertEquals(2,Utils.computeMostJointGames(teamA, teamB));
    }

    @Test
    public void test2() {
        TeamTracker teamA = new TeamTracker("WDW");
        TeamTracker teamB = new TeamTracker("WDL");
        assertEquals(1,Utils.computeMostJointGames(teamA, teamB));
    }

    @Test
    public void test3() {
        TeamTracker teamA = new TeamTracker("WWLW");
        TeamTracker teamB = new TeamTracker("LWL");
        assertEquals(2,Utils.computeMostJointGames(teamA, teamB));
    }

    @Test
    public void test4() {
        TeamTracker teamA = new TeamTracker("LWWWWWW");
        TeamTracker teamB = new TeamTracker("LLWLWL");
        assertEquals(2,Utils.computeMostJointGames(teamA, teamB));
    }

    @Test
    public void test5() {
        TeamTracker teamA = new TeamTracker("DDWWLDLWLWLWDWDDWWWWDWLDDLWWLLDDLDWDDWWWLDW");
        TeamTracker teamB = new TeamTracker("LWWDDWWWLLWWWWWDDWWLDWDLWLDDDLWWDLLWWWWWWWDDWWDW");
        assertEquals(8,Utils.computeMostJointGames(teamA, teamB));
    }

    @Test
    public void test6() {
        TeamTracker teamA = new TeamTracker("WWWLLWLWLDDWW");
        TeamTracker teamB = new TeamTracker("LLLWWWWLWLDDL");
        assertEquals(6, Utils.computeMostJointGames(teamA, teamB));
    }

    @Test
    public void test7() {
        TeamTracker teamA = new TeamTracker("WWW");
        TeamTracker teamB = new TeamTracker("WWW");
        assertEquals(0, Utils.computeMostJointGames(teamA, teamB));
    }
}
