public class Solution_2 {


	/**
	 * Date : 2018/11/9
	 *
	 * time complexity : O(n)
	 * space complexity : O(n)
	 *
	 * ps : 将空间复杂度将为O(1) 的方法 ： 先获取两个list的长度，在较长的上做修改。
	 */



	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode one = l1;
		ListNode two = l2;
		ListNode dummmyHead = new ListNode(0);

		ListNode curr = dummmyHead;
		int carried = 0;

		while(one != null || two != null){

			int val1 = (one == null) ? 0 : one.val;
			int val2 = (two == null) ? 0 : two.val;

			curr.next = new ListNode((val1 + val2 + carried) % 10);
			carried = (val1 + val2 + carried) / 10;
			curr = curr.next;

			one = (one == null) ? null : one.next;
			two = (two == null) ? null : two.next;
		}

		if(carried != 0){
			curr.next = new ListNode(carried);
		}

		ListNode res = dummmyHead.next;
		dummmyHead = null;    //手动优化垃圾回收

		return res;
	}


}