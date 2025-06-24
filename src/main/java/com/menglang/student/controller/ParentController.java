package com.menglang.student.controller;

import com.menglang.common.library.page.PageResponse;
import com.menglang.common.library.page.PageResponseHandler;
import com.menglang.student.dto.parent.ParentMapper;
import com.menglang.student.dto.parent.ParentRequest;
import com.menglang.student.dto.parent.ParentResponse;
import com.menglang.student.model.entities.Parents;
import com.menglang.student.service.parent.ParentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/v1/parents")
@RestController
@RequiredArgsConstructor
public class ParentController {
    private static final Logger log = LoggerFactory.getLogger(ParentController.class);
    private final ParentService parentService;
    private final ParentMapper parentMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PageResponse> getParentById(@PathVariable Long id){
       ParentResponse parentResponse= parentService.getById(id);
        log.info("data response: {}",parentResponse.getFullName());
        return PageResponseHandler.success(parentResponse,null,"Get Successful");
    }

    @PostMapping
    public ResponseEntity<PageResponse> createParent(@Valid @RequestBody ParentRequest data){
        return PageResponseHandler.success(parentService.create(data),null,"Create Successful");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PageResponse> updateParent(@PathVariable Long id, @RequestBody ParentRequest data){
        return PageResponseHandler.success(parentService.update(id,data),null,"Update Successful") ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PageResponse> deleteParent(@PathVariable Long id){
        return PageResponseHandler.success( parentService.delete(id),null,"Delete Successful");
    }

    @GetMapping("/get-all")
    public ResponseEntity<PageResponse> getAll(@PathVariable Map<String,String> params){
        Page<Parents> parentsPage=parentService.getAll(params);
        List<ParentResponse> parentResponseList=parentsPage.getContent()
                .stream()
                .map(parentMapper::toParentResponse)
                .toList();
        return PageResponseHandler.success(parentResponseList,parentsPage,"Get Successful");
    }
}
