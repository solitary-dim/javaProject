package seventeen.june.thirtieth;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/30
 * Time: 20:20
 */
public final class SelectSort {

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();

        int[] arr = new int[]{2, 6, 7, 1, 3, 4, 9, 5, 8};
        selectSort.showArray(arr);
        selectSort.maxFirst(arr);
        selectSort.showArray(arr);

        arr = new int[]{2, 6, 7, 1, 3, 4, 9, 5, 8};
        selectSort.showArray(arr);
        selectSort.minFirst(arr);
        selectSort.showArray(arr);
    }

    //一、先沉淀最大的值
    private void maxFirst(int[] array) {
        int index;
        for (int i = 1; i < array.length; i++) {
            index = 0;
            for (int j = 1; j <= array.length - i; j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
                /*int temp = array[array.length-i];
                array[array.length-i] = array[index];
                array[index] = temp;*/
                swap(array, array.length - i, index);
            }
        }
    }

    //二、先决出最小值
    private void minFirst(int[] array) {
        int index;
        for (int i = 0; i < array.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (i != index) {
                /*int temp = array[index];
                array[i] = array[index];
                array[index] = temp;*/
                swap(array, index, i);
            }
        }
    }

    private void swap(int[] array, int mix, int i) {
        int temp = array[mix];
        array[mix] = array[i];
        array[i] = temp;
    }

    private void showArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
