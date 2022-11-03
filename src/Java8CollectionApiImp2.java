
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java8CollectionApiImp2 {

	public static List<Person> createPeople() {
		return List.of(new Person("sara", 20), new Person("Nancy", 22), new Person("Bob", 20), new Person("Paula", 32),
				new Person("Paul", 32), new Person("Jack", 3), new Person("Bill", 72), new Person("Jill", 11));
	}

	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				createPeople().stream().filter(person -> person.getAge() > 30).map(Person::getName).collect(toList()));
		System.out.println(createPeople().stream().map(Person::getName).collect(toSet()));

		// name as key and age as value

		final Map<String, Integer> nameAndAge = new HashMap();
		for (final Person person : createPeople()) {
			nameAndAge.put(person.getName(), person.getAge());
		}
		System.out.println(nameAndAge);
		// It's an imperative statement of code.

		// functional way of coding( it removes garbage variables, and it is not
		// complex.
		System.out.println(createPeople().stream()
				//// .collect(toMap(person->person.getName(), person->person.getAge()));
				.collect(toMap(Person::getName, Person::getAge)));
		// final List<Integer> ll =
		// createPeople().stream().map(Person::getAge).collect(toList());

		// ll.add(78);// we can add 78 to this list, even if it's not actually an age.
		// so instead of using toList() we can use toUnmodifiableList
		final List<Integer> ll = createPeople().stream().map(Person::getAge).collect(toUnmodifiableList());
		// ll.add(78); //ERROR
		// like toUnmodifiableList(), there is toUnmodifiableSet() and
		// toUnmodifiableMap() methods- Java 10 feature
		System.out.println(ll);
		System.out.println(ll.getClass());
		//

		//
		//
		//
		// create comma separated the names in upper case of people older than 30
		for (final Person person : createPeople()) {
			if (person.getAge() > 30) {
				System.out.print(person.getName().toUpperCase() + ",");// there is a extra comma in the end
			}
		}
		// another way
		System.out.println(createPeople().stream().filter(person -> person.getAge() > 30).map(Person::getName)
				.map(String::toUpperCase).collect(joining(", ")));
		// .collect(Collector)- collect functions uses a collector
		// Collector<T,A,R> ; T: object u are dealing with, A- accumulator, r- will
		// collect all the concurrent values and combine the result.
		// collectors using local mutability

	}

}
