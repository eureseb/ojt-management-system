package edu.project.intern.student;

import edu.project.intern.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
  StudentService studentService;

  @GetMapping
  public Page<Student> getStudents(Pageable pageable) {
    return studentService.getStudents(pageable);
  }

  @PostMapping
  public Student signUp(@RequestBody StudentSignUpRequest request) {
    return studentService.signUp(request);
  }

  @PostMapping("/preferences")
  @PreAuthorize("hasRole('STUDENT')")
  public Student updatePreferences(@RequestBody UpdatePreferencesRequest request) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    User user = (User) authentication.getPrincipal();
    return studentService.updatePreferences(request, user);
  }

  @GetMapping("/me")
  public Student getMe() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    User user = (User) authentication.getPrincipal();
    return studentService.getStudentByUser(user);
  }

  @DeleteMapping("/{id}/company")
  @PreAuthorize("hasRole('TEACHER')")
  public Student removeCompany(@PathVariable Long id) {
    return studentService.removeCompany(id);
  }
}
