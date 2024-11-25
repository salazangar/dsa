public class Main {
    public static void main(String[] args)
    {
        String s = "Hello World";
        System.out.println(individualReverse(s));
    }

    public static String individualReverse(String s){
        StringBuilder sb = new StringBuilder();
        StringBuilder rev = new StringBuilder();

        for (String word : s.split(" ")){
            sb.append(reverse(word));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String reverse(String s){
        byte[] arr = s.getBytes();

        byte[] res = new byte[arr.length];

        for (int i = 0; i < arr.length; i++)
            res[i] = arr[arr.length - i - 1];

        return new String(res);
    }
}