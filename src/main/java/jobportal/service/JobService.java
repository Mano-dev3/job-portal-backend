package jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobportal.entity.Job;
import jobportal.repository.JobRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repo;

    // ✅ POST JOB (FIXED)
    public Job postJob(Job job) {

        // 🔥 FIX: remove SecurityContext (causing 400 error)
        job.setPostedBy("admin@gmail.com");

        // 🔥 Auto set time
        job.setCreatedAt(LocalDateTime.now());

        return repo.save(job);
    }

    // ✅ GET ALL JOBS
    public List<Job> getAllJobs() {
        return repo.findAll();
    }

    // ✅ SEARCH JOBS BY LOCATION
    public List<Job> searchByLocation(String location) {
        return repo.findByLocationContainingIgnoreCase(location);
    }
}