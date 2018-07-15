package sort;

/**
 * 选择排序
 * @author liq
 *
 */
public class SlectSort {
	
	public static void main(String[] args) {
		int[] data = {34,2,-9,9,9,11,4,7};
		sort(data);
		for (int i : data) {
			System.out.print(i+" ");
		}
	}

	private static void sort(int[] data) {
		if (data == null) {
			return;
		}
		int minPosition = 0;
		for(int i=0; i<data.length-1; i++) {
			minPosition = i ;
			for(int j=i+1; j<data.length; j++) {
				if (data[j] < data[minPosition]) {
					minPosition = j;
				}
			}
			
			if (minPosition != i) {
				int temp = data[i];
				data[i] = data[minPosition];
				data[minPosition] = temp;
			}
		}
	}
}
