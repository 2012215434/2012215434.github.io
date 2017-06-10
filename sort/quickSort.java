
public void quicksort(int[] a , int start, int end){
	int mid = partition(a,start,end);
	quicksort(a,start,mid-1);
	quicksort(a,mid+1,end);
}

public int partition(int[] a , int start , int  end){
	int pivot = a[start];
	int i =start;
	int j=end;
	while(i<j){
		while(i<j&&a[j]>=pivot){
			j--;
		}
		a[i]=a[j];
		while(i<j&&a[i]>pivot){
			i++;
		}
		a[j]=a[i];
	}
	a[i]=pivot;
	return i;
}