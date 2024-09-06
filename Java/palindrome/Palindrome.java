class Palindrome{
    // Given an integer x, return true if x is a palindrome, and false otherwise.

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int rev = 0;
        int temp = x;
        while(temp != 0){
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return rev == x;
    }
}