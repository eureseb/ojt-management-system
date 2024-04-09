package edu.project.intern.jobapplication;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AcceptedJobApplication extends ApplicationEvent {
  private final JobApplication jobApplication;
  public AcceptedJobApplication(Object source, JobApplication jobApplication) {
    super(source);
    this.jobApplication = jobApplication;
  }
}
