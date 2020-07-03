class CQueue {

    Stack mStack1;
    Stack mStack2;

    public CQueue() {
        mStack1 = new Stack();
        mStack2 = new Stack();
    }

    public void appendTail(int value) {
        mStack1.push(value);
    }

    public int deleteHead() {
        if (mStack2.isEmpty()) {
            if (mStack1.isEmpty()) {
                return -1;
            } else {
                while (!mStack1.isEmpty()) {
                    mStack2.push(mStack1.pop());
                }
                return (int) mStack2.pop();
            }
        } else {
            return (int) mStack2.pop();
        }

    }
}

/**
 * Your CQueue object will be instantiated and called as such: CQueue obj = new
 * CQueue(); obj.appendTail(value); int param_2 = obj.deleteHead();
 */