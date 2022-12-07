package com.project.study.studyRecruitment.command.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Writer {

    @Column(name="STUDY_RECRUITMENT_WRITER")
    private Integer id;

    public Writer() {}

    public Writer(Integer id) {
        this.id = id;
    }
}
