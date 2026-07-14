
package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaStrings {

    private static final Pattern SECRET_CODE_REGEX =
            Pattern.compile("[AEIOUaeiou]");

    public static Pattern getSecretCodeRegex() {
        return SECRET_CODE_REGEX;
    }

    public int addTogether(String firstString,
                           String secondString) {

        String firstTrimmed = firstString.trim();
        String secondTrimmed = secondString.trim();

        String combined =
                firstTrimmed.concat(secondTrimmed);

        return combined.length();
    }

    public String idProcessing(String firstName,
                               String lastName,
                               String petName,
                               int birthYear) {

        String firstInitial =
                firstName.substring(0, 1);

        String lastInitial =
                lastName.substring(0, 1);

        String petInitial =
                petName.substring(0, 1);

        return firstInitial
                + lastInitial
                + petInitial
                + birthYear;
    }

    public String secretCode(String ingredient) {

        Matcher matcher =
                SECRET_CODE_REGEX.matcher(ingredient);

        String replacedIngredient =
                matcher.replaceAll("z");

        return replacedIngredient.substring(0, 3);
    }

    public static void main(String args[]) {

        JavaStrings myObject = new JavaStrings();

        // Examples from addTogether
        String oneExample = "12 4 6789";
        String twoExample = "abcdef gh";

        int theLength =
                myObject.addTogether(oneExample, twoExample);

        System.out.println(theLength);

        // Whitespace at the beginning and end
        oneExample = "   " + oneExample + "\n";
        twoExample = "\t" + twoExample;

        theLength =
                myObject.addTogether(oneExample, twoExample);

        System.out.println(theLength);

        // Example from idProcessing
        String personFirst = "Dorothy";
        String personLast = "Gale";
        String petName = "Toto";
        int petBirth = 1899;

        String theID =
                myObject.idProcessing(
                        personFirst,
                        personLast,
                        petName,
                        petBirth
                );

        System.out.println(theID);

        // Examples from secretCode
        String ingredientOne = "tomato";
        String ingredientTwo = "WATER";

        String theCode =
                myObject.secretCode(ingredientOne);

        System.out.println(theCode);

        theCode =
                myObject.secretCode(ingredientTwo);

        System.out.println(theCode);
    }
}