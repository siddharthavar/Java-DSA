public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }

    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean find(Node root, int val) {
        if (root == null)
            return false;
        if (root.data == val)
            return true;
        if (root.data > val)
            return find(root.left, val);
        if (root.data < val)
            return find(root.right, val);

        return false;
    }

    public static Node delete(Node root, int val)
    {
        if(root.data> val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val)
        {

            root.right = delete(root.right, val); 
        }
        else{
        if(root.left== null && root.right== null){
            return null;
        }
        if(root.right == null){
            return root.left;
        }
        if(root.left == null){
        return root.right;
        }

        Node is = inordersuccessor(root.right);
        root.data = is.data;
        root.right = delete(root.right, is.data);

    }
    return root;
}

public static Node inordersuccessor(Node root)
{
    while(root.left != null)
    {
        root=root.left;
        
    }
    return root;
}
    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);

        System.out.println(find(root, 3));

    }
}
