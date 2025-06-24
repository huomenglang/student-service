package com.menglang.student.service.AcademicYear;

import com.menglang.common.library.exceptions.common.BadRequestException;
import com.menglang.common.library.exceptions.common.NotFoundException;
import com.menglang.common.library.page.filter.FilterBy;
import com.menglang.common.library.page.parser.BaseSpecification;
import com.menglang.common.library.page.parser.PageableParser;
import com.menglang.common.library.page.parser.QueryParamParser;
import com.menglang.student.dto.academicYear.AcademicYearMapper;
import com.menglang.student.dto.academicYear.AcademicYearRequest;
import com.menglang.student.dto.academicYear.AcademicYearRequestParam;
import com.menglang.student.dto.academicYear.AcademicYearResponse;
import com.menglang.student.model.entities.AcademicYear;
import com.menglang.student.repository.AcademicYearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AcademicYearServiceImpl implements AcademicService{
    private final AcademicYearRepository academicYearRepository;
    private final AcademicYearMapper academicYearMapper;

    @Override
    public AcademicYearResponse createAcademicYear(AcademicYearRequest academicYearRequest) {
        AcademicYear academicYear = academicYearMapper.toAcademicYear(academicYearRequest);
        if(Boolean.TRUE.equals(this.checkExistAcademicYear(academicYearRequest.getName()))) throw new BadRequestException("Academic Year Already Exist!");
       try{
          AcademicYear savedAcademicYear= academicYearRepository.save(academicYear);
          return academicYearMapper.toAcademicYearResponse(savedAcademicYear);
       }catch (Exception e){
           throw new BadRequestException(e.getMessage());
       }
    }

    @Override
    public AcademicYearResponse getAcademicYear(Long academicYearId) {
        AcademicYear academicYear = this.findAcademicYearById(academicYearId);
        return academicYearMapper.toAcademicYearResponse(academicYear);
    }

    @Override
    public AcademicYearResponse updateAcademicYear(AcademicYearRequest academicYearRequest, Long academicYearId) {
        AcademicYear academicYearToUpdate = this.findAcademicYearById(academicYearId);
        if(Boolean.TRUE.equals(this.checkExistAcademicYear(academicYearRequest.getName()))) throw new BadRequestException("Academic Year Already Exist!");
        academicYearMapper.updateAcademicYearToEntity(academicYearRequest, academicYearToUpdate);
        try {
            AcademicYear savedAcademicYear= academicYearRepository.save(academicYearToUpdate);
            return academicYearMapper.toAcademicYearResponse(savedAcademicYear);
        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }

    }

    @Override
    public AcademicYearResponse deleteAcademicYear(Long academicYearId) {
        AcademicYear academicYear=this.findAcademicYearById(academicYearId);
        try{
            academicYearRepository.delete(academicYear);
            return academicYearMapper.toAcademicYearResponse(academicYear);

        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }

    }

    @Override
    public Page<AcademicYear> getAllAcademicYear(Map<String,String> params) {

        Pageable pageable = PageableParser.from(params);
        List<FilterBy> filters = QueryParamParser.parse(params);
        Specification<AcademicYear> spec = new BaseSpecification<>(filters);
        Page<AcademicYear> academicYearPage= academicYearRepository.findAll(spec,pageable);

        return academicYearPage;
    }

    private AcademicYear findAcademicYearById(Long academicYearId) {
        return academicYearRepository.findById(academicYearId).orElseThrow(()->new NotFoundException("Not Found!"));
    }
    private Boolean checkExistAcademicYear(String name){
        return academicYearRepository.isAcademicExist(name);
    }
}
