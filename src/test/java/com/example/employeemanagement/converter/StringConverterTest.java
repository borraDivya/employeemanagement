package com.example.employeemanagement.converter;

import com.sample.employeemanagement.converter.StringConverter;
import com.sample.employeemanagement.dto.DepartmentDTO;
import com.sample.employeemanagement.entity.Department;
import com.sample.employeemanagement.service.DepartmentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StringConverterTest {

    @InjectMocks
    private StringConverter stringConverter;

    @Mock
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvert() {
        String departmentName = "HR";
        Department department = new Department();
        department.setId(1L);
        department.setName(departmentName);
        DepartmentDTO expectedDTO = new DepartmentDTO(department.getId(), department.getName());when(departmentService.findOrCreateDepartment(departmentName)).thenReturn(department);
        DepartmentDTO result = stringConverter.convert(departmentName);
        assertEquals(expectedDTO, result);
    }
}
