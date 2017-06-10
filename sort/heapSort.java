int getParent(int i){
	return Math.flower((i-1)/2);
}

int getLeftChild(int i){
	return 2*i+1;
}

int getRightChild(int i){
	return 2*i +2;
}

//构建一个大顶堆
//从最后一个有子节点的节点开始向上堆化
void buildMaxHeap(int[] data){
	//从最后一个节点的父节点开始堆化
	int startIndex =  getParent(data.length-1);

	for(int i= startIndex; i>=0; i--){
		MaxHeapify(data, data.length, i);
	}
}

//以当前节点为根节点，进行最大堆化
void MaxHeapify(int[] data, int heapSize, int index){
	int left = getLeftChild(index);
	int right = getRightChild(index);

	//取当前节点，左儿子节点，右儿子节点三者最大值的下标
	int largest = index;
	if(left<heapSize && data[left]>data[largest]){
		largest = left;
	}
	if(right<heapSize && data[right]>data[largest]){
	 	largest = right;
	}

	//当最大值不是当前节点，将最大值与该节点数据对换，如果交换了，
	//那么以其子节点为根节点的堆就不一定是大顶
	//堆了，则需要重新调整
	if(largest != index){
		int temp = data[index];
		data[index] = data[largest];
		data[largest] = temp;

		MaxHeapify(data, heapSize, largest);
	}
}

void heapSort(int[] data){
	buildMaxHeap(data);

	//将堆顶的值与末尾值交换（相当于把最大值放到末尾，然后再进行堆化）
	for(int i= data.length-1; i>0; i--){
		int temp = data[0];
		data[0] = data[i];
		data[i] = temp;

		//i代表当前堆的大小
		MaxHeapify(data,i,0);
	}
}