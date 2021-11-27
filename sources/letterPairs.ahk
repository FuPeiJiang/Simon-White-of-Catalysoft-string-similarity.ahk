; The basis of the algorithm is the method that computes the pairs of characters contained in the input string. This method creates an
; array of Strings to contain its result. It then iterates through the input string, to extract character pairs and store them in the array.
; Finally, the array is returned.

; @return an array of adjacent letter pairs contained in the input string
;    private static String[] letterPairs(String str) {
letterPairs(str) {
    pairs := []
    loop % StrLen(str) - 1 {
        pairs.push(SubStr(str, A_Index, 2))
    }
    return pairs
}
