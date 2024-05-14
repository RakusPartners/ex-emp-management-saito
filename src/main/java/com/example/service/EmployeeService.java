package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;

/**
*   Employee Serviceクラス　
*   @author Ryo Saito
*/
@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * リスト表示サービスクラスメソッド
     * @return List<Employee>
     */
    public List<Employee> showList(){
        return employeeRepository.findAll();
    }

    /**
     * 詳細表示サービスクラスメソッド
     * @param id
     * @return Employee
     */
    public Employee showDetail(Integer id){
        return employeeRepository.load(id);
    }

    /**
     * データ更新サービスクラスメソッド
     * @param employee
     */
    public void update(Employee employee){
        employeeRepository.update(employee);
    }

}
