package com.project.study.studyRecruitment.command.domain.model;

import com.project.study.studyRecruitment.command.domain.exception.StudyRecruitmentCountRangeException;

import javax.persistence.*;

@Entity
@Table(name="TBL_STUDY_RECRUITMENT")
public class StudyRecruitment {

    @Id
    @Column(name="STUDY_RECRUITMENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;       // 아이디

    @Column(name="STUDY_RECRUITMENT_TITLE")
    private String title;     // 제목

    @Column(name="STUDY_RECRUITMENT_CONTENT")
    private String content;   // 내용

    @Column(name="STUDY_RECRUITMENT_NUM_COUNT")
    private Integer count;    // 모집인원

    @Embedded
    private Writer writer;  // 작성자

    protected StudyRecruitment() {}

    public StudyRecruitment(String title, String content, Integer count, Writer writer) {

        // 생성자에서 비즈니스 로직 처리
        validateStudyRecruitmentCountRange(count);
        this.title = title;
        this.content = content;
        this.count = count;
        this.writer = writer;
    }

    // 비즈니스 로직 검증 메소드
    private void validateStudyRecruitmentCountRange(Integer count) {
        if(!((count >= 2) && (count <= 10))) {
            throw new StudyRecruitmentCountRangeException("모집인원은 2명에서 10명 사이여야 합니다");
        }
    }


    // 게터

    public Integer getId() { return id;  }

    public String getContent() {
        return content;
    }

    public Integer getCount() {
        return count;
    }

    public Writer getWriter() {
        return writer;
    }

    // 세터


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

