//package test.tencent;
//
//import java.util.Scanner;
//
//class ListNode {
//    public ListNode next;
//    public int val;
//
//    public ListNode(int x) {
//        val = x;
//    }
//}
//
//public class Linkedlist {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        ListNode dummy1 = new ListNode(-1);
//        ListNode head = dummy1;
//        for (int i = 0; i < n; i++) {
//            ListNode node = new ListNode(sc.nextInt());
//            head.next = node;
//            head = head.next;
//        }
//        int m = sc.nextInt();
//        ListNode dummy2 = new ListNode(-1);
//        head = dummy2;
//        for (int i = 0; i < m; i++) {
//            ListNode node = new ListNode(sc.nextInt());
//            head.next = node;
//            head = head.next;
//        }
//        ListNode cur1 = dummy1.next;
//        ListNode cur2 = dummy2.next;
//        while (cur1 != null && cur2 != null) {
//            if (cur1.val > cur2.val) {
//                cur1 = cur1.next;
//            } else if (cur1.val < cur2.val) {
//                cur2 = cur2.next;
//            } else {
//                System.out.printf("%d ", cur1.val);
//                cur1 = cur1.next;
//                cur2 = cur2.next;
//            }
//        }
//    }
//}
