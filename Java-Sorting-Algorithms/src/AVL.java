import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AVL {

    private final int ALLOWED_IMBALANCE = 1;

    public AvlNode<Vulnerability> root; // Tree root

    private class AvlNode<Vulnerability> {
        Vulnerability element; // The data in the node

        AvlNode<Vulnerability> left; // Left child

        AvlNode<Vulnerability> right; // Right child

        int height; // Height

        AvlNode(Vulnerability theElement) {
            this(theElement, null, null);
        }

        AvlNode(Vulnerability theElement, AvlNode<Vulnerability> l, AvlNode<Vulnerability> r) {
            element = theElement;
            left = l;
            right = r;
            height = 0;
        }
    }

    public AVL() // Construct the tree
    {
        root = null;
    }

    /***
     * Return the height of node t, or -1, if
     * null.
     */
    private int height(AvlNode<Vulnerability> t) {
        return t == null ? -1 : t.height;
    }

    /**
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1.
     * Update heights, then return new root.
     */
    private AvlNode<Vulnerability> rotateWithLeftChild(AvlNode<Vulnerability> k2) {
        AvlNode<Vulnerability> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4.
     * Update heights, then return new root.
     */
    private AvlNode<Vulnerability> rotateWithRightChild(AvlNode<Vulnerability> k1) {
        AvlNode<Vulnerability> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private AvlNode<Vulnerability> doubleWithLeftChild(AvlNode<Vulnerability> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<Vulnerability> doubleWithRightChild(AvlNode<Vulnerability> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private AvlNode<Vulnerability> balance(AvlNode<Vulnerability> t) {
        if (t == null)
            return t;

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {

            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else {
            if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
                if (height(t.right.right) >= height(t.right.left)) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /**
     * Internal method to insert into a subtree.
     * 
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    public AvlNode<Vulnerability> insert(Vulnerability x, AvlNode<Vulnerability> t) {
        if (t == null)
            return new AvlNode(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult > 0)
            t.left = insert(x, t.left);
        else if (compareResult < 0)
            t.right = insert(x, t.right);
        else
            ; // Duplicate; do nothing
        return balance(t);
    }

    /**
     * Internal method to remove from a subtree.
     * 
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    public AvlNode<Vulnerability> remove(Vulnerability x, AvlNode<Vulnerability> t) {
        if (t == null)
            return t; // Item not found; do nothing

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return balance(t);
    }

    /*
     * Given a non-empty binary search tree,
     * return the minimum data value found in that
     * tree. Note that the entire tree does not need
     * to be searched.
     */
    private AvlNode<Vulnerability> findMin(AvlNode<Vulnerability> right) {

        AvlNode<Vulnerability> current = right;

        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void avlSort(ArrayList<Vulnerability> list) {
        for (Vulnerability vulnerability : list) {
            this.root = insert(vulnerability, root);
        }

    }


    //prints binary tree
    public void printBinaryTree(AvlNode<Vulnerability> rootNode) {
        Queue<AvlNode<Vulnerability>> rootsQueue = new LinkedList<AvlNode<Vulnerability>>();
        Queue<AvlNode<Vulnerability>> levelQueue = new LinkedList<AvlNode<Vulnerability>>();
        levelQueue.add(rootNode);
        int treeHeight = height(findMin(rootNode));
        int firstNodeGap;
        int internalNodeGap;
        int copyinternalNodeGap;
        while (true) {
            System.out.println("");
            internalNodeGap = (int) (Math.pow(2, treeHeight + 1) - 1);
            copyinternalNodeGap = internalNodeGap;
            firstNodeGap = internalNodeGap / 2;

            boolean levelFirstNode = true;

            while (!levelQueue.isEmpty()) {
                internalNodeGap = copyinternalNodeGap;
                AvlNode<Vulnerability> currNode = levelQueue.poll();
                if (currNode != null) {
                    if (levelFirstNode) {
                        while (firstNodeGap > 0) {
                            System.out.format("%s", "   ");
                            firstNodeGap--;
                        }
                        levelFirstNode = false;
                    } else {
                        while (internalNodeGap > 0) {
                            internalNodeGap--;
                            System.out.format("%s", "   ");
                        }
                    }
                    System.out.format("%3f", currNode.element.getBaseScore());
                    rootsQueue.add(currNode);
                }
            }

            --treeHeight;

            while (!rootsQueue.isEmpty()) {
                AvlNode<Vulnerability> currNode = rootsQueue.poll();
                if (currNode != null) {
                    levelQueue.add(currNode.left);
                    levelQueue.add(currNode.right);
                }
            }

            if (levelQueue.isEmpty())
                break;
        }
    }
}
