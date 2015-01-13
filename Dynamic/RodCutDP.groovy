int[] p = [0,1,5,8,9,10,17,17,20]
int n = 5
println "${rodCut(p,n)}"

int rodCut(int[] p,int n){
   // R[] remembers the previously calculated 
   // revenues, if any
   int[] r = new int[p.length]
   for(i in 0..<r.length){
       r[i] = -1
   }
   return aux(p,n,r)
}

int aux(int[] p,int n,int[] r){
    int q
    // if we have calculated the solution
    // for a rod of length "n"
    // then we return that solution
    if(r[n] >= 0){
        return r[n]
    }
    // no revenue can be calculated for a rod of length 0
    if(n == 0){
        q = 0
    }else{
        // if this is the first time we are 
        // encountering this problem,
        // we perform the calculations
        q = p[n]
        for(i in 1..n){
            q = Math.max(q,p[i]+aux(p,n-i,r))
        }
    }
    // save th solution for future use
    r[n] = q
    // return the max revenue
    return q
}