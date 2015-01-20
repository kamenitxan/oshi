package oshi.util;

/**
 * Exception used when accesing device which is not in computer.
 * @author Kamenitxan (kamenitxan[at]me[dot]com)
 */
public class NoSuchDeviceException extends Exception {
	public NoSuchDeviceException() {
	}

	public NoSuchDeviceException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return "No such device: " + super.getMessage();
	}
}
