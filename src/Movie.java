////∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
//        ∗ @file: Movie.java
//        ∗ @description: This program helps contain all data from dataset.
//        ∗ @author: Brett Fried
//        ∗ @date: December 5, 2024
//        ∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗
public class Movie {
    private int year;
    private String title;
    private int gross;

    public Movie(int year, String title, int gross) {
        this.year = year;
        this.title = title;
        this.gross = gross;
    }

    // Getters for accessing the data
    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public int getGross() {
        return gross;
    }

    @Override
    public String toString() {
        return "Year: " + year + ", Title: " + title + ", Gross: $" + gross;
    }
}
