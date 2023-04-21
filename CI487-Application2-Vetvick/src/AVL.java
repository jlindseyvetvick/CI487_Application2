/**	 DO  NOT  MODIFY  **/

public class AVL<T extends Comparable<T>>{

    public class TreeNode<T extends Comparable<T>>{
        T data;
        int height;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
            height = 0;
        }

    }

    private TreeNode<T> root;

    public AVL() {
        root = null;
    }
    private int nodeHeight(TreeNode<T> node){
        return node == null ? -1 : node.height;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private TreeNode<T> balance(TreeNode<T> curr){
        if ((nodeHeight(curr.left) - nodeHeight(curr.right)) < -1){
            if ((nodeHeight(curr.right.left) - nodeHeight(curr.right.right)) > 0){
                curr = rightLeftRotate(curr);
            } else {
                curr = leftRotate(curr);
            }
        } else if ((nodeHeight(curr.left) - nodeHeight(curr.right)) > 1){
            if ((nodeHeight(curr.left.left) - nodeHeight(curr.left.right)) < 0) {
                curr = leftRightRotate(curr);
            } else {
                curr = rightRotate(curr);
            }
        }
        return curr;
    }

    private TreeNode<T> insert(TreeNode<T> curr, T data){

        if(curr == null){
            curr = new TreeNode<>(data);
            return curr;
        } else if (data.compareTo(curr.data) < 0) {
            curr.left = insert(curr.left, data);
        } else {
            curr.right = insert(curr.right, data);
        }
        curr.height = Math.max(nodeHeight(curr.left), nodeHeight(curr.right)) + 1;
        return balance(curr);
    }

    private TreeNode<T> leftRotate(TreeNode<T> node){

        /*rotate*/
        TreeNode<T> tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;

        /*update nodeHeights*/
        node.height = Math.max(nodeHeight(node.left), nodeHeight(node.right)) + 1;
        tmp.height = Math.max(nodeHeight(tmp.left), nodeHeight(tmp.right)) + 1;

        /*return the new "root"*/
        return tmp;
    }

    private TreeNode<T> rightRotate(TreeNode<T> node){

        /*rotate*/
        TreeNode<T> tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;

        /*update nodeHeights*/
        node.height = Math.max(nodeHeight(node.left), nodeHeight(node.right)) + 1;
        tmp.height = Math.max(nodeHeight(tmp.left), nodeHeight(tmp.right)) + 1;

        /*return the new "root"*/
        return tmp;
    }

    private TreeNode<T> leftRightRotate(TreeNode<T> node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    private TreeNode<T> rightLeftRotate(TreeNode<T> node){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public void remove(T data){
        root = remove(root, data);
    }

    private TreeNode<T> remove(TreeNode<T> curr, T data){

        if(curr == null){
            return null;
        }

        if(curr.data.compareTo(data) < 0){
            curr.right = remove(curr.right, data);
        } else if (curr.data.compareTo(data) > 0){
            curr.left = remove(curr.left, data);
        } else {
            if(curr.left == null){
                return curr.right;
            }else if(curr.right == null){
                return curr.left;
            }else{
                TreeNode<T> minNode = findMinNode(curr.right);
                curr.data = minNode.data;
                curr.right = remove(curr.right, minNode.data);
            }
        }

        curr.height = Math.max(nodeHeight(curr.left), nodeHeight(curr.right)) + 1;
        return balance(curr);

    }

    private TreeNode<T> findMinNode(TreeNode<T> curr){

        if(curr == null){
            return null;
        }

        while(curr.left != null){
            curr = curr.left;
        }

        return curr;
    }


    public T search(T data){
        return search(root, data, 1);
    }

    private T search(TreeNode<T> curr, T data, int count){
        if(curr == null){
            //System.out.println("Not found!");
            return null;
        } else if(data.compareTo(curr.data) == 0){
            //System.out.printf("Found in %d steps!\n", count);
            return curr.data;
        }
        if(data.compareTo(curr.data) < 0){
            return search(curr.left, data, count + 1);
        } else {
            return search(curr.right, data, count + 1);
        }
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode<T> node){
        if(node != null){
            inorderTraversal(node.left);
            System.out.println(node.data);
            inorderTraversal(node.right);
        }
    }

}
