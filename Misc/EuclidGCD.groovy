println gcd(3768,1701)

int gcd(int a,int b){
    int A
    int B
    int q
    int r = -1
    if( a > b ){
        A = a
        B = b
    }else{
        A = b
        B = a
    }
    // A = B * q + r
    // A becomes B
    // B becomes r
    while( r != 0 ){
        r = A % B
        println "$A = $B.${(int)Math.floor(A/B)} + $r"
        A = B
        B = r
    }
    return A
}