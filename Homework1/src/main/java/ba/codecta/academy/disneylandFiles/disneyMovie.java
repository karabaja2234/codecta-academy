package ba.codecta.academy.disneylandFiles;

public class disneyMovie {
    String idNumber;
    String name;
    String year;
    String numberOfAwards;
    String duration;
    String likes;

    public disneyMovie(String disneyMovieId, String disneyMovieName, String disneyMovieYear, String disneyMovieAwards, String disneyMovieDuration, String disneyMovieLikes) {
        this.idNumber = disneyMovieId;
        this.name = disneyMovieName;
        this.year = disneyMovieYear;
        this.numberOfAwards = disneyMovieAwards;
        this.duration = disneyMovieDuration;
        this.likes = disneyMovieLikes;
    }

    public void printDisneyMovie() {
        System.out.println(this.idNumber + " - " + this.name);
    }

    String getName() {
        return this.name;
    }
    String getYear() {
        return this.year;
    }
    String getAwards() {
        return this.numberOfAwards;
    }
    String getDuration() { return this.duration; }
    String getLikes() {
        return this.likes;
    }
}
