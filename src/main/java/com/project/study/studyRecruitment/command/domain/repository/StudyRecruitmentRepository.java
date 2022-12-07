package com.project.study.studyRecruitment.command.domain.repository;

import com.project.study.studyRecruitment.command.domain.model.StudyRecruitment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudyRecruitmentRepository extends JpaRepository<StudyRecruitment, Integer> {

    Optional<StudyRecruitment> findById(Integer id);
}
