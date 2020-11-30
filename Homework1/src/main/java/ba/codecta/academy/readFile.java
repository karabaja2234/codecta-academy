package ba.codecta.academy;
import ba.codecta.academy.netflixFiles.Movie;
import java.io.*;
import java.util.*;

public class readFile {
    private Scanner scanner;

    public void openFile() {
        try {
            scanner = new Scanner(new File("../movies.txt"));
        } catch (Exception e) {
            System.out.println("Error while opening a file: " + e);
        }
    }

    public void readMovies(List<Movie> movies) {
        while(scanner.hasNext()) {
            String idNumber = scanner.next();
            String numberOfVotes = scanner.next();
            String rating  = scanner.next();
            String name = scanner.next();

            Movie movie = new Movie(idNumber, numberOfVotes, rating, name);
            movies.add(movie);
        }
    }

    public void closeFile() {
        scanner.close();
    }
}
