package com.juan.workshopjavafx.model.services;

import com.juan.workshopjavafx.model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();
        list.add(new Department(1, "BOOKS"));
        list.add(new Department(2, "COMPUTERS"));
        list.add(new Department(3, "ELECTRONICS"));
        return list;
    }
}