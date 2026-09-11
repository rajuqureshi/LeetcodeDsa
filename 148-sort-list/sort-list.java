/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int size(ListNode head){
        int size =0;
        if(head==null) return 0;
        while(head!=null){
            head = head.next;
            size++;
        }
        return size;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        int size = size(head);
        int [] arr = new int[size];
        int i=0;
        ListNode temp = head;
        while(temp!=null){
            arr[i] = temp.val;
            temp = temp.next;
            i++;
        }
        Arrays.sort(arr);
        temp = head;
        for(int j=0;j<arr.length;j++){
            temp.val = arr[j];
            temp = temp.next;
        }
        return head;
    }
}