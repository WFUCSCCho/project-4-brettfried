////∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
//        ∗ @file: Proj4.java
//        ∗ @description: This program houses my main, a perform operations method, and a time of operations method.
//        ∗ @author: Brett Fried, started code provided by Dr. Samuel Cho
//        ∗ @date: December 5, 2024
//        ∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Proj4 {
    public static void main(String[] args) throws IOException {
        // Use command line arguments to specify the input file
        if (args.length != 2) {
            System.err.println("Usage: java Proj4 <input file> <number of lines>");
            System.exit(1);
        }

        String inputFileName = args[0];
        int numLines = Integer.parseInt(args[1]);
        System.out.println("Number of lines: " + numLines);

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line (header)
        inputFileNameScanner.nextLine();

        List<Movie> movies = new ArrayList<>();
        while (inputFileNameScanner.hasNextLine() && movies.size() < numLines) {
            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) {
                try {
                    int year = Integer.parseInt(parts[0].trim());
                    String title = parts[1].trim();
                    int gross = Integer.parseInt(parts[2].replaceAll("[^0-9]", ""));
                    movies.add(new Movie(year, title, gross));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing line: " + line);
                }
            }
        }
        inputFileNameScanner.close();
        inputFileNameStream.close();

        SeparateChainingHashTable<Integer> hashTable = new SeparateChainingHashTable<>();
        performOperations(hashTable, movies, numLines);
    }

    private static void performOperations(SeparateChainingHashTable<Integer> hashTable, List<Movie> movies, int numLines) {
        // Extract the gross values to create the data list
        List<Integer> data = new ArrayList<>();
        for (Movie movie : movies) {
            data.add(movie.getGross());
        }

        List<Integer> sortedData = new ArrayList<>(data);
        Collections.sort(sortedData);
        List<Integer> shuffledData = new ArrayList<>(data);
        Collections.shuffle(shuffledData);
        List<Integer> reversedData = new ArrayList<>(sortedData);
        Collections.reverse(reversedData);

        try (FileOutputStream fos = new FileOutputStream("analysis.txt", true)) {
            StringBuilder output = new StringBuilder("");

            if (fos.getChannel().size() > 0) {
                output.append("\n"); // Start a new line if there is already data in the file
            }
            output.append(numLines).append(",");

            timeOperations("sorted", hashTable, sortedData, fos);
            timeOperations("shuffled", hashTable, shuffledData, fos);
            timeOperations("reversed", hashTable, reversedData, fos);

            output.append("------\n");

            fos.write(output.toString().getBytes());
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void timeOperations(String label, SeparateChainingHashTable<Integer> hashTable, List<Integer> data, FileOutputStream fos) throws IOException {
        long startTime, endTime;

        String output = label + ",";
        System.out.println("Timing operations for: " + label);

        // Insert
        startTime = System.nanoTime();
        for (int value : data) {
            hashTable.insert(value);
        }
        endTime = System.nanoTime();
        double insertTime = (endTime - startTime) / 1_000_000_000.0;
        output += String.format("%.9f", insertTime) + ",";
        System.out.println(String.format("Insert time (s): %.9f", insertTime));

        // Search
        startTime = System.nanoTime();
        for (int value : data) {
            hashTable.contains(value);
        }
        endTime = System.nanoTime();
        double searchTime = (endTime - startTime) / 1_000_000_000.0;
        output += String.format("%.9f", searchTime) + ",";
        System.out.println(String.format("Search time (s): %.9f", searchTime));

        // Delete
        startTime = System.nanoTime();
        for (int value : data) {
            hashTable.remove(value);
        }
        endTime = System.nanoTime();
        double deleteTime = (endTime - startTime) / 1_000_000_000.0;
        output += String.format("%.9f", deleteTime) + "\n";
        System.out.println(String.format("Delete time (s): %.9f", deleteTime));

        fos.write(output.getBytes());

        // Make hash table empty
        hashTable.makeEmpty();
    }
}