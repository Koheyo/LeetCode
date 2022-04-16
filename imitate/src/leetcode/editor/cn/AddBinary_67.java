  //给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 👍 797 👎 0

  
  package leetcode.editor.cn;
  public class AddBinary_67{
      public static void main(String[] args) {
           Solution solution = new AddBinary_67().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public String addBinary(String a, String b) {
              int i = a.length() - 1;
              int j = b.length() - 1;
              int carry = 0;//进位标记
//              String result = "";
              StringBuilder result = new StringBuilder();//StringBuffer 类是可变字符串类，创建 StringBuffer 类的对象后可以随意修改字符串的内容
              while (i >= 0 && j >= 0) {
                  if (a.charAt(i) == b.charAt(j) && a.charAt(i) == '0' && carry == 0)//都为0且无进位
                  {
                      //result = "0" + result;
                      result.append('0');
                  }
                  else if (a.charAt(i) == b.charAt(j) && a.charAt(i) == '1' && carry == 0)//都为1无进位
                  {
                      //result = "0" + result;
                      result.append('0');
                      carry = 1;//进位
                  }
                  else if (a.charAt(i) == b.charAt(j) && a.charAt(i) == '0' && carry == 1)
                  {
                      //result = "1" + result;
                      result.append('1');
                      carry = 0;
                  }
                  else if (a.charAt(i) == b.charAt(j) && a.charAt(i) == '1' && carry == 1)
                  {
                      //result = "1" + result;
                      result.append('1');
                  }
                  else if (a.charAt(i) != b.charAt(j) && carry == 0)
                  {
                      //result = "1" + result;
                      result.append('1');
                  }
                  else if (a.charAt(i) != b.charAt(j) && carry == 1)
                  {
                      //result = "0" + result;
                      result.append('0');
                  }
                  i--;
                  j--;
              }
              //a,b不同位时计算剩余位
              while (i >= 0)
              {
                  if (a.charAt(i) == '0' && carry == 0)
                  {
                      //result = "0" + result;
                      result.append('0');
                  }
                  else if (a.charAt(i) == '0' && carry == 1)
                  {
                      //result = "1" + result;
                      result.append('1');
                      carry = 0;
                  }
                  else if (a.charAt(i) == '1' && carry == 0)
                  {
                      //result = "1" + result;
                      result.append('1');
                  }
                  else if (a.charAt(i) == '1' && carry == 1)
                  {
                      //result = "0" + result;
                      result.append('0');
                      carry = 1;
                  }
                  i--;
              }
              while (j >= 0)
              {
                  if (b.charAt(j) == '0' && carry == 0)
                  {
                      //result = "0" + result;
                      result.append('0');
                  }
                  else if(b.charAt(j) == '0' && carry == 1)
                  {
                      //result = "1" + result;
                      result.append('1');
                      carry = 0;
                  }
                  else if (b.charAt(j) == '1' && carry == 0)
                  {
                      //result = "1" + result;
                      result.append('1');
                  }
                  else if (b.charAt(j) == '1' && carry == 1)
                  {
                      //result = "0" + result;
                      result.append('0');
                      carry = 1;
                  }
                  j--;
              }
              if (carry == 1)
              {
                  //result = "1" + result;
                  result.append('1');
              }
              //return result;
              return result.reverse().toString();
          }
      }

//leetcode submit region end(Prohibit modification and deletion)

  }