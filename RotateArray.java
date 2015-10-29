/* 
 * time: O(n)
 * space: O(n)
 */
public class RotateArray{
	/* time: O(n)
	 * space: O(n)
	 */
	public static void intermediateRotate(int[] nums, int k){
		int[] result = new int[nums.length];
		k = k % nums.length;

		for(int i = 0; i < nums.length; i++){
			result[(i+k) % (nums.length)] = nums[i];
		}
		System.arraycopy(result, 0, nums, 0, nums.length);
	}

	/* time: O(k*n)
	 * space: O(1)
	 */
	public static void bubbleRotate(int[] nums, int k){
		for(int i = 0; i < k; i++){
			for(int j = nums.length-1; j > 0; j--){
				int temp = nums[j];
				nums[j] = nums[j-1];
				nums[j-1] = temp;
			}
		}
	}

	/* time: O(n)
	 * space: O(1)
	 */
	public static void reverseRotate(int[] nums, int k){
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	public static void reverse(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void printArray(int[] nums){
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + ", ");
		}
		System.out.println();
	}

	public static void main(String[] argvs){
		int[] nums = {1,2,3,4,5,6,7};
		// intermediateRotate(nums, 3);
		// bubbleRotate(nums, 3);
		reverseRotate(nums, 3);
		printArray(nums);
	}
}