package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.InsertAdministratorForm;
import com.example.service.AdministratorService;

/**
*   Administrator Controllerクラス 
*   @author Ryo Saito
*/
@Controller
@RequestMapping("/")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    /**
     * administrator/insert.htmlへフォワードするメソッド
     * @param form　InsertAdministratorFormオブジェクトを自動でリクエストスコープへ格納
     * @return
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form){

        return "/administrator/insert";
    }
}
