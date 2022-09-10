package com;
class Solution{
        public static boolean isMatch(String s, String p) {

                int n = s.length();
                int m = p.length();


                boolean dp[][] = new boolean[n+1][m+1];

                dp[0][0] = true;


                for(int i =1;i<=n;i++){
                        dp[i][0] = false;
                }

                for(int i = 1;i<=m;i++){
                        dp[0][i] = matchStar(p,i);
                }
                for(int i =1;i<=n;i++){
                        for(int j =1;j<=m;j++){
                                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                                        dp[i][j] = dp[i-1][j-1];
                                else if(p.charAt(j-1) == '*')
                                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                                else
                                        dp[i][j] = false;

                        }
                }
                return dp[n][m];
        }



        public static boolean matchStar(String p,int i){
                for(int k =1;k<=i;k++){
                        if(p.charAt(k-1) != '*')
                                return false;
                }
                return true;
        }
//public static boolean isMatch(String s, String p) {
//
//        return batch(s,p,s.length()-1,p.length()-1);
//
//        }
//
//
//
//public static boolean batch(String s , String p , int i ,int j){
//
//        if(i < 0 && j < 0)
//        return true;
//
//        if(j < 0 && i >= 0)
//        return false;
//
//
//        if(i < 0 && j >= 0){
//        boolean val = matchStar(p,j);
//        System.out.println(val +" "+j);
//        return val;
//        }
//
//        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
//        return batch(s,p,i-1,j-1);
//
//        else if(s.charAt(j) == '*'){
//        boolean bol =  (batch(s,p,i,j-1) ||  batch(s,p,i-1,j));
//        return bol;
//        }
//        else
//        return false;
//
//        }

//
//public static boolean matchStar(String p,int j){
//
//
//        for(int k = 0 ;k <= j;k++){
//        if(p.charAt(k) != '*')
//        return false;
//        }
//        return true;
//        }

        public static void main(String[] args) {
               String s = "aa";
               String s1 = "*";
               System.out.println("match is : " + isMatch(s,s1));
        }

        }