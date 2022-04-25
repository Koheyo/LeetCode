###优化
(时间11ms->6ms,内存差不多)
一开始没想到用case，以及用break减少判断次数
```java
class Solution {
    public boolean judgeCircle(String moves) {
        int x =0,y = 0;//对四种方向分别计数，左右一样上下一样就会回到原点
        for (int i = 0; i < moves.length(); i++){
            switch (moves.charAt(i)){
                case 'R':{
                    x++;
                    break;
                }
                case 'L':{
                    x--;
                    break;
                }
                case 'U':{
                    y++;
                    break;
                }
                case 'D':{
                    y--;
                    break;
                }
            }
        }
        if (x == 0 && y == 0){
            return true;
        }else return false;
    }
}
```