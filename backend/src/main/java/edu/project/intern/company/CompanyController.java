package edu.project.intern.company;

import jakarta.websocket.server.PathParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
  private final CompanyService companyService;

  @GetMapping
  public Page<Company> getCompanies(Pageable pageable) {
    return companyService.getCompanies(pageable);
  }

  @GetMapping("/all")
  public List<CompactCompany> getAllCompanies(){
    return companyService.getAllCompanies();
  }

  @GetMapping("/{id}")
  public Company getCompanyById(@PathVariable Long id){
    return companyService.getCompanyById(id);
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasRole('TEACHER')")
  public Company updateCompany(@PathVariable Long id, @RequestBody UpdateCompanyRequest request){
    return companyService.updateCompany(id, request);
  }

  @PostMapping
  @PreAuthorize("hasRole('TEACHER')")
  public Company createCompany(@RequestBody CreateCompanyRequest request){
    return companyService.createCompany(request);
  }
}
