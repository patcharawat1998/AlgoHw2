
public class RadixSort {
    // Get maximum value from array.
    public int getMax(PrepareToSort arr[], int n)
    {
        int max = arr[0].rule3;
        for (int i = 1; i < n; i++){
            if (arr[i].rule3 > max)
                max = arr[i].rule3;
        }

        return max;
    }

    // Count sort of arr[].
    public void countSort(PrepareToSort arr[], int n, int exp)
    {
        // Count[i] array will be counting the number of array values having that 'i' digit at their (exp)th place.
        int output[] = new int[n];
        int count[] = new int[10];
        count[0] = 0;

        // Count the number of times each digit occurred at (exp)th place in every input.
        for (int i = 0; i < n; i++)
            count[(arr[i].rule3 / exp) % 10]++;

        // Calculating their cumulative count.
        for (int i = 1; i < 10; i++)
            count[i] += count[i-1];

        // Inserting values according to the digit '(arr[i] / exp) % 10' fetched into count[(arr[i] / exp) % 10].
        for (int i = n - 1; i >= 0; i--)
        {
            output[count[(arr[i].rule3 / exp) % 10] - 1] = arr[i].rule3;
            count[(arr[i].rule3 / exp) % 10]--;
        }

        // Assigning the result to the arr pointer of main().
        for (int i = 0; i < n; i++)
            arr[i].rule3 = output[i];
    }

    // Sort arr[] of size n using Radix Sort.
    public void radixsort(PrepareToSort arr[], int n)
    {
        int exp, m;
        m = getMax(arr, n);

        // Calling countSort() for digit at (exp)th place in every input.
        for (exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }


}
