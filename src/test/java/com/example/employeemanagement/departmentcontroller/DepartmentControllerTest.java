package com.example.employeemanagement.departmentcontroller;

import com.sample.employeemanagement.departmentcontroller.DepartmentController;
import com.sample.employeemanagement.dto.DepartmentDTO;
import com.sample.employeemanagement.exceptions.DepartmentNotFoundException;
import com.sample.employeemanagement.service.DepartmentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DepartmentControllerTest {

    @InjectMocks
    private DepartmentController departmentController;

    @Mock
    private DepartmentService departmentService;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    //@Test
    public void testListDepartments() {
        Long id = (Long) 1L;

        DepartmentDTO departmentDTO = new DepartmentDTO(id, "HR");
        when(departmentService.getAllDepartments()).thenReturn(Collections.singletonList(departmentDTO));
        String viewName = departmentController.listDepartments(model);
        assertEquals("departments", viewName);
    }

    @Test
    public void testShowAddDepartmentForm() {
        String viewName = departmentController.showAddDepartmentForm(model);
        assertEquals("add_department", viewName);
    }

    @Test
    public void testAddDepartment() {
        String departmentName = "HR";
        String viewName = departmentController.addDepartment(departmentName);
        assertEquals("redirect:/departments", viewName);
    }

    //@Test
    public void testShowEditDepartmentForm() throws DepartmentNotFoundException {
        Long id = (Long) 1L;
        DepartmentDTO departmentDTO = new DepartmentDTO(id, "HR");
        when(departmentService.getDepartmentById(id)).thenReturn(departmentDTO);
        String viewName = departmentController.showEditDepartmentForm(id, model);
        assertEquals("edit_department", viewName);
    }

    @Test
    public void testUpdateDepartment() throws DepartmentNotFoundException {
        Long id = (Long) 1L;
        String departmentName = "Finance";
        String viewName = departmentController.updateDepartment(id, departmentName);
        assertEquals("redirect:/departments", viewName);
    }

    @Test
    public void testDeleteDepartment() {
        Long id =(Long) 1L;

        String viewName = departmentController.deleteDepartment(id);
        assertEquals("redirect:/departments", viewName);
    }
}
