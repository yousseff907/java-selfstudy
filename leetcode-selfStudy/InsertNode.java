

/*
Insert a new node with given data at a specific position in a linked list.
Position is 0-indexed.

Example: 
List: 16 -> 13 -> 7
Insert 1 at position 2
Result: 16 -> 13 -> 1 -> 7
*/

class ListNode
{
	int			val;
	ListNode	next;

	ListNode() {}

	ListNode(int val)
	{
		this.val = val;
	}

	ListNode(int val, ListNode next)
	{
		this.val = val; this.next = next;
	}
}

public class InsertNode
{
    public ListNode insertNodeAtPosition(ListNode head, int data, int position)
	{
		int	index = 0;
		ListNode newHead = head;

		if (position < 0)
			return (head);

		if (position == 0)
		{
			ListNode newNode = new ListNode(data);
			newNode.next = head;

			return (newNode);
		}

		if(head == null)
			return (null);

		while(newHead != null)
		{
			if (index == position - 1)
			{
				ListNode newNode = new ListNode(data);
				newNode.next = newHead.next;  
				newHead.next = newNode;

				return (head);
			}

			newHead = newHead.next;
			index++;
		}

		return (head);
    }

	public static void main(String[] args)
	{
		InsertNode solution = new InsertNode();

		ListNode head = new ListNode(16);
		head.next = new ListNode(13);
		head.next.next = new ListNode(7);

		head = solution.insertNodeAtPosition(head, 1, 2);
		
		// Print result
		ListNode current = head;
		while (current != null)
		{
			System.out.print(current.val);
			if (current.next != null) System.out.print(" -> ");
			current = current.next;
		}

		System.out.println(); // Expected: 16 -> 13 -> 1 -> 7
	}
}