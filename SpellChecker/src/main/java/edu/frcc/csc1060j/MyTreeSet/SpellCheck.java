package edu.frcc.csc1060j.MyTreeSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SpellCheck {

    public static void main(String[] args) {
        String dictionaryFile = "words.txt";  
        MyTreeSet<String> dictionary = new MyTreeSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dictionaryFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String word = line.trim();
                if (!word.isEmpty()) {
                    dictionary.add(word);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: Could not open dictionary file '" + dictionaryFile + "'.");
            System.exit(1);
        }

        System.out.println("Loaded the words into a tree with height = " + dictionary.getTreeHeight());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String inputLine = scanner.nextLine();
            if (inputLine == null) {
                break;
            }
            String[] words = inputLine.split("\\s+");
            boolean printedCorrectWord = false;
            		for (String word : words) {
	                if (word.equals("End")) {
	                    scanner.close();
	                    return;
	                }
	                if (word.isEmpty()) {
	                    continue;
	                }
	                if (dictionary.contains(word)) {
	                    System.out.print(word + " ");
	                    printedCorrectWord = true;
	                } else {
	                    System.out.println(word + " is spelled wrong");
	                }
            }
            		if (printedCorrectWord) {
                System.out.println();
            }
        }
    }
}