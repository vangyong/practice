package cn.segema.learn.interview.exceptions;

public class StoreException extends RuntimeException {
	
	private static final long serialVersionUID = -1663293724487152190L;

	public StoreException() {
	}

	public StoreException(String message) {
		super(message);
	}

	public StoreException(Throwable cause) {
        super(cause);
    }
	
	public StoreException(String message, Throwable cause) {
		super(message, cause);
	}
}
