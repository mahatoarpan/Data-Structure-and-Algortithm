package binary_search;

public class FirstAndLastOccurrence {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        res[0] = findFirstIndex(nums, target);
        if (res[0] != -1) {
            res[1] = findLastIndex(nums, target);
        }
        return res;
    }

    private int findFirstIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                res = mid;
                high = mid - 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private int findLastIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                res = mid;
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
