class MedianFinder {
    Queue<Integer> mMin, mMax;

    public MedianFinder() {
        mMin = new PriorityQueue<>();
        mMax = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (mMin.size() != mMax.size()) {
            mMin.add(num);
            mMax.add(mMin.poll());
        } else {
            mMax.add(num);
            mMin.add(mMax.poll());
        }
    }

    public double findMedian() {
        if (mMin.size() == mMax.size()) {
            return (mMin.peek() + mMax.peek()) / 2.0;
        } else {
            return mMin.peek();
        }
    }
}