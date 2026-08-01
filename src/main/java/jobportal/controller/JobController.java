package jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jobportal.entity.Job; // or model.Job 
import jobportal.service.JobService;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@CrossOrigin("*")   // 🔥 ADD THIS
public class JobController {

    @Autowired
    private JobService service;

    @PostMapping
    public Job postJob(@RequestBody Job job) {
        return service.postJob(job);
    }

    @GetMapping
    public List<Job> getJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/search")
    public List<Job> search(@RequestParam String location) {
        return service.searchByLocation(location);
    }
}