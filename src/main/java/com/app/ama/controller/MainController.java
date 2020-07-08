package com.app.ama.controller;

import com.app.ama.entity.Applicant;
import com.app.ama.entity.Response;
import com.app.ama.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    ApplicantService applicantService;

    @GetMapping("/")
    public String getRegisterPage(
            Response response,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Applicant applicant
    ) {
        System.out.println(response.getMessage());
        redirectAttributes.addFlashAttribute("response", response);
        return "index";
    }

    @PostMapping("/apply")
    public String addData(
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute("applicant") Applicant applicant,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        Response response = applicantService.addApplicant(applicant);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/";
    }

}
