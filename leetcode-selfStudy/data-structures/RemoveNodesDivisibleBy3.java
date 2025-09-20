

/*
Remove all nodes from a linked list where the value is divisible by 3.

Example:
Input:  1 -> 6 -> 2 -> 9 -> 4 -> 12 -> 5
Output: 1 -> 2 -> 4 -> 5
(Removed: 6, 9, 12 because they're divisible by 3)
*/

class ListNode
{
    int val;
    ListNode next;
    
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNodesDivisibleBy3
{
    
    public ListNode removeDivisibleBy3(ListNode head)
	{
		while (head != null && head.val % 3 == 0)
			head = head.next;

		if (head == null)
			return (null);

		ListNode	current = head;

		while (current.next != null)
		{
			if (current.next.val % 3 == 0)
			{
				current.next = current.next.next;
			}
			else
				current = current.next;
		}

		return (head);
    }
    
    public void printList(ListNode head)
	{
		ListNode	current = head;

		while (current != null)
		{
			System.out.print("LinkedListNode= " + current.val + ", ");
			current = current.next;
		}
		System.out.println("null");
    }
    
    public static void main(String[] args)
	{
		RemoveNodesDivisibleBy3 solution = new RemoveNodesDivisibleBy3();

		ListNode head = new ListNode(1);
		head.next = new ListNode(6);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(9);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(12);
		head.next.next.next.next.next.next = new ListNode(5);
		
		System.out.print("Original: ");
		solution.printList(head);
		
		head = solution.removeDivisibleBy3(head);
		
		System.out.print("After removal: ");
		solution.printList(head);

		ListNode head2 = new ListNode(3);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(9);
		
		System.out.print("\nTest 2 - Original: ");
		solution.printList(head2);
		
		head2 = solution.removeDivisibleBy3(head2);
		
		System.out.print("After removal: ");
		solution.printList(head2);
	}
}
