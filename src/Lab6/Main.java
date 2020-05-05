package Lab6;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Lvl 1
//        double[] time = new double[10];
//        int size = 1000000;
//        for (int j = 0; j < 10; j++) {
//            int[] arr = new int[size];
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = (int) (Math.random() * 101);
//            }
//            long start = System.nanoTime();
//            quickSort(arr, 0, arr.length -1);
//            long end = System.nanoTime();
//            time[j] = (double) (end - start) / 1000000000;
//            System.out.println("Time "+size+" elements: " +time[j]+"sec");
//            Thread.sleep((long)(Math.random() * 2000));
//        }
//        double avg = 0;
//        for (var t:time) {
//            avg +=t;
//        }
//        avg /= time.length;
//        System.out.println("Result: "+avg+"sec");

        // Lvl 2
//        double[] time_q = new double[10];
//        double[] time_b = new double[10];
//        int N = 1000000;
//        System.out.println("Array size "+N);
//
//        for (int j = 0; j < 10; j++) {
//            int[] arr = new int[N];
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = (int) (Math.random() * 101);
//            }
//
//            int[] arr2 = new int[N];
//            System.arraycopy(arr,0,arr2,0,N);
//            long start = System.nanoTime();
//            quickSort(arr, 0, arr.length -1);
//            long end = System.nanoTime();
//            time_q[j] = (double) (end - start) / 1000000000;
//            System.out.println(j+1+" iteration");
//            System.out.println("QuickSort " +time_q[j]+"sec");
//            long start2 = System.nanoTime();
//            bubbleSort(arr2);
//            long end2 = System.nanoTime();
//            time_b[j] = (double) (end2 - start2) / 1000000000;
//            System.out.println("BubbleSort " +time_b[j]+"sec");
//            Thread.sleep((long)(Math.random() * 2000));
//        }
//        double avg_q = 0;
//        for (var t:time_q) {
//            avg_q +=t;
//        }
//        avg_q /= time_q.length;
//        System.out.println("Result QuickSort: "+avg_q+"sec");
//        double avg_b = 0;
//        for (var t:time_b) {
//            avg_b +=t;
//        }
//        avg_b /= time_b.length;
//        System.out.println("Result BubbleSort: "+avg_b+"sec");
        double[] time_q = new double[10];
        int N = 10000;
        System.out.println("Array size "+N);
        for (int j = 0; j < 10; j++) {
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = (int ) (Math.random() * 101);
            }
            System.out.println(j+1+" iteration");
            long start = System.nanoTime();
            bubbleSort(arr);
            long end = System.nanoTime();
            time_q[j] = (double) (end - start) / 1000000000;
            System.out.println("BubbleSort " +time_q[j]+"sec");
            Thread.sleep(999);
        }
        double avg_q = 0;
        for (var t:time_q) {
            avg_q +=t;
        }
        avg_q /= time_q.length;
        System.out.println("Result BubbleSort: "+avg_q+"sec");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int start, int end){

        int partition = partition(arr, start, end);

        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];

        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }
}
