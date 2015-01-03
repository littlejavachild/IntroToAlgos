// JAVA: http://ideone.com/ems8a3
int[] arr = [5,4,3,2,1]
quickSort(arr,0,arr.length-1)
print arr

void quickSort(int[] A,int p,int r){
    if(p<r){
        int q = partition(A,p,r)
//        println "sorting from: $p to $q and ${q+1} to $r"
        quickSort(A,p,q)
        quickSort(A,q+1,r)
    }
}

int partition(int[] A,int p,int r){
    int pivot = A[r]
    int i = p
    int j = p
    for(j = p; j < r; j++){
        if(A[j] <= pivot){
            int temp = A[j]
            A[j] = A[i]
            A[i] = temp
            i++
        }
    }
    int temp = A[r]
    A[r] = A[i]
    A[i] = temp
    return i==0?0:(i-1)
}