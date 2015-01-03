class Stack{
    final static int MAX = 100
    private int[] stack
    private int top = -1
    public Stack(){ stack = new int[MAX] }
    public Stack(int size){ stack = new int[size] }
    
    public void push(int x){
        top++
        stack[ top ] = x
    }
    public int pop(){
        int x = stack[ top ]
        top--
        return x
    }
    
    public boolean isFull(){ return top == stack.length-1 }
    public boolean isEmpty(){ return top == -1 }
}

Stack s = new Stack(5)

for(i in 1..10){
    if( !s.isFull() ){
        s.push(i)
    }
}
for(i in 1..10){
    if( !s.isEmpty() ){
        println s.pop()
    }
}