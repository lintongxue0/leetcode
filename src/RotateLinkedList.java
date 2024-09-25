/**
 * 61.旋转链表
 */
public class RotateLinkedList {
    /**
     * @param head 给你一个链表的头节点 head ，旋转链表，
     * @param k 将链表每个节点向右移动 k 个位置。
     * @return
     * 思路：将链表连成环，看什么时候需要断开（拿到第一个节点，把最后一个节点置空）
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 计算链表长度
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // 将链表连成环
        current.next = head;

        // 对 k 进行模运算，避免不必要的旋转
        k = k % length;

        // 找到新的头节点的前一个节点
        int stepsToNewHead = length - k;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewHead - 1; i++) {
            newTail = newTail.next;
        }

        // 新的头节点
        ListNode newHead = newTail.next;

        // 断开链表
        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 测试旋转
        ListNode result = rotateRight(head, 2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
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