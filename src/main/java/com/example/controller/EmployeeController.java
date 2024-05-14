package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;

/**
*   Employee Controllerクラス
*   @author Ryo Saito
*/
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * EmployeeServiceクラスのshowListを呼び出してリストを取得後にリクエストスコープに格納してlist.htmlにフォワードするメソッド
     * @param model
     * @return
     */
    @GetMapping("/showList")
    public String showList(Model model){
        List<Employee> employeeList = employeeService.showList();
        
        model.addAttribute("employeeList", employeeList);

        return "/employee/list";
    }

    /**
     * 詳細ページ表示用メソッド
     * @param id
     * @param model
     * @param form
     * @return
     */
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form){

        Employee employee = employeeService.showDetail(Integer.parseInt(id));

        model.addAttribute("employee", employee);

        return "employee/detail";
    }


    /**
     * 情報更新用メソッド
     * @param form
     * @return String
     */
    @PostMapping("/update")
    public String update(UpdateEmployeeForm form){

        Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));

        employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));

        employeeService.update(employee);

        return "redirect:/employee/showList";
    }
}
