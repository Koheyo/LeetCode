##Tips：
#####Integer.toBinaryString():  
toBinaryString() 方法返回由二进制参数(基数为 2)表示的无符号整数值的字符串表示形式。  
如果字符串超过 3333 位，不能转化为 Integer  
如果字符串超过 6565 位，不能转化为 Long  
如果字符串超过 500000001500000001 位，不能转化为 BigInteger    


#####StringBuilder：  
(提升了执行时间)  
StringBuffer对象则代表一个字符序列可变的字符串，当一个StringBuffer被创建以后，通过StringBuffer提供的append()、insert()、reverse()、setCharAt()、setLength()等方法可以改变这个字符串对象的字符序列。一旦通过StringBuffer生成了最终想要的字符串，就可以调用它的toString()方法将其转换为一个String对象。


##其他方法
####一、模拟(类似)
(提升了内存消耗)  
其实字符的相加相减是ASCII的相加相减,'0'的ascii的值为48， -'0'是在计算ASCII值  
同样的道理int转换成字符char是利用相反的方向 为+'0'
```java
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 && j >= 0) {
            int sum = carry;
            sum += a.charAt(i--) - '0';//i先算charAt(i)再算i=i-1
            sum += b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        while (i >= 0) {
            int sum = carry + a.charAt(i--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        while (j >= 0) {
            int sum = carry + b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry == 1) {
            builder.append(carry);
        }
        //反转字符串获得正常结果
        return builder.reverse().toString();
    }
}
```
###二、位运算
待研究......