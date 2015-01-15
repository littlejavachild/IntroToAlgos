println "${fiboDP(6)}"

int fiboDP(int n){
    // F remembers the previously calculated
    // fibonacci numbers
    int[] F = new int[n+1]
    // -1 = not calculated
    for(i in 0..<F.length){
        F[i] = -1
    }
    // auxilary function that
    // performs the calculation
    return fibo(n,F)
}

int fibo(int n,int[] F){
    // BASE CASE: n <= 1 
    if( n <= 1 ){
        F[n] = n
        return n
    }
    // If we have calculated the fibonacci
    // number previously, we return the
    // calculated value
    if( F[n] >= 0 ){
        return F[n]
    }else{
        // Else, we calculate it for the first time
        F[n] = fibo(n-1,F) + fibo(n-2,F)
        return F[n]
    }
}