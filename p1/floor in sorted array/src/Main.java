// return index of floor

public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 10, 12, 14};
        int x = 6;
        int res = sortedArrayFloor(arr,x);
//        int res = floorSearch(arr,0, arr.length-1, x);
        if(res == -1){

            System.out.println("No valid floor");
        }else{
            System.out.println("The floor index is: " + res);
        }
    }

    private static int sortedArrayFloor(int[] arr, int x) {

        if(x >= arr[arr.length-1]){
            return arr.length-1;
        }
        if(x < arr[0]) return -1;

        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == x){
                return mid;
            }
            if(mid > 0 && arr[mid-1] <= x && arr[mid] > x){
                return mid - 1;
            }else if(arr[mid] > x){
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

//    static int floorSearch(int arr[], int low, int high,
//                           int x)
//    {
//        // If low and high cross each other
//        if (low > high)
//            return -1;
//
//        // If last element is smaller than x
//        if (x >= arr[high])
//            return high;
//
//        // Find the middle point
//        int mid = (low + high) / 2;
//
//        // If middle point is floor.
//        if (arr[mid] == x)
//            return mid;
//
//        // If x lies between mid-1 and mid
//        if (mid > 0 && arr[mid - 1] <= x && x < arr[mid])
//            return mid - 1;
//
//        // If x is smaller than mid, floor
//        // must be in left half.
//        if (x < arr[mid])
//            return floorSearch(arr, low, mid - 1, x);
//
//        // If mid-1 is not floor and x is
//        // greater than arr[mid],
//        return floorSearch(arr, mid + 1, high, x);
//    }
}