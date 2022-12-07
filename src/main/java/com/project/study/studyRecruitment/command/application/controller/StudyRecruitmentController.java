package com.project.study.studyRecruitment.command.application.controller;


import com.project.study.helper.api.ResponseMessage;
import com.project.study.studyRecruitment.command.application.dto.StudyRecruitmentDTO;
import com.project.study.studyRecruitment.command.application.service.StudyRecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("studyrecruitments")
public class StudyRecruitmentController {

    private StudyRecruitmentService studyRecruitmentService;

    @Autowired
    public StudyRecruitmentController(StudyRecruitmentService studyRecruitmentService) {
        this.studyRecruitmentService = studyRecruitmentService;
    }

    @PostMapping
    public ResponseEntity<?> writeStudyRecruitmentPost(@RequestBody StudyRecruitmentDTO writeStudyRecruitment) throws URISyntaxException {
        System.out.println("writeStudyRecruitment = " + writeStudyRecruitment);

        Integer createdStudyRecruitmentId = studyRecruitmentService.writeStudyRecruitment(writeStudyRecruitment);

        return ResponseEntity.created(new URI("/studyrecruitments/" + createdStudyRecruitmentId)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudyRecruitment(@PathVariable Integer id, @RequestBody StudyRecruitmentDTO studyRecruitmentData) {

        try {
            studyRecruitmentService.updateStudyRecruitment(id, studyRecruitmentData);
            return ResponseEntity
                    .created(URI.create("/studyrecruitments/" + id))
                    .body(new ResponseMessage(HttpStatus.CREATED.value(), "success"));
        } catch (RuntimeException e){
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudyRecruitment(@PathVariable Integer id) {

        try {
            studyRecruitmentService.deleteStudyRecruitment(id);
            return ResponseEntity
                    .created(URI.create("/studyrecruitments"))
                    .body(new ResponseMessage(HttpStatus.CREATED.value(), "success"));
        } catch (RuntimeException e){
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }
    }
}