package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateNormalizer {

    private static final Pattern YEAR_FIRST_REGEX =
            Pattern.compile(
                    "^(\\d{4})([-.])(\\d{1,2})\\2(\\d{1,2})$"
            );

    private static final Pattern YEAR_LAST_REGEX =
            Pattern.compile(
                    "^(\\d{1,2})([-.])(\\d{1,2})\\2(\\d{4})$"
            );

    public static String normalizeDate(String input) {

        Matcher yearFirstMatcher =
                YEAR_FIRST_REGEX.matcher(input);

        // Format: year-month-day
        if (yearFirstMatcher.matches()) {

            String year = yearFirstMatcher.group(1);
            String month = yearFirstMatcher.group(3);
            String day = yearFirstMatcher.group(4);

            return year
                    + "-"
                    + addLeadingZero(month)
                    + "-"
                    + addLeadingZero(day);
        }

        Matcher yearLastMatcher =
                YEAR_LAST_REGEX.matcher(input);

        // Format: day-month-year
        if (yearLastMatcher.matches()) {

            String day = yearLastMatcher.group(1);
            String month = yearLastMatcher.group(3);
            String year = yearLastMatcher.group(4);

            return year
                    + "-"
                    + addLeadingZero(month)
                    + "-"
                    + addLeadingZero(day);
        }

        return "";
    }

    private static String addLeadingZero(String number) {

        if (number.length() == 1) {
            return "0" + number;
        }

        return number;
    }

    public static void main(String[] args) {

        System.out.println(normalizeDate("2021-12-16"));
        System.out.println(normalizeDate("2022.01.15"));
        System.out.println(normalizeDate("15-01-2022"));
        System.out.println(normalizeDate("16.12.2021"));
        System.out.println(normalizeDate("14.32.2021"));
        System.out.println(normalizeDate("3 Jan 2022"));
    }
}