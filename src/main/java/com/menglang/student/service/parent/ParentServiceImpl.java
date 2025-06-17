package com.menglang.student.service.parent;

import com.menglang.student.dto.parent.ParentMapper;
import com.menglang.student.dto.parent.ParentRequest;
import com.menglang.student.dto.parent.ParentResponse;
import com.menglang.student.model.entities.Parents;
import com.menglang.student.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private static final Logger log = LoggerFactory.getLogger(ParentServiceImpl.class);
    private final ParentRepository parentRepository;
    private final ParentMapper parentMapper;

    @Override
    public ParentResponse create(ParentRequest dto) throws RuntimeException {
        try {
            Parents parent = parentMapper.toParents(dto);
            Parents parentCreated = parentRepository.save(parent);
            log.info("data position: {}",parentCreated.getPosition());
           return parentMapper.toParentResponse(parentCreated);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public ParentResponse update(Long id, ParentRequest dto) {
        Parents parent=this.getParentById(id);


        parentMapper.updateParentToEntity(dto,parent);
        try{
            Parents updatedParent= parentRepository.save(parent);
            return parentMapper.toParentResponse(updatedParent);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public ParentResponse delete(Long id) {
        Parents parent=this.getParentById(id);

        try{
            parentRepository.deleteById(id);
            return parentMapper.toParentResponse(parent);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Optional<ParentResponse> getById(Long id) {
        Parents parent=this.getParentById(id);
        log.info(" data parents: {}",parent.getPosition());
        return Optional.ofNullable(parentMapper.toParentResponse(parent));
    }

    private Parents getParentById(Long id){
        return parentRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found!"));
    }
}
