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

            Long totalReleases = dataScanner.nextLong();
            String vhsReleases = dataScanner.next();
            Long vhsReleasesAsLong = Long.parseLong(vhsReleases);
            String dvdReleases = dataScanner.next();
            Long dvdReleasesAsLong = Long.parseLong(dvdReleases);
            String blurayReleases = dataScanner.next();
            Long blurayReleasesAsLong = Long.parseLong(blurayReleases);
            String revenue = dataScanner.next();
            Long revenueAsLong = Long.parseLong(revenue);
            // public Video(String title, long moneyEarned, LocalDate release, long allCount, long vhsCount, long dvdCount, long blurayCount) {

            Video newVideo = new Video(title, revenueAsLong, releaseAsLocalDate, totalReleases, vhsReleasesAsLong, dvdReleasesAsLong, blurayReleasesAsLong);
            System.out.println(newVideo);
        }

    }
}
