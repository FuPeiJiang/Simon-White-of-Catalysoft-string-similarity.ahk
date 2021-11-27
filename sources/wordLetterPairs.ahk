; Taking Account of White Space
; This method uses the split() method of the String class to split the input string into separate words, or tokens. It then iterates through
; each of the words, computing the character pairs for each word. The character pairs are added to an ArrayList, which is returned
; from the method. An ArrayList is used, rather than an array, because we do not know in advance how many character pairs will be
; returned. (At this point, the program doesn't know how much white space the input string contains.)

; @return an ArrayList of 2-character Strings.
;    private static ArrayList wordLetterPairs(String str) {
wordLetterPairs(str) {
    allPairs := []
    ; Tokenize the string and put the tokens/words into an array
    words := StrSplit(str, [" ", "-", "_", "."])
    ; For each word
    for unused, v in words {
        ; Find the pairs of characters
        if (v) { ;this "if" adds nothing to it
            pairsInWord := letterPairs(v)
            allPairs.push(pairsInWord*)
        }
    }
    return allPairs
}
