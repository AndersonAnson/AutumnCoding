package dp;

public class MaxProfitV5 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int dayNum = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE, dp_i_2 = 0;
        for (int i = 0; i < dayNum; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_2 - prices[i]);
            dp_i_2 = temp;
        }
        return dp_i_0;
    }

    public int maxProfitV2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int dayNum = prices.length;
        //0��ʾ�������У�1��ʾ���У�2��ʾ����������������
        int[][] dp = new int[dayNum][3];  //�ö�ά�����¼���������������Ž�(��������ֵ)
        dp[0][1] = -prices[0];  //��һ�������У�������Ϊ����������������Ϊ��
        for (int i = 1; i < dayNum; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);  //����ı������п�����ǰһ�챾�����л�ǰһ�������õ�
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);  //����ĳ��п�����ǰһ��ĳ��л�ǰһ��ı�������-����Ĺ�Ʊ�۸�õ�, �����һֻ��Ʊ
            dp[i][2] = dp[i - 1][1] + prices[i];  //��������������ǰһ��ĳ���+����Ĺ�Ʊ�۸�õ�, ���������еĹ�Ʊ
        }
        return Math.max(dp[dayNum - 1][0], dp[dayNum - 1][2]);  //�������һ�첻���й�Ʊ��״̬���˴����Եõ���������ֵ
    }
}
