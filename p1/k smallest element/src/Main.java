import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)
    {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 4;
        int res = kSmallestElement(arr, k);
        System.out.println(res);
    }

    public static int kSmallestElement(int[] arr, int k){
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);

        for(int i : arr) {
            q.add(i);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();

    }
}