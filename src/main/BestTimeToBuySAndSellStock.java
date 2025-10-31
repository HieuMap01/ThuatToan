package main;

/*
 * 🎯 Bài toán: THỜI ĐIỂM TỐT NHẤT ĐỂ MUA VÀ BÁN CỔ PHIẾU
 *
 * Cho mảng prices, với prices[i] là giá cổ phiếu ở ngày i.
 * Chọn 1 ngày mua (i) và 1 ngày bán (j > i) để tối đa lợi nhuận.
 * Trả về lợi nhuận tối đa, hoặc 0 nếu không có lợi nhuận.
 *
 * Ví dụ:
 * - [7,1,5,3,6,4] -> 5 (mua 1, bán 6)
 * - [7,6,4,3,1]   -> 0
 */

public class BestTimeToBuySAndSellStock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int p : prices) {
			if (p < minPrice) {
				minPrice = p;
			} else {
				maxProfit = Math.max(maxProfit, p - minPrice);
			}
		}
		return maxProfit;
	}

	// 🧪 Test nhanh
	public static void main(String[] args) {
		BestTimeToBuySAndSellStock solver = new BestTimeToBuySAndSellStock();

		int[] t1 = { 7, 1, 5, 3, 6, 4 };
		int[] t2 = { 7, 6, 4, 3, 1 };
		int[] t3 = { 2, 4, 1 };
		int[] t4 = { 2, 1, 2, 1, 0, 1, 2 };

		System.out.println("Input: [7,1,5,3,6,4] -> " + solver.maxProfit(t1)); // 5
		System.out.println("Input: [7,6,4,3,1]   -> " + solver.maxProfit(t2)); // 0
		System.out.println("Input: [2,4,1]       -> " + solver.maxProfit(t3)); // 2 (mua 2, bán 4)
		System.out.println("Input: [2,1,2,1,0,1,2]-> " + solver.maxProfit(t4)); // 2 (mua 0, bán 2)
	}
}
