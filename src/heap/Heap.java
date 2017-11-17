package heap;


/**
 * This is a small heap exeample
 * @author liq
 *
 */
public class Heap {
		
		public final int MAXSIZE = 100;
		int[] heap = new int[MAXSIZE];
		int heapSize = 0;
		
		public void create() {
			//从最后一个非叶子节点开始向前的每一个节点，每个节点都执行向下调整
			for(int i=heapSize/2; i>=1; i--) {
				shiftDown(i);
			}
		}
		
		public void shiftDown(int i) {
			
			//向下调整到位了
			int flag = 0;
			//没有调整到位且没调整完
			while(flag == 0 && i*2 <= heapSize) {
				//在父亲和两个孩子之间找到最小的
				int minLocation = findMinLocation(i);
				
				//是他自己
				if(minLocation == i) {
					//调整到位，不需要继续了
					flag = 1;
				}else {
					//不是自己，说明孩子中有比自己小的存在。交换！
					swap(i, minLocation);
					i = minLocation;
				}
			}
		}
		
		private void swap(int i, int minLocation) {
			
			int temp = 0;
			temp = heap[i];
			heap[i] = heap[minLocation];
			heap[minLocation] = temp;
		}
		
		
		public int findMinLocation(int i) {
			int minLocation = i;
			//和左孩子比较
			if (i*2 <= heapSize && heap[i] > heap[i*2]) {
				minLocation = i*2;
			}
			//和右孩子比较
			if (i*2+1 <= heapSize && heap[minLocation] > heap[i*2+1]) {
				minLocation = i*2+1;
			}
			return minLocation;
		}
		
		
		public int getTop() {
			
			int resultTop = heap[1];
			heap[1] = heap[heapSize];
			heapSize -- ;
			shiftDown(1);
			return resultTop;
		}
}


