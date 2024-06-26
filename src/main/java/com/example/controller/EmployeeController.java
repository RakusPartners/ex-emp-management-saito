package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        
        if(AdministratorController.isHttpSession){
            List<Employee> employeeList = employeeService.showList();
        
            model.addAttribute("employeeList", employeeList);

            return "/employee/list";
        } else {
            return "redirect:/";
        }

        
        
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
        if(AdministratorController.isHttpSession){
            Employee employee = employeeService.showDetail(Integer.parseInt(id));

        model.addAttribute("employee", employee);

        return "employee/detail";
        } else {
            return "redirect:/";
        }

        
    }


    /**
     * 情報更新用メソッド
     * @param form
     * @return String
     */
    @PostMapping("/update")
    public String update(@Validated UpdateEmployeeForm form, BindingResult result, Model model){

        if(result.hasErrors()){
            return showDetail(form.getId(), model, form);
        }

        Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));

        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdFormat.parse(form.getHireDate());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        employee.setName(form.getName());
        employee.setGender(form.getGender());        
        employee.setHireDate(date);
        employee.setMailAddress(form.getMailAddress());
        employee.setZipCode(form.getZipCode());
        employee.setTelephone(form.getTelephone());
        employee.setSalary(Integer.parseInt(form.getSalary()));
        employee.setCharacteristics(form.getCharacteristics());

        employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));

        employeeService.update(employee);

        return "redirect:/employee/showList";
    }
}
