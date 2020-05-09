package lhj.leetcode;


import org.junit.jupiter.api.Test;

/** 2. 两数相加
 * @author lhj
 * @version 1.0
 * @description: 两数之和
 * @date 2019-12-15 22:19
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        int init = 0;
        if(l1 != null){
            init += l1.val;
        }
        if(l2 != null){
            init += l2.val;
        }
        if(l1 == null && l2 == null){

        }else{
            node = new ListNode(init%10);
            addNext(node,l1.next,l2.next,init >= 10 ? 1 : 0);
        }
        return node;
    }

    /**
     * 需要考虑的场景比较多，首先要判断是否继续迭代，尤其在最后一次的迭代，虽然链表后面都为空，但是刚好两之和大于等于10，就需要再次迭代一次
     * @param node
     * @param l1
     * @param l2
     * @param ad
     */
    private void addNext(ListNode node,ListNode l1, ListNode l2,int ad) {
        int sum = 0;
        ListNode l1Next = null;
        ListNode l2Next = null;
        if(l1 != null){
            l1Next = l1.next;
            sum += l1.val;
            if(l2 != null){
                l2Next = l2.next;
                sum += l2.val;
            }
        }else{
            if(l2 != null){
                l2Next = l2.next;
                sum += l2.val;
            }
        }

        sum += ad;
        if(l1Next == null && l2Next == null){
            if( sum != 0){
                node.next = new ListNode(sum%10);
                if( sum >= 10){
                    addNext(node.next,l1Next,l2Next,sum >= 10 ? 1 : 0);
                }
            }
        }else{
            node.next = new ListNode(sum%10);
            addNext(node.next,l1Next,l2Next,sum >= 10 ? 1 : 0);
        }
    }

   class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("111");

    }

}
