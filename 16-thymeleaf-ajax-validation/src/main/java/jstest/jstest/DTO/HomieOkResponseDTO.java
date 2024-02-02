package jstest.jstest.DTO;

public class HomieOkResponseDTO {

    // Data Transfer Object for OK response for validation controller
    private String message;

    public HomieOkResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HomieOkResponseDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
