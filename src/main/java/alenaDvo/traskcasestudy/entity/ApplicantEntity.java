package alenaDvo.traskcasestudy.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "applicant")
public class ApplicantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;

    private String firstName;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApplicantTechnologyEntity> applicantTechnologies;

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

    public List<ApplicantTechnologyEntity> getApplicantTechnologies() {
        return applicantTechnologies;
    }

    public void setApplicantTechnologies(List<ApplicantTechnologyEntity> applicantTechnologies) {
        this.applicantTechnologies = applicantTechnologies;
    }

    @Override
    public String toString() {
        return "%s %s [%d]".formatted(firstName, surname, id);
    }
}
