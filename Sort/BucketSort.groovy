def arr = [0,1,0,1,0,0,0,0,1,0,1,0,1,1]
def buckets = [
                [], // 00 - 10
                [], // 11 - 20
                [], // 21 - 30
                [], // 31 - 40
                [], // 41 - 50
                []  // otherwise
              ]
// put things into the buckets 
for(int i = 0; i < arr.size(); i++){
    int x = arr[i]
    switch(x){
    case 0..10:
        def bucket = buckets[0]
        bucket << x
        break;
    case 11..20:
        def bucket = buckets[1]
        bucket << x
        break;
    case 21..30:
        def bucket = buckets[2]
        bucket << x
        break;
    case 31..40:
        def bucket = buckets[3]
        bucket << x
        break;
    case 41..50:
        def bucket = buckets[4]
        bucket << x
    break;
    default:
        def bucket = buckets[5]
        bucket << x
    }
}
// insertion sort each individual bucket
for(int i = 0; i < buckets.size(); i++){
    insertionSort(buckets[i])
}
// concatenate the buckets
print buckets.flatten()


void insertionSort(def A){
    int i;
    int j;
    for(j = 1; j < A.size(); j++){
        int key = A[j]
        i = j
        while(i > 0 && A[i-1] > key){
            A[i] = A[i-1]
            i--
        }
        A[i] = key
    }
}