  //给定一个 n x n 的二进制矩阵 image ，先 水平 翻转图像，然后 反转 图像并返回 结果 。 
//
// 水平翻转图片就是将图片的每一行都进行翻转，即逆序。 
//
// 
// 例如，水平翻转 [1,1,0] 的结果是 [0,1,1]。 
// 
//
// 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。 
//
// 
// 例如，反转 [0,1,1] 的结果是 [1,0,0]。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：image = [[1,1,0],[1,0,1],[0,0,0]]
//输出：[[1,0,0],[0,1,0],[1,1,1]]
//解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// 
//
// 
//
// 提示： 
//
// 
//
// 
// n == image.length 
// n == image[i].length 
// 1 <= n <= 20 
// images[i][j] == 0 或 1. 
// 
// Related Topics 数组 双指针 矩阵 模拟 👍 274 👎 0

  
  package leetcode.editor.cn;
  public class FlippingAnImage_832{
      public static void main(String[] args) {
           Solution solution = new FlippingAnImage_832().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n/2; j++){
                if (image[i][j] == image[i][n-1-j]){//两端相同取反；不同不变
                    image[i][j] ^= 1;
                    image[i][n-1-j] ^= 1;
                }
            }
            if (n%2 == 1){//奇数个时，考虑中间数
                image[i][n/2] ^= 1;
            }
        }
        return image;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }