package edu.project.intern.teacher;

import edu.project.intern.user.User;
import edu.project.intern.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherService {
  private TeacherRepository teacherRepository;
  private UserService userService;

  public Teacher signUp(TeacherSignUpRequest student) {
    User user = userService.registerTeacher(student.firstName(), student.lastName(), student.email(), student.password());
    return teacherRepository.save(Teacher.builder().accountInformation(user).build());
  }
}
