package Week_03;

import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2,5,2,1,2};
//        int[] candidates = new int[]{10, 1, 2, 7,1, 6, 5};
        int target = 5;
        Arrays.sort(candidates);//[[1, 2, 5], [2, 6], [1, 1, 6], [1, 7]]
        System.out.println(new CombinationSum2().combinationSum2(candidates, target));
    }
    private HashSet<List<Integer>> listset;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        listset = new HashSet<>();
        List<Integer> combination = new ArrayList<>();
        dfs(combination, candidates, target, 0);
        return new ArrayList<>(listset);
    }

    private void dfs(List<Integer> combination, int[] candidates, int target, int i) {
        if (candidates.length == i) {
            return;
        }
        if (target == 0) {
            listset.add(new ArrayList<>(combination));
            return;
        }
        dfs(combination, candidates, target, i +1);
        if (target - candidates[i] >= 0) {
            combination.add(candidates[i]);
            dfs(combination, candidates, target - candidates[i], i +1);
            combination.remove(combination.size() - 1);
        }
    }
}
