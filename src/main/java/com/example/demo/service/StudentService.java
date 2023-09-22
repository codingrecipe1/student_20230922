package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Long save(StudentDTO studentDTO) {
        System.out.println("studentDTO = " + studentDTO);
        // DTO -> Entity 변환을 위한 메서드 호출
        StudentEntity studentEntity = StudentEntity.toSaveEntity(studentDTO);
        Long savedId = studentRepository.save(studentEntity).getId();
        return savedId;
    }

    public List<StudentDTO> findAll() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        /*
            List<StudentEntity> -> List<StudentDTO> 로 옮겨 담는 코드 작성
            Entity -> DTO 변환하는 메서드는 DTO에 정의
         */
//        for (StudentEntity studentEntity: studentEntityList) {
////            StudentDTO studentDTO = StudentDTO.toDTO(studentEntity);
////            studentDTOList.add(studentDTO);
//            studentDTOList.add(StudentDTO.toDTO(studentEntity));
//        }
        studentEntityList.forEach(entity -> {
            studentDTOList.add(StudentDTO.toDTO(entity));
        });
        return studentDTOList;
    }
}










