class LinearQueue{
    final static int MAX = 100
    int[] queue;
    int head = -1
    int tail = -1
    public LinearQueue(){ queue = new int[MAX] }
    public LinearQueue(int size){ queue = new int[size] }
    
    public void enqueue(int x){
        if(head == -1 && tail == -1){
            head++
            tail++
            queue[ tail ] = x
        }else{
            tail++
            queue[ tail ] = x
        }
    }
    public int dequeue(){
        int x = queue[head]
        head++
        return x
    }
    
    
    public boolean isFull(){ return tail == queue.length-1 }
    public boolean isEmpty(){   
        boolean c1 = (head==-1) && (tail==-1)
        boolean c2 = head > tail
        return c1 || c2
    }
}

LinearQueue q = new LinearQueue(5)
for(i in 1..10){
    if(  !q.isFull() ){ q.enqueue(i) }
}
for(i in 1..10){
    if( !q.isEmpty() ){
        println q.dequeue()
    }
}