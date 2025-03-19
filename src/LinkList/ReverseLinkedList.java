package LinkList;

/**
 * 206. 反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class ReverseLinkedList {
    public class ListNode {
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

    public ListNode reverseList(ListNode head) {
        //依次遍历链表， 使用三个指针 pre,cur,next来依次转换指针方向，并转换后再指向下一个
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            //拿到后面的节点备份
            ListNode next = cur.next;
            //转换指针方向
            cur.next = pre;
            //pre和cur指针往后移
            pre = cur; //从pre开始挪
            cur = next;
        }
        return pre; //返回最前面的指针
    }
}
