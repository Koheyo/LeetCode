###方法一（简化）
省略数组变换过程，以计数为目的。统计一下每行被加1的次数，以及每列被加1的次数，看相加之和是否为奇数。
```java
class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] row=new int[n];
        int[] col=new int[m];
        
        for(int i=0;i<indices.length;i++) {
        	row[indices[i][0]]++;
        	col[indices[i][1]]++;
        }
        
        int ans=0;
        for(int i=0;i<n;i++)
        	for(int j=0;j<m;j++) {
        		if((row[i]+col[j])%2>0)
        			ans++;
        	}
        return ans;
    }
}
```
###方法二
看了一个讨论，发现太妙了。有以下几点：

奇 偶的加减可以转变成boolean的true 和 false
行列的加减可以统一用两个数组解决
最后根据公式（规律）来得出奇偶的数量
最后得到的是rr * m + cc * n - rr * cc * 2，原本行列奇数的数量相加为rr * m + cc * n - rr * cc，但是当行列同时为奇数时，重叠部分就成了偶数了。

所以 最后的结果是rr * m + cc * n - rr * cc * 2

从求几何面积考虑就知道了，横向面积 + 纵向面积 - 2横纵重合面积 将单元格设为一个单位，rr表示在多少行上有阴影，cc表示在多少列上有阴影， 阴影面积就为： rr * m + cc * n - rr * cc 但是横纵重合部分是偶数的，所以需要再减去重合部分得到：rr * m + cc * n - 2rr * cc by @1900

```java
class Solution {
    public int oddCells(int n, int m, int[][] indices){
        boolean[] r = new boolean[n];
        boolean[] c = new boolean[m];

        for(int i = 0; i < indices.length; i++){
            r[indices[i][0]] = !r[indices[i][0]];
            c[indices[i][1]] = !c[indices[i][1]];
        }

        int rr = 0, cc = 0;
        for(int i = 0; i < r.length; i++){
            if(r[i]) rr++;
        }

        for(int i = 0; i < c.length; i++){
            if(c[i]) cc++;
        }
        
        return rr * m + cc * n - rr * cc * 2;
    }
}
```

###方法二类似
直接用某一行，某一列的操作的次数的奇偶性来判断。就是先建立两数组来判断某行和某列分别被操作（被加1）了奇数次还是偶数次（奇数次就是1，偶数次0），在分别统计共有多少行（假设是h）和共有多少列（假设是l）操作了奇数次。注意，如果只是相加结果h * m+l * n的话，首先多算了行列交汇处的数字，因为那里的数字每次操作是进行了两次加1，另外在上述相加的式子里面也是重复计算了，所以最后要减去两倍重复计算，也就是减去h*l的两倍。
```java
class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int hang[]=new int[n];
        int lie[]=new int[m];
        for(int i=0;i<indices.length;i++){
            hang[indices[i][0]]++;
            hang[indices[i][0]]%=2;
            lie[indices[i][1]]++;
            lie[indices[i][1]]%=2;
        }
        int h=0;
        int l=0;
        for(int i=0;i<n;i++){
            h+=hang[i];
        }
        for(int i=0;i<m;i++){
            l+=lie[i];
        }
        return h*m+l*n-2*h*l;
    }
}
```