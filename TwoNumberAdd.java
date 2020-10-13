import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * 
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 */
class TwoNumberAdd {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 5, 13, 11, 15 };
        int target = 10;
        int[] result = twoSum1(arr, target);
        System.out.println("结果是: " + Arrays.toString(result));
    }

    /**
     * 暴力破解法 说明:遍历数组,拿第一个index上的数字和剩下的分别相加,直到之和等于target为止 拿第二个index上.......
     * 时间复杂度:O(N2) 空间复杂度：O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[0];
    }

    /**
     * 哈希表......; 复杂度分析 时间复杂度:O(N) 空间复杂度：O(N)
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[] { hashtable.get(target - nums[i]), i };
            }
            hashtable.put(nums[i], i);
        }

        return new int[0];
    }
}