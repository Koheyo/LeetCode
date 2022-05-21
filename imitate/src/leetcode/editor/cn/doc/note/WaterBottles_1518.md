###模拟（不同算法）
首先我们一定可以喝到 b 瓶酒，剩下 b 个空瓶。接下来我们可以拿瓶子换酒，每次拿出 e 个瓶子换一瓶酒，然后再喝完这瓶酒，得到一个空瓶。以此类推，我们可以统计得到答案。
```java
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int bottle = numBottles, ans = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            ++ans;
            ++bottle;
        }
        return ans;
    }
}
```
###数学
```java
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int bottle = numBottles, ans = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            ++ans;
            ++bottle;
        }
        return ans;
    }
}
```
每e个酒瓶可以换1个酒瓶；那其实相当于每减少e-1瓶酒，就可以换喝一瓶酒。 那一共能换多少呢是不是就是 n/(e-1) 瓶？
但这有个前提，就是最后至少得有e瓶酒才可以兑换，所以如果最后只剩e-1瓶酒的时候我们就不能换了。
在小学奥数题里我们可以通过借酒瓶解决这个问题。

为了处理这个问题，我们应该 用 (n-1)/(e-1) 这样最后只剩 e-1 瓶酒的时候，就不足以被 e-1 整除而多兑换一次了。
```java
int numWaterBottles(int n, int e) {
    return n + (n - 1) / (e - 1);
}；
```

![](https://raw.githubusercontent.com/Koheyo/PicgoImg/main/img/1639706497-scbChw-DrinkProblem.png)  
由于换酒过程本质是：我们只在乎喝到 [酒水]

1 瓶酒 等价于 空瓶加酒水

换酒的过程需要我们必须用瓶子装酒水，而我们不能借酒瓶，3 空瓶换 1 瓶酒，本质是总保留 1 个空瓶用于装酒

2 空瓶 等价于 1 酒水

所以我们开始的 9 瓶酒 就是有 9 个空瓶，手里要保留 1 个空瓶装酒，所以用于交换的只有 8 个空瓶。而 2 个空瓶等价于 1 酒水，所以我们能换到 8/2 = 4 瓶酒水。答案就是 9+4 = 13。
