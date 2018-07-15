package sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] src = {9,3,-9,3,800,10009,4,72};
		int[] temp = new int[src.length];
		mergeSort(src ,0, src.length-1, temp);
		temp[0] = 1;
		for (int i : src) {
			System.out.print(i+" ");
		}
	}

	private static void mergeSort(int[] src, int start, int end, int[] temp) {

		if (src == null ||
				end <= start) {
			return ;
		}
		int mid = (start+end)/2;
		
		mergeSort(src, start, mid, temp);
		mergeSort(src, mid+1, end, temp);
		mergeArray(src,start, mid, end, temp);
	}

	private static void mergeArray(int[] src, int start, int mid, int end, int[] temp) {

		if (src == null || temp == null) {
			return;
		}
		
		int leftCounter = start;
		int rightCounter = mid+1;
		int tempCounter = 0;
		
		while(leftCounter <= mid && rightCounter <= end) {
			if (src[leftCounter] < src[rightCounter]) {
				temp[tempCounter++] = src[leftCounter++];
			}else {
				temp[tempCounter++] = src[rightCounter++];
			}
		}
		while (leftCounter <= mid) {
			temp[tempCounter++] = src[leftCounter++];
		}
		while (rightCounter <= end) {
			temp[tempCounter++] = src[rightCounter++];
		}
		
		//拷贝回src里
		for(int i= 0; i< tempCounter; i++) {
			src[start + i] = temp[i];
		}
	}
}
