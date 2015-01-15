String s1 = "aaab"
String s2 = "aaabbbcccddd"
println "${lcs(s1,s2,s1.length()-1,s2.length()-1)}"

int lcs(final String s1,final String s2,int m,int n){
    // BASE CASE: we have run out of characters in either 
    // of the strings
    if(m < 0 || n < 0){
        return 0
    }
    // If we get a match, we decrement m and n
    // and check the smaller string for subsequent matches
    if( s1.charAt(m) == s2.charAt(n) ){
        // we add 1 because we found a match
        return 1 + lcs(s1,s2,m-1,n-1)
    }else{
        // If not, we have to reduce both the
        // strings by one and return the max of the two
        return Math.max( lcs(s1,s2,m-1,n) , lcs(s1,s2,m,n-1) )
    }
}