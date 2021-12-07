

class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        //初始状态
        dp[0][0] = true;
        for (int n = 1; n <= pLen; n++) {
            dp[0][n] = false;
            if (p.charAt(n - 1) == '*') {
                dp[0][n] = dp[0][n - 2];
            }
            for (int i = 1; i <= sLen; i++) {
                for (int j = 1; j <= pLen; j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        boolean b = s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.';
                        dp[i][j] = dp[i][j - 2];
                        if (b) {
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="aa";
        String p="a*";
        boolean is;
        is = solution.isMatch(s,p);
        System.out.println("is = " + is);
    }
}