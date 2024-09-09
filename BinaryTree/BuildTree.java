package BinaryTree;

import java.util.*;

public class BuildTree {
    static class Node{
        int data;
        Node left, right;
        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class createTree {
        static int index=-1;
        public static Node Construct( int []nodes)
        {
            index++;
            if(nodes[index]==-1)
            {
                return null;
            }
            Node newNode=new Node(nodes[index]);
            newNode.left=Construct(nodes);
            newNode.right=Construct(nodes);
            return newNode;
        }
    
        
    }

    public static void Preorder(Node root){
        if(root==null){
            return;       
        }

        System.out.print(root.data);
        Preorder(root.left);
        Preorder(root.right);
    }
    public static void Inorder(Node root){
        if(root==null){
            return;       
        }
        Inorder(root.left);
        System.out.print(root.data);
        Inorder(root.right);
    }

    public static void PostOrder(Node root){
        if(root==null){
            return;       
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data);
    }

    public static void levelOrder(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            Node curr=q.remove();
            if(curr==null)
            {
                System.out.println("");
                if(q.isEmpty())
                {
                    break;
                }
                else{
                    q.add(null);
                }

            }
            else{
                System.out.println(curr.data);
                if(curr.left != null)
                {
                    q.add(curr.left);
                }
                if(curr.right!= null)
                {
                    q.add(curr.right);
                }
            }
        }

    }

    public static int CountOfNode(Node root)
    {
        if(root == null) return 0;
        
        int left= CountOfNode(root.left);
        int right=CountOfNode(root.right);
        return left+right+1;
    }

    public static int sumOfNode(Node root)
    {
        if(root == null)return 0 ;
        int left= CountOfNode(root.left);
        int right=CountOfNode(root.right);
        return left+right+root.data ;

    }

    public static int height(Node root)
    {
        if(root == null)return 0 ;
        int leftHeight=height(root.left); 
        int rightHeight=height(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    static class info{
        int height, diameter;
        info(int h, int d){
            this.height=h;
            this.diameter=d;
    }}
    public static info DiameterOfTree(Node root){
        if(root == null) return new info(0, 0) ;
        info leftInfo=DiameterOfTree(root.left);
        info rightInfo=DiameterOfTree(root.right);
        int height=Math.max(leftInfo.height,rightInfo.height)+1;
        int diameter=leftInfo.height + rightInfo.height+1;
        int resultant_dia= Math.max(diameter,Math.max(leftInfo.diameter,rightInfo.diameter));
        return new info(height, resultant_dia);

    }

    public static boolean isIdentical(Node root, Node subroot){
        if(subroot == null && root ==null)return true;
        if(subroot == null || root ==null)return false;
        if(root.data == subroot.data){ return isIdentical(root.left, subroot.left)&& isIdentical(root.right, subroot.right);}
        return false;
    }

    public static Boolean isSubTree(Node root, Node subroot)
    {
        if(subroot == null)return true;
        if(root == null)return false;
        if(root.data== subroot.data){
            if(isIdentical(root,subroot))
            {
                return true;
            }
        }
        return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
    }

    public static void main(String[] args) {
        int nodes[]={ 1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        createTree tree=new createTree();
        Node root= tree.Construct(nodes);
        System.out.println(root.data);
        // Preorder(root);
        // System.out.println("");
        // Inorder(root);
        levelOrder(root);
    }
}
