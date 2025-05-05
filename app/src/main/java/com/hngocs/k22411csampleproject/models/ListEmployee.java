package com.hngocs.k22411csampleproject.models;

import java.util.ArrayList;
import java.util.List;
public class ListEmployee {
    private List<Employee> employees;

    public ListEmployee() {
        employees=new ArrayList<>();
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public void generate_sample_dataset(){
        Employee e1=new Employee();
        e1.setName("John");
        e1.setEmail ("john@gmail.com");
        e1.setUsername("john");
        e1.setPassword("123");
        employees.add(e1);

        Employee e2=new Employee();
        e2.setName("Lina");
        e2.setEmail ("lina@gmail.com");
        e2.setUsername("peter");
        e2.setPassword("456");
        employees.add(e2);

        Employee e3=new Employee();
        e3.setName("Misa");
        e3.setEmail ("misa@gmail.com");
        e3.setUsername("misa");
        e3.setPassword("789");
        employees.add(e3);

    }
}
