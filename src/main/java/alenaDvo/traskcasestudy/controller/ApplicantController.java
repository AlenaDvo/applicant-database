package alenaDvo.traskcasestudy.controller;

import alenaDvo.traskcasestudy.entity.ApplicantEntity;
import alenaDvo.traskcasestudy.service.ApplicantDetail;
import alenaDvo.traskcasestudy.service.ApplicantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping
    public List<ApplicantDetail> getAll() {
        return applicantService.findAll();
    }

    @GetMapping("/{id}")
    public ApplicantDetail getById(@PathVariable Long id) {
        return applicantService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ApplicantEntity> create(@Valid @RequestBody ApplicantEntity applicantEntity) {
        ApplicantEntity createdApplicantEntity = applicantService.create(applicantEntity);
        return new ResponseEntity<>(
                createdApplicantEntity,
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicantDetail> updateById(@PathVariable Long id, @Valid @RequestBody ApplicantDetail applicantDetail) {
        if (!applicantService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            applicantDetail.setId(id);      // ignoring the id in the request body
            ApplicantDetail updatedApplicant = applicantService.update(applicantDetail);
            return ResponseEntity.ok(updatedApplicant);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@Valid @PathVariable Long id) {
        if (!applicantService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Applicant with id " + id + " does not exist.");
        } else {
            applicantService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}