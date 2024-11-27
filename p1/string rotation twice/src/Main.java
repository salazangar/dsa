// Check if a string can be obtained by rotating another string 2 places

// Given two strings, str1 and str2, the task is to determine if str2 can be obtained by rotating str1 exactly 2 places
// in either a clockwise or anticlockwise direction.


public class Main {
    public static void main(String[] args) {
        String s1 = "amazon";
        String s2 = "onamaz";
        System.out.println(ifRotationNaive(s1,s2));
        System.out.println(ifRotationModulo(s1,s2));
    }

    public static boolean ifRotationNaive(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 != n2) return false;
        if(n1 <= 2 || n2 <= 2 ) return s1.equals(s2);

        String clock = "";
        String anti = "";

        anti = s1.substring(n1-2) + s1.substring(0, n1-2);
        clock = s1.substring(2) + s1.substring(0, 2);

        return s2.equals(anti) || s2.equals(clock);
    }

    public static boolean ifRotationModulo(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 != n2) return false;
        if(n1 <= 2 || n2 <= 2 ) return s1.equals(s2);

        boolean anti = true;
        boolean clock = true;

        // clockwise rotation of s1
        for (int i = 0; i < n1; i++) {
            if(s1.charAt((i+2)%n1) == s2.charAt(i)){
                clock = false;
                break;
            }
        }

        // anticlockwise rotation of s1
        for (int i = 0; i < n1; i++) {
            if(s1.charAt(i) == s2.charAt((i+2)%n1)){
                clock = false;
                break;
            }
        }

        return anti || clock;

    }

}