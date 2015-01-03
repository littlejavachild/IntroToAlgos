import groovy.transform.Field
@Field final static int EMPTY = -1
@Field final static int DELETED = -2
@Field int n = 10
@Field int m = getM(n)
@Field int[] table = new int[m]

init(table)
for(i in 1..m){
    int key = new java.util.Random().nextInt(40)
    hashInsert(key)
}
print table
//------------------------------------------------------------------------------
void init(int[] table){
    for(int i = 0; i < table.length; i++){
        table[ i ] = EMPTY
    }
}
//------------------------------------------------------------------------------
int getM(int n){
    int x = Math.ceil(1.5 * n)
    while( !isPrime(x) ){
        x++
    }
    return x
}
//------------------------------------------------------------------------------
boolean isPrime(int x){
    boolean isPrime = true
    for(int i = 2; i <= Math.sqrt(x); i++){
        if( x%i == 0){
            isPrime = false
            break
        }
    }
    return isPrime
}
//------------------------------------------------------------------------------
boolean hashInsert(int key){
    for(int i = 0; i < m; i++){
        int index = hash(key,i)
        if(table[index] == EMPTY || table[index] == DELETED){
            table[index] = key
            return true
        }
    }
    return false
}
//------------------------------------------------------------------------------
int hash(int k,int i){
    return (h1(k) + i*h2(k))%m
}
//------------------------------------------------------------------------------
int h1(int k){
    return k%m
}
//------------------------------------------------------------------------------
int h2(int k){
    return 1 + (k%(m-1))
}
//------------------------------------------------------------------------------