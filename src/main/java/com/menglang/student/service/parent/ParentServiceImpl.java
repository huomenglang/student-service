package com.menglang.student.service.parent;

import com.menglang.common.library.exceptions.common.BadRequestException;
import com.menglang.common.library.exceptions.common.ConflictException;
import com.menglang.common.library.exceptions.common.NotFoundException;
import com.menglang.common.library.page.filter.FilterBy;
import com.menglang.common.library.page.parser.BaseSpecification;
import com.menglang.common.library.page.parser.PageableParser;
import com.menglang.common.library.page.parser.QueryParamParser;
import com.menglang.student.dto.parent.ParentMapper;
import com.menglang.student.dto.parent.ParentRequest;
import com.menglang.student.dto.parent.ParentResponse;
import com.menglang.student.model.entities.AcademicYear;
import com.menglang.student.model.entities.Parents;
import com.menglang.student.model.enums.FamilyType;
import com.menglang.student.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private static final Logger log = LoggerFactory.getLogger(ParentServiceImpl.class);
    private final ParentRepository parentRepository;
    private final ParentMapper parentMapper;

    @Override
    public ParentResponse create(ParentRequest dto) throws RuntimeException {
        if(Boolean.TRUE.equals(this.findParentByPhone(dto.phoneNumber(),null))) throw new ConflictException("Phone Number Already Exist.");
        try {
            Parents parent = parentMapper.toParents(dto);

            Parents parentCreated = parentRepository.save(parent);
           return parentMapper.toParentResponse(parentCreated);
        } catch (BadRequestException e) {
            log.info("Create Parent: {}",e.getMessage());
            throw new BadRequestException("Unable to Crete Parent!");
        } catch (RuntimeException e){
            log.info("Create Parent: {}",e.getMessage());
            throw new BadRequestException("Unable to create Parent!");
        }

    }

    @Override
    public ParentResponse update(Long id, ParentRequest dto) {
        Parents parent=this.getParentById(id);
        if(Boolean.TRUE.equals(this.findParentByPhone(dto.phoneNumber(),id))) throw new ConflictException("Phone Number Already Exist.");
        parentMapper.updateParentToEntity(dto,parent);
        try{
            Parents updatedParent= parentRepository.save(parent);
            return parentMapper.toParentResponse(updatedParent);
        }catch (BadRequestException e) {
            log.info("Create Parent: {}",e.getMessage());
            throw new BadRequestException("Unable to Update Parent!");
        } catch (RuntimeException e){
            log.info("Create Parent: {}",e.getMessage());
            throw new BadRequestException("Unable to Update Parent!");
        }

    }

    @Override
    public ParentResponse delete(Long id) {
        Parents parent=this.getParentById(id);

        try{
            parentRepository.deleteById(id);
            return parentMapper.toParentResponse(parent);
        }catch (BadRequestException e) {
            log.info("Create Parent: {}",e.getMessage());
            throw new BadRequestException("Unable to Delete Parent!");
        } catch (RuntimeException e){
            log.info("Create Parent: {}",e.getMessage());
            throw new BadRequestException("Unable to Delete Parent!");
        }
    }

    @Override
    public ParentResponse getById(Long id) {

        Parents parent=this.getParentById(id);

        log.info("parent......{}",parent.getPosition());

        return parentMapper.toParentResponse(parent);
    }

    private Parents getParentById(Long id){
        return parentRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found!"));
    }
    private boolean findParentByPhone(String phoneNumber,Long pId){
        return parentRepository.findParentByPhoneNumber(phoneNumber,pId);
    }

    @Override
    public Page<Parents> getAll(Map<String, String> params) {
        Pageable pageable = PageableParser.from(params);
        List<FilterBy> filters = QueryParamParser.parse(params);
        Specification<Parents> spec = new BaseSpecification<>(filters);

        return parentRepository.findAll(spec,pageable);
    }
}
