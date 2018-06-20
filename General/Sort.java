public class SortPractice {
     
    public static void main(String[] args) {
      int[] data = new int[] {5, -2, 1, 10, 74, 23, 100, 33, -58, -34, 5, 53, 12, 90, 0};	
    	mergesort(data, new int[data.length], 0, data.length - 1);
    	for (int i=0; i<data.length; i++) {
            System.out.println(data[i]);
        }
    }
    
    public static void mergesort(int[] data, int[] helper, int leftStart, int rightEnd) {
      if(leftStart >= rightEnd) return;	
    
    	int mid = (rightEnd + leftStart) / 2;
    	mergesort(data, helper, leftStart, mid);
    	mergesort(data, helper, mid+1, rightEnd);
    	merge(data, helper, leftStart, rightEnd);
    } 
    
    public static void merge(int[] data, int[] helper, int leftStart, int rightEnd) {
    	int leftEnd = (rightEnd + leftStart) / 2;
    	int rightStart = leftEnd + 1;
    	int left = leftStart;
    	int right = rightStart;
    	int index = left;
    
    	while(left <= leftEnd && right <= rightEnd) {
    		if (data[left] <= data[right]) {
    			helper[index] = data[left];
    			left++;
            } else {
            	helper[index] = data[right];
            	right++;
            }
            index++;
        }
    
        System.arraycopy(data, left, helper, index, leftEnd-left+1);
        System.arraycopy(data, right, helper, index, rightEnd-right+1);
        System.arraycopy(helper, leftStart, data, leftStart, rightEnd-leftStart+1);
    }
}
