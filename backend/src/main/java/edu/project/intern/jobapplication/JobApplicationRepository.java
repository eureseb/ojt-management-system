package edu.project.intern.jobapplication;

import edu.project.intern.student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>{
  @Modifying
  @Query("UPDATE JobApplication j SET j.status = ?1 WHERE j.student = ?2 AND j.id != ?3")
  void updateStatusByStudentExcluding(JobApplicationStatus status, Student student, Long id);

  @Query("SELECT j FROM JobApplication j WHERE j.status = edu.project.intern.jobapplication.JobApplicationStatus.PENDING")
  Page<JobApplication> findAllPending(Pageable pageable);
}
