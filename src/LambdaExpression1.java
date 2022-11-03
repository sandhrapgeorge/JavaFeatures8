
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@FunctionalInterface
interface MyInterface {
	void abstract_func(int x, int y);
	// void display();

	default void default_Fun() {
		System.out.println("This is default method");
	}
}

public class LambdaExpression1 {

	public static void main(final String[] args) {
		// TODO Auto-generated method stub

		final MyInterface fobj = (final int x, final int y) -> System.out.println(x + y);

		System.out.print("The result = ");
		fobj.abstract_func(5, 5);
		fobj.default_Fun();

		//
		final ConcurrentHashMap<Integer, String> map2 = new ConcurrentHashMap<>();
		map2.put(11, "baeldung");
		map2.put(33, "HashMap");
		map2.put(2, "jini");
		map2.forEachValue(2, v -> v = v + 1, System.out::println);
		System.out.println(map2.reduceKeys(1, (k1, k2) -> k1.compareTo(k2) < 0 ? k1 : k2));
		final int search1 = 2;
		final String result1 = map2.search(3, (k, v) -> {
			if (k.equals(search1)) {
				return (v);
			}
			return ("no result found");
		});

		final List<Integer> arr = Arrays.asList(5, 7, 8, 9, 4, 3);
		arr.forEach(i -> System.out.println(i)); // using consumer interface; ie, in here i consumer interface object
		// accept() will Performs this operation on the given argument.
	}

}
