###Tips
Integer.parseInt（）和Integer.valueOf（）区别：  
Integer.parseInt（），返回一个原子类型int。  
Integer.valueOf（），返回的是封装的Integer对象。

###数组模拟栈(官方)：
for(String a:b)  
a是String类型，有的人可能把b也当做是String类型，实际上是String[]，也就是字符串数组。  
a是根据字符串数组b来进行for循环，输出b字符串数组中的每一个字符串。
```java
class Solution {
    public int calPoints(String[] ops) {
        int ret = 0;
        List<Integer> points = new ArrayList<Integer>();
        for (String op : ops) {
            int n = points.size();
            switch (op.charAt(0)) {
                case '+':
                    ret += points.get(n - 1) + points.get(n - 2);
                    points.add(points.get(n - 1) + points.get(n - 2));
                    break;
                case 'D':
                    ret += 2 * points.get(n - 1);
                    points.add(2 * points.get(n - 1));
                    break;
                case 'C':
                    ret -= points.get(n - 1);
                    points.remove(n - 1);
                    break;
                default:
                    ret += Integer.parseInt(op);
                    points.add(Integer.parseInt(op));
                    break;
            }
        }
        return ret;
    }
}
```