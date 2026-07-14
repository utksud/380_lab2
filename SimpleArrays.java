/*
Copyright Ann Barcomb and Emily Marasco, 2021-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import java.util.Arrays;

public class SimpleArrays {

    public String[] words;


    public SimpleArrays(){
        words = new String[4];
        Arrays.fill(words,"Hello, world");
    }

    public SimpleArrays(String text){
        words = new String[4];
        Arrays.fill(words,text);
    }

    public String arrayConcat(){
        String empty = "";
        for (int i = 0; i< words.length; i++) {
            empty += words[i];

            if(i != words.length-1) {
                empty += "#";
            }
        }
        return empty;
    }

    public String arrayConcat(int number){
        String empty = "";
        for (int i = 0; i< words.length; i++) {
            empty += words[i];

            if(i != words.length-1) {
                empty += "#";
            }
        }
        return empty;
    }

    public String arrayCrop(int first, int last) {
        if (first < 0 || first >= words.length || last < 0 ||
        last >= words.length) {
            return "Fail";
        }

        if (first == last) {
            return "Match";
        }

        if (first > last){
            int x = first;
            first= last;
            last = x;
        }
        String empty = "";

        for (int i = first; i <= last; i++){
            empty += words[i];

            if (i != last){
                empty += "#";
            }
        }
        return empty;
    }
}
  
