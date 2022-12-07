package com.project.study.studyRecruitment.command.application.service;

import com.project.study.studyRecruitment.command.application.dto.StudyRecruitmentDTO;
import com.project.study.studyRecruitment.command.domain.model.StudyRecruitment;
import com.project.study.studyRecruitment.command.domain.model.Writer;
import com.project.study.studyRecruitment.command.domain.repository.StudyRecruitmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StudyRecruitmentService {

    private StudyRecruitmentRepository studyRecruitmentRepository;

    @Autowired
    public StudyRecruitmentService(StudyRecruitmentRepository studyRecruitmentRepository){
        this.studyRecruitmentRepository = studyRecruitmentRepository;
    }

    // 스터디 모집 게시글 삭제
    @Transactional
    public void deleteStudyRecruitment(Integer id) {

        // 옵셔널은 널이 들어올 수도 있어서 먼저 get으로 null이 아닌 값을 가져온다음에 set 메소드를 쓴다.
        Optional<StudyRecruitment> studyRecruitment = studyRecruitmentRepository.findById(id);

        StudyRecruitment result = studyRecruitment.get();

        if(result == null) {
            throw new RuntimeException("존재하지 않는 게시글입니다.");
        }

        studyRecruitmentRepository.delete(result);
    }

    // 스터디 모집 게시글 등록
    @Transactional
    public Integer writeStudyRecruitment(StudyRecruitmentDTO studyRecruitmentRequest) {
        StudyRecruitment studyRecruitment = new StudyRecruitment(studyRecruitmentRequest.getTitle(), studyRecruitmentRequest.getContent(), studyRecruitmentRequest.getCount(), new Writer(studyRecruitmentRequest.getUserId()));

        studyRecruitmentRepository.save(studyRecruitment);

        return studyRecruitment.getId();
    }

    @Transactional
    public void updateStudyRecruitment(Integer id, StudyRecruitmentDTO studyRecruitmentData) {

        Optional<StudyRecruitment> studyRecruitment = null;
        studyRecruitment = studyRecruitmentRepository.findById(id);
        StudyRecruitment result = studyRecruitment.get();

        result.setTitle(studyRecruitmentData.getTitle());
        result.setContent(studyRecruitmentData.getContent());
        result.setCount(studyRecruitmentData.getCount());

    }
}
