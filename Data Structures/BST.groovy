class BinarySearchTree<E>{
    Node<E> root
    int count = 0
    public BinarySearchTree(){ }
    public BinarySearchTree(E data){ root = new Node<E>(data,null); count++ }
//--------------------------------------------------------------------------------------------------    
    Node<E> insert(E data,Node<E> node,Node<E> parent){
        if(node == null){
            node = new Node<E>(data,parent)
            count++
        }else if(data > node.value){
           node.right = insert(data,node.right,node)
        }else{
           node.left = insert(data,node.left,node)
        }
        return node
    }
//--------------------------------------------------------------------------------------------------   
    Node<E> search(Node<E> node, int data){
        if(node == null){ return null }
        
        if( node.value == data ){
            return node
        }else if(data > node.value){
            return search(node.right,data)
        }else{
            return search(node.left,data)
        }
    }
//--------------------------------------------------------------------------------------------------    
    void preorder(Node<E> root){
        if(root == null){
            return
        }else{
            println root.value
            preorder(root.left)
            preorder(root.right)
        }
    }
//--------------------------------------------------------------------------------------------------   
    void inorder(Node<E> root){
        if( root == null ){
            return
        }else{
            inorder(root.left)
            Integer parent = root.parent == null ? null : root.parent.value
            println "${root.value}"
            inorder(root.right)
        }
    }
//--------------------------------------------------------------------------------------------------    
    void postorder(Node<E> root){
        if( root == null ){
            return
        }else{
            postorder(root.left)
            postorder(root.right)
            println root.value
        }
    }
//--------------------------------------------------------------------------------------------------    
    int getHeight(){ return Math.round( Math.log(count) / Math.log(2) ) }
//--------------------------------------------------------------------------------------------------   
    Node<E> getMin(Node<E> node){
        if(node == null){
            return null
        }else{
            while( node.left != null ){
                node = node.left
            }
        }
        return node
    }
//--------------------------------------------------------------------------------------------------       
    Node<E> getMax(Node<E> node){
        if(node == null){
            return null
        }else{
            while( node.right != null ){
                node = node.right
            }
        }
        return node
    } 
//--------------------------------------------------------------------------------------------------
    Node<E> getSuccessor(Node<E> x){
        Node<E> y = x.parent
        if(x.right != null){
            return getMin(x.right)
        }else{
            while(y != null && x == y.right){
                x = y
                y = y.parent
            }
        }
        return y
    }
//--------------------------------------------------------------------------------------------------
    Node<E> getPredecessor(Node<E> x){
        Node<E> y = x.parent
        if(x.left != null){
            return getMax(x.left)
        }else{
            while(y != null && x == y.left){
                x = y
                y = y.parent
            }
        }
        return y
    }
//-------------------------------------------------------------------------------------------------- 
    void transplant(Node<E> u,Node<E> v){
        if(u.parent == null){
            // If you are deleting the root
            // the root points to the new child
            root = v
        }else if(u == u.parent.left){
            // if u is the left child
            u.parent.left = v
        }else{
            // if u is the right child
            u.parent.right = v
        }
        // Now, change of parents
        if(v != null){
            v.parent = u.parent
        }
    }
//--------------------------------------------------------------------------------------------------
    void delete(Node<E> z){
        if(z.left == null){
            // node has no left child
            // then right child replaces z
            transplant(z,z.right)
        }else if(z.right == null){
            // node has no right child
            // then left child replaces z
            transplant(z,z.left)
        }else{
            // else, we find the successor node
            Node<E> y = getMin(z.right)
            if(y.parent !=  z){
                // if the successor is not the immediate
                // right child of z then
                // 1. replace Y by its right child
                transplant(y,y.right)
                y.right = z.right
                y.right.parent = y
            }
            // 2. replace z by y
            transplant(z,y)
            y.left = z.left
            y.left.parent = y
        }
    }
//-------------------------------------------------------------------------------------------------- 
    public static class Node<E>{
        E value
        Node<E> parent
        Node<E> left
        Node<E> right
        public Node(){}
        public Node(E data,Node<E> parent){ 
            value = data;
            this.parent = parent
        }
    }
}
//--------------------------------------------------------------------------------------------------
BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>(15)
for(i in [6,18,3,7,17,20,2,4,13,9]){
    bt.insert(i,bt.root,null)
}
BinarySearchTree.Node<Integer> node = bt.search(bt.root,15)
bt.delete(node)
bt.inorder(bt.root)