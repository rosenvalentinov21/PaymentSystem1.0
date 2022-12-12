package tu.st.paymentsystem.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ErrorDTO {
    private final List<String> violations;
    private final String message;

    public ErrorDTO(final List<String> violations, final String message) {
        this.violations = violations;
        this.message = message;
    }
}
