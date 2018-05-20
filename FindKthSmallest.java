
public class FindKthSmallest {
	
	public static int findKthSmallest(int k, int [] arr, int first, int last){
		int pivot = partitionArr(arr, first, last);
		if(pivot == (k-1)){
			return arr[k-1];//arr[pivot];
		}
		else if( (k-1) < pivot){
			return findKthSmallest(k, arr, first, pivot-1);//change focus by reducing pivot index by 1.. look  left
		}
		else{//(k-1) > pivot
			return findKthSmallest(k, arr, pivot+1,last);//change focus by reducing pivot index by 1.. look  left
		}	
	}
	private static int partitionArr(int [] arr, int first, int last){
		int pivot = arr[first];
		int pivPosition = first;
		first++;
		while(first < last){
			while( (first <=last) && (arr[first] < pivot)){
				first++;
			}
			while( ( first <=last ) && ( arr[last] >= pivot)){
				last--;
			}
			if(first > last){
				swapValues(arr, pivPosition, last);
			}
			else{
				swapValues(arr, first, last);
			}
		}
		return last;// return the pivot.... now we can use the pivot to findKthSmallest
	}
	
	private static void swapValues(int [] arr, int x, int y){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

}
