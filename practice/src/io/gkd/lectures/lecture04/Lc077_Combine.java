package io.gkd.lectures.lecture04;

import java.util.ArrayList;
import java.util.List;

public class Lc077_Combine {

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        findSubsets(1);
        return ans;
    }

    private void findSubsets(int index) {
        // 剪枝：选的数大于 k 个，或者剩下的全部选了也不够 k 个，就可以直接退出了
        if (subset.size() > k || subset.size() + n - index + 1 < k) return;
        if (index == n + 1) {
            ans.add(new ArrayList<>(subset)); // make a copy
            return;
        }
        findSubsets(index + 1);
        subset.add(index);
        findSubsets(index + 1);
        subset.remove(subset.size() - 1);
    }

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();
    private int n;
    private int k;

}
