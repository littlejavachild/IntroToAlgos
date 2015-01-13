int[] p = [0,1,5,8,9,10,17,17,20]
int n = 5
println "${rodCut(p,n)}"

int rodCut(int[] p,int n){
   int q
   if(n == 0){
       return 0
   }
   q = p[n]
   for(int i in 1..n){
       q = Math.max(q,p[i]+rodCut(p,n-i))
   }
   return q
}
