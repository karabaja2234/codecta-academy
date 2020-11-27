package ba.codecta;

import ba.codecta.disneychars.DisneyCharacter;
import ba.codecta.disneychars.MickeyCharacter;
import ba.codecta.disneychars.MinneyCharacter;
import ba.codecta.thema.AdventureLand;
import ba.codecta.thema.DisneyLand;
import ba.codecta.thema.FantasyLand;
import ba.codecta.thema.MickeysTown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public class Adventure {
    //private static String BASE_PATH = ""
    static String VISITOR = "";
    private void process(String visitorName) {
        System.out.println(visitorName);
    }
    public static void main(final String[] args) {
        /*
        System.out.println("Random text");

        List<String> messages = new ArrayList<String>();
        messages.add("Welcome message");

        Map<String, String> mapMessages = new HashMap<String, String>();
        mapMessages.put("Welcome", "Welcome messageee");

        System.out.println(messages.get(0));
        System.out.println(mapMessages.get("Welcome"));

        Scanner console = new Scanner(System.in);
        String text = console.next();
        VISITOR = text;
        displayLands();*/

        displayLandsWithNumbers();
        System.out.println("Enter your theme park choice: ");
        Scanner console = new Scanner(System.in);
        int landOption = console.nextInt();

        switch(landOption) {
            case 1:
                System.out.println("Welcome to Mickeys Town!");
                break;
            case 2:
                System.out.println("Welcome to Fantasy Land!");
                break;
            case 3:
                System.out.println("Welcome to Adventure Land!");
                break;
        }

        displayCharactersWithNumbers();
        System.out.println("Choose your character: ");
        int characterOption = console.nextInt();

        List<DisneyCharacter> characters = new ArrayList<DisneyCharacter>();
        characters.add(new MickeyCharacter());
        characters.add(new MinneyCharacter());
        switch(characterOption) {
            case 1:
                System.out.println();
                break;
            case 2:
                System.out.println(characters.get(characterOption - 1).getName());
                break;
            case 3:
                System.out.println(characters.get(characterOption - 1).getName());
                break;
        }
    }

    private static void displayLands() {
        List<DisneyLand> themaParks = new ArrayList<DisneyLand>();
        themaParks.add(new MickeysTown());
        themaParks.add(new FantasyLand());
        themaParks.add(new AdventureLand());

        System.out.println("THEMA PARKS: ");
        for(DisneyLand land : themaParks) {
            System.out.println(land.getName());
        }
    }

    private static void displayLandsWithNumbers() {
        List<DisneyLand> themaParks = new ArrayList<DisneyLand>();
        themaParks.add(new MickeysTown());
        themaParks.add(new FantasyLand());
        themaParks.add(new AdventureLand());

        System.out.println("THEMA PARKS: ");
        for(int i=0; i<themaParks.size(); i++) {
            System.out.println(i+1 + ". " + themaParks.get(i).getName());
        }
    }

    private static void displayCharactersWithNumbers() {
        List<DisneyCharacter> characters = new ArrayList<DisneyCharacter>();
        characters.add(new MickeyCharacter());
        characters.add(new MinneyCharacter());

        System.out.println("CHARACTERS: ");
        for(int i=0; i<characters.size(); i++) {
            System.out.println(i+1 + ". " + characters.get(i).getName());
        }
    }
}
