class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        ;
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // first add to the maxheap 
        maxHeap.offer(num);

        // now as we added one element in the maxHeap remove the largest element to the minHeap
        minHeap.offer(maxHeap.poll());

        // now we have to balance the two heaps 
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */