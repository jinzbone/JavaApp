public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = {1,2,3,4,5,6,7};
        int target = 2;
        int index = search.binarySearchLeftBound(nums, target);
        System.out.println(index);
    }

    /**
     * @Title: 二分查找
     * @Description: 数组中无重复元素时的二分查找
     * @Param: int[] nums, int target
     * @return: int index
     */
    public int binarySearch(int[] nums, int target){
        int n = nums.length;
        int i = 0, j = n-1;
        while (i<=j){
            int mid = (i+j)/2;
            if (target==nums[mid]){
                return mid;
            }else if (target>nums[mid]){
                i = mid + 1;
            }else if (target<nums[mid]){
                j = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearchLeftBound(int[] nums, int target){
        int n = nums.length;
        int i = 0, j = n-1;
        while (i<=j){
            int mid = (i+j)/2;
            if (target == nums[mid]){
                j = mid - 1;
            }else if (target > nums[mid]){
                i = mid + 1;
            }else if (target < nums[mid]){
                j = mid - 1;
            }
        }
        if (i>=n || nums[i]!=target)return -1;
        return i;
    }
}
