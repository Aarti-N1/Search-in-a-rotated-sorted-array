package medium;

public class SearchinRotatedSortedArray_33 {

	public static void main(String[] args) {
		int[] nums = {3,4,5,6,1,2};
		System.out.println(search(nums, 2));
	//	System.out.println(findStartIndex(nums));
	}

	// Find the peak Notice that the left & right of peak will ALWAYS be lesser than
	// itself.
    public static int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int startIndex = findStartIndex(nums);
       
        if(startIndex==0 ||target >= nums[startIndex] && target <= nums[nums.length-1] ){
            //search right side
            return binSearch(nums, target, startIndex, nums.length-1);            
        }else if(target >= nums[0] && target <= nums[startIndex-1] ){
            //search left side
            return binSearch(nums, target, 0, startIndex-1);
        } else{
            return -1;
        }
    }
    public static int binSearch(int[] nums, int target, int low, int high){
        int mid;
        while(low<=high){
            mid= low+ (high-low)/2;
            if(nums[mid]== target)
                return mid;
            else if(nums[mid]<target)
                low= mid+1;
            else
                high= mid-1;
        }
        return -1;
    }
    public static int findStartIndex(int[] nums){
        //if mid value > last we move right
        //if mid value < last we move left
        int last = nums[nums.length-1];
        int mid, low = 0, high = nums.length-1;
        while(low<=high){
            mid= low+ (high-low)/2;
            if(nums[mid]>last){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}
