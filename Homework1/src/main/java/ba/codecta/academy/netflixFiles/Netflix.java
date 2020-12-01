package ba.codecta.academy.netflixFiles;
import ba.codecta.academy.readFile;
import java.util.*;

public class Netflix {
    public static void start() {
        boolean closeMenu = false;
        boolean optionIsChosen;
        do {
            optionIsChosen = false;
            System.out.println("\n\n***** Welcome to the Netflix section! *****");
            System.out.println("Option 1: Top 20 Netflix movies");
            System.out.println("Option 2: Print information of a chosen movie");
            System.out.println("Option 3: Leave the Netflix area");
            System.out.println("********************************************");
            System.out.println("Choose one of the options from 1 to 3: ");
            Scanner console = new Scanner(System.in);
            int chosenOption = console.nextInt();

            if(chosenOption < 1 || chosenOption > 3) {
                System.out.println("You have to enter one of the values from 1 to 3!");
            } else {
                optionIsChosen = true;
            }
            if(optionIsChosen == true) {
                switch (chosenOption) {
                    case 1:
                        ArrayList<Movie> movies = new ArrayList<Movie>();
                        readFile file = new readFile();
                        file.openFile("../movies.txt");
                        file.readMovies(movies);
                        file.closeFile();

                        for(Movie movie : movies) {
                            movie.printMovie();
                        }
                        break;
                    case 2:
                        ArrayList<Movie> moviesList = new ArrayList<Movie>();
                        readFile file2 = new readFile();
                        file2.openFile("../movies.txt");
                        file2.readMovies(moviesList);
                        file2.closeFile();
                        int i = 1;
                        for(Movie movie : moviesList) {
                            System.out.println(i + ". - " + movie.getName());
                            i++;
                        }
                        int chosenMovie;
                        boolean movieIsChosen = false;
                        do {
                            System.out.println("Enter your choice: ");
                            chosenMovie = console.nextInt();
                            if(chosenMovie < 1 || chosenMovie > moviesList.size()) {
                                System.out.println("You have to choose one of the movies from the list!");
                            } else {
                                movieIsChosen = true;
                            }
                        } while(movieIsChosen == false);


                        System.out.println("\n\n***** Movie information *****");
                        System.out.println("Name of the movie: " + moviesList.get(chosenMovie-1).getName());
                        System.out.println("Number of votes on IMDB: " + moviesList.get(chosenMovie-1).getNumberOfVotes());
                        System.out.println("Rating: " + moviesList.get(chosenMovie-1).getRating());
                        System.out.println("******************************");
                        break;
                    case 3:
                        closeMenu = true;
                        break;
                }
            }
        } while(closeMenu == false || optionIsChosen == false);
    }
}
