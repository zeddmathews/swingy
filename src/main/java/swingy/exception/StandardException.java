package swingy.exception;

public class StandardException extends Exception {
	private static final long serialVersionUID = -5890918875278535579L; // fucking serial id begone

	public StandardException(String err) {
		super(err);
	}

	public void usage() {
		System.out.println("why such stoopid");
	}
}