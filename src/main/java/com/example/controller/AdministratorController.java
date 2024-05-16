package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    public static boolean isHttpSession;
    /**
     * login画面へフォワードするメソッド
     * @param form
     * @return
     */
    @GetMapping("/")
    public String toLogin(LoginForm form){

        return "administrator/login";
    }

    

    @PostMapping("/login")
    public String login(LoginForm form, Model model){
        Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
        if(administrator==null){
            model.addAttribute("loginErrorMessage", "メールアドレスまたはパスワードが不正です");
            return "/administrator/login";
        } else {
            session.setAttribute("administratorName", administrator.getName());
            isHttpSession = true;
            return "redirect:/employee/showList";
        }
    }

    /**
     * administrator/insert.htmlへフォワードするメソッド
     * @param form　InsertAdministratorFormオブジェクトを自動でリクエストスコープへ格納
     * @return
     */
    @GetMapping("/toInsert")
    public String toInsert(Model model, InsertAdministratorForm form){

        Administrator administrator = new Administrator();

        BeanUtils.copyProperties(form, administrator);

        model.addAttribute("administrtor", administrator);

        return "administrator/insert";
    }

    /**
     * データ追加を行う際に呼ばれるメソッド administrtorServiceのinsertメソッドを呼ぶ
     * @param form
     * @return
     */
    @PostMapping("/insert")
    public String insert(@Validated InsertAdministratorForm form, BindingResult result ,Model model){

        if(result.hasErrors()){
            return toInsert(model, form);
        } 
        if(administratorService.checkMailAddress(form.getMailAddress())!=null){
            model.addAttribute("insertErrorMessage", "そのメールアドレスは既に登録されています");
            return toInsert(model, form);
        }

        

        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(form, administrator);
        administratorService.insert(administrator);
        return "redirect:/";    
    }

    
    @GetMapping("/logout")
    public String logout(LoginForm form){

        session.invalidate();
        isHttpSession = false;
        
        return "redirect:/";
    }
}
