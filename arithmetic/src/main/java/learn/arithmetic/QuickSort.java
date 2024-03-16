package learn.arithmetic;

/**
 * @Description 快速排序（Quick Sort）
 * 原理：采用分治策略，选择一个“基准”元素，将数组分为两部分，一部分的所有元素都比基准小，另一部分的所有元素都比基准大，然后递归地对这两部分进行快速排序。
 * 时间复杂度：平均情况下为O(n log n)，最坏情况下为O(n²)，但通过合理选择基准可以减少这种可能性。
 * @Author yangxh8
 * @Date 2024/3/16 17:26
 */
public class QuickSort {

    /**
     * 快速排序方法
     *
     * @param array: 数组
     * @param left:
     * @param right:
     * @return: void
     * @author yangxh8
     * @date 2024/3/16 17:27
     **/
    public static void quicksort(int[] array, int left, int right) {
        int i, j, t, temp;
        if (left > right)
            return;
        temp = array[left]; //temp中存的就是基准数
        i = left;
        j = right;
        while (i != j) { //顺序很重要，要先从右边开始找
            while (array[j] >= temp && i < j)
                j--;
            while (array[i] <= temp && i < j)//再找左边的
                i++;
            if (i < j)//交换两个数在数组中的位置
            {
                t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        //最终将基准数归位
        array[left] = array[i];
        array[i] = temp;
        //继续处理左边的，这里是一个递归的过程
        quicksort(array, left, i - 1);
        //继续处理右边的 ，这里是一个递归的过程
        quicksort(array, i + 1, right);
    }
}
