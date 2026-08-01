package jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jobportal.entity.Application;
import jobportal.service.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("/applications")
@CrossOrigin("*")   // 🔥 MUST ADD
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    // ✅ APPLY JOB
    @PostMapping
    public Application apply(@RequestBody Application app) {
        return service.applyJob(app);
    }

    // ✅ VIEW APPLICATIONS
    @GetMapping("/my")
    public List<Application> myApplications() {
        return service.getMyApplications();
    }

    // ✅ UPDATE STATUS
    @PutMapping("/{id}")
    public Application updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}