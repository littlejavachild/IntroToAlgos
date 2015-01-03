import groovy.transform.Field
@Field final int EMPTY = -1
@Field final int DELETED = -2
int n = 10 // key space
int m = getM(n) // table size
int[] table = new int[m]
init(table)
// Insert n values into the hash table
for(i in 1..n){
    int key = new java.util.Random().nextInt(40)
    if( !hashInsert(key,table,m) ){
        println "Table Full"
    }
}
println table
// Delete half the shit you just inserted, cause you can
for(i in 1..Math.ceil(n/2)){
    int key = new java.util.Random().nextInt(40)
    if( hashDelete(key,table,m) ){
        println "Deleted $key"
    }else{
        println "Could not find $key"
    }
}
println table
//------------------------------------------------------------------------------
int getM(int n){
    int size = Math.round(1.5 * n)
    while ( !isPrime(size) ){
        size++
    }
    return size
}
//------------------------------------------------------------------------------
boolean isPrime(int n){
    boolean prime = true
    for(int i = 2; i < Math.sqrt(n); i++){
        if( n%i == 0){
            prime = false
            break
        } 
    }
    return prime
}
//------------------------------------------------------------------------------
boolean hashInsert(int key,int[] table,int m){
    for(int i = 0; i < m; i++){
        int index = hash(key,m,i)
        if(table[ index ] == EMPTY || table[ index ] == DELETED){ // if that entry is empty or has been deleted
            table[ index ] = key
            return true
        }
    }
    return false
}
//------------------------------------------------------------------------------
boolean hashDelete(int key,int[] table,int m){
    for(int i = 0; i < m; i++){
        int index = hash(key,m,i)
        // If the value was never inserted
        if( table[index] == EMPTY ){
            return false
        }else if( table[index] == DELETED || table[index] != key){
                // If the added value was deleted OR
                // some other value is occupying the 
                // index, we continue the probe.
                // Do nothing
        }else{
                // Else, mark the value deleted
                table[ index ] = DELETED
                return true
        }
    }
    return false
}
//------------------------------------------------------------------------------
int hash(int k,int m,int i){
    if(i == 0){ 
        return k % m 
    }else{
        return (k+i)%m
    }
}
//------------------------------------------------------------------------------
void init(int[] table){
    for(int i = 0; i < table.length; i++){
        table[i] = -1
    }
}
//------------------------------------------------------------------------------