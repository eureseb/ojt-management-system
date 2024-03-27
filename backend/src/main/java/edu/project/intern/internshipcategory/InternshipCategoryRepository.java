package edu.project.intern.internshipcategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternshipCategoryRepository extends JpaRepository<InternshipCategory, Long>{
}
