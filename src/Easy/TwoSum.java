package main;

/*
 * Easy
 * 🎯 Bài toán: TÌM HAI SỐ CỘNG LẠI THÀNH MỤC TIÊU (Two Sum)
 * 
 * Cho một mảng số nguyên `nums` và một số nguyên `target`,
 * hãy tìm **chỉ số (index)** của hai phần tử trong mảng sao cho **tổng của chúng bằng target**.
 * 
 * 🔹 Yêu cầu:
 * - Mỗi đầu vào chỉ có duy nhất một cặp nghiệm hợp lệ.
 * - Không được sử dụng lại cùng một phần tử hai lần.
 * - Kết quả có thể trả về theo bất kỳ thứ tự nào.
 */

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] {};
	}

	// 🧪 Hàm test
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();

		int[] nums1 = { 2, 7, 11, 15 };
		int target1 = 9;
		printResult(ts.twoSum(nums1, target1)); // [0, 1]

		int[] nums2 = { 3, 2, 4 };
		int target2 = 6;
		printResult(ts.twoSum(nums2, target2)); // [1, 2]

		int[] nums3 = { 3, 3 };
		int target3 = 6;
		printResult(ts.twoSum(nums3, target3)); // [0, 1]
	}

	// Hàm in kết quả ra màn hình
	private static void printResult(int[] result) {
		if (result.length == 0) {
			System.out.println("Không tìm thấy cặp nào thỏa mãn.");
		} else {
			System.out.println("Kết quả: [" + result[0] + ", " + result[1] + "]");
		}
	}
}
