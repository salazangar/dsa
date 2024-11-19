public class c_two_pointer {

    public static void main(String[] args) {
        int[] arr = {  2, 1, 5, 3, 1, 0, 4 };
        System.out.println(maxWater(arr));
    }

    private static int maxWater(int[] arr) {
        int n =arr.length;
        int left = 1;
        int right = n-2;
        int lmax = arr[0];
        int rmax = arr[n-1];
        int res = 0;

        while(left <= right){

            if(lmax >= rmax){               // move l towards right
                res += Math.max(0, rmax - arr[right]);
                rmax = Math.max(rmax, arr[right]);
                right--;
            }else{
                res += Math.max(0, lmax - arr[left]);
                lmax = Math.max(lmax, arr[left]);
                left++;
            }
        }
        return res;
    }
}
