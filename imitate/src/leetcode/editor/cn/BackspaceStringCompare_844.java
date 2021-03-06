  //给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
// 
//
// 示例 2： 
//
// 
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
// 
//
// 示例 3： 
//
// 
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 200 
// s 和 t 只含有小写字母以及字符 '#' 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
// Related Topics 栈 双指针 字符串 模拟 👍 415 👎 0

  
  package leetcode.editor.cn;

  import java.util.Stack;

  public class BackspaceStringCompare_844{
      public static void main(String[] args) {
           Solution solution = new BackspaceStringCompare_844().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder builder1 = new StringBuilder();//开始写的方法复杂度高
        StringBuilder builder2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '#'){
                if (builder1.length() != 0){
                    builder1.deleteCharAt(builder1.length() - 1);
                }else continue;
            }else builder1.append(s.charAt(i));
        }
        for (int j = 0; j < t.length(); j++) {
            if (t.charAt(j) == '#') {
                if (builder2.length() != 0){
                    builder2.deleteCharAt(builder2.length() - 1);
                }else continue;
            }else builder2.append(t.charAt(j));
        }
        if (builder1.toString().equals(builder2.toString())){
            return true;
        }else return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }