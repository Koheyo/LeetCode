###方法一(类似)
遍历的时候更简洁
```java
class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = nums.size(),n = nums[0].size();
        int[][] ans = new int[r][c];
        if(r*c != m*n)
            return nums;
        int m_index = 0,n_index = 0;
        for(int i = 0;i < r;++i){
            for(int j = 0;j < c;++j){
                ans[i][j] = nums[m_index][n_index++];
                if(n_index == n){
                    n_index = 0;m_index++;
                }
            }
        }
        return ans;
    }
};
```

###方法二9(官方) 机器学习卷积神经网络中的flatten操作
把二维数组「排扁」成了一个一维数组  
(i,j)->i*n+j设为x  
->i=x/n  
->j=x%n  
反之亦然
```java
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }
}
```
