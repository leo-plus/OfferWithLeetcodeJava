class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null && popped == null) {
            return true;
        }

        if (pushed == null || popped == null) {
            return true;
        }

        if (pushed.length != popped.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex < popped.length) {
            if (stack.isEmpty() || stack.peek() != popped[popIndex]) {
                if (pushIndex < pushed.length) {
                    stack.push(pushed[pushIndex++]);
                } else {
                    return false;
                }

            } else {
                stack.pop();
                popIndex++;
            }
        }

        return true;

    }
}