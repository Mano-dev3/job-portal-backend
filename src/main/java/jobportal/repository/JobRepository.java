package jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; // ✅ ADD THIS IMPORT

import jobportal.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByLocationContainingIgnoreCase(String location);
}