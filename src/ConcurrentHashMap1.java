import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap1 {

	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		// ConcurrentHashMap- it is similar to hashmap, except that it has maintained
		// concurrency.
		// default concurrency level:16, ie; internally it get divided into 16 segments.
		// and each section behaves independently.
		// provide thread-safe operations on collections of data.
		// In ConcurrentHashMap, read operations are non-blocking, whereas write
		// operations take a lock on a particular segment or bucket.

		final Map<Integer, String> map1 = new HashMap<>();
		map1.put(1, "baeldung0");
		map1.put(2, "HashMap1");
		final Map<Integer, String> synchronizedMap = Collections.synchronizedMap(map1);
		final Iterator<Entry<Integer, String>> iterator = synchronizedMap.entrySet().iterator();
		while (iterator.hasNext()) {
			// synchronizedMap.put(3, "Modification");
			iterator.next();
		}

		final ConcurrentHashMap<Integer, String> map2 = new ConcurrentHashMap<>();
		map2.put(11, "baeldung");
		map2.put(33, "HashMap");
		map2.put(2, "jini");

		// final Iterator<Entry<Integer, String>> iterator1 =
		// map2.entrySet().iterator();
		// while (iterator1.hasNext()) {
		// map2.put(3, "modification");
		// iterator1.next();
		// }
		// map2.compute(1, (k, v) -> v.concat(" - new "));
		// map1.compute(1, (key, val)
		// -> val + 512);

		map2.forEach(3, (k, v) -> System.out.println("Key : " + k + " Value : " + v));
		// map2.forEachEntry(1, e -> System.out.println("key: " + e.getKey() + ",Value:"
		// + e.getValue()));
		// map2.forEachKey(2, System.out::println);
		// map2.forEachValue(2, System.out::println);
		// map2.forEachValue(2, v -> v = v + 1, System.out::println);
		// map2.merge(2, "newOne", (v1, v2) -> v1 + ", " + v2);
		// map2.forEachValue(1, System.out::println);
		final String result = map2.reduce(4, (k, v) -> v = v + "   ", (t, v) -> t + v);
		// 1st parameter is parallelism threshold,
		// the method will run in parallel when the size of the map reaches the
		// parallelism threshold being 4
		System.out.println(result);
		System.out.println(map2.reduceKeys(1, (k1, k2) -> k1.compareTo(k2) < 0 ? k1 : k2));
		final int search1 = 2;
		final String result1 = map2.search(3, (k, v) -> {
			if (k.equals(search1)) {
				return (v);
			}
			return ("no result found");
		});
		System.out.println(result1);
	}

}
