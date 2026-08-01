package jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jobportal.entity.Application;
import jobportal.repository.ApplicationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository repo;

    public Application applyJob(Application app) {

        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        app.setApplicantEmail(email);
        app.setStatus("APPLIED");
        app.setAppliedAt(LocalDateTime.now());

        return repo.save(app);
    }

    public List<Application> getMyApplications() {

        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return repo.findByApplicantEmail(email);
    }
    public Application updateStatus(Long id, String status) {
        Application app = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        app.setStatus(status);
        return repo.save(app);
    }
}
