// basic recursion (EXCLUDE AND INCLUDE)
// does not remove duplicates

// T = O[2^n]
// S = O[r]

public class recursion {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        printCombinations(arr,r);
    }

    public static void printCombinations(int[] arr, int r){
        int[] tempArray = new int[r];

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

        recur(arr,temp, r, i+1, index );       // exclude
    }
}
