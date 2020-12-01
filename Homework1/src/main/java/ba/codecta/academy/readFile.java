package ba.codecta.academy;
import ba.codecta.academy.disneylandFiles.disneyCharacter;
import ba.codecta.academy.disneylandFiles.disneyMovie;
import ba.codecta.academy.netflixFiles.Movie;
import java.io.*;
import java.util.*;

public class readFile {
    private Scanner scanner;

    public void openFile(String path) {
        try {
            scanner = new Scanner(new File(path));
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

    public void readDisneyMovies(List<disneyMovie> movies) {
        while(scanner.hasNext()) {
            String idNumber = scanner.next();
            String name = scanner.next();
            String year  = scanner.next();
            String awards = scanner.next();
            String duration = scanner.next();
            String likes = scanner.next();

            disneyMovie movie = new disneyMovie(idNumber, name, year, awards, duration, likes);
            movies.add(movie);
        }
    }

    public void readDisneyCharacters(List<disneyCharacter> characters) {
        while(scanner.hasNext()) {
            String idNumber = scanner.next();
            String name = scanner.next();
            String movie  = scanner.next();
            String role = scanner.next();

            disneyCharacter character = new disneyCharacter(idNumber, name, movie, role);
            characters.add(character);
        }
    }

    public void closeFile() {
        scanner.close();
    }
}
