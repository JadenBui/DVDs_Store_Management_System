package Movie;

import javax.lang.model.util.Elements;
import javax.swing.*;

public class BTS {
    Node root;

    public void addNode(int key, String value){
        Node newNode = new Node(key,value);
        if(root == null){
            root = newNode;
        }else{
            Node focusNode = root;
            Node parent;
            while(true){
                parent = focusNode;
                if(key < focusNode.key){
                    focusNode = focusNode.left;
                    if(focusNode == null){
                        parent.left = newNode;
                        return;
                    }
                }else{
                    focusNode = focusNode.right;
                    if(focusNode == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteNode(int key){
        Node parent = this.root;
        Node focusNode = this.root;
        if(parent == null){return false;}
        //Move the focus node to the node to be delete
        while(key != focusNode.key){
            parent = focusNode;
            if(key > focusNode.key){focusNode = focusNode.right;}
            else if(key < focusNode.key){focusNode = focusNode.left;}
        }
        //Node to be deleted was not found
        if (focusNode == null){return false;}
        //Node to be deleted is a leaf || has 1 children
        if(focusNode.right == null || focusNode.left == null || focusNode.left == null && focusNode.right == null){
            Node replacementNode;
            if(focusNode.right == null){
                replacementNode = focusNode.left;
            }else{
                replacementNode = focusNode.right;
            }
            //If node to be deleted is a root with 1 child
            if(focusNode == root){root = replacementNode;}
            else if(parent.right == focusNode){
                parent.right = replacementNode;
            }else{
                parent.left = replacementNode;
            }
            //Node to be deleted has 2 children
        }else if(focusNode.left != null && focusNode.right != null){
            if(focusNode.right.left == null){
                //Preserve the left children of the deleted node
                focusNode.key = focusNode.right.key;
                focusNode.value = focusNode.right.value;
                //Carry on the right branch of the replacement node
                focusNode.right = focusNode.right.right;
            }else{
                Node replacementNode = focusNode.right;
                while(replacementNode.left != null){
                    parent = replacementNode;
                    replacementNode = replacementNode.left;
                }
                focusNode.key = replacementNode.key;
                focusNode.value = replacementNode.value;
                parent.left = replacementNode.right;
            }
        }
        return true;
    }


    public String search(int key){
        //int visit = 0;
        Node focusNode = root;
        while(true){
//            visit++;
//            System.out.println(visit);
            if(key == focusNode.key) return focusNode.value;

            if(key < focusNode.key){
                focusNode = focusNode.left;
            }else{
                focusNode = focusNode.right;
            }
            if(focusNode == null) return null;
        }
    }

    public static void main(String[] args) {
        BTS tree = new BTS();
        tree.addNode(50,"Fifty");
        tree.addNode(30,"Thirty");
        tree.addNode(70,"Seventy");
        tree.addNode(20,"Twenty");
        tree.addNode(45,"Forty-five");
        tree.addNode(15,"Fifteen");
        tree.addNode(43,"Forty-three");
        tree.addNode(41,"Forty-one");
        tree.addNode(42,"Forty-two");
        tree.addNode(44,"Forty-four");
        tree.addNode(49,"Forty-nine");
        tree.addNode(65,"Sixty-five");
        tree.addNode(72,"Seventy-two");
        tree.addNode(71,"Seventy-one");
        //System.out.println(tree.search(5));
        tree.deleteNode(30);

        tree.innerTraverse(tree.root);

    }

    public void innerTraverse(Node node){
        if(node != null){
            innerTraverse(node.left);
            System.out.println(node);
            innerTraverse(node.right);

        }
    }
   class Node{
        int key;
        String value;
        Node left;
        Node right;
        public Node(int key, String value){
            this.key = key;
            this.value = value;
        }

       @Override
       public String toString() {
           return "Node{" +
                   "key=" + key +
                   ", value='" + value + '\'' +
                   ", left=" + left +
                   ", right=" + right +
                   '}';
       }
   }
}


