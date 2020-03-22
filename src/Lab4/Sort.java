package Lab4;

public class Sort {
    public static void shellSort(Student[] arr) {
        for (int gap = (arr.length / 2); gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                Student temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap].missedClasses > temp.missedClasses; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void bubbleSort(SinglyLinkedList l) {
        for (int i = l.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (l.get(j).avgRating < l.get(j + 1).avgRating) {
                    Student temp = l.get(j);
                    l.set(j, l.get(j + 1));
                    l.set(j + 1, temp);
                }
            }
        }

        for (int i = l.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (l.get(j).avgRating == l.get(j + 1).avgRating) {
                    if (l.get(j).missedClasses > l.get(j + 1).missedClasses) {
                        Student temp = l.get(j);
                        l.set(j, l.get(j + 1));
                        l.set(j + 1, temp);
                    }
                }
            }
        }
    }

    public static void TopDownMergeSort(Student[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            TopDownMergeSort(arr, l, m);
            TopDownMergeSort(arr, m + 1, r);

            TopDownMerge(arr, l, m, r);
        }
    }

    private static void TopDownMerge(Student[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].missedClasses <= R[j].missedClasses) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
