import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.Scanner;

public class Video extends Movie {


    private long allCount;
    private long vhsCount;
    private long dvdCount;
    private long blurayCount;

    public Video(String title, long moneyEarned, LocalDate release, long allCount, long vhsCount, long dvdCount, long blurayCount) {
        super(title, moneyEarned, release);
        this.allCount = allCount;
        this.vhsCount = vhsCount;
        this.dvdCount = dvdCount;
        this.blurayCount = blurayCount;
    }

    public long getAllCount() {
        return allCount;
    }

    public void setAllCount(long allCount) {
        this.allCount = allCount;
    }

    public long getVhsCount() {
        return vhsCount;
    }

    public void setVhsCount(long vhsCount) {
        this.vhsCount = vhsCount;
    }

    public long getDvdCount() {
        return dvdCount;
    }

    public void setDvdCount(long dvdCount) {
        this.dvdCount = dvdCount;
    }

    public long getBlurayCount() {
        return blurayCount;
    }

    public void setBlurayCount(long blurayCount) {
        this.blurayCount = blurayCount;
    }

    public String toString() {
        String other3Values = super.toString();
        return other3Values+ ". Total sales:"+getAllCount()+ " divided amongst VHS: " + getVhsCount() + " DVD: " + getDvdCount() + " Blu-Ray: " + getBlurayCount() + ".";
    }

    public static void readData() throws Exception {
        File dataFile = new File("src/VideosData");
        Scanner dataScanner = new Scanner(dataFile);
        dataScanner.useDelimiter("\t|\n");

        while (dataScanner.hasNext()) {
            // construct  1 video object using 7 chunks of data
            String title = dataScanner.next();

            String releaseDate = dataScanner.next();
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()
                    .append(DateTimeFormatter.ofPattern("MMMM d, uuuu"))
                    .toFormatter(Locale.ENGLISH);            //convert String to LocalDate
            LocalDate releaseAsLocalDate = LocalDate.parse(releaseDate, formatter);
            //Finding Nemo
            //November 4, 2003	40,600,000	520,000[5]	38,800,000[2]	1,320,000[6]	$801,400,000[5][2][6]

            Long totalReleases = dataScanner.nextLong();

            String vhsReleases = dataScanner.next();
            int locationOfSquareBracket = vhsReleases.indexOf("[");
            if (locationOfSquareBracket > 0) {
                vhsReleases = vhsReleases.substring(0, locationOfSquareBracket);
            }
            vhsReleases = vhsReleases.replace(",", "");
            if (vhsReleases.equalsIgnoreCase("—")) {
                vhsReleases = "0";
            }
            Long vhsReleasesAsLong = Long.parseLong(vhsReleases);

            String dvdReleases = dataScanner.next();
            locationOfSquareBracket = dvdReleases.indexOf("[");
            if (locationOfSquareBracket > 0) {
                dvdReleases = dvdReleases.substring(0, locationOfSquareBracket);
            }
            dvdReleases = dvdReleases.replace(",", "");
            Long dvdReleasesAsLong = Long.parseLong(dvdReleases);

            String blurayReleases = dataScanner.next();
            locationOfSquareBracket = blurayReleases.indexOf("[");
            if (locationOfSquareBracket > 0) {
                blurayReleases = blurayReleases.substring(0, locationOfSquareBracket);
            }
            blurayReleases = blurayReleases.replace(",", "");
            if (blurayReleases.equalsIgnoreCase("—")) {
                blurayReleases = "0";
            }
            Long blurayReleasesAsLong = Long.parseLong(blurayReleases);

            String revenue = dataScanner.next();
            locationOfSquareBracket = revenue.indexOf("[");
            if (locationOfSquareBracket > 0) {
                revenue = revenue.substring(0, locationOfSquareBracket);
            }
            revenue = revenue.replace(",", "");
            revenue = revenue.replace("$", "");
            Long revenueAsLong = Long.parseLong(revenue);

            // public Video(String title, long moneyEarned, LocalDate release, long allCount, long vhsCount, long dvdCount, long blurayCount) {

            Video newVideo = new Video(title, revenueAsLong, releaseAsLocalDate, totalReleases, vhsReleasesAsLong, dvdReleasesAsLong, blurayReleasesAsLong);
            System.out.println(newVideo);
        }

    }
}
