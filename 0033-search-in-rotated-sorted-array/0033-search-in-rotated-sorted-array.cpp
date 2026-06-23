class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n = nums.size();
        int k = -1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                k = i;
                break;
            }
        }

        int st, en;

        // Array not rotated
        if (k == -1) {
            st = 0;
            en = n - 1;
        }
        // Target in left sorted part
        else if (target >= nums[0]) {
            st = 0;
            en = k;
        }
        // Target in right sorted part
        else {
            st = k + 1;
            en = n - 1;
        }

        // Binary Search
        while (st <= en) {
            int mid = st + (en - st) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                st = mid + 1;
            else
                en = mid - 1;
        }

        return -1;
    }
};