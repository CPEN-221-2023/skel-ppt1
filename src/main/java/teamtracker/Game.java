package teamtracker;

/**
 * Helper class
 *
 * @author Sathish Gopalakrishnan
 */
public class Game {
    public final char result;
    public final Level level;

    public Game(char result, Level level) {
        this.result = result;
        this.level = level;
    }

    public boolean isCompatible(Game other) {
        if (!this.level.equals(other.level)) {
            return false;
        }

        switch (this.result) {
            case 'W': return (other.result == 'L');
            case 'L': return (other.result == 'W');
            case 'D': return (other.result == 'D');
            default: return false;
        }
    }
}
