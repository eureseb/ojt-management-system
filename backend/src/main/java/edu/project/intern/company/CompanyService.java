package edu.project.intern.company;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {
  private CompanyRepository companyRepository;

  public Page<Company> getCompanies(Pageable pageable) {
    return companyRepository.findAll(pageable);
  }

  public List<Company> getAllCompanies(){
    return companyRepository.findAll();
  }

  public Company getCompanyById(Long id) {
    return companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Company not found with id " + id));
  }
}
