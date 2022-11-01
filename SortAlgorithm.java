public class SortAlgorithm {
    /*
     * 선택 정렬(Selection sort)
     * : 데이터 배열에서 가장 작은 데이터를 선택하여 앞으로 보내는 정렬(오름차순 기준)
     * -> 시간복잡도 : O(N^2)
     */
    public int[] selection_sort(int[] numbers) {
        int[] sortedNumbers = numbers.clone();
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            int min = sortedNumbers[i];
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (sortedNumbers[j] < min) {
                    min = sortedNumbers[j];
                    minIdx = j;
                }
            }
            swap(sortedNumbers, i, minIdx);
        }

        return sortedNumbers;
    }

    /*
     * 삽입 정렬(Insertion sort)
     * : 필요할 때만 각 데이터를 적절한 위치에 삽입하는 정렬
     * -> 시간복잡도 : O(N^2)
     */
    public int[] insertion_sort(int[] numbers) {
        int[] sortedNumbers = numbers.clone();
        int n = numbers.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sortedNumbers[j] > sortedNumbers[i]) {
                    swap(sortedNumbers, j, i);
                }
            }
        }

        return sortedNumbers;
    }

    /*
     * 버블 정렬(Bubble sort)
     * : 옆에 있는 데이터와 비교하여 더 작은 값을 앞으로 보내는 정렬(오름차순 기준)
     * -> 시간복잡도 : O(N^2)
     */
    public int[] bubble_sort(int[] numbers) {
        int[] sortedNumbers = numbers.clone();
        int n = numbers.length;

        for (int i = n; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (sortedNumbers[j - 1] > sortedNumbers[j]) {
                    swap(sortedNumbers, j - 1, j);
                }
            }
        }

        return sortedNumbers;
    }

    private void swap(int[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
