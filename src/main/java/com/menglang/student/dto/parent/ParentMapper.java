package com.menglang.student.dto.parent;

import com.menglang.student.model.entities.Parents;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParentMapper {

//    @Mapping(target = "students", ignore = true)
    Parents toParents(ParentRequest parentRequest);


    ParentResponse toParentResponse(Parents parent);

    List<ParentResponse> toParentsList(List<Parents> parents);

//    @Mapping(target = "students", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    void updateParentToEntity(ParentRequest parentRequest, @MappingTarget Parents parent);
}
