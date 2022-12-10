package tu.st.paymentsystem.DTO;

import java.util.List;

public class ErrorDTO {
    private final List<String> violations;
    private final String message;

    public ErrorDTO(final List<String> violations, final String message) {
        this.violations = violations;
        this.message = message;
    }

    public List<String> getViolations() {
        return violations;
    }

    public String getMessage() {
        return message;
    }
}
