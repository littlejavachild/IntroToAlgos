import groovy.transform.Field
@Field final int MAX = 20
@Field int[] heap = new int[20]
@Field int size = 0
@Field int heapSize = 0

// Fill in some data into the heap
for(i in 1..15){
    size++
    heapSize++
    heap[size-1] = i
}
// Make a max heap
buildMaxHeap(heap)
// Insert some more data in it
insert(heap,199)
insert(heap,200)
insert(heap,001)
insert(heap,302)
insert(heap,201)
// Sort the heap
heapSort(heap)
// Print the heap
println heap

//--------------------------------------------------------------
int getRight(int i){
    return 2*i+2
}
//--------------------------------------------------------------
int getLeft(int i){
    return 2*i+1
}
//--------------------------------------------------------------
int getParent(int i){
    return Math.floor(i/2)
}
//--------------------------------------------------------------
void maxHeapify(int[] A,int i){
    int l = getLeft(i)
    int r = getRight(i)
    int largest = i
    if(l < heapSize && A[l] > A[i])
        largest = l
    if(r < heapSize && A[r] > A[largest])
        largest = r
    if(largest != i){
        int temp = A[i]
        A[i] = A[largest]
        A[largest] = temp
        maxHeapify(A,largest)
    }
}
//--------------------------------------------------------------
void buildMaxHeap(int[] A){
    int i = (size/2)-1
    while(i >= 0){
        maxHeapify(A,i)
        i--
    }
}
//--------------------------------------------------------------
void increaseKey(int[] A,int i,int key){
    if(key < A[i])
        throw new Exception("Key cannot be decreased")
    else{
        A[i] = key
        while(i >= 0 && A[i] > A[getParent(i)]){
            int temp = A[i]
            A[i] = A[getParent(i)]
            A[getParent(i)] = temp
            i = getParent(i) 
        }
    }
}
//--------------------------------------------------------------
void insert(int[] A,int key){
    if(size == MAX)
        throw new Exception("Heap overflow")
    else{
        size++
        heapSize++
        increaseKey(A,size-1,key)
    }
}
//--------------------------------------------------------------
void heapSort(int[] A){
    int i = size - 1
    while(i > 0){
        int temp = A[0]
        A[0] = A[i]
        A[i] = temp
        heapSize--
        i--
        maxHeapify(A,0)
    }
}
//--------------------------------------------------------------