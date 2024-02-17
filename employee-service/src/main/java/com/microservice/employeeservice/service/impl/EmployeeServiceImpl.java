package com.microservice.employeeservice.service.impl;

import com.microservice.employeeservice.dto.EmployeeDto;
import com.microservice.employeeservice.entity.Employee;
import com.microservice.employeeservice.repository.EmployeeRepository;
import com.microservice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto,Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee,EmployeeDto.class);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Optional<Employee> savedEmployee = employeeRepository.findById(id);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee,EmployeeDto.class);
        return savedEmployeeDto;
    }
}
