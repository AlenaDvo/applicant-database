package alenaDvo.traskcasestudy.service;

import alenaDvo.traskcasestudy.entity.ApplicantEntity;

import java.util.List;

public class ApplicantDetail {

    private Long id;

    private String surname;

    private String firstName;

    private List<ApplicantTechnologyDetail> technologies;

    public ApplicantDetail() {
    }

    public ApplicantDetail(ApplicantEntity applicantEntity) {
        id = applicantEntity.getId();
        surname = applicantEntity.getSurname();
        firstName = applicantEntity.getFirstName();
        technologies = applicantEntity.getApplicantTechnologies()
                .stream()
                .map(ApplicantTechnologyDetail::new)
                .toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<ApplicantTechnologyDetail> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<ApplicantTechnologyDetail> technologies) {
        this.technologies = technologies;
    }

    @Override
    public String toString() {
        return "%s %s: ".formatted(firstName, surname) + technologies;
    }
}
