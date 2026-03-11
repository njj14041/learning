import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {


    public List<List<String>> f(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.get(s);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }




    // groupAnagrams
    public static void main(String[] args) {
        ListNode h = new Solution().removeNthFromEnd(node1, 2);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
//        System.out.println(h);
    }

}

