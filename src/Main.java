import java.text.Format;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // construct a Film object
        // Rank	Peak	Title	Worldwide gross	Year	Reference(s)
        //  1	1	Avatar	$2,923,706,026	2009
        Date date1 = new Date(2009, 1, 1);
        Film film1 = new Film("Avatar",2923706026l,date1,1,1);
        System.out.println(film1);
        // construct a Video object

        // print out the Film object

        // print out the Video object

    }
}