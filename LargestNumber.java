public class LargestNumber{
	public String largestNumber(int[] nums){
		if(nums.length == 0)
			return "";
		if(nums.length == 1)
			return  String.valueOf(nums[0]);

		String[] arr = new String[nums.length];
		for(int i = 0; i < nums.length; i++){
			arr[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(arr, new Comparator<String>(){
			public int compare(String s1, String s2){
				return (s2 + s1).compareTo(s1 + s2);
			}
		});

		if(arr[0].equals("0")) return "0";
		StringBuilder sb = new StringBuilder();
		for(String s : arr)
			sb.append(s);
		return sb.toString();
	}
}