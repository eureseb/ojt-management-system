package edu.project.intern.student;

import edu.project.intern.user.User;
import edu.project.intern.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
  private StudentRepository studentRepository;
  private UserService userService;

  public Student signUp(StudentSignUpRequest student) {
    User user = userService.register(student.firstName(), student.lastName(), student.email(), student.password());
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
}
