import java.awt.Color;

public class RedBlackTree<E>{
    Node<E> root
    //----------------------------------------------------------------
    void rbInsert(E key){
        // Z is the new node to insert
        Node<E> z = new Node<E>(key:key)
        // X is the root
        Node<E> x = root
        // Y is the parent, initially null
        Node<E> y = null
        // we now iterate until we find X to be null
        while(x != null){
            y = x
            if( z.key < x.key ){
                x = x.left
            }else{
                x = x.right
            }
        }
        // then we set the parent of Z to be Y
        z.parent = y
        // We now decide whether Z is the left child or the
        // right child of its parent
        if(y == null){
            root = z
        }else if(z.key < y.key){
            y.left = z
        }else{
            y.right = z
        }
        z.left = null
        z.right = null
        z.color = Color.RED
        // we push the violation up the tree
        rbInsertFixUp(z)
    }
    //----------------------------------------------------------------
    void rbInsertFixUp(Node<E> z){
        if(z.parent == null || z.parent.parent == null){
            return
        }
        while(z.parent.color == Color.RED){
            // If Z's parent is the left child
            if(z.parent == z.parent.parent.left){
                // We look at the right uncle/aunt of Z
                Node<E> y = z.parent.parent.right
                // CASE 1: If the uncle/aunt is red
                // we dont care whether z is left or right child
                if(y.color == Color.RED){
                    // We push the blackness of the grandparent
                    // down into the parent and uncle/aunt of Z
                    // and make the grandparent red
                    z.parent.color = Color.BLACK
                    y.color = Color.BLACK
                    z.parent.parent.color = Color.RED
                    // we move z two levels up the tree
                    // and look for any further violations
                    // that may have been caused because of the
                    // changes that we just made
                    z = z.parent.parent
                }else{
                    if(z == z.parent.right){
                        // CASE 2: Z is the right child and Y is black
                        z = z.parent
                        leftRotate(z)
                    } // CASE 2 decomposes to CASE 3
                    // CASE 3: Z is left child and Y is black
                    z.parent.color = Color.BLACK
                    z.parent.parent.color = Color.RED
                    rightRotate(z.parent.parent)
                }
            }else{
                Node<E> y = z.parent.parent.left
                   if(y != null){
                        if(y.color == Color.RED){
                        z.parent.color = Color.BLACK
                        y.color = Color.BLACK
                        z.parent.parent.color = Color.RED
                        z = z.parent.parent
                    }else{
                        if(z == z.parent.left){
                            z = z.parent
                            rightRotate(z)
                        }
                        z.parent.color = Color.BLACK
                        z.parent.parent.color = Color.RED
                        leftRotate(z.parent.parent)
                    }
               }
            }
        }
        root.color = Color.BLACK
    }
    //----------------------------------------------------------------
    void leftRotate(Node<E> x){
        if(x.right != null){
            Node<E> y = x.right
            x.right = y.left
            if(y.left != null){
                y.left.parent = x
            }
            y.parent = x.parent
            if(x.parent == null){
                root == y
            }else if(x == x.parent.left){
                x.parent.left = y
            }else{
                x.parent.right = y
            }
            y.left = x
            x.parent = y
        }
    }
    //----------------------------------------------------------------
    void rightRotate(Node<E> y){
        if(y.left != null){
            Node<E> x = y.left
            y.left = x.right
            if(x.right != null){
                x.right.parent = y
            }
            x.parent = y.parent
            if(y.parent == null){
                root = x
            }else if(y == y.parent.right){
                y.parent.right = x
            }else{
                y.parent.left = x
            }
            x.right = y
            y.parent = x
        }
    }
    //----------------------------------------------------------------
    void inorder(Node<E> x){
        if(x != null){
            inorder(x.left)
            println x.key
            inorder(x.right)
        }
    }
    //----------------------------------------------------------------
    Node<E> getMin(Node<E> x){
        while(x.left != null){
            x = x.left
        }
        return x
    }
    //----------------------------------------------------------------
    Node<E> getMax(Node<E> x){
        while(x.right != null){
            x = x.right
        }
        return x
    }
    //----------------------------------------------------------------
    Node<E> search(E key,Node x){
        if(x == null){
            return null
        }else if(x.key == key){
            return x
        }else if(key > x.key){
            return search(key,x.right)
        }else{
            return search(key,x.left)
        }
    }
    //----------------------------------------------------------------
    Node<E> getSuccessor(Node<E> x){
        if(x.right != null){
            return getMin(x.right)
        }else{
            Node<E> y = x.parent
            while(y != null && x == y.right){
                x = y
                y = y.parent
            }
            return y
        }
    }
    //----------------------------------------------------------------
    void transplant(Node<E> u,Node<E> v){
        if(u.parent == null){
            root = v
        }else if(u == u.parent.left){
            u.parent.left = v
        }else{
            u.parent.right = v
        }
        if(v != null){
            u.parent = v.parent
        }
    }
    //----------------------------------------------------------------
    void delete(Node<E> z){
        if(z.left == null){
            transplant(z,z.right)
        }else if(z.right == null){
            transplant(z,z.left)
        }else{
            Node<E> y = getSuccessor(z)
            if( y.parent != z ){
                transplant(y,y.right)
                y.right = z.right
                y.right.parent = y
            }
            transplant(z,y)
            y.left = z.left
            y.left.parent = y
        }
    }
    //----------------------------------------------------------------
    static class Node<E>{
        E key
        Node<E> parent
        Node<E> left
        Node<E> right
        Color color
    }
}


RedBlackTree<Integer> r = new RedBlackTree<Integer>()
for(i in [10,12,13,1,9,32,69,0]){
    r.rbInsert(i)
}
println "lalaal"
r.inorder(r.root)