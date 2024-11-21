// Add code to sort the array before calling recur() in printCombinations()
// If the current element is equal to previous element we simply skip that element.

import java.util.Arrays;

public class recursion_handling_duplicates {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        printCombinations(arr,r);
    }

    public static void printCombinations(int[] arr, int r){
        int[] tempArray = new int[r];

        Arrays.sort(arr);

        recur(arr,tempArray, r, 0, 0);
    }

    public static void recur(int[] arr, int[] temp, int r, int i, int index){

        if(index == r){
            for (int j = 0; j < r; j++){
                System.out.print(temp[j] + " ");
            }
            System.out.println();
            return;
        }

        if(i >= arr.length) return;

        temp[index] = arr[i];

        recur(arr,temp, r, i+1, index + 1);     // include

        while(i < arr.length-1 && arr[i] == arr[i+1]) i++;  // skip duplicates

        recur(arr,temp, r, i+1, index );       // exclude
    }

}
