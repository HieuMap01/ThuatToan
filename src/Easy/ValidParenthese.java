package main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/*
 * 🎯 Bài toán: KIỂM TRA DẤU NGOẶC HỢP LỆ (Valid Parentheses)
 * 
 * Cho một chuỗi s chỉ chứa các ký tự: '(', ')', '{', '}', '[' và ']',
 * hãy xác định xem chuỗi đầu vào có hợp lệ hay không.
 * 
 * 🔹 Chuỗi được coi là hợp lệ nếu:
 *   1️⃣ Dấu mở phải được đóng bằng cùng loại dấu ngoặc.
 *   2️⃣ Dấu mở phải được đóng theo đúng thứ tự.
 *   3️⃣ Mỗi dấu đóng phải có một dấu mở tương ứng.
 */
public class ValidParenthese {
	public boolean isValid(String s) {
		Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');

		Deque<Character> Stack = new ArrayDeque<>();

		for (Character c : s.toCharArray()) {
			// kiểm tra nếu là mở thì đẩy vào stack
			if (c == '(' || c == '{' || c == '[') {
				Stack.push(c);
			}
			// kiểm tra XEM KHÓA có tồn tại hay không
			else if (map.containsKey(c)) {
				// không có ngoặc mở tương ứng or sai
				if (Stack.isEmpty() || Stack.peek() != map.get(c)) {
					return false;
				}
				Stack.pop();
			} else {
				return false;
			}
		}
		return Stack.isEmpty();
	}

	// 🧪 Test chương trình
	public static void main(String[] args) {
		ValidParenthese vp = new ValidParenthese();

		String[] tests = { "()", "()[]{}", "(]", "([])", "([)]", "{[]}", "(((", "" };
		for (String s : tests) {
			System.out.printf("Input: %-8s ➜ Output: %s%n", "\"" + s + "\"", vp.isValid(s));
		}
	}
}
