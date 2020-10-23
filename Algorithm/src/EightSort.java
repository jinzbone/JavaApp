import java.util.Arrays;

public class EightSort {

    public static void main(String[] args) {
        EightSort es = new EightSort();
        int[] nums = {3 ,1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        es.quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * @Title: 冒泡排序
     * @Description: 时间复杂度 O(n^2)
     * @Param: int[] nums
     * @return: void
     */
    public void bubbleSort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    /**
     * @Title: 快排
     * @Description: 用到递归，并且涉及3个难点
     * @Param: int[] nums, int low, int high
     * @return: void
     */
    public void quickSort(int[] nums, int low, int high){
        if (low>high) return;
        int i = low, j = high;
        int key = nums[low];
        while (i<j){
            while (i<j & nums[j]>key){
                j -= 1;
            }
            while (i<j & nums[i]<key){
                i += 1;
            }
            System.out.println(i + " "+ j);
            if (i<j){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            if (i==j){
                int temp = nums[low];
                nums[low] = nums[j];
                nums[j] = temp;
                break;
            }
        }
        quickSort(nums, low, i-1);
        quickSort(nums, i+1, high);
    }

}
