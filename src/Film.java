import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

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

    public static void readData() throws Exception {
        File dataFile = new File("src/FilmsData");
        Scanner dataScanner = new Scanner(dataFile);
        dataScanner.useDelimiter("\t|\n");

        while (dataScanner.hasNext()) {
            // construct  1 film object using 5 chunks of data
            //1	1	Avatar	$2,923,706,026	2009	[# 1][# 2]
            int rank = dataScanner.nextInt();
            int highestRank = dataScanner.nextInt();
            String title = dataScanner.next();
            String revenue = dataScanner.next();
            revenue = revenue.replace(",", "");
            revenue = revenue.replace("$", "");
            Long revenueAsLong = Long.parseLong(revenue);

            String releaseDate = dataScanner.next();
            DateTimeFormatter format = new DateTimeFormatterBuilder()
                    .appendPattern("yyyy")
                    .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                    .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                    .toFormatter();
            LocalDate releaseAsLocalDate = LocalDate.parse(releaseDate, format);

            String skipBrackets = dataScanner.next();

            Film newFilm = new Film(title, revenueAsLong, releaseAsLocalDate, rank, highestRank);
            System.out.println(newFilm);
        }

    }


}
