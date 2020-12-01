package ba.codecta.academy.netflixFiles;

public class Movie {
    String idNumber;
    String numberOfVotes;
    String rating;
    String name;

   public Movie(String id, String votes, String rating, String name) {
       this.idNumber = id;
       this.numberOfVotes = votes;
       this.rating = rating;
       this.name = name;
   }

   public void printMovie() {
       System.out.println(this.idNumber + " - " + this.name);
   }

   String getNumberOfVotes() {
       return this.numberOfVotes;
   }
   String getName() {
       return this.name;
   }
   String getRating() {
       return this.rating;
   }
}
