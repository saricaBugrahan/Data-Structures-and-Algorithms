public class Heap<Key extends Comparable<Key>> {
    int size;
    Key[] pq;
    int maxNumber;
    //Creating constructor with one parameter.
    public Heap(int size) {
        this.size = 0;
        maxNumber = size;
        pq = (Key[]) new Comparable[maxNumber + 1];


    }
    //Returns the true if the size of the heap is 0.
        public boolean isEmpty()
    {
        return size == 0;
    }
    //It takes two integer parameters and if pq[i]>pq[j] returns true.
    private boolean bigger(int i, int j) {
        return pq[i].compareTo(pq[j])> 0;
    }
    private void swim(int k) {
        while (k > 1 && bigger(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    //It starts from the top of the heap and goes to the bottom if still satisfies the min heap's rule.
    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && bigger(j, j+1)) j++;
            if (!bigger(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    //In this method we are exchanging the values in the array.
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;

    }
    //In this method we are store our min value and swap them with the highest value.
    //Then sink the highest value in the heap which size is decreased by 1 to the bottom and return the minimum
    public Key delMin() {
        Key min = pq[1];
        exch(1, size--);
        sink(1);
        pq[size+1] = null;
        return min;

    }
    //Increase the size of the heap by 1 and insert the key.
    //Then goes top until it violates the min heap's rule.
    public void insert(Key key) {
        pq[++size] = key;
        swim(size);
    }

}
