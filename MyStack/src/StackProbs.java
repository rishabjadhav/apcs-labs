import java.util.Stack;

public class StackProbs {
	public static Stack<Integer> makeStack(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		for (int num : nums)
		stack.push(num);
		return stack;
		}
	
	public static Stack<Integer> doubleUp(Stack<Integer> nums) {  //change to non-static after testing
		Stack<Integer> dStack = new Stack<>();
		for (int i = 0; i < nums.size(); i++) {
				dStack.add(nums.get(i), i + 1);
		}
		return dStack;
	}
	
	public static Stack<Integer> posAndNeg(Stack<Integer> nums) {  //change to non-static after testing
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) < 1) {
				stack.add(nums.get(i));
			}
		}
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) >= 1) {
				stack.add(nums.get(i));
			}
		}
		return stack;
	}
}
