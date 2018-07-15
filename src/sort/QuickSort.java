package sort;

public class QuickSort {

	public static int[] data = {-9,3,9,3,800,10009,4,72};
	public static int count = 0;
	
	public static void main(String[] args) {

		//sort(0, data.length-1);
		quickSort2(0, data.length-1);
		
		for (int i : data) {
			System.out.print(i+" ");
		}
	}

	private static void sort(int left, int right) {
		
		if (left > right) {
			return;
		}
		
		int i = left;
		int temp = data[left];
		int j = right;
		
		
		while (i != j) {
			
			while(i<j && data[j] >= temp) {
				j--;
			}
			
			while(i<j && data[i] <= temp) {
				i++;
			}
			
			if (i <j) {
				int t = data[i];
				data[i] = data[j];
				data[j] = t;
			}
		}
		
		data[left] = data[i];//或者data[j] 因为此时i和j相等
		data[i] = temp;

		sort(left, i-1);
		sort(i+1, right);	
		return;
	}

	public static void quickSort2(int L, int R){
		if (L<R) {
			int[] range = partition(L, R);
			quickSort2(L, range[0]-1);
			quickSort2(range[1]+1, R);
		}
	}
	
	public static int[] partition(int L, int R) {
		int less = L-1;
		int more = R+1;
		
		int cur = L;
		int num = data[R];
		
		//小于放左边，大于放中间，等于num的统统放中间，并返回这个区间
		while(cur < more) {
			if (data[cur] < num) {
				swap(++less, cur++);
			}else if (data[cur] > num) {
				swap(--more, cur);
			}else {
				cur ++;
			}
		}
		return new int[] {less+1, more-1};
	}
	
	private static void swap(int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
	
}
