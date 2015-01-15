// http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
// https://www.youtube.com/watch?v=P-mMvhfJhu8

String s1 = "aaaxxx"
String s2 = "bbbaaaxzzz"
println "LCS for $s1 and $s2 is ${lcsDP(s1,s2,s1.length()-1,s2.length()-1)}"

String lcsDP(final String s1,final String s2,int m,int n){
    int[][] L = new int[m+1][n+1]
    int i
    int j
    // REMEMBER THE PAPER SOLUTION AS YOU READ THIS CODE
    for(i = 0; i <= m; i++){
        for(j = 0; j <= n;j++){
            // If we are in the "zero" row or column
            // we fill it with 0
            if(i == 0 || j == 0){
                L[i][j] = 0
            }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                // If we find a match
                // We take the value from the 
                // diagonally previous element and add 1
                // REMEMBER BRIDGE
                L[i][j] = L[i-1][j-1] + 1
            }else{
                // If we do don't find a match
                // we take the max of either of the two 
                // values : LEFT or TOP
                L[i][j] = Math.max( L[i-1][j],L[i][j-1] )
            }
        }
    }
    // L[m][n] is the length of the string
    return getLCS(L,s1,s2,m,n)
}

String getLCS(int[][] L,final String s1,final String s2,int m,int n){
    int i = m
    int j = n
    // StringBuffer to store the LCS
    StringBuffer x = new StringBuffer()
    // DONT FORGET TO SETLENGTH() OR YOU WILL HIT AN EXCEPTION
    x.setLength(L[m][n])
    // Index to keep track of where the next character goes in the LCS. 
    // Since we use zero indexing, we subtract 1 from the size of the LCS
    int index = L[m][n] - 1
    while(i > 0 && j > 0){
        // If two characters match
        // we take the bridge
        if( s1.charAt(i-1) == s2.charAt(j-1) ){
            x.setCharAt(index,s1.charAt(i-1))
            index-- 
            i--
            j--
        }else{
            // If two characters dont match, we go
            // in the direction of the higher value
            if(L[i-1][j] > L[i][j-1]){
                i--
            }else{
                j--
            }
        }
    }
    return x
}