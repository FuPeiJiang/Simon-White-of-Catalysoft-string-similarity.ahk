// https://web.archive.org/web/20210415112545/http://www.catalysoft.com/articles/strikeamatch.html

import java.util.ArrayList;

public class LetterPairSimilarity {

    // The basis of the algorithm is the method that computes the pairs of characters contained in the input string. This method creates an
    // array of Strings to contain its result. It then iterates through the input string, to extract character pairs and store them in the array.
    // Finally, the array is returned.
    /** @return an array of adjacent letter pairs contained in the input string */
    public static String[] letterPairs(String str) {
        int numPairs = str.length() - 1;
        String[] pairs = new String[numPairs];
        for (int i = 0; i < numPairs; i++) {
            pairs[i] = str.substring(i, i + 2);
        }
        return pairs;
    }

    // Taking Account of White Space
    // This method uses the split() method of the String class to split the input string into separate words, or tokens. It then iterates through
    // each of the words, computing the character pairs for each word. The character pairs are added to an ArrayList, which is returned
    // from the method. An ArrayList is used, rather than an array, because we do not know in advance how many character pairs will be
    // returned. (At this point, the program doesn't know how much white space the input string contains.)
    /** @return an ArrayList of 2-character Strings. */
    public static ArrayList<String> wordLetterPairs(String str) {
        ArrayList<String> allPairs = new ArrayList<String>();
        // Tokenize the string and put the tokens/words into an array
        // String[] words = str.split("\\s");
        // https://stackoverflow.com/questions/5993779/use-string-split-with-multiple-delimiters
        String[] words = str.split(" |_|-|\\.");
        // For each word
        for (int w = 0; w < words.length; w++) {
            // Find the pairs of characters
            if (words[w].length() > 0) {
                String[] pairsInWord = letterPairs(words[w]);
                for (int p = 0; p < pairsInWord.length; p++) {
                    allPairs.add(pairsInWord[p]);
                }
            }
        }
        return allPairs;
    }

    // Computing the Metric
    // This public method computes the character pairs from the words of each of the two input strings, then iterates through the ArrayLists
    // to find the size of the intersection. Note that whenever a match is found, that character pair is removed from the second array list to
    // prevent us from matching against the same character pair multiple times. (Otherwise, 'GGGGG' would score a perfect match against 'GG'.)
    /** @return lexical similarity value in the range [0,1] */
    public static double compareStrings(String str1, String str2) {
        ArrayList<String> pairs1 = wordLetterPairs(str1.toUpperCase());
        ArrayList<String> pairs2 = wordLetterPairs(str2.toUpperCase());
        int intersection = 0;
        int union = pairs1.size() + pairs2.size();
        for (int i = 0; i < pairs1.size(); i++) {
            String pair1 = pairs1.get(i);
            for (int j = 0; j < pairs2.size(); j++) {
                String pair2 = pairs2.get(j);
                if (pair1.equals(pair2)) {
                    intersection++;
                    pairs2.remove(j);
                    break;
                }
            }
        }
        return (2.0 * intersection) / union;
    }
}
