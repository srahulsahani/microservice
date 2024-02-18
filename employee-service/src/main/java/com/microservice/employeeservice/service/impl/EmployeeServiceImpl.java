package com.microservice.employeeservice.service.impl;

import com.microservice.employeeservice.dto.APIResponseDto;
import com.microservice.employeeservice.dto.DepartmentDto;
import com.microservice.employeeservice.dto.EmployeeDto;
import com.microservice.employeeservice.entity.Employee;
import com.microservice.employeeservice.repository.EmployeeRepository;
import com.microservice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto,Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee,EmployeeDto.class);
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        /*Get Employee Data*/
        Optional<Employee> savedEmployee = employeeRepository.findById(id);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee,EmployeeDto.class);

        /*Get Department Data*/
        ResponseEntity<DepartmentDto> departmentDtoResponseEntity =
                restTemplate.getForEntity("http://localhost:8080/api/departments/"+savedEmployee.get().getDepartmentCode(), DepartmentDto.class);
        DepartmentDto saveddepartmentDto = departmentDtoResponseEntity.getBody();

        //Combining two Responses
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(savedEmployeeDto);
        apiResponseDto.setDepartmentDto(saveddepartmentDto);

        return apiResponseDto;
    }
}
