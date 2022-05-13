
###改进
```java
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[]target=new int[nums.length];
        Arrays.fill(target,-1);//添加-1可判断是否已填充
        for (int i = 0; i <nums.length ; i++) {
            if(target[index[i]]==-1){
                target[index[i]]=nums[i];
            }else {
                //说明原有位置已有元素，那么则类似于插入排序，把元素往后移一位
                for (int j = index.length-1; j >index[i]; j--) {
                     int tmp=target[j];
                     target[j]=target[j-1];
                     target[j-1]=tmp;
                }
                target[index[i]]=nums[i];
            }
        }
        return target;
    }
}
```

###模拟（官方）
add方法有两种，一种是add(Element e)，另一种是add(Index i，Element e)。前者添加元素时，是依次往后添加；后者添加元素时，若索引位置没有值，则直接添加，若索引位置有值，则添加到索引位置，后边的元素依次往后移动。
```java
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            list.add(index[i], nums[i]);
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
```
