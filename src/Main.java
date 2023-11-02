import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Video> allMyVideos = new ArrayList();
        Video.readData();
        System.out.println("These are all of my Videos:");
        System.out.println(allMyVideos);

        ArrayList<Film> allMyFilms = new ArrayList();
        Film.readData();
        System.out.println("These are all of my Films:");
        System.out.println(allMyFilms);
    }
}