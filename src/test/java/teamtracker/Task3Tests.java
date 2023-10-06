package teamtracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Task3Tests {

    @Test
    public void test1() {
        TeamTracker teamA = new TeamTracker("WWLLDW");
        List<Integer> expPoints = Arrays.asList(2, 2, -1, -1, 0, 2);
        assertEquals(expPoints, teamA.getPointsHistory());
    }

    @Test
    public void test2a() {
        TeamTracker teamA = new TeamTracker("DLWLLDLWLWWWLDWDLDWWLLLDLLL");
        assertEquals(0.1875, teamA.fractionDrawsAtLevel(new Level(4, 4)), 0.001);
    }

    @Test
    public void test2b() {
        TeamTracker teamA = new TeamTracker("DLWLLDLWLWWWLDWDLDWWLLLDLLL");
        assertEquals(0.0, teamA.fractionWinsAtLevel(new Level(1, 1)), 0.001);
        assertEquals(0.0, teamA.fractionLossesAtLevel(new Level(2, 1)), 0.001);
    }

    @Test
    public void test2c() {
        TeamTracker teamA = new TeamTracker("DLWLLDLWLWWWLDWDLDWWLLLDLLL");
        assertEquals(0.2727, teamA.fractionWinsAtLevel(new Level(4, 3)), 0.001);
    }

    @Test
    public void test3a() {
        TeamTracker teamA = new TeamTracker("WWWWWWWLLDWWDWDWWWDWWLWWWDLDLDWDWWDLWWWLLL");
        assertEquals(0.4285, teamA.fractionWinsAtLevel(new Level(3, 4)), 0.001);
    }

    @Test
    public void test3b() {
        TeamTracker teamA = new TeamTracker("WWWWWWWLLDWWDWDWWWDWWLWWWDLDLDWDWWDLWWWLLL");
        assertEquals(0.3571, teamA.fractionDrawsAtLevel(new Level(3, 4)), 0.001);
    }

    @Test
    public void test4a() {
        TeamTracker teamA = new TeamTracker("WWWLWW");
        TeamTracker teamB = new TeamTracker("WWWWWWWWWLLLWWWWWW");
        assertFalse(teamA.similar(teamB));
    }

    @Test
    public void test4b() {
        TeamTracker teamA = new TeamTracker("LLWWDW");
        TeamTracker teamB = new TeamTracker("WDLLWW");
        assertTrue(teamA.similar(teamB));
    }

    @Test
    public void test4c() {
        TeamTracker teamA = new TeamTracker("LLWWDWWWWLWWWWWLLL");
        TeamTracker teamB = new TeamTracker("WDLLWWWWWWWLWWWLLL");
        assertFalse(teamA.similar(teamB));
    }
}
