int[] input = [-1,-2,-3,4,5,6,-7,-8,-9]
print insertionSort(input)

int[] insertionSort(int[] A){
    for(int j = 1; j < A.length; j++){
        int key = A[j]
        i = j
        while(i>0 && A[i-1]>key){
            A[i] = A[i-1]
            i--
        }
        A[i] = key
    }
    return A
}