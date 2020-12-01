package ba.codecta.academy.disneylandFiles;
import ba.codecta.academy.mainApp;
import ba.codecta.academy.readFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class DisneyLand {
    public static void start() {
        Logger logger = Logger.getLogger(String.valueOf(mainApp.class));
        boolean closeMenu = false;
        boolean optionIsChosen;
        do {
            optionIsChosen = false;
            System.out.println("\n\n***** Welcome to the DisneyLand section! *****");
            System.out.println("Option 1: Read some main info about the most underrated Disney movies!");
            System.out.println("Option 2: You think you know every single Disney character? What about these?");
            System.out.println("Option 3: Leave the DisneyLand area");
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
                        logger.info("User has chosen option 1 in DisneyLand section");
                        ArrayList<disneyMovie> moviesList = new ArrayList<disneyMovie>();
                        readFile file = new readFile();
                        file.openFile("../disneyMovies.txt");
                        file.readDisneyMovies(moviesList);
                        file.closeFile();
                        int i = 1;
                        System.out.println("\n\n*** Choose one of the movies to see some more info! ***");
                        for(disneyMovie movie : moviesList) {
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
                        System.out.println("Release year: " + moviesList.get(chosenMovie-1).getYear());
                        System.out.println("Number of awards: " + moviesList.get(chosenMovie-1).getAwards());
                        System.out.println("Duration: " + moviesList.get(chosenMovie-1).getDuration() + " minutes");
                        System.out.println("Liked by: " + moviesList.get(chosenMovie-1).getLikes() + "% people");
                        System.out.println("******************************");
                        break;
                    case 2:
                        logger.info("User has chosen option 2 in DisneyLand section");
                        ArrayList<disneyCharacter> charactersList = new ArrayList<disneyCharacter>();
                        readFile file2 = new readFile();
                        file2.openFile("../disneyCharacters.txt");
                        file2.readDisneyCharacters(charactersList);
                        file2.closeFile();
                        int j = 1;
                        System.out.println("\n\n*** Choose one of the characters to see some more info! ***");
                        for(disneyCharacter character : charactersList) {
                            System.out.println(j + ". - " + character.getName());
                            j++;
                        }
                        int chosenCharacter;
                        boolean characterIsChosen = false;
                        do {
                            System.out.println("Enter your choice: ");
                            chosenCharacter = console.nextInt();
                            if(chosenCharacter < 1 || chosenCharacter > charactersList.size()) {
                                System.out.println("You have to choose one of the characters from the list!");
                            } else {
                                characterIsChosen = true;
                            }
                        } while(characterIsChosen == false);


                        System.out.println("\n\n***** Disney character information *****");
                        System.out.println("Name of the character: " + charactersList.get(chosenCharacter-1).getName());
                        System.out.println("Disney movie which the character stars in: " + charactersList.get(chosenCharacter-1).getCharactersMovie());
                        System.out.println("Role of the character: " + charactersList.get(chosenCharacter-1).getCharactersRole());
                        System.out.println("******************************");
                        break;
                    case 3:
                        logger.info("User has chosen option 3 in DisneyLand section");
                        closeMenu = true;
                        break;
                }
            }
        } while(closeMenu == false || optionIsChosen == false);
    }
}

