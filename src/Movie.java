import java.time.LocalDate;

public class Movie extends Object {
    private String title;
    private long moneyEarned;
    private LocalDate release;

    public Movie(String title, long moneyEarned, LocalDate release) {
        this.title = title;
        this.moneyEarned = moneyEarned;
        this.release = release;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(long moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public String toString() {
        return getTitle() + " was released on " + getRelease() + ", earned $" + getMoneyEarned();
    }

}
