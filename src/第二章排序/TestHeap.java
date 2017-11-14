package µÚ¶şÕÂÅÅĞò;

import java.util.Arrays;

public class TestHeap {
	public static void main(String[] args) {
		Integer a[] = { 10, 9, 8,11,100};
		FailHeapSort<Integer> p=new FailHeapSort<>(a.length);
		p.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
