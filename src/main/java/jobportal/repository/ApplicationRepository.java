package jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jobportal.entity.Application;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByApplicantEmail(String email);
}