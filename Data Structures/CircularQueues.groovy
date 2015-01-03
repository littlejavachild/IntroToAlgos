public class CircularQueue{
    final static int MAX = 100
    int head = -1
    int tail = -1
    int count = 0
    int[] queue
    public CircularQueue(){ queue = new int[MAX] }
    public CircularQueue(int size){ queue = new int[size] }
    
    public void enqueue(int x){
        if( head == -1 && tail == -1){
            head++
            tail++
            queue[ tail ] = x
        }else{
            tail = (tail+1)%queue.length
            queue[ tail ] = x
        }
        count++
    }
    
    public int dequeue(){
        int x = queue[ head ]
        head = (head+1)%queue.length
        count--
        return x
    }
    
    
    public boolean isFull(){ return (head==(tail+1)%queue.length) && (count==queue.length) }
    public boolean isEmpty(){ return (count == 0) }
    
}

CircularQueue c = new CircularQueue(5)
for(i in 1..10){
    if( !c.isFull() ){
        c.enqueue(i)
    }
}
println "Queue:${c.queue} Head:${c.head} Tail:${c.tail}"
for(i in 1..10){
    if( !c.isEmpty() ){
        c.dequeue()
    }
}
println "Queue:${c.queue} Head:${c.head} Tail:${c.tail}"
for(i in 1..10){
    if( !c.isFull() ){
        c.enqueue(i)
    }
}
println "Queue:${c.queue} Head:${c.head} Tail:${c.tail}"
for(i in 1..3){
    if( !c.isEmpty() ){
        println c.dequeue()
    }
}
println "Queue:${c.queue} Head:${c.head} Tail:${c.tail}"