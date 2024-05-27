package learn.arithmetic;

/**
 * @Description 选择排序（Selection Sort）
 * 原理：每一趟从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
 * 时间复杂度：无论最好、最坏还是平均情况，都是O(n²)。
 * @Author yangxh8
 * @Date 2024/3/16 17:34
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0, len = arr.length; i < len; i++) {
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }
}
