import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class JavaIOImprovements {

	public static void main(final String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Java IO improvements

		// Get all the names of the files present
		// in the given directory

		final Path path = Paths.get("test.txt");
		// System.out.println(path);
		try (final Stream<String> lines = Files.lines(path)) {
			final Optional<String> checkNull = lines.filter(s -> s.contains("2")).findFirst();
			if (checkNull.isPresent()) {
				// System.out.println(checkNull.get());
			} else {
				System.out.println("No data found");
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		//
		//
		//
		final Path path1 = Paths.get(".");
		final Stream<Path> matches = Files.find(path1, 1,
				(p, basicFileAttributes) -> String.valueOf(p).endsWith(".txt"));
		// matches.map(Path::getFileName).forEach(System.out::println);
		///
		//
		//
		final Stream<Path> list1 = Files.list(path1);
		// list1.forEach(System.out::println);
		///
		//
		//
		try {
			final BufferedReader b = new BufferedReader(new FileReader("test.txt"));
			final Stream<String> lines1 = b.lines();
			lines1.forEach(System.out::println);

		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
