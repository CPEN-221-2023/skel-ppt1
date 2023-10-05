package org.example;

public class Level {
    private int division;
    private int bracket;

    public Level(int division, int bracket) {
        if (division < 1 || division > 4) {
            throw new IllegalArgumentException("Division must be between 1 and 4");
        }
        if (bracket < 1 || bracket > 4) {
            throw new IllegalArgumentException("Bracket must be between 1 and 4");
        }

        this.division = division;
        this.bracket = bracket;
    }

    public int getDivision() {
        return division;
    }

    public int getBracket() {
        return bracket;
    }

    public boolean updateDivision(int division) {
        if (division < 1 || division > 4) {
            return false;
        }
        this.division = division;
        return true;
    }

    public boolean updateBracket(int bracket) {
        if (bracket < 1 || bracket > 4) {
            return false;
        }
        this.bracket = bracket;
        return true;
    }
}
