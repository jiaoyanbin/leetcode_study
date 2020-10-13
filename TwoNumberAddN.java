public class TwoNumberAddN {
    public static void main(String[] args) {
        int[] src1 = { 2, 4, 3, 9 };
        int[] src2 = {};

        ListNode listNode1 = getListNode(src1);
        ListNode listNode2 = getListNode(src2);

        ListNode result = addListNode(listNode1, listNode2);

        System.out.println("result = " + result);

    }

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

        ListNode head = null;
        ListNode tail = null;
        int limit = 0;
        while (listNode1 != null || listNode2 != null) {
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

        if (limit > 0) {
            tail.next = new ListNode(limit);
        }

        return head;
    }

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
