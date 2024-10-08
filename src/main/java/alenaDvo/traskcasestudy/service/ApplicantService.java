package alenaDvo.traskcasestudy.service;

import alenaDvo.traskcasestudy.entity.ApplicantEntity;
import alenaDvo.traskcasestudy.entity.ApplicantTechnologyEntity;
import alenaDvo.traskcasestudy.entity.TechnologyEntity;
import alenaDvo.traskcasestudy.repository.ApplicantRepository;
import alenaDvo.traskcasestudy.repository.TechnologyRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;

    private final TechnologyRepository technologyRepository;

    public ApplicantService(ApplicantRepository applicantRepository, TechnologyRepository technologyRepository) {
        this.applicantRepository = applicantRepository;
        this.technologyRepository = technologyRepository;
    }

    public List<ApplicantDetail> findAll() {
        List<ApplicantDetail> applicantDetails = applicantRepository.findAll()
                .stream()
                .map(ApplicantDetail::new)
                .toList();
        return applicantDetails;
    }

    public ApplicantDetail findById(Long id) {
        ApplicantEntity applicantEntity = applicantRepository.findById(id).orElse(null);
        ApplicantDetail applicantDetail = new ApplicantDetail(applicantEntity);
        return applicantDetail;
    }

    public ApplicantEntity create(ApplicantEntity applicantEntity) {
        return applicantRepository.save(applicantEntity);
    }

    public boolean existsById(Long id) {
        return applicantRepository.existsById(id);
    }

    public ApplicantDetail update(@Valid ApplicantDetail applicantDetail) {
        ApplicantEntity applicant = applicantRepository.findById(applicantDetail.getId()).get();
        applicant.setFirstName(applicantDetail.getFirstName());
        applicant.setSurname(applicantDetail.getSurname());

        applicant.getApplicantTechnologies().clear();
        for (ApplicantTechnologyDetail techDetail : applicantDetail.getTechnologies()) {
            ApplicantTechnologyEntity applicantTech = new ApplicantTechnologyEntity();
            applicantTech.setApplicant(applicant);

            Optional<TechnologyEntity> technology = technologyRepository.findByName(techDetail.getName());
            if (technology.isPresent()) {
                applicantTech.setTechnology(technology.get());
            } else {
                TechnologyEntity newTechnology = new TechnologyEntity();
                newTechnology.setName(techDetail.getName());
                technologyRepository.save(newTechnology);
                applicantTech.setTechnology(newTechnology);
            }
            applicantTech.setLevel(techDetail.getLevel());
            applicantTech.setNote(techDetail.getNote());

            applicant.getApplicantTechnologies().add(applicantTech);
        }
        return new ApplicantDetail(applicantRepository.save(applicant));
    }

    public void deleteById(Long id) {
        applicantRepository.deleteById(id);
    }
}