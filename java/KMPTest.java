public class KMPTest {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDDE";
        String str2 = "ABCDABD";
        System.out.println(KMP(str1,str2));
    }
    static void getNext(String str,int[] next) { //获取部分匹配信息
        int i=-1,j=0;
        next[0] = -1;
        while(j < str.length()-1) {       //判断长度，需注意
            if(i==-1 || str.charAt(i) == str.charAt(j)) {
                ++i;++j;
                next[j] = i;
            }else i = next[i];        //相当于自身进行KMP匹配
        }
    }
     static int KMP(String str1,String str2) {
        int len = str2.length();
        int[] next = new int[len];
        getNext(str2,next);
        int i=0,j=0;
        while(i < str1.length() && j < str2.length()) {
            if(j == -1 || str1.charAt(i) == str2.charAt(j)) {
                ++i;++j;
            }else j = next[j];
        }
        if(j >=str2.length()) return i-str2.length();
        else return -1;
    }
}
