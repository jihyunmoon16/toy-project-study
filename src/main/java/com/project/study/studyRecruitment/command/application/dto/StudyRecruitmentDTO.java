package com.project.study.studyRecruitment.command.application.dto;

public class StudyRecruitmentDTO {

    private Integer id;
    private String title;
    private String  content;
    private Integer count;
    private Integer userId;

    public StudyRecruitmentDTO() {};
    public StudyRecruitmentDTO(String title, String content, Integer count, Integer userId) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.userId = userId;
    }

    public Integer getId() { return id; }
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "RegistStudyRecruitmentDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", count=" + count +
                ", userId=" + userId +
                '}';
    }
}
