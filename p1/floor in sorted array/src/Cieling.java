// find index of cieling of an element in an sorted array

public class Cieling {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 10, 12, 14};
        int x = 12;
        int res = sortedArrayCeiling(arr,x);
//        int res = floorSearch(arr,0, arr.length-1, x);
        if(res == -1){

            System.out.println("No valid ceiling");
        }else{
            System.out.println("The ceiling index is: " + res);
        }
    }

    private static int sortedArrayCeiling(int[] arr, int x) {

        if(x > arr[arr.length-1]){
            return -1;
        }
        if(x < arr[0]) return 0;

        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == x){
                return mid;
            }
            if(mid > 0 && arr[mid+1] > x && arr[mid] < x){
                return mid+1;
            }else if(arr[mid] > x){
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}
