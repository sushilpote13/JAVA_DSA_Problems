class Solution {
    public int compress(char[] chars) {
        int st = 0; // write pointer 
        int next = 1; // read pointer
        char s = chars[0];
        int count = 1;
        while (next < chars.length) {
            if (s == chars[next]) {
                count++;
            } else {
                chars[st++] = s;
                if (count > 1) {
                    for (char digit : String.valueOf(count).toCharArray()) {
                        chars[st++] = digit;
                    }
                }
                s = chars[next];
                count = 1;
            }
            next++;
        }
        // Process last group
        chars[st++] = s;

        if (count > 1) {
            for (char digit : String.valueOf(count).toCharArray()) {
                chars[st++] = digit;
            }
        }   
        return st;
    }
}