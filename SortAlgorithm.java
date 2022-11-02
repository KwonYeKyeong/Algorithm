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

    /*
     * 퀵 정렬(Quick Sort)
     * : 특정 데이터(= pivot)를 기준으로 큰 데이터와 작은 데이터를 서로 교환한 후 배열을 두 집합으로 나누는 방식의 알고리즘
     * -> 평균 시간복잡도 : O(NlogN) / 최악 시간복잡도 : O(N^2)
     */
    public void quick_sort(int[] numbers, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (i <= end && numbers[pivot] >= numbers[i]) {
                i++;
            }
            while (j >= i && numbers[pivot] <= numbers[j]) {
                j--;
            }

            if (i > j) {
                swap(numbers, pivot, j);
            } else {
                swap(numbers, i, j);
            }
        }

        quick_sort(numbers, start, j - 1);
        quick_sort(numbers, j + 1, end);
    }

    private void swap(int[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
