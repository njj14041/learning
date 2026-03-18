import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {



    //findDuplicateSubtrees
    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, null);
        List<List<Integer>> lists = new Solution().pathSum(treeNode1, 1);
        lists.forEach(System.out::println);
    }

}

