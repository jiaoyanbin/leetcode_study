/**
 * 2.两数相加
 * 
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 */

public class TwoNumberAddN {
    public static void main(String[] args) {
        int[] src1 = { 2, 4, 3, 9 };
        int[] src2 = {};

        ListNode listNode1 = getListNode(src1);
        ListNode listNode2 = getListNode(src2);

        ListNode result = addListNode(listNode1, listNode2);

        System.out.println("result = " + result);

    }

    /**
     * 1.记录链表head和tail
     * 2.记录进位
     * 3.while循环遍历,直到两个链表都为null为止
     * 4.两数相加其中一个为null,用0替代
     * 5.判断最后一次相加是否进位了
     * @param listNode1
     * @param listNode2
     * @return
     */
    private static TwoNumberAddN.ListNode addListNode(TwoNumberAddN.ListNode listNode1,
            TwoNumberAddN.ListNode listNode2) {
        if (listNode1 == null && listNode2 == null) {
            return null;
        }
        if (listNode1 == null && listNode2 != null) {
            return listNode2;
        }
        if (listNode1 != null && listNode2 == null) {
            return listNode1;
        }

        /**
         * 1
         */
        ListNode head = null;
        ListNode tail = null;
        /**
         * 2
         */
        int limit = 0;
        /**
         * 3
         */
        while (listNode1 != null || listNode2 != null) {
            /**
             * 4
             */
            int num1 = listNode1 != null ? listNode1.val : 0;
            int num2 = listNode2 != null ? listNode2.val : 0;

            int sum = num1 + num2 + limit;

            if (head == null) {
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            limit = sum / 10;

            if (listNode1 != null) {
                listNode1 = listNode1.next;
            }

            if (listNode2 != null) {
                listNode2 = listNode2.next;
            }
        }

        // 当最后limit大于0说明最高位进位了
        /**
         * 5
         */
        if (limit > 0) {
            tail.next = new ListNode(limit);
        }

        return head;
    }

    /**
     * 将数组转化为链表
     * @param src1
     * @return
     */
    private static TwoNumberAddN.ListNode getListNode(int[] src1) {

        if (src1.length == 0) {
            return null;
        }
        ListNode listNode = null;
        if (src1.length == 1) {
            listNode = new ListNode(src1[0]);
            return listNode;
        }

        listNode = new ListNode(src1[0]);
        ListNode listNode1 = listNode;
        for (int i = 1; i < src1.length; i++) {
            listNode.next = new ListNode(src1[i]);
            listNode = listNode.next;
        }
        return listNode1;
    }

    /**
     * 链表数据结构
     */
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return val + "->" + (next == null ? "null" : next.toString());
        }
    }
}
