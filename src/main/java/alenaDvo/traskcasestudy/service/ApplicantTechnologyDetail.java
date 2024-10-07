package alenaDvo.traskcasestudy.service;

import alenaDvo.traskcasestudy.entity.ApplicantTechnologyEntity;

public class ApplicantTechnologyDetail {
    private String name;

    private int level;

    private String note;

    public ApplicantTechnologyDetail() {
    }

    public ApplicantTechnologyDetail(ApplicantTechnologyEntity applicantTechnologyEntity) {
        name = applicantTechnologyEntity.getTechnology().getName();
        level = applicantTechnologyEntity.getLevel();
        note = applicantTechnologyEntity.getNote();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "%s: %d (%s)".formatted(name, level, note);
    }
}