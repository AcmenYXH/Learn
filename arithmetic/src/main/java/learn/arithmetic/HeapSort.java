package learn.arithmetic;

/**
 * @Description 堆排序（Heap Sort）
 * 原理：利用完全二叉树的性质构建最大堆（或最小堆），然后将堆顶元素与末尾元素交换，并调整剩余元素重新形成堆，重复此过程直至排序完成。
 * 时间复杂度：在所有情况下均是O(n log n)。
 * @Author yangxh8
 * @Date 2024/3/16 17:35
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // 交换堆顶元素与末尾元素，并重新调整堆
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    // 调整大顶堆
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // 交换函数
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
