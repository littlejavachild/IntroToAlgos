int[] input = [-1,-2,-3,4,5,6,-7,-8,-9]
print bubbleSort(input)

int[] bubbleSort(int[] A){
    for(int i = 0; i < A.length;i++){
        for(int j = 0; j < A.length-1;j++){
            if(A[j] > A[j+1]){
                int temp = A[j]
                A[j] = A[j+1]
                A[j+1] = temp
            }
        }
    }
    return A
}