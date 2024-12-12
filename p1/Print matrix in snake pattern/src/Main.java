// Given an n x n matrix. In the given matrix,
// you have to print the elements of the matrix in the snake pattern.
//  -> -> ->
//         |
//         V
//  <- <- <-
//  |
//  V
//  -> -> ->


public class Main {
    public static void main(String[] args) {
        int[][] arr = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        printSnake(arr);
    }

    public static void printSnake(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {

            // even row .: left to right
            if(i % 2 ==0){
                for (int j = 0; j < m; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }else{
                for (int j = m-1; j >= 0 ; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }
}