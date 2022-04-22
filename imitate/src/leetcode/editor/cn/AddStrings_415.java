  //给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
// Related Topics 数学 字符串 模拟 👍 551 👎 0

  
  package leetcode.editor.cn;
  public class AddStrings_415{
      public static void main(String[] args) {
           Solution solution = new AddStrings_415().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        //沿用了与67题二进制加法类似的模拟算法
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 && j >= 0) {
            int sum = carry;
            sum += num1.charAt(i--) - '0';//i先算charAt(i)再算i=i-1
            sum += num2.charAt(j--) - '0';
            carry = sum / 10;
            builder.append(sum % 10);
        }
        // 如果 num1 还没遍历完成，则继续遍历添加 num1 的剩余部分
        while (i >= 0) {
            int sum = carry + num1.charAt(i--) - '0';
            carry = sum / 10;
            builder.append(sum % 10);
        }
        // 如果 num2 还没遍历完成，则继续遍历添加 num2 的剩余部分
        while (j >= 0) {
            int sum = carry + num2.charAt(j--) - '0';
            carry = sum / 10;
            builder.append(sum % 10);
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry != 0) {
            builder.append(carry);
        }
        //反转字符串获得正常结果
        return builder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }