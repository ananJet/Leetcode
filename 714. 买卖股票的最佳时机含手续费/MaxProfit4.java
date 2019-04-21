public class MaxProfit4 {
    public int maxProfit1(int[] prices, int fee) {
        if (prices.length < 2)
            return 0;
        int[] dp = new int[prices.length];
        dp[dp.length - 1] = 0;
        for (int i = dp.length - 2; i >= 0; i--) {
            int max = 0;
            int gap = prices[i] + fee;
            for (int j = i + 1; j < dp.length; j++) {
                if (prices[j] > gap) {
                    if (j < dp.length - 1) {
                        if (prices[j] > prices[j + 1]) {
                            int temp = prices[j] - gap + dp[j + 1];
                            if (temp > max) {
                                max = temp;
                            }
                        }
                    }else {
                        int temp = prices[j] - gap;
                        if (temp > max) {
                            max = temp;
                        }
                    }
                }
            }
            dp[i] = Math.max(max, dp[i + 1]);
        }
        return dp[0];
    }


    public int maxProfit(int[] prices, int fee) {
//        ���������꽻���͵Ķ�̬�滮
        if (prices.length < 2)
            return 0;
//        ������Ϊ���ڣ�������Ϊ0�������룬1����������dp��¼��ˮ
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
//            �ڸõ���������ֵ������ǰһ���������ǰһ�������ڸõ��������߼�ȡ���
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
//            �ڸõ����������ֵ������ǰһ����������ǰһ�������ڸõ��������߼�ȡ���
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }

}
