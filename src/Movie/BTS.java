package Movie;

import javax.lang.model.util.Elements;

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
        Node focusNode = root;
        Node parent = root;

        boolean isLeft = true;
        while(key != focusNode.key){
            parent = focusNode;
            if(key < focusNode.key){
                focusNode = focusNode.left;
                isLeft = true;
            }
            else{
                focusNode = focusNode.right;
                isLeft = false;
            }

            if(focusNode == null){
                return false;
            }
        }

        if(focusNode.left == null && focusNode.right == null){
            if(focusNode == root){
                root = null;
            }else if(isLeft){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        else if(focusNode.right == null){
            if(focusNode == root){
                root = focusNode.left;
            }else if(isLeft){
                parent.left = focusNode.left;
            }else {
                parent.right = focusNode.left;
            }

        }else if(focusNode.left == null){
            if(focusNode == root){
                root = focusNode.right;
            }else if(isLeft){
                parent.left = focusNode.right;
            }else{
                parent.right = focusNode.right;
            }
        }else{
            Node replacement = getReplaceNode(focusNode);
            if(focusNode == root){
                root = replacement;
            }else if(isLeft){
                parent.left = replacement;
            }else{
                parent.right = replacement;
            }
            replacement.left = focusNode.left;
        }
        return true;
    }

    public Node getReplaceNode(Node replacedNode){
        Node replace = replacedNode;
        Node parent = replacedNode;
        Node focusNode = replacedNode.right;

        while(focusNode != null){
            parent = replace;
            replace = focusNode;
            focusNode = focusNode.left;
        }

        if(replace != replacedNode.right){
            parent.left = replace.right;
            replace.right = replacedNode.right;

        }

        return replace;
    }

    public String search(int key){
        int visit = 0;
        Node focusNode = root;
        while(true){
            visit++;
            System.out.println(visit);;
            if(key == focusNode.key) return focusNode.value;

            if(key < focusNode.key){
                focusNode = focusNode.left;
            }else{
                focusNode = focusNode.right;
            }
        }
    }

    public static void main(String[] args) {
        BTS tree = new BTS();
        tree.addNode(1,"Boss");
        tree.addNode(2,"Employee");
        tree.addNode(3,"Super Boss");
        tree.addNode(4,"Smaller employee");
        tree.addNode(5,"Bigger Employee");
        //tree.innerTraverse(tree.root);
        System.out.println(tree.search(5));
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
                   '}';
       }
   }
}


