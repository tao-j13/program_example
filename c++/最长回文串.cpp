class Solution {
public:
    string longestPalindrome(string s) {
        vector<vector<bool>>dp(s.size(),vector<bool>(s.size()));
        int max_ =0;
        int l=0,r=0;
        for(int i = 0;i<s.size();++i)
        {
           for(int j =i;j>=0;j--)
           {
               dp[j][i] = (s[i] == s[j]) && (i-j<=1 || dp[j+1][i-1]);
               if(dp[j][i])
               {
                   if(i-j+1 > max_)
                   {
                       l = j;
                       r = i;
                       max_ = i-j+1;
                   }
               }  
           }
           
        }
         return s.substr(l,max_);
    }
};
