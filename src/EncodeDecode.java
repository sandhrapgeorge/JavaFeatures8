
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncodeDecode {

	public static void main(final String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		// encoding
		final String text = "welcome to java programming";
		final String etext = Base64.getEncoder().encodeToString(text.getBytes("UTF-8"));
		System.out.println(etext);

		// decoding
		final byte darr[] = Base64.getDecoder().decode(etext);
		final String dtext = new String(darr, "UTF-8");
		System.out.println(dtext);

		// getUrlEncoder(),getUrlDecoder()
		// getMimeEncoder(),getMimeDecoder()
		
		System.out.println("hii");
	}

}
