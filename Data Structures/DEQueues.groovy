class DEqueue<E>{
    Node<E> start
    Node<E> end
    public DEqueue(){  }
    public DEqueue(E data){  
        Node<E> x = new Node<E>(data)
        start = end = x
    }
    
    public void enqueueEnd(E data){
        Node<E> x = new Node<E>(data)
        if(start == null){
            start = end = x
        }else{
            end.next = x
            x.prev = end
            end = x
        }
    }
    
    public void enqueueStart(E data){
        Node<E> x = new Node<E>(data)
        if(start == null){
            start = end = x
        }else{
            start.prev = x
            x.next = start
            start = x
        }
    }
    
    public void printForward(){
        Node<E> x = start
        while(x != null){
            println x.value
            x = x.next
        }
    }
    
    public void printBackward(){
        Node<E> x = end
        while(x != null){
            println x.value
            x = x.prev
        }
    }
    
    public Node<E> search(E data){
        Node<E> x = start
        while( x != null && x.value != data ){
            x = x.next
        }
        return x
    }
    
    public boolean delete(E data){
        Node<E> x = search(data)
        // If we cant find the data,
        // we cant delete it
        if(x == null){ return false }
        // If we are deleting the first element,
        // we need to be careful about setting the 
        // 'next' pointer
        if( x.prev != null ){
            x.prev.next = x.next
        }else{
            start = x.next
        }
        // If wwe are deleting the last element,
        // we need to be careful in setting the 
        // 'prev' pointer
        if( x.next != null ){
            x.next.prev = x.prev
        }else{
            end = x.prev
        }
        
    }
    
    public static class Node<E>{
        E value
        Node<E> next
        Node<E> prev
        public Node(){  }
        public Node(E data){ value = data }
    }
}

DEqueue<String> d = new DEqueue<String>()
d.enqueueEnd("Fasih")
d.enqueueEnd("Vignesh")
d.enqueueEnd("Yash")
d.enqueueEnd("Ajay")
d.enqueueStart("Tambe")
d.delete("Fasih")

d.printForward()
