package teamtracker;

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

    public int hashCode() {
        return (division * 4 + bracket * 4);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Level)) {
            return false;
        }

        Level oLevel = (Level) other;
        return (this.division == oLevel.division && this.bracket == oLevel.bracket);
    }


}
