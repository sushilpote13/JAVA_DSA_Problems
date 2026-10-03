class Solution {
    public String reverseVowels(String s) {

        HashSet<Character> vowels = new HashSet<>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] arr = s.toCharArray();

        int st = 0;
        int en = arr.length - 1;

        while (st < en) {

            if (vowels.contains(arr[st]) && vowels.contains(arr[en])) {

                char temp = arr[st];
                arr[st] = arr[en];
                arr[en] = temp;

                st++;
                en--;

            } else if (!vowels.contains(arr[st])) {
                st++;

            } else if (!vowels.contains(arr[en])) {
                en--;
            }
        }

        return new String(arr);
    }
}