class Solution {
    public static boolean checkPalindrome(String s) {
        int st = 0;
        int en = s.length() - 1;
        while (st <= en) {
            if (s.charAt(st) != s.charAt(en)) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    }

    public static void recursive(List<List<String>> result, List<String> current, String s, int start) {
        // base condition 
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (checkPalindrome(substring)) {
                current.add(substring);
                // recursion code 
                recursive(result, current, s, i + 1);
                // backtaring
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        recursive(result, current, s, 0);
        return result;
    }
}