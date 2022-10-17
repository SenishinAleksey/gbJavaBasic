public class Homework1 {
    /**
     * https://leetcode.com/problems/remove-element/
     */
    public int removeElement(int[] nums, int val) {
        int copyInd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[copyInd] = nums[i];
                copyInd++;
            }
        }
        return copyInd;
    }

    /**
     * https://leetcode.com/problems/merge-sorted-array/
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }
        while (n >= 0) {
            nums1[i] = nums2[n];
            i--;
            n--;
        }
    }

    /**
     * https://leetcode.com/problems/reverse-words-in-a-string/
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int endWord = s.length() - 1;
        while (endWord >= 0) {
            if (s.charAt(endWord) == ' ') {
                endWord--;
                continue;
            }
            int startWord = endWord - 1;
            while (startWord >= 0 && s.charAt(startWord) != ' ') {
                startWord--;
            }
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(s, startWord + 1, endWord + 1);
            endWord = startWord - 1;
        }
        return sb.toString();
    }

    /**
     * https://leetcode.com/problems/valid-palindrome/
     */
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String res = sb.toString();
        String resReverse = sb.reverse().toString();
        return res.equals(resReverse);
    }

    public boolean isPalindrome2(String s) {
        int leftPos = 0;
        int rightPos = s.length() - 1;
        while (rightPos > leftPos) {
            char leftChar = s.charAt(leftPos);
            if (!Character.isLetterOrDigit(leftChar)) {
                leftPos++;
                continue;
            }
            char rightChar = s.charAt(rightPos);
            if (!Character.isLetterOrDigit(rightChar)) {
                rightPos--;
                continue;
            }
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            leftPos++;
            rightPos--;
        }
        return true;
    }
}
