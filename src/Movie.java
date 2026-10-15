public class Movie {
    private String title;
    private int year;
    private String genre;
    private String director;
    private String leadActor;

    public Movie() {
        this.title = "";
        this.year = 0;
        this.genre = "";
        this.director = "";
        this.leadActor = "";
    }
    public Movie(String Title, int Year, String Genre, String Director, String LeadActor) {
        this.title = Title;
        this.year = Year;
        this.genre = Genre;
        this.director = Director;
        this.leadActor = LeadActor;
    }
    public String getTitle() {
        return this.title;
    }
    public int getYear() {
        return this.year;
    }
    public String getGenre() {
        return this.genre;
    }
    public String getDirector() {
        return this.director;
    }
    public String getLeadActor() {
        return this.leadActor;
    }
    public String toString() {
        return this.title + " came out in " + this.year +". It is part of the "+ this.genre + " genre. It was directed by "+ this.director + " and stars "+ this.leadActor + " in a leading role.";
    }
}
