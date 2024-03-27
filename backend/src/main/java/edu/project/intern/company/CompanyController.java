package edu.project.intern.company;

import jakarta.websocket.server.PathParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public List<Company> getAllCompanies(){
    return companyService.getAllCompanies();
  }

  @GetMapping("/{id}")
  public Company getCompanyById(@PathVariable Long id){
    return companyService.getCompanyById(id);
  }
}
