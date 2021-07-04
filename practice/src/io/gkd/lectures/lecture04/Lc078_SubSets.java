package io.gkd.lectures.lecture04;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * 78. https://leetcode-cn.com/problems/subsets/submissions/
 */
public class Lc078_SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(nums, 0);
        return ans;
    }

    // 递归去枚举 nums[0], nums[1], nums[2], ..., nums[n-1] 这 n 个数选或者不选
    private void findSubsets(int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(subset)); // make a copy
            return;
        }
        // 不选 index 位置的数
        findSubsets(nums, index + 1);
        subset.add(nums[index]);
        // 选 index 位置的数
        findSubsets(nums, index + 1);
        // 恢复现场，防止一次递归结束，subset 被上一次递归污染
        subset.remove(subset.size() - 1);
    }

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();

}
