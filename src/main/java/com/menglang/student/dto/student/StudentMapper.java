package com.menglang.student.dto.student;

import com.menglang.student.dto.parent.ParentMapper;
import com.menglang.student.dto.parent.ParentResponse;
import com.menglang.student.model.entities.Parents;
import com.menglang.student.model.entities.Student;
import com.menglang.student.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    protected ParentMapper parentMapper;
    protected ParentRepository parentRepository;

    @Autowired
    public void setDependencies(ParentMapper parentMapper, ParentRepository parentRepository) {
        this.parentMapper = parentMapper;
        this.parentRepository = parentRepository;
    }

    @Mapping(target = "studentEnrollments",ignore = true)
    @Mapping(target = "parents", expression = "java(mapParent(studentRequest.parents()))")
    public abstract Student toStudent(StudentRequest studentRequest);

    @Named("mapParent")
    protected Set<Parents> mapParent(List<Long> parentIds) {

        return parentIds.stream().map(
                p -> parentRepository.findById(p).orElseThrow(() -> new RuntimeException(p + " Parent Not Found!"))
        ).collect(Collectors.toSet());
    }

    @Mapping(target = "parents", expression = "java(mapParentToResponse(student.getParents()))")
    public abstract StudentResponse studentResponse(Student student);

    @Named("mapParentToResponse")
    protected List<ParentResponse> mapParentToResponse(Set<Parents> parentsList) {
        return parentsList.stream().map(parentMapper::toParentResponse).toList();
    }

}
