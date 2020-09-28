package swingy.exception;

public class StandardException extends Exception {
	private static final long serialVersionUID = -5890918875278535579L; // fucking serial id begone

	public StandardException(String err) {
		super(err);
	}

	public static void usage() {
		System.out.println("Usage:");
		System.out.println(" -> $java -jar ./target/swingy.jar \"mode\"");
		System.out.println(" -> $./compile.sh \"mode\"");
		System.out.println("Mode options:");
		System.out.println(" ->Console");
		System.out.println(" ->GUI");
	}
}