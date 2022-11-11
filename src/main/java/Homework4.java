import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Homework4 {

    /**
     * https://leetcode.com/problems/valid-parentheses/
     */
    public boolean isValid(String s) {
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (openingBrackets.indexOf(c) != -1) {
                stack.push(c);
            } else if (stack.isEmpty() || closingBrackets.indexOf(c) != openingBrackets.indexOf(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
     */
    public int maxDepth(String s) {
        int maxDepth = 0;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
                maxDepth = Math.max(depth, maxDepth);
            } else if (s.charAt(i) == ')')
                depth--;
        }
        return maxDepth;
    }

    /**
     * https://leetcode.com/problems/remove-outermost-parentheses/
     */
    public String removeOuterParentheses(String s) {
        final char OPENING = '(';
        final char CLOSING = ')';
        int bracketsCount = 0;
        Queue<StringBuilder> parts = new LinkedList<>();
        StringBuilder part = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == OPENING) {
                part.append(OPENING);
                bracketsCount++;
            } else {
                part.append(CLOSING);
                bracketsCount--;
                if (bracketsCount == 0) {
                    parts.add(part);
                    part = new StringBuilder();
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder resPart : parts) {
            result.append(resPart.toString(), 1, resPart.length() - 1);
        }
        return result.toString();
    }

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = new ListNode(0);
        ListNode prev = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        if (list1 != null) {
            prev.next = list1;
        }
        if (list2 != null) {
            prev.next = list2;
        }
        return result.next;
    }
}
