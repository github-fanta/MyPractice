package heap;

/**
 * This is a big heap example
 * @author liq
 *
 */
public class BigHeap {

	private final int MAXSIZE=100;
	int[] heap = new int[MAXSIZE];
	int heapSize = 0;
	
	//建堆
	public void create() {
		for(int i=heapSize/2; i>0; i--) {
			shiftDown(i);
		}
	}

	//将第i个节点向下调整
	private void shiftDown(int i) {

		//直到没有孩子的那一层
		while(i*2 <= heapSize) {
			int maxLocation = findMaxLocation(i);
			//如果自己已经是最大，就没有必要继续向下调整
			if (maxLocation == i) {
				break;
			}else {
				swap(i, maxLocation);
				i = maxLocation;
			}
		}
		
		
	}

	private void swap(int i, int maxLocation) {

		int temp = 0;
		temp = heap[i];
		heap[i] = heap[maxLocation];
		heap[maxLocation] = temp;
		
	}

	//在父亲和左儿子，右儿子三者之中找出最大值的位置
	private int findMaxLocation(int i) {
		
		return i*2 <= heapSize && heap[i*2] > heap[i]
				?i*2
				:i*2+1 <= heapSize && heap[i*2+1] > heap[i*2+1]
						?i*2 + 1
						:i;
						
	/*	//默认假设i位置已经最大
		int maxLocation = i;
		//若左儿子大，那么改变最大的位置，否则就不变
		if (i*2 <= heapSize && heap[i*2] > heap[maxLocation]) {
			maxLocation = i*2;
		}
		//右儿子同样
		if (i*2+1 <= heapSize && heap[i*2+1] > heap[maxLocation]) {
			maxLocation = i*2 + 1;
		}
		
		return maxLocation;*/
	
	}
	
	public int getTop() {
		
		int result = heap[1];
		heap[1] = heap[heapSize];
		heapSize--;
		shiftDown(1);
		return result;
	}
	
}
