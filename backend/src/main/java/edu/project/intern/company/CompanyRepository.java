package edu.project.intern.company;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
  @Query("SELECT new edu.project.intern.company.CompactCompany(c.id, c.name) FROM Company c")
  public List<CompactCompany> findAllCompact();
}
