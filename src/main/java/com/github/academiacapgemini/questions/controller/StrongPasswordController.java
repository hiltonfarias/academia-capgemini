package com.github.academiacapgemini.questions.controller;

import com.github.academiacapgemini.questions.two.StrongPassword;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrongPasswordController {


    StrongPassword strongPassword;

    public StrongPasswordController() {
        strongPassword = new StrongPassword();
    }

    @GetMapping("/password")
    public String getStrongPassword(@RequestParam String key) {
        strongPassword.setPassword(new StringBuilder(key));
        return "O número de dígitos necessário para a senha " + key +" ser forte é : " + strongPassword.getNumberOfDigits();
    }
}
