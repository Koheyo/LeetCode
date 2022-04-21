##Tips：
#####Integer.toBinaryString():  
toBinaryString() 方法返回由二进制参数(基数为 2)表示的无符号整数值的字符串表示形式。  
如果字符串超过 3333 位，不能转化为 Integer  
如果字符串超过 6565 位，不能转化为 Long  
如果字符串超过 500000001 位，不能转化为 BigInteger    


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
(python int(a,2)直接能用二进制算别的语言好像不太行...)  
####官方python实现的位运算：  
把 aa 和 bb 转换成整型数字 xx 和 yy，在接下来的过程中，xx 保存结果，yy 保存进位。  
当进位不为 00 时  
计算当前 xx 和 yy 的无进位相加结果：answer = x ^ y  
计算当前 xx 和 yy 的进位：carry = (x & y) << 1  
完成本次循环，更新 x = answer，y = carry  
返回 xx 的二进制形式
```python
class Solution:
    def addBinary(self, a, b) -> str:
        x, y = int(a, 2), int(b, 2)
        while y:
            answer = x ^ y
            carry = (x & y) << 1
            x, y = answer, carry
        return bin(x)[2:]
```

####用栈+布尔位运算
异或（^）运算符也适用于布尔值  
|| 和 && 定义为逻辑运算符，而 | 和 & 定义为位运算符。  
判断语句中为布尔类型，值只有 true 和 false（如果变量值为 0 就是 false，否则为 true）  
 & 和 && 在判断语句中都可以实现“和”这个功能，不过区别在于 & 两边都运算，而 && 先算 && 左侧，若左侧为 false 那么右侧就不运算了。因此从效率上来说，判断语句中推荐使用 &&
```java
    class Solution {
        //因为加法是低位到高位的，可以用栈来存储
        public String addBinary(String a, String b) {
            //特殊情况
            if(a.length() + b.length() == 0)    return "0";

            Stack<Boolean> A = new Stack<>();
            Stack<Boolean> B = new Stack<>();
            // C用来存结果
            Stack<Boolean> C = new Stack<>();

            for(int i = 0; i < a.length(); i++){
                if(a.charAt(i) == '0')  A.push(false);
                else    A.push(true);
            }
            for(int i = 0; i < b.length(); i++){
                if(b.charAt(i) == '0')  B.push(false);
                else    B.push(true);
            }

            //jinwei判断是否需要进位
            Boolean jinwei = false;
            while(!(A.empty() && B.empty())){
                //一直到加完
                //a1 b1表示要相加的位
                Boolean a1 = false;
                Boolean b1 = false;
                if(!A.empty())  a1 = A.pop();
                if(!B.empty())  b1 = B.pop();

                //计算结果、进位
                Boolean res = (a1 ^ b1) ^ jinwei;
                C.push(res);
                jinwei = a1 && b1 || a1 && jinwei || b1 && jinwei;
            }

            //如果最高位还有进位，还要算上
            if(jinwei)  C.push(true);

            //将结果转为字符串
            StringBuilder res = new StringBuilder();
            while(!C.empty()){
                Boolean c = C.pop();
                if(c)   res.append("1");
                else    res.append("0");
            }
            return res.toString();
        }
    }

```
