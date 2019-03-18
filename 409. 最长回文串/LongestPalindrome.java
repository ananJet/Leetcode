import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int result = 0;
        char[] cs = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            int temp = hashMap.getOrDefault(cs[i], 0) + 1;
            hashMap.put(cs[i], temp);
        }
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            int temp = entry.getValue();
            if (temp >= 2) {
                if (temp % 2 == 0)
                    result += temp;
                else {
                    result += temp - 1;
                    flag = true;
                }
            }else
                flag = true;
        }
        result += flag ? 1 : 0;
        return result;
    }

    public int longestPalindrome1(String s) {
        int[] flag = new int[128];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            flag[c] = ~flag[c];
            if (flag[c] == 0)
                result += 2;
        }
        return result < s.length() ? ++result : result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome1("ccc"));
    }
}
