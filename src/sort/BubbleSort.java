package sort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] data = {9,3,-9,3,800,10009,4,72};
		bubbleSort(data);
		for (int i : data) {
			System.out.print(i+" ");
		}
	}

	/**
	 * 冒泡排序
	 * @param data
	 */
	private static void bubbleSort(int[] data) {

		if (data == null) {
			return;
		}
		int temp = 0;
		int swapped = 1;
		for(int i=0; i<data.length-1&&(swapped==1); i++) {//定位置
			swapped = 0;
			for(int j=data.length-1; j>i; j--) {//冒上来
				if (data[j-1] > data[j]) {
					temp = data[j-1];
					data[j-1] = data[j];
					data[j] = temp;
					swapped = 1;
				}
			}
		}
	}
}
