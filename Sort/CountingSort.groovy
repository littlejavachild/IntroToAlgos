void countingSort(int[] A){
    int[] output = new int[A.length]
    int[] freq = new int[10]
    // Calculate frequency
    for(int i = 0; i < A.length; i++){
        freq[ A[i] ]++
    }
    // Calculate cumulative frequency
    for(int i = 1; i < freq.length; i++){
        freq[i] = freq[i] + freq[i-1]
    }
    // Prepare output list
    for(int i = 0; i < A.length; i++){
        int digit = A[i]
        output[ freq[digit] - 1 ] = A[i]
        freq[digit]--
    }
    // Copy everything into original array
    for(int i = 0; i < A.length; i++){
        A[i] = output[i]
    }
}
//------------------------------------------------------------------------------
int[] array = [5,4,3,2,1]
countingSort(array)
print array