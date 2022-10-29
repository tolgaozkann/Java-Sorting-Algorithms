import java.util.ArrayList;

public class MaxHeap <T extends Comparable<T>> {
    /* Static Methods */
    private static int parent(int node) {
        return (node - 1) / 2;
    }

    private static int leftChild(int node) {
        return node * 2 + 1;
    }

    private static int rightChild(int node) {
        return node * 2 + 2;
    }

    /* Private Fields */
    private ArrayList<Integer> heap;

    /* Constructor */
    public MaxHeap() {
        this.heap = new ArrayList<Integer>();
    }

    /* Private Methods */
    private int getParent(int node) {
        return this.heap.get(MaxHeap.parent(node));
    }

    private int getLeftChild(int node) {
        try {
            return this.heap.get(MaxHeap.leftChild(node));
        } catch (Exception e) {
            return (int)Double.NEGATIVE_INFINITY;
        }
    }

    private int getRightChild(int node) {
        try {
            return this.heap.get(MaxHeap.rightChild(node));
        } catch (Exception e) {
            return (int)Double.NEGATIVE_INFINITY;
        }
    }

    private void swap(int node1, int node2) {
        int tmp = this.heap.get(node1);
        this.heap.set(node1, this.heap.get(node2));
        this.heap.set(node2, tmp);
    }

    /* Public Methods */
    public void insert(int value) {
        int node = this.heap.size();
        this.heap.add(value);

        while (this.getParent(node) < value) {
            int parent = MaxHeap.parent(node);
            this.swap(parent, node);
            node = parent;
        }
    }

    public int deleteMax() {
        int out = this.heap.get(0);

        int last = this.heap.remove(this.heap.size() - 1);
        int node = 0;
        this.heap.set(node, last);

        int left = this.getLeftChild(node);
        int right = this.getRightChild(node);

        while (last < left || last < right) {
            int replacer;

            if (last < left && last < right)
                replacer = (left > right)
                    ? MaxHeap.leftChild(node)
                    : MaxHeap.rightChild(node);                
            else if (last < left)
                replacer = MaxHeap.leftChild(node);
            else
                replacer = MaxHeap.rightChild(node);

            this.swap(node, replacer);

            node = replacer;
            left = this.getLeftChild(node);
            right = this.getRightChild(node);
        }

        return out;
    }
    
    /* Utility Methods */
    public void print() {
        int row = 1;
        int count = 0;

        for (int i: this.heap) {
            if (count == row) {
                System.out.println();
                count = 0;
                row++;
            }

            System.out.printf("%d ", i);
            count++;
        }
    }

}
