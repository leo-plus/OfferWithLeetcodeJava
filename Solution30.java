class MinStack {

    Stack<Integer> normal;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        normal = new Stack();
        min = new Stack();
    }

    public void push(int x) {
        normal.push(x);
        if (min.isEmpty()) {
            min.push(x);
            return;
        }

        Integer i = min.peek();
        if (i > x) {
            min.push(x);
        } else {
            min.push(i);
        }
    }

    public void pop() {
        normal.pop();
        min.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.min();
 */