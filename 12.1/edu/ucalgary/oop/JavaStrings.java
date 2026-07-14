package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaStrings {

    public static void main(String[] args) {

        String myString =
                "ENSF Principles of Software Development";

        // Count uppercase and lowercase E using regex
        Pattern ePattern = Pattern.compile("[Ee]");
        Matcher eMatcher = ePattern.matcher(myString);

        int count = 0;

        while (eMatcher.find()) {
            count++;
        }

        System.out.println("Number of E/e: " + count);

        // Split the String wherever there is whitespace
        String[] tokens = myString.split("\\s+");

        System.out.println("Number of tokens: " + tokens.length);

        for (String token : tokens) {
            System.out.println(token);
        }

        // Insert a colon after ENSF
        StringBuilder updatedString =
                new StringBuilder(myString);

        updatedString.insert(4, ":");

        System.out.println(updatedString);
    }
}