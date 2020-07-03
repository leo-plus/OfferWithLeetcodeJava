class Solution {
    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }

        int left = 0;
        int right = numbers.length - 1;
        int mid = left;
        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                return numbers[right];
            }

            mid = (right + left) / 2;

            if (numbers[left] == numbers[right] && numbers[mid] == numbers[left]) {
                return findMin(numbers, left, right);
            }

            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }

        }

        return numbers[mid];
    }

    private int findMin(int[] numbers, int left, int right) {
        int result = numbers[left];
        for (int i = left; i <= right; i++) {
            result = Math.min(result, numbers[i]);
        }

        return result;
    }
}