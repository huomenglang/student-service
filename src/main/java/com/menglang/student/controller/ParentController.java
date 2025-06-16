package com.menglang.student.controller;

import com.menglang.student.dto.parent.ParentRequest;
import com.menglang.student.dto.parent.ParentResponse;
import com.menglang.student.service.parent.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api/v1/parents")
@RestController
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping("/{id}")
    public Optional<ParentResponse> getParentById(@PathVariable Long id){
        return parentService.getById(id);
    }

    @PostMapping
    public ParentResponse createParent(@RequestBody ParentRequest data){
        return parentService.create(data);
    }

    @PutMapping("/{id}")
    public ParentResponse updateParent(@PathVariable Long id, @RequestBody ParentRequest data){
        return parentService.update(id,data);
    }

    @DeleteMapping("/{id}")
    public ParentResponse deleteParent(@PathVariable Long id){
        return parentService.delete(id);
    }
}
