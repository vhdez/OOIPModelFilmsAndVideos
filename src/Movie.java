import java.util.Date;

public class Movie {
    private String title;
    private long moneyEarned;
    private Date release;

    public Movie(String title, long moneyEarned, Date release) {
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

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public String toString() {
        return getTitle() + " was released on " + getRelease() + ", earned $" + getMoneyEarned();
    }

}
