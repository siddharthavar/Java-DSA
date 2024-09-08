// import java.util.*;
// public class BinaryTreeYT {
//     static class Node{
//         int data;
//         Node left;
//         Node right;
        
//         Node(int data){
//             this.data=data;
//             this.left=null;
//             this.right=null;
//         }

//     }


//     static class BinaryTree {
//         static int ind=-1;
//     public static Node builtree(int nodes[]){
//         ind++;
//         if(nodes[ind]== -1){
//             return null;
//         }
//         Node newNode= new Node(nodes[ind]);
//         newNode.left= builtree(nodes);      
//         newNode.right= builtree(nodes);
//         return newNode;

//     }
        
//     }

//     public static void preorder(Node root){
//         if (root == null)
//         {
//             return;
//         }
//         System.out.print(root.data + " ");
//         preorder(root.left);
//         preorder(root.right);

//     }
//     public static void postorder(Node root){
//         if (root == null)
//         {
//             return;
//         }
//         postorder(root.left);
//         postorder(root.right);
//         System.out.print(root.data + " ");
//     }
//     public static void inorder(Node root){
//         if (root == null)
//         {
//             return;
//         }
//         inorder(root.left);
//         System.out.print(root.data + " ");
//         inorder(root.right);

//     }

//     public static void levelorder( Node root)
//     {
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         q.add(null);
//         while (!q.isEmpty()) {
//             Node temp = q.remove();
//             if(temp == null){
//                 System.out.print("\n  ");
//                 if(q.isEmpty())
//                 {
//                     break;
//                 }
//                 else{
//                     q.add(null);
//                 }
//             }
//             else{
//                 System.out.print(temp.data);
//                 if(temp.left != null){
//                     q.add(temp.left);
//                 }
//                 if(temp.right != null)
//                 {
//                     q.add(temp.right);
//                 }

//             }}
//     }

//     // public static void sumOfKthLevel( Node root, int target)
//     // {
//     //     Queue<Node> q = new LinkedList<>();
//     //     q.add(root);
//     //     q.add(null);
//     //     int level=0;
//     //     int sum=0;
//     //     while (!q.isEmpty()) {
//     //         if (level == target)
//     //         {Node temp = ;
                
//     //             while(temp != null)
//     //             {
//     //                 sum +=temp.data;
//     //                 temp  = q.remove();
//     //             }

//     //         }
//     //         Node temp = q.remove();
//     //         if(temp == null){
//     //             System.out.print("\n  ");
//     //             level++;
//     //             if(q.isEmpty())
//     //             {
//     //                 break;
//     //             }
//     //             else{
//     //                 q.add(null);
//     //             }
//     //         }
//     //         else{
//     //             System.out.print(temp.data);
//     //             if(temp.left != null){
//     //                 q.add(temp.left);
//     //             }
//     //             if(temp.right != null)
//     //             {
//     //                 q.add(temp.right);
//     //             }

//     //         }}
//     // }

//     public static int countOfnode(Node root)
//     {if (root == null) return 0;

//         int left = countOfnode(root.left);
//         int right= countOfnode(root.right);
//         return left+right+1;
//     }

//     public static int sumOfNode(Node root)
//     {if (root == null) return 0;

//         int left = sumOfNode(root.left);
//         int right= sumOfNode(root.right);
//         return left+right+ root.data;
//     }

//     public static int height(Node root){
//         if (root == null)
//         {return 0;}
//         int left =height(root.left);
//         int right = height(root.right);
//         int currheight = Math.max(left, right)+1;
//         return currheight;
//     }

//     static class Treeinfo
//     {   int ht;
//         int dia;
//         Treeinfo(int ht , int dia)
//         {
//             this.ht = ht;
//             this.dia = dia;
//         }    }

//         public static Treeinfo diameter(Node root){
//             if (root == null)
//             { return new Treeinfo(0, 0);}
//          Treeinfo left = diameter(root.left);
//          Treeinfo right = diameter(root.right);
//             int height = Math.max(left.ht, right.ht) +1;
//             int d1 = left.dia;
//             int d2 = right.dia;
//             int d3 = left.ht + right.ht + 1;
//             int my_dia =  Math.max(d3, Math.max(d1,d2));

//             Treeinfo newnode = new Treeinfo(height, my_dia);
//             return newnode;
            

//         }


//     public static void main(String[] args) {
//         int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
//         BinaryTree Tree= new BinaryTree();
//         Node root = Tree.builtree(nodes);
//         // preorder(root);
//         // System.out.println();
//         // postorder(root);
//         // System.out.println();
//         // inorder(root);
//         // System.out.println();
//         // levelorder(root);
//         // System.out.println();
//         // int count = countOfnode(root);
//         // System.out.println(count);
//         // int sum = sumOfNode(root);
//         // System.out.println(sum);
//         int height = height(root);
//         System.out.println(height);
        
//     }
// }
