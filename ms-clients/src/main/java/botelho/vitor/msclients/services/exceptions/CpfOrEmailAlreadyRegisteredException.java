package botelho.vitor.msclients.services.exceptions;

public class CpfOrEmailAlreadyRegisteredException extends RuntimeException {
    public CpfOrEmailAlreadyRegisteredException() {
        super();
    }

    public CpfOrEmailAlreadyRegisteredException(String message) {
        super(message);
    }
}
