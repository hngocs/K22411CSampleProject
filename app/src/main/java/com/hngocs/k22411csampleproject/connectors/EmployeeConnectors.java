package com.hngocs.k22411csampleproject.connectors;

import com.hngocs.k22411csampleproject.models.Employee;
import com.hngocs.k22411csampleproject.models.ListEmployee;

public class EmployeeConnectors {
    public Employee login(String usr, String pwd)
    {
        ListEmployee le=new ListEmployee();
        le.generate_sample_dataset();
        for(Employee e : le.getEmployees())
        {
            if(e.getUsername().equalsIgnoreCase(usr) && e.getPassword().equals(pwd))
            //equalIsIgnoreCase là không phân biệt hoa thường
            {
                return e;
            }
        }

        return null;
    }
}
