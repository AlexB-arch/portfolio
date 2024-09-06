package leetcode;

public class AddTwoNumbers {
    /*
     * You are given two non-empty linked lists representing two non-negative
     * integers. The digits are stored in reverse order, and each of their nodes
     * contains a single digit. Add the two numbers and return the sum as a linked
     * list.
     * 
     * You may assume the two numbers do not contain any leading zero, except the
     * number 0 itself.
     */

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
            }

            if (l2 != null) {
                sum += l2.val;
            }

            sum += carry;

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next; 
            }
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
