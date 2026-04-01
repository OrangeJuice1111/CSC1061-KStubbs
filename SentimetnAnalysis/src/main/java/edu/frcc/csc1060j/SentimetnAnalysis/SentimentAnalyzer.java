package edu.frcc.csc1060j.SentimetnAnalysis;

import edu.frcc.csc1060j.MyHashMap.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SentimentAnalyzer {

    private static MyHashMap<String, Integer> loadSentiments(File file) throws IOException {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            int comma = line.lastIndexOf(',');
            if (comma <= 0 || comma == line.length() - 1) continue;

            String phrase = line.substring(0, comma).trim().toLowerCase();
            String scoreStr = line.substring(comma + 1).trim();

            try {
                int score = Integer.parseInt(scoreStr);
                map.put(phrase, score);
            } catch (NumberFormatException ignored) {
            }
        }

        return map;
    }

    public static void main(String[] args) {
        File sentimentsFile = new File("sentiments.txt");

        MyHashMap<String, Integer> sentimentMap;
        try {
            sentimentMap = loadSentiments(sentimentsFile);
        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());
            return;
        }

        System.out.println("Enter text (type END on a new line to finish):");
        Scanner scanner = new Scanner(System.in);

        int wordCount = 0;
        int totalSentiment = 0;
        String previousWord = null;

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) break;

            String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

            for (String word : words) {
                if (word.isBlank()) continue;

                wordCount++;
                wordCount++;

                Integer score = sentimentMap.get(word);
                if (score != null) {
                    totalSentiment += score;
                }

                if (previousWord != null) {
                    String phrase = previousWord + " " + word;
                    Integer phraseScore = sentimentMap.get(phrase);
                    if (phraseScore != null) {
                        totalSentiment += phraseScore;
                    }
                }

                previousWord = word;
            }
        }

        scanner.close();

        double average = (wordCount == 0) ? 0.0 : (totalSentiment / (double) wordCount);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println();
        System.out.println("Words: " + wordCount);
        System.out.println("Sentiment: " + totalSentiment);
        System.out.println("Overall: " + df.format(average));
    }
}
