package main;

/*
 * 🎯 Bài toán: KIỂM TRA CHUỖI CÓ PHẢI LÀ PALINDROME
 *
 * Một chuỗi là palindrome nếu sau khi:
 *   - Chuyển hết sang chữ thường.
 *   - Loại bỏ các ký tự không phải chữ hoặc số.
 *   => Chuỗi đó đọc xuôi và ngược giống nhau.
 *
 * 🧩 Ví dụ:
 * 1) "A man, a plan, a canal: Panama" → true
 * 2) "race a car" → false
 * 3) " " → true (chuỗi trống sau xử lý vẫn là palindrome)
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;

		// 1️⃣ Chuyển hết về chữ thường
		s = s.toLowerCase();

		// 2️⃣ Giữ lại chỉ chữ cái và số
		StringBuilder cleaned = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				cleaned.append(c);
			}
		}

		// 3️⃣ Đảo ngược chuỗi rồi so sánh
		String original = cleaned.toString();
		String reversed = cleaned.reverse().toString();

		return original.equals(reversed);
	}

	// 🧪 Test
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();

		String[] tests = { "A man, a plan, a canal: Panama", "race a car", " ", "No lemon, no melon", "12321",
				"Hello!@#olleH" };

		for (String s : tests) {
			System.out.printf("Input: \"%s\" ➜ Output: %s%n", s, vp.isPalindrome(s));
		}
	}
}
