import groovy.transform.Field
@Field int n = 10
@Field int m = getM(n)
@Field int[] table = new int[m]
@Field int c1 = 7
@Field int c2 = 11
@Field final static int EMPTY = -1
@Field final static int DELETED = -2

init(table)
for(i in 1..n){
    int key = new java.util.Random().nextInt(100)
    hashInsert(key)
}
println table
//--------------------------------------------------------------------------------------------------
int getM(int n){
    int x = Math.round( 1.5 * n )
    while( !isPrime(x) ){
        x++
    }
    return x
}
//--------------------------------------------------------------------------------------------------
boolean isPrime(int x){
    boolean isPrime = true
    for(int i = 2; i <= Math.sqrt(x); i++){
        if(x % i == 0){
            isPrime = false
            break
        }
    }
    return isPrime
}
//--------------------------------------------------------------------------------------------------
boolean hashInsert(int key){
    int index
    for(i=0; i < m; i++){
        index = hash(key,i)
        if(table[index] == EMPTY  || table[index] == DELETED){
            table[index] = key
            println "Inserted $key at $index"
            return true
        }
    }
    println "Could not insert $key at $index"
    return false
}
//--------------------------------------------------------------------------------------------------
int hash(int k,int i){
    int hash = ((k%m) + (c1*i) + (c2*i*i))%m
    return hash
}
//--------------------------------------------------------------------------------------------------
void init(int[] table){
    for(int i = 0; i < table.length; i++)
        table[i] = EMPTY
}
//--------------------------------------------------------------------------------------------------