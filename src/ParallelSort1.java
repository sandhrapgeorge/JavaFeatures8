
import java.util.Arrays;

public class ParallelSort1 {

	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		final int[] arr = { 5, 8, 1, 0, 6, 9 };
		//Arrays.parallelSort(arr);
		Arrays.parallelSort(arr,0,4);
		for (final int i : arr) {
			System.out.println(i);
		}
	}

}