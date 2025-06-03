package com.menglang.student.service.AcademicYear;

import com.menglang.student.dto.academicYear.AcademicYearMapper;
import com.menglang.student.dto.academicYear.AcademicYearRequest;
import com.menglang.student.dto.academicYear.AcademicYearResponse;
import com.menglang.student.model.entities.AcademicYear;
import com.menglang.student.repository.AcademicYearRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademicYearServiceImpl implements AcademicService{
    private final AcademicYearRepository academicYearRepository;
    private final AcademicYearMapper academicYearMapper;

    @Override
    public AcademicYearResponse createAcademicYear(AcademicYearRequest academicYearRequest) {
        AcademicYear academicYear = academicYearMapper.toAcademicYear(academicYearRequest);
       try{
          AcademicYear savedAcademicYear= academicYearRepository.save(academicYear);
          return academicYearMapper.toAcademicYearResponse(savedAcademicYear);
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
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
        academicYearMapper.updateAcademicYearToEntity(academicYearRequest, academicYearToUpdate);
        try {
            AcademicYear savedAcademicYear= academicYearRepository.save(academicYearToUpdate);
            return academicYearMapper.toAcademicYearResponse(savedAcademicYear);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public AcademicYearResponse deleteAcademicYear(Long academicYearId) {
        AcademicYear academicYear=this.findAcademicYearById(academicYearId);
        try{
            academicYearRepository.delete(academicYear);
            return academicYearMapper.toAcademicYearResponse(academicYear);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public List<AcademicYearResponse> getAllAcademicYear() {
        return academicYearMapper.toAcademicYearResponse(academicYearRepository.findAll());
    }

    private AcademicYear findAcademicYearById(Long academicYearId) {
        return academicYearRepository.findById(academicYearId).orElseThrow(()->new RuntimeException("Not Found!"));
    }
}
