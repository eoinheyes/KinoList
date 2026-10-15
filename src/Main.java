import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to KinoList!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPlease select from the menu:");
            System.out.println("[1] Show my watchlist");
            System.out.println("[2] Add a movie to my watchlist.");
            System.out.println("[3] Exit the program.");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                showMovies();
            }
            else if (input.equals("2")) {
                newMovie();
            }
            else if (input.equals("3")) {
                System.out.println("Thank you for using KinoList.");
                System.out.println("Program is now closing...");
                break;
            }
            else {
                System.out.println("Error that is an invalid option.");
            }
        }
        scanner.close();
    }
    public static void newMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("What is the name of the film you would like to add? ");
        String title = scanner.nextLine();
        System.out.printf("What year did the film release? ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("What genre is the film? ");
        String genre = scanner.nextLine();
        System.out.printf("Who directed the film? ");
        String director = scanner.nextLine();
        System.out.printf("Who is the lead actor in the film? ");
        String leadActor = scanner.nextLine();
        Movie m = new Movie(title, year, genre, director, leadActor);
        MovieFileHandler.saveMovie(m);
        scanner.close();
    }
    public static void showMovies() throws FileNotFoundException {
        System.out.println("Here are my movies:");
        for(Movie film : MovieFileHandler.movieClass(MovieFileHandler.getMovies())) {
            System.out.println(film);
        }
    }
}