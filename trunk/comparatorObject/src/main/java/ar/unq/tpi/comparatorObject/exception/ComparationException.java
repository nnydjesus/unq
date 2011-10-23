package ar.unq.tpi.comparatorObject.exception;

public class ComparationException extends RuntimeException {
	
	public ComparationException() {
        super();
    }

    public ComparationException(String message) {
        super(message);
    }

    public ComparationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComparationException(Throwable cause) {
        super(cause);
    }

}
