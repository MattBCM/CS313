/*
INSERTION SORT PROGRAM

DESC: we check array where i = 1, then j = i. check first if arr[j] < arr[j-1]. It will keep going till its false.

 */

public class insetionSort {
    public insetionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            //initialize j to equal to i to have the same space
            int j = i;
            //checks if j is greater than 0 and if array at space j is less than the space behind it
            while(j > 0 && arr[j] < arr[j-1]){
                //its true, so we switch the values around using a temporary int holder.
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                //we move back by one space to keep checking if arr[j] is smaller than the rest of the array.
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] p = {3, 5, 6, 2, 8, 3};
        printArr(p);
        insetionSort newSort = new insetionSort(p);
        printArr(p);

    }
    public static void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i + ", ");
        }
    }
}
