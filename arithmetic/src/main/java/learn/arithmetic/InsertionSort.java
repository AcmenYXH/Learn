package learn.arithmetic;

/**
 * @Description 插入排序（Insertion Sort）
 * 原理：将每个元素按照其正确位置插入到已经排序好的子序列中，对于未排序数据，在已排序序列中从后向前扫描找到合适的位置并插入。
 * 时间复杂度：最好情况下为O(n)，当数组近乎有序时效率最高；最坏和平均情况下为O(n²)。
 * @Author yangxh8
 * @Date 2024/3/16 17:30
 */
public class InsertionSort {

    /**
     * 插入排序方法
     *
     * @param arry:
     * @return: void
     * @author yangxh8
     * @date 2024/3/16 17:31
     **/
    public static void sort(int[] arry) {
        for (int i = 1; i < arry.length; i++) {
            //插入的数
            int insertVal = arry[i];
            //被插入的位置(准备和前一个数比较)
            int index = i - 1;
            //如果插入的数比被插入的数小
            while (index >= 0 && insertVal < arry[index]) {
                //将把 arry[index] 向后移动
                arry[index + 1] = arry[index];
                //让 index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            arry[index + 1] = insertVal;
        }
    }
}
