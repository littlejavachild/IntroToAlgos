int[] data = [77,69,59,100]
radixSort(data)

void radixSort(int[] A){
    int max = getMax(A);
    int div = 1
    while( (max/div) > 0 ){
        countingSort(A,div)
        max = max / div
        div *= 10
    }
}

void countingSort(int[] A,int div){
    int[] freq = new int[10] // key space is 0 - 10
    int[] output = new int[A.length]
    // calculate frequency
    for(int i = 0; i < A.length; i++){
        int digit = (A[i]/div).intValue().intValue()%10
        println "number in $div's place for ${A[i]} is $digit"
        freq[digit]++
    }
    // calculate cumulative frequency
    for(int i = 1; i < freq.length; i++){
        freq[i] = freq[i] + freq[i-1]
    }
    // rearrange
    for(int i = A.length-1; i >= 0;i--){
        int digit = (A[i]/div).intValue()%10
        int index = freq[digit] - 1
        freq[digit]--
        output[index] = A[i]
    }
    // copy
    for(int i = 0; i < A.length; i++){
        A[i] = output[i]
    }
    print A
    println ""
    println ""
}

int getMax(int[] A){
    int max
    for(int i = 0; i < A.length; i++){
        if( A[i] > max ){
            max = A[i]
        }
    }
    return max
}