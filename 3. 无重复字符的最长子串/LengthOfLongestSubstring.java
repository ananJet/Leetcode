import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int temp_result = 0;
        char[] cs = s.toCharArray();
        if (cs.length == 0)
            return 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int n = cs.length - 1;
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(cs[i])) {
                i = hashMap.get(cs[i]) + 1;
                hashMap.clear();
                hashMap.put(cs[i], i);
                temp_result = 1;
            }else {
                hashMap.put(cs[i], i);
                temp_result++;
                if (result < temp_result)
                    result = temp_result;
            }
        }
        if (!hashMap.containsKey(cs[cs.length - 1])) {
            temp_result++;
            if (result < temp_result)
                result = temp_result;
        }
        return result;
    }

    public int lengthOfLongestSubstring1(String s) {
        int[] index = new int[128];
        int result = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            left = Math.max(left, index[cur]);
            result = Math.max(result, right - left + 1);
            index[cur] = right + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring1("abba"));
    }
}
