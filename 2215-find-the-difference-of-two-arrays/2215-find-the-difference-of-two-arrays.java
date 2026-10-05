class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        HashSet<Integer> hashset1 = new HashSet<>();
        HashSet<Integer> hashset2 = new HashSet<>();

        // Store nums1 and nums2 in sets
        for (int num : nums1) {
            hashset1.add(num);
        }

        for (int num : nums2) {
            hashset2.add(num);
        }

        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Elements present in nums1 but not nums2
        for (int num : hashset1) {
            if (!hashset2.contains(num)) {
                list1.add(num);
            }
        }

        // Elements present in nums2 but not nums1
        for (int num : hashset2) {
            if (!hashset1.contains(num)) {
                list2.add(num);
            }
        }

        answer.add(list1);
        answer.add(list2);

        return answer;
    }
}