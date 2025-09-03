package TwoPointers;

public class ValidPalindrome {
    // public boolean isPalindrome(String s) {
    //     s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
    //     return palindromeCheck(s, 0, s.length() - 1);
    // }

    // private boolean palindromeCheck(String s, int left, int right) {
    //     if (left >= right) return true;
    //     if (s.charAt(left) != s.charAt(right)) return false;
    //     return palindromeCheck(s, left + 1, right - 1);
    // }

    // public static void main(String[] args) {
    //     ValidPalindrome sol = new ValidPalindrome();
    //     System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // true
    //     System.out.println(sol.isPalindrome("race a car")); // false
    //     System.out.println(sol.isPalindrome(" ")); // true
    // }


    
    //efficient approach
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start < end){
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}