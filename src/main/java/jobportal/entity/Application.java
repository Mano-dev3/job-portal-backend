package jobportal.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jobId;

    private String applicantEmail; // from JWT

    private String resumeUrl;

    private String status; // APPLIED, REJECTED, SELECTED

    private LocalDateTime appliedAt;
}