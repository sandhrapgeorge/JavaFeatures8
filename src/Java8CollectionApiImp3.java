import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;
import java.util.stream.Collectors;

public class Java8CollectionApiImp3 {

	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		// Stream API
		// Collection interface has been extended with stream() and parallelStream()
		// default methods to get the Stream for sequential and parallel execution.
		// A sequential stream is executed in a single thread running on one CPU core.
		// The elements in the stream are processed sequentially in a single pass by the
		// stream operations that are executed in the same thread.
		// A parallel stream is executed by different threads, running on multiple CPU
		// cores in a computer.
		// Def: A stream is a sequence of objects that supports various methods which
		// can be pipelined to produce the desired result.
		// Intermediate Operations:
		// 1.map
		final List<Integer> num = new ArrayList<>(List.of(5, 6, 7, 8));

		final List square = num.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(square);

		// 2.filter

		final List<String> names = new ArrayList<>(List.of("Reflection", "Collection", "Stream"));
		final List result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
		System.out.println(result);

		// 3.sorted
		final List result1 = names.stream().sorted().collect(Collectors.toList());
		System.out.println(result1);

		// Terminal Operations:
		// 1.collect:
		// 2.forEach:
		names.stream().sorted().forEach(System.out::println);
		// 3.Reduce
		// final int even = num.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) ->
		// ans + i);
		final int even = num.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);

		System.out.println(even);

		// A stream consists of source followed by zero or more intermediate methods
		// combined together (pipelined) and a terminal method to process the objects
		// obtained from the source as per the methods described.
		// Stream is used to compute elements as per the pipelined methods without
		// altering the original value of the object.

	}

}
