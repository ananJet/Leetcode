public class NumDecodings {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0')
            return 0;
        dp[0] = 1;
        if (s.length() == 1)
            return dp[0];
        if (s.charAt(1) == '0') {
            if (s.charAt(0) == '1' || s.charAt(0) == '2')
                dp[1] = 1;
            else
                return 0;
        }else {
            if (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) <= '6'))
                dp[1] = 2;
            else
                dp[1] = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
                    dp[i] = dp[i - 2];
                else
                    return 0;
            }else {
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))
                    dp[i] = dp[i - 1] + dp[i - 2];
                else
                    dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("17"));
    }
}
