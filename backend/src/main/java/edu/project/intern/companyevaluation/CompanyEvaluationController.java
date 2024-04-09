package edu.project.intern.companyevaluation;

import edu.project.intern.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company-evaluations")
@AllArgsConstructor
public class CompanyEvaluationController {
    private CompanyEvaluationService companyEvaluationService;

    @PostMapping
    public CompanyEvaluation createCompanyEvaluation(@RequestBody CompanyEvaluationRequest companyEvaluationRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = (User) authentication.getPrincipal();
        return companyEvaluationService.createCompanyEvaluation(companyEvaluationRequest, user);
    }

    @GetMapping
    public Page<CompanyEvaluationDTO> getCompanyEvaluations(@RequestParam Long companyId, Pageable pageable) {
        return companyEvaluationService.getCompanyEvaluations(companyId, pageable);
    }
}
