package edu.project.intern.teacher;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@AllArgsConstructor
public class TeacherController {
  TeacherService teacherService;
  @PostMapping
  public Teacher signUp(@RequestBody TeacherSignUpRequest request) {
    return teacherService.signUp(request);
  }
}
