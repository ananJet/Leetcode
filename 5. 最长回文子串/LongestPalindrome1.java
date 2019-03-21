public class LongestPalindrome1 {

    public int[][] dp;
    public String s;

    public int dg(int left, int right) {
        if (this.dp[left][right] != 0)
            return this.dp[left][right];
        if (left == right)
            this.dp[left][right] = 1;
        else if (left == right - 1) {
            this.dp[left][right] = this.s.charAt(left) == this.s.charAt(right) ? 1 : -1;
        } else if (this.s.charAt(left) == this.s.charAt(right)) {
            this.dp[left][right] = this.dg(left + 1, right - 1);
        }else {
            this.dp[left][right] = -1;
        }
        return this.dp[left][right];
    }

    public String longestPalindrome1(String s) {
        if (s.length() < 2)
            return s;
        this.s = s;
        this.dp = new int[s.length()][s.length()];
        int[] res = new int[3];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (this.dg(i, j) == 1 && j - i + 1 > res[2]) {
                    res[0] = i;
                    res[1] = j;
                    res[2] = j - i + 1;
                }
            }
        }
        return s.substring(res[0], res[1] + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome1().longestPalindrome1("bb"));
    }
}
