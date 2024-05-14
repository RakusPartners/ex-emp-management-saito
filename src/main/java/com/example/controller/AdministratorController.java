package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;

import jakarta.servlet.http.HttpSession;

/**
*   Administrator Controllerクラス 
*   @author Ryo Saito
*/
@Controller
@RequestMapping("/")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private HttpSession session;

    /**
     * login画面へフォワードするメソッド
     * @param form
     * @return
     */
    @GetMapping("/")
    public String toLogin(LoginForm form){

        return "/administrator/login";
    }

    @PostMapping("/login")
    public String login(LoginForm form, Model model){
        Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
        if(administrator==null){
            model.addAttribute("loginErrorMessage", "メールアドレスまたはパスワードが不正です");
            return "/administrator/login";
        } else {
            session.setAttribute("administratorName", administrator.getName());
            return "redirect:/employee/showList";
        }
    }

    /**
     * administrator/insert.htmlへフォワードするメソッド
     * @param form　InsertAdministratorFormオブジェクトを自動でリクエストスコープへ格納
     * @return
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form){

        return "/administrator/insert";
    }

    /**
     * データ追加を行う際に呼ばれるメソッド administrtorServiceのinsertメソッドを呼ぶ
     * @param form
     * @return
     */
    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form){
        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(form, administrator);
        administratorService.insert(administrator);
        return "redirect:/";    
    }
}