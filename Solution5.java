class Solution {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        char[] data = s.toCharArray();
        int newLength = data.length;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == ' ') {
                newLength += 2;
            }
        }
        int indexOld = data.length - 1, indexNew = newLength - 1;
        char[] dataNew = new char[newLength];
        for (int i = 0; i < data.length; i++) {
            dataNew[i] = data[i];
        }

        for (; indexOld >= 0 && indexOld != indexNew; indexOld--, indexNew--) {
            if (data[indexOld] == ' ') {
                dataNew[indexNew--] = '0';
                dataNew[indexNew--] = '2';
                dataNew[indexNew] = '%';
            } else {
                dataNew[indexNew] = data[indexOld];
            }
        }

        return String.valueOf(dataNew);

    }
}