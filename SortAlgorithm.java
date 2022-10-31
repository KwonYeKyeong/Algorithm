public class SortAlgorithm {
    /*
     * 선택 정렬(Selection sort)
     * : 데이터 배열에서 가장 작은 데이터를 선택하여 앞으로 보내는 정렬(오름차순 기준)
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

    private void swap(int[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
