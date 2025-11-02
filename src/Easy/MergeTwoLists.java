package main;

/* 🎯 Bài toán: HỢP NHẤT HAI DANH SÁCH LIÊN KẾT ĐÃ SẮP XẾP (Merge Two Sorted Lists)
*
* Cho head của hai danh sách liên kết đơn đã sắp xếp không giảm: list1 và list2.
* Hãy hợp nhất chúng thành một danh sách liên kết đã sắp xếp (không giảm),
* bằng cách nối các node của hai danh sách ban đầu.
*
* Trả về head của danh sách đã hợp nhất.
*/

public class MergeTwoLists {

	// định nghĩa node của danh sách liên kết đơn
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

	// dùng đệ quy để giải bài toán
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		if (list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}

	// ---------------- TEST ----------------
	public static void main(String[] args) {
		MergeTwoLists obj = new MergeTwoLists();

		ListNode l1 = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(4)));

		ListNode l2 = obj.new ListNode(1, obj.new ListNode(3, obj.new ListNode(4)));

		ListNode merged = obj.mergeTwoLists(l1, l2);

		System.out.print("Kết quả hợp nhất: ");
		while (merged != null) {
			System.out.print(merged.val);
			if (merged.next != null)
				System.out.print(" ");
			merged = merged.next;
		}
	}
}
