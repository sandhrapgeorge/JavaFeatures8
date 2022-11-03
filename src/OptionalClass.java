import java.util.Optional;

public class OptionalClass {

	public static void main(final String[] args) {
		// TODO Auto-generated method stub

		final String[] str = new String[10];
		// str[5] = "HII";// Setting value for 5th index

		final Optional<String> checkNull = Optional.ofNullable(str[5]);
		if (checkNull.isPresent()) {
			// Optional.isPresent - checks the value is present or not
			// final String lowercaseString = str[5].toLowerCase();
			// System.out.print(lowercaseString);
			System.out.println(checkNull.get().toLowerCase());
		} else {
			System.out.println("word is null");
		}
	}

}
