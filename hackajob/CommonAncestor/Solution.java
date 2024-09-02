package hackajob.CommonAncestor;

public class Solution {

    private static int findLCA(int n1, int n2) {
        // Loop until both nodes coverage to the same ancestor
        while (n1 != n2) {
            if (n1 > n2)
                n1 /= 2; // Move n1 up to its parent
            else
                n2 /= 2; // Move n2 up to its parent
        }

        return n1;
    }

    public static void main(String[] args) {
        int n1 = 15;
        int n2 = 11;

        int lca = findLCA(n1, n2);

        System.out.println("The Lowest Common Ancestor of nodes " + n1 + " and " + n2 + " is: " + lca);
    }
}
