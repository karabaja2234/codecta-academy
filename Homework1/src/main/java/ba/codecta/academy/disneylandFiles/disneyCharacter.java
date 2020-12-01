package ba.codecta.academy.disneylandFiles;

public class disneyCharacter {
    String idNumber;
    String name;
    String movie;
    String role;

    public disneyCharacter(String charactersId, String charactersName, String disneyMovie, String movieRole) {
        this.idNumber = charactersId;
        this.name = charactersName;
        this.movie = disneyMovie;
        this.role = movieRole;
    }

    public void printCharacter() {
        System.out.println(this.idNumber + " - " + this.name);
    }


    String getName() {
        return this.name;
    }
    String getCharactersMovie() {
        return this.movie;
    }
    String getCharactersRole() {
        return this.role;
    }
}

