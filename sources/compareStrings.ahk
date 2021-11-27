; Computing the Metric
; This public method computes the character pairs from the words of each of the two input strings, then iterates through the ArrayLists
; to find the size of the intersection. Note that whenever a match is found, that character pair is removed from the second array list to
; prevent us from matching against the same character pair multiple times. (Otherwise, 'GGGGG' would score a perfect match against 'GG'.)
; @return lexical similarity value in the range [0,1]
; public static double compareStrings(String str1, String str2) {
compareStrings(str1, str2) {
    StringUpper, str1, str1
    StringUpper, str2, str2

    pairs1 := wordLetterPairs(str1)
    pairs2 := wordLetterPairs(str2)
    intersection := 0
    union := pairs1.Length() + pairs2.Length()
    for k, pair1 in pairs1 {
        for i, pair2 in pairs2 {
            if (pair1 == pair2) {
                intersection++
                pairs2.removeAt(i)
                break
            }
        }
    }
    return (2.0*intersection)/union
}
