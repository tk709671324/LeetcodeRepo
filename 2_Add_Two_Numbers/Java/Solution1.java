import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution1 {


	/**
	 *
	 * Date : 2018/11/9
	 *
	 * beats : 54.18 %
	 */
	public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int count1 = 0;
		int count2 = 0;
		ListNode curr = l1;

		while(curr != null){    //O(n)
			count1++;
			curr = curr.next;
		}

		curr = l2;

		while(curr != null){    //O(n)
			count2++;
			curr = curr.next;
		}

		ListNode longList;
		ListNode shortList;


		if(count1 > count2){
			longList = l1;
			shortList = l2;

		}else {
			shortList = l1;
			longList = l2;

		}

		ListNode longTail = longList;
		ListNode shortTail = shortList;


		while(shortTail != null){    //该循环n步，总共时间开销O(n^2)
			addNode(shortTail.val, longTail);    //O(n)
			longTail = longTail.next;
			shortTail = shortTail.next;
		}


		return longList;

	}

	private ListNode addNode(int inc, ListNode l){    //O(n)    n是长度
		if(l == null){
			return new ListNode(inc);
		}
		if(l.val + inc >= 10){
			l.next = addNode(1, l.next);
			l.val = l.val + inc - 10;
			return l;
		}else {
			l.val = l.val + inc;
			return l;
		}
	}
}
