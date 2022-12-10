package tu.st.paymentsystem.exception;

public class NonExistingEntityException extends RuntimeException {

    public NonExistingEntityException() {
    }

    public NonExistingEntityException(final String message) {
        super(message);
    }

    public NonExistingEntityException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NonExistingEntityException(final Throwable cause) {
        super(cause);
    }
}