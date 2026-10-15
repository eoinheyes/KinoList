import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class MovieFileHandler {
    public static void saveMovie(Movie movie) {
        //Try catch to prevent crashing
        try (FileWriter writer = new FileWriter("movies.csv", true)) {

            writer.write(
                    movie.getTitle() + "," +
                            movie.getYear() + "," +
                            movie.getGenre() + "," +
                            movie.getDirector() + "," +
                            movie.getLeadActor() + "\n"
            );
            System.out.println("Movie has been saved!");
        } catch (IOException e) {
            //If the file can't be saved, this is outputted.
            System.out.println("Error saving movie: " + e.getMessage());
        }
    }
    public static ArrayList<String[]> getMovies() throws FileNotFoundException {
        ArrayList<String[]> movies = new ArrayList<>();
        File file= new File("movies.csv");
        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().strip().split(",");
                movies.add(data);
            }
            return movies;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<Movie> movieClass(ArrayList<String[]> data) {
        ArrayList<Movie> movies = new ArrayList<>();
        for(String[] record : data) {
            Movie m = new Movie(record[0],Integer.parseInt(record[1]),record[2],record[3],record[4]);
            movies.add(m);
        }
        return movies;
    }
}
