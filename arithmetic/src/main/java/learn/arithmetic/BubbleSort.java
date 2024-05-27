package learn.arithmetic;

/**
 * @Description 冒泡排序（Bubble Sort）
 * 原理：通过重复遍历待排序序列，比较每对相邻元素并交换顺序（如果必要），直到整个序列按升序或降序排列。
 * 时间复杂度：最好情况下为O(n)，最坏情况下和平均情况下为O(n²)。
 * @Author yangxh8
 * @Date 2024/3/16 17:23
 */
public class BubbleSort {

    /**
     * 冒泡排序方法
     *
     * @param array: 排序数组
     * @return: void
     * @author yangxh8
     * @date 2024/3/16 17:24
     **/
    public static int sort(int[] array) {
        int i, j,count=0;
        int n = array.length;
        for (i = 0; i < n; i++) {
            //表示 n 次排序过程。
            for (j = 1; j < n - i; j++) {
                if (array[j - 1] > array[j]) {
                    count++;
                    //前面的数字大于后面的数字就交换
                    //交换 array[j-1]和 array[j]
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return count;
    }
}
