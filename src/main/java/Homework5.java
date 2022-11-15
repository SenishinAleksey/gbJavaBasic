import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework5 {
    /**
     * https://leetcode.com/problems/contains-duplicate-ii/
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * https://leetcode.com/problems/roman-to-integer/
     */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = map.get(s.charAt(i));
            int next = 0;
            int nextIndex = i + 1;
            if (nextIndex < s.length()) {
                next = map.get(s.charAt(nextIndex));
            }
            if (current < next) {
                current = -current;
            }
            res += current;
        }
        return res;
    }

    /**
     * https://leetcode.com/problems/intersection-of-two-arrays-ii/
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums1) {
            counts.putIfAbsent(num, 0);
            counts.put(num, counts.get(num) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (counts.containsKey(num) && counts.get(num) > 0) {
                result.add(num);
                counts.put(num, counts.get(num) - 1);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    /**
     * https://leetcode.com/problems/find-duplicate-file-in-system/
     */
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];
            for (int i = 1; i < parts.length; i++) {
                int sepIndex = parts[i].indexOf('(');
                String fileName = parts[i].substring(0, sepIndex);
                String content = parts[i].substring(sepIndex + 1, parts[i].length() - 1);
                List<String> files = map.getOrDefault(content, new ArrayList<>());
                files.add(dir + "/" + fileName);
                map.put(content, files);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (var entry: map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
