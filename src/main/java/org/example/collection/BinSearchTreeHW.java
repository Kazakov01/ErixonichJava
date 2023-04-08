package org.example.collection;

public class BinSearchTreeHW {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //   2
        //  / \
        // 1   3
        //Node root = new Node(2, new Node(1, null, null), new Node(3, null, null));

//        /*
//              5
//             / \
//            2   8
//           / \   \
//          1   3   10
//
//         */
        Node root = new Node(5,
                             new Node(2,
                                      new Node(1),
                                      new Node(3)
                             ),
                             new Node(8,
                                      null,
                                      new Node(10)
                             )
        );


//        assert checkBST(root);
        printTree(root);
    }

    public static boolean checkBST(Node root) {
        return false;
    }

    public static void printTree(Node root) {

        /*
              5
             / \
            2   8
           / \   \
          1   3   10

         */

        if (root.left != null) {
            printTree(root.left);
        }

        System.out.print(root.val);
        System.out.print(' ');

        if (root.right != null) {
            printTree(root.right);
        }
    }
}
