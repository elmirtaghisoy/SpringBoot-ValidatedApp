package com.app.ama.service;

import com.app.ama.entity.Applicant;
import com.app.ama.entity.Response;
import com.app.ama.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ApplicantService {

    @Autowired
    MailService mailService;

    @Autowired
    ApplicantRepository applicantRepository;

    public Response addApplicant(Applicant applicant) {
        applicant.setId(UUID.randomUUID().toString());
        applicant.setDateTime(LocalDateTime.now());
        applicantRepository.save(applicant);
        if (!sendMessage(applicant)) {
            return new Response(0, "E-poçtun göndərilməsində xəta baş verdi.");
        }
        return new Response(1, "İstifadəçi məlumatları daxil etdiyiniz e-poçt ünvanına göndərildi.");
    }

    private boolean sendMessage(Applicant applicant) {
        if (!StringUtils.isEmpty(applicant.getEmail())) {
            String message = String.format(
                    "%s %s %s \n" +
                            "Sizin şifrəniz: %s",
                    applicant.getName(),
                    applicant.getSurname(),
                    applicant.getFatherName(),
                    applicant.getId()
            );
            mailService.send(applicant.getEmail(), "AMA", message);
            return true;
        }
        return false;
    }
}
