package com.microservices.departmentservice.service.impl;

import com.microservices.departmentservice.dto.DepartmentDto;
import com.microservices.departmentservice.entity.Department;
import com.microservices.departmentservice.repository.DepartmentRepository;
import com.microservices.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = modelMapper.map(departmentDto,Department.class);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment,DepartmentDto.class);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDto = modelMapper.map(department,DepartmentDto.class);
        return departmentDto;
    }
}
