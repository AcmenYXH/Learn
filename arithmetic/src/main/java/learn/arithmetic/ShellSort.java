package learn.arithmetic;

/**
 * @Description 希尔排序（Shell Sort）
 * 原理：改进版的插入排序，通过定义不同的增量序列来分组元素，先对各组进行插入排序，随着增量逐渐减小，最后变为1时相当于普通的插入排序，使得整体序列趋于有序。
 * 时间复杂度：希尔排序不保证有固定的性能界限，但它通常在实际应用中表现得优于O(n²)。
 * @Author yangxh8
 * @Date 2024/3/16 17:32
 */
public class ShellSort {
    /**
     * 希尔排序方法
     *
     * @param arr:
     * @return: void
     * @author yangxh8
     * @date 2024/3/16 17:47
     **/
    public static void sort(int[] arr) {
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
