import java.time.LocalDate;
import java.util.Date;

public class Film extends Movie {

    private int rank;
    private int peak;

    public Film(String title, long moneyEarned, LocalDate release, int rank, int peak) {
        super(title, moneyEarned, release);
        this.rank = rank;
        this.peak = peak;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPeak() {
        return peak;
    }

    public void setPeak(int peak) {
        this.peak = peak;
    }

    public  String toString() {
        return "Rank #" + getRank() + ": " + super.toString() + " and peaked at " + getPeak() + ".";
    }


}
