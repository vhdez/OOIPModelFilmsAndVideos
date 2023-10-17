import java.io.File;
import java.time.LocalDate;
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
        dataScanner.useDelimiter("\t");
        while (dataScanner.hasNext()) {
            System.out.println(dataScanner.next());
        }
    }
}
