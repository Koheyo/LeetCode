###Tips：
foreach：  
foreach 循环语句的语法格式如下：  
```java
for(类型 变量名:集合) {
    语句块;
}
```
其中，“类型”为集合元素的类型，“变量名”表示集合中的每一个元素，“集合”是被遍历的集合对象或数组。每执行一次循环语句，循环变量就读取集合中的一个元素  
###模拟
```java
public class Solution {

    public int numRookCaptures(char[][] board) {
        // 因为题目已经明确给出 board.length == board[i].length == 8，所以不做输入检查
        // 定义方向数组，可以认为是四个方向向量，在棋盘问题上是常见的做法
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                
                if (board[i][j] == 'R') {
                    int res = 0;
                    for (int[] direction : directions) {
                        if (burnout(board, i, j, direction)) {
                            res++;
                        }
                    }
                    return res;
                }
            }
        }
        // 代码不会走到这里，返回 0 或者抛出异常均可
        return 0;
    }

    /**
     * burnout 横冲直撞的意思（来自欧路词典）
     *
     * @param board     输入棋盘
     * @param x         当前白象位置的横坐标
     * @param y         当前白象位置的纵坐标
     * @param direction 方向向量
     * @return 消灭一个 p，就返回 true
     */
    private boolean burnout(char[][] board, int x, int y, int[] direction) {
        int i = x;
        int j = y;
        while (inArea(i, j)) {
            // 是友军，路被堵死，直接返回
            if (board[i][j] == 'B') {
                break;
            }

            // 是敌军，拿下一血（不知道一血这个词是不是这么用的）
            if (board[i][j] == 'p') {
                return true;
            }

            i += direction[0];
            j += direction[1];
        }
        return false;
    }

    /**
     * @param i 当前位置横坐标
     * @param j 当前位置纵坐标
     * @return 是否在棋盘有效范围内
     */
    private boolean inArea(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        Solution solution = new Solution();
        int res = solution.numRookCaptures(board);
        System.out.println(res);
    }
}
```

###官方
```java
class Solution {
    public int numRookCaptures(char[][] board) {
        int cnt = 0, st = 0, ed = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    st = i;
                    ed = j;
                    break;
                }
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int step = 0;; ++step) {
                int tx = st + step * dx[i];
                int ty = ed + step * dy[i];
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                    break;
                }
                if (board[tx][ty] == 'p') {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}
```