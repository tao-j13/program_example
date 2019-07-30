//通过加减实现乘法
//a*b，其中将a转化为二进制，可以a*b相当于b左移相应位数的和。
 public static int mutil(int a,int b) {
        String str = Integer.toBinaryString(a);
        int len = str.length();
        int next = -1;
        int sum = 0;
        while(--len >= 0) { 
            next++;
            if(str.charAt(len) == '1') {
                sum += b<<next;
            }
        }
        return sum;
    }
 

//实现除法
//这里的思想是乘法的逆运算，假设a/b,相当于找出c，b*c < a,b*(c+1) > a,将c表示为二进制，通过位运算进行。
//注意点需要用long类型原因
    1.Math.abs()中，若是-MIN_VALUE,不用long会溢出
    2.在循环中，若被除数为MAX_VALUE,其中的temp会溢出，造成死循环。
    
public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long sum = 0;
        int flag = dividend > 0 ^ divisor >0 ? -1 : 1;
        long dividend1 = Math.abs((long)dividend);
        long divisor1 = Math.abs((long)divisor);
        while(dividend1 >= divisor1) {
            long temp = divisor1,index = 1;
            while(temp << 1 <= dividend1) {
                temp = temp << 1;
                index = index << 1;
            }
            sum += index;
            dividend1 -= temp;
        }
        return  Integer.parseInt(String.valueOf(flag*sum));
    }
