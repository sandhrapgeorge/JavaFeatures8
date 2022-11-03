
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
	private String name;
	private int age;

	public Person(final String name, final int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}
}

public class Java8CollectionApiImp1 {

	public static List<Person> createPeople() {
		return List.of(new Person("sara", 20), new Person("sara", 22), new Person("Bob", 20), new Person("Paula", 32),
				new Person("Paul", 32), new Person("Jack", 3), new Person("Jack", 72), new Person("Jill", 11));
	}

	public static void main(final String[] args) {
		// TODO Auto-generated method stub

		// createPeople().stream().filter(person -> person.getAge() > 30
		// ).forEach(System.out::println);

		// createPeople().stream().map(Person::getName).forEach(System.out::println);
		// createPeople().stream().map(Person::getName).forEach(System.out::println);
		// createPeople().stream().map(Person::getAge).forEach(System.out::println);
		// System.out.println(createPeople().stream().map(Person::getAge).reduce(0,
		// (total, age) -> total + age));
		// reduce takes collection and reduces to a single value
		// reduce converts stream to something concrete
		// System.out.println(createPeople().stream().map(Person::getAge).reduce(0,
		// (total, age) -> Integer.sum(total, age)));

		// System.out.println(createPeople().stream().map(Person::getAge).reduce(0,
		// Integer::sum));
		// java has reduce in two forms
		// 1) reduce , 2)collect

		// Object oriented programming: Polymorphism

		// functional programming: functional composition and lazy evaluation(eager
		// evaluation creates more garbage-> collect more garbage-> poor performance

		final List<String> namesOfOlderThan30 = new ArrayList<>();
		// don't do this way(foreach in line 66); .parallelStream , you need to always
		// avoid shared mutability
		System.out.println(createPeople().stream().filter(person -> person.getAge() > 30).map(Person::getName)
				.map(String::toUpperCase)
				// .forEach(name -> namesOfOlderThan30.add(name));//impure function, because it
				// mutating; if it using parallel stream, their is a chance of failing the code
				.reduce(new ArrayList<String>(), (names, name) -> {
					names.add(name);// it works fine in all situation, but the problem is the code is to complex
					return names;
				}, (names1, names2) -> { // even if we use parallelStream
					names1.addAll(names2);// it uses local mutability, but it is pure(because we are not using
											// global shared variable as mutable.
					return names1;
				}));

		// Other way
		System.out.println(createPeople().stream().filter(person -> person.getAge() > 30).map(Person::getName)
				.map(String::toUpperCase).collect(toList()));// by using collectors, it is thread safe and
		// handle concurrency properly, not only in stream, but also in parallel stream.
		System.out.println(createPeople().stream().filter(person -> person.getAge() > 30).map(Person::getName)
				.map(String::toUpperCase).collect(toSet()));// same for set as well
		// namesOfOlderThan30.forEach(System.out::println);
		// List<Integer> ll=Arrays.asList(5,3,5,8,9);
		//
		//
		//
		//
		//
		final Map<String, String> map = new HashMap<>();
		map.put("C", "c");
		map.put("B", "b");
		map.put("Z", "z");

		// Sorting Map directly with Comparators.
		// final List<Map.Entry<String, String>> sortedByKey =
		// map.entrySet().stream().sorted(Map.Entry.comparingByKey())
		// .collect(Collectors.toList());
		// System.out.println(sortedByKey.get(0));
		// sortedByKey.forEach(System.out::println);

		// for (final Map.Entry<Integer, String> m : map.entrySet()) {
		// System.out.println(m.getKey() + ":" + m.getValue());
		// }
		// Iterate over map easily with forEach.
		// map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));

		// Get rid off ugly if-else condition, use getOrDefault method
		// final String val = map.getOrDefault("A", "Nah!");
		// System.out.println(val); // prints Nah!

		// Replace and Remove utilities.
		// map.replaceAll((k, v) -> "x"); // values is "x" for all keys.

		// Do not override keys accidentally use putIfAbsent
		// map.putIfAbsent("H", "x");
		// System.out.println(map.get("H")); // prints "b"
		// map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));

		// replace value of a map if it equals an expected value.
		// map.replace("H", "x", "m");

		// operate directly on values.
		// map.put("B", null);
		// map.compute("B", (k, v) -> v.concat(" - new "));
		map.merge("B", "G", (k, v) -> v.concat(" - new "));
		System.out.println(map.get("B")); // prints "b - new"

		// Set grade = “A” for students with score > 80
		// students.filter(s - > s.getScore() > 80)
		// .forEach(s - > {
		// s.setGrade(“A”);
		// System.out.println("name: " + s.getName() + " -> Grade:" + s.getGrade());
		// });

	}

}
