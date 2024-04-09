package edu.project.intern.student;

import edu.project.intern.jobapplication.AcceptedJobApplication;
import edu.project.intern.user.User;
import edu.project.intern.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
  private StudentRepository studentRepository;
  private UserService userService;

  public Student signUp(StudentSignUpRequest student) {
    User user = userService.registerStudent(student.firstName(), student.lastName(), student.email(), student.password());
    return studentRepository.save(Student.builder().accountInformation(user).build());
  }

  public Student updatePreferences(UpdatePreferencesRequest request, User user) {
    Student student = studentRepository.findByAccountInformation(user).orElseThrow(() -> new StudentNotFoundException("Student with user id " + user.getId() + " not found"));
    student.setCompanyPreferences(request.companyPreferences());
    student.setWorkEnvironmentPreferences(request.workEnvironmentPreferences());
    student.setLocationAndCommutePreferences(request.locationAndCommutePreferences());
    student.setCompensationAndBenefitsPreferences(request.compensationAndBenefitsPreferences());
    student.setTechnicalSkillsAndInterests(request.technicalSkillsAndInterests());
    student.setFeedbackAndSuggestions(request.feedbackAndSuggestions());
    return studentRepository.save(student);
  }

  public Student getStudentByUser(User user) {
    return studentRepository.findByAccountInformation(user).orElseThrow(() -> new StudentNotFoundException("Student with user id " + user.getId() + " not found"));
  }

  public Page<Student> getStudents(Pageable pageable) {
    return studentRepository.findAll(pageable);
  }

  @EventListener(AcceptedJobApplication.class)
  public void handleAcceptedJobApplication(AcceptedJobApplication event) {
    Student student = event.getJobApplication().getStudent();
    student.setCurrentCompany(event.getJobApplication().getJobListing().getCompany());
    studentRepository.save(student);
  }

  public Student removeCompany(Long id) {
    Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
    student.setCurrentCompany(null);
    return studentRepository.save(student);
  }
}
