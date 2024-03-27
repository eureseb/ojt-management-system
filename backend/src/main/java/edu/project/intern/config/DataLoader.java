package edu.project.intern.config;

import edu.project.intern.company.Company;
import edu.project.intern.company.CompanyRepository;
import edu.project.intern.companyevaluation.CompanyEvaluation;
import edu.project.intern.companyevaluation.CompanyEvaluationRepository;
import edu.project.intern.companyevaluation.EvaluationTerm;
import edu.project.intern.companyevaluation.ExperienceEvaluation;
import edu.project.intern.joblisting.JobListing;
import edu.project.intern.joblisting.JobListingRepository;
import edu.project.intern.student.StudentService;
import edu.project.intern.student.StudentSignUpRequest;
import edu.project.intern.user.User;
import edu.project.intern.user.UserRepository;
import edu.project.intern.user.UserService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {


  @Bean
  public CommandLineRunner runner(CompanyRepository companyRepository, StudentService studentService, JobListingRepository jobListingRepository, CompanyEvaluationRepository companyEvaluationRepository) {
    return (String... args) -> {
      var student = studentService.signUp(new StudentSignUpRequest("Jeman", "Mama", "jemanmama@gmail.com", "Password#1"));
      var company1 = Company.builder()
                         .id(1L)
                         .name("Alliance Software Incorporation")
                         .description("Alliance Software Incorporation is a software development company that provides software solutions to businesses.")
                         .tags(List.of("Computer Science", "Business", "OJT", "Software"))
                         .addressLine1("Kamputhaw, Cebu City, Cebu")
                         .addressLine2("9F Ayala Center Cebu Tower, Bohol St., Cebu Business Park")
                         .yearEstablished(2016)
                         .noOfEmployeesMin(1001)
                         .noOfEmployeesMax(5000)
                         .contactEmail("hr@alliancesoftwareincorporation.com")
                         .build();
      company1 = companyRepository.save(company1);
      var company2 = Company.builder()
                         .id(2L)
                         .name("Accenture Incorporation")
                         .description("Accenture Incorporation is a global professional services company that provides consulting and outsourcing services.")
                         .tags(List.of("Computer Science", "Outsourcing", "Consulting", "OJT"))
                         .addressLine1("Mandaluyong City, Metro Manila")
                         .addressLine2("6750 Ayala Avenue, Makati City, Metro Manila")
                         .yearEstablished(1989)
                         .noOfEmployeesMin(10001)
                         .noOfEmployeesMax(50000)
                         .contactEmail("hr@accentureincorporation.com")
                         .build();
      company2 = companyRepository.save(company2);
      var company3 = Company.builder()
                         .id(3L)
                         .name("Google Incorporation")
                         .description("Google Incorporation is a multinational technology company that specializes in Internet-related services and products.")
                         .tags(List.of("Computer Science", "Internet", "OJT", "Software"))
                         .addressLine1("Mountain View, California")
                         .addressLine2("1600 Amphitheatre Parkway, Mountain View, California")
                         .yearEstablished(1998)
                         .noOfEmployeesMin(10001)
                         .noOfEmployeesMax(50000)
                         .contactEmail("hr@google.com")
                         .build();
      company3 = companyRepository.save(company3);
      var company4 = Company.builder()
                         .id(4L)
                         .name("Facebook Incorporation")
                         .description("Facebook Incorporation is an American online social media and social networking service company.")
                         .tags(List.of("Computer Science", "Social Media", "OJT", "Software"))
                         .addressLine1("Menlo Park, California")
                         .addressLine2("1 Hacker Way, Menlo Park, California")
                         .yearEstablished(2004)
                         .noOfEmployeesMin(10001)
                         .noOfEmployeesMax(50000)
                         .contactEmail("hr@faceboook.com")
                         .build();
      company4 = companyRepository.save(company4);
      var company5 = Company.builder()
                         .id(5L)
                         .name("Amazon Incorporation")
                         .description("Amazon Incorporation is an American multinational technology company that focuses on e-commerce, cloud computing, digital streaming, and artificial intelligence.")
                         .tags(List.of("Computer Science", "E-commerce", "Cloud Computing", "OJT"))
                         .addressLine1("Seattle, Washington")
                         .addressLine2("410 Terry Ave N, Seattle, Washington")
                         .yearEstablished(1994)
                         .noOfEmployeesMin(10001)
                         .noOfEmployeesMax(50000)
                         .contactEmail("hr@amazon.com")
                         .build();
      company5 = companyRepository.save(company5);
      var company6 = Company.builder()
                         .id(6L)
                         .name("Google LLC")
                         .description("Google LLC is an American multinational technology company that specializes in Internet-related services and products, which include online advertising technologies, a search engine, cloud computing, software, and hardware.")
                         .tags(List.of("Computer Science", "Search Engine", "Cloud Computing", "Artificial Intelligence"))
                         .addressLine1("Mountain View, California")
                         .addressLine2("1600 Amphitheatre Parkway, Mountain View, California")
                         .yearEstablished(1998)
                         .noOfEmployeesMin(50001)
                         .noOfEmployeesMax(100000)
                         .contactEmail("careers@google.com")
                         .build();
      company6 = companyRepository.save(company6);
      var company7 = Company.builder()
                         .id(7L)
                         .name("Microsoft Corporation")
                         .description("Microsoft Corporation is an American multinational technology company that develops, manufactures, licenses, supports, and sells computer software, consumer electronics, personal computers, and related services.")
                         .tags(List.of("Computer Software", "Operating Systems", "Productivity Software", "Cloud Computing"))
                         .addressLine1("Redmond, Washington")
                         .addressLine2("One Microsoft Way, Redmond, Washington")
                         .yearEstablished(1975)
                         .noOfEmployeesMin(100001)
                         .noOfEmployeesMax(200000)
                         .contactEmail("jobs@microsoft.com")
                         .build();
      company7 = companyRepository.save(company7);
      var company8 = Company.builder()
                         .id(8L)
                         .name("Apple Inc.")
                         .description("Apple Inc. is an American multinational technology company that designs, develops, and sells consumer electronics, computer software, and online services.")
                         .tags(List.of("Consumer Electronics", "Smartphones", "Computers", "Software"))
                         .addressLine1("Cupertino, California")
                         .addressLine2("One Apple Park Way, Cupertino, California")
                         .yearEstablished(1976)
                         .noOfEmployeesMin(50001)
                         .noOfEmployeesMax(100000)
                         .contactEmail("jobs@apple.com")
                         .build();
      company8 = companyRepository.save(company8);
      var company9 = Company.builder()
                         .id(9L)
                         .name("Facebook, Inc.")
                         .description("Facebook, Inc. is an American social media conglomerate corporation founded in 2004. It is the world's largest online social network, with more than 2.8 billion monthly active users.")
                         .tags(List.of("Social Media", "Networking", "Online Services", "Technology"))
                         .addressLine1("Menlo Park, California")
                         .addressLine2("1 Hacker Way, Menlo Park, California")
                         .yearEstablished(2004)
                         .noOfEmployeesMin(20001)
                         .noOfEmployeesMax(50000)
                         .contactEmail("careers@fb.com")
                         .build();
      company9 = companyRepository.save(company9);
      var company10 = Company.builder()
                          .id(10L)
                          .name("Tesla, Inc.")
                          .description("Tesla, Inc. is an American electric vehicle and clean energy company based in Palo Alto, California. Tesla's current products include electric cars, battery energy storage from home to grid-scale, solar panels and solar roof tiles, as well as other related products and services.")
                          .tags(List.of("Electric Vehicles", "Clean Energy", "Automobiles", "Technology"))
                          .addressLine1("Palo Alto, California")
                          .addressLine2("3500 Deer Creek Road, Palo Alto, California")
                          .yearEstablished(2003)
                          .noOfEmployeesMin(10001)
                          .noOfEmployeesMax(20000)
                          .contactEmail("careers@tesla.com")
                          .build();
      company10 = companyRepository.save(company10);
      var company11 = Company.builder()
                          .id(11L)
                          .name("Twitter, Inc.")
                          .description("Twitter, Inc. is an American microblogging and social networking service on which users post and interact with messages known as tweets.")
                          .tags(List.of("Social Media", "Microblogging", "Online Services", "Technology"))
                          .addressLine1("San Francisco, California")
                          .addressLine2("1355 Market Street, Suite 900, San Francisco, California")
                          .yearEstablished(2006)
                          .noOfEmployeesMin(5001)
                          .noOfEmployeesMax(10000)
                          .contactEmail("careers@twitter.com")
                          .build();
      company11 = companyRepository.save(company11);
      var company12 = Company.builder()
                          .id(12L)
                          .name("Netflix, Inc.")
                          .description("Netflix, Inc. is an American over-the-top content platform and production company headquartered in Los Gatos, California.")
                          .tags(List.of("Streaming Media", "Entertainment", "Online Services", "Technology"))
                          .addressLine1("Los Gatos, California")
                          .addressLine2("100 Winchester Circle, Los Gatos, California")
                          .yearEstablished(1997)
                          .noOfEmployeesMin(10001)
                          .noOfEmployeesMax(20000)
                          .contactEmail("jobs@netflix.com")
                          .build();
      company12 = companyRepository.save(company12);
      var company13 = Company.builder()
                          .id(13L)
                          .name("Intel Corporation")
                          .description("Intel Corporation is an American multinational corporation and technology company headquartered in Santa Clara, California, in Silicon Valley.")
                          .tags(List.of("Semiconductors", "Processors", "Technology", "Electronics"))
                          .addressLine1("Santa Clara, California")
                          .addressLine2("2200 Mission College Blvd., Santa Clara, California")
                          .yearEstablished(1968)
                          .noOfEmployeesMin(100001)
                          .noOfEmployeesMax(200000)
                          .contactEmail("jobs@intel.com")
                          .build();
      company13 = companyRepository.save(company13);
      var company14 = Company.builder()
                          .id(14L)
                          .name("IBM")
                          .description("International Business Machines Corporation (IBM) is an American multinational technology company headquartered in Armonk, New York, with operations in over 170 countries.")
                          .tags(List.of("Computer Hardware", "Software", "Consulting", "Cloud Computing"))
                          .addressLine1("Armonk, New York")
                          .addressLine2("1 New Orchard Road, Armonk, New York")
                          .yearEstablished(1911)
                          .noOfEmployeesMin(100001)
                          .noOfEmployeesMax(200000)
                          .contactEmail("careers@ibm.com")
                          .build();
      company14 = companyRepository.save(company14);
      var company15 = Company.builder()
                          .id(15L)
                          .name("Cisco Systems, Inc.")
                          .description("Cisco Systems, Inc. is an American multinational technology conglomerate headquartered in San Jose, California, in the center of Silicon Valley.")
                          .tags(List.of("Networking", "Telecommunications", "Security", "Technology"))
                          .addressLine1("San Jose, California")
                          .addressLine2("170 West Tasman Drive, San Jose, California")
                          .yearEstablished(1984)
                          .noOfEmployeesMin(50001)
                          .noOfEmployeesMax(100000)
                          .contactEmail("jobs@cisco.com")
                          .build();
      company15 = companyRepository.save(company15);
      jobListingRepository.save(JobListing.builder()
                          .company(company1)
                          .datePosted(LocalDateTime.now())
                          .jobTitle("Software Engineer Intern")
                          .jobDescription("Develop software applications")
                          .datePosted(LocalDateTime.now())
                          .build());
      jobListingRepository.save(JobListing.builder()
                          .company(company2)
                          .datePosted(LocalDateTime.now())
                          .jobTitle("Software Engineer Intern")
                          .jobDescription("Develop software applications")
                          .datePosted(LocalDateTime.now())
                          .build());
      jobListingRepository.save(JobListing.builder()
                          .company(company3)
                          .datePosted(LocalDateTime.now())
                          .jobTitle("Software Engineer Intern")
                          .jobDescription("Develop software applications")
                          .datePosted(LocalDateTime.now())
                          .build());
      jobListingRepository.save(JobListing.builder()
                          .company(company4)
                          .datePosted(LocalDateTime.now())
                          .jobTitle("Software Engineer Intern")
                          .jobDescription("Develop software applications")
                          .datePosted(LocalDateTime.now())
                          .build());
      jobListingRepository.save(JobListing.builder()
                          .company(company5)
                          .datePosted(LocalDateTime.now())
                          .jobTitle("Software Engineer Intern")
                          .jobDescription("Develop software applications")
                          .datePosted(LocalDateTime.now())
                          .build());
      jobListingRepository.save(JobListing.builder()
                                    .company(company6)
                                    .datePosted(LocalDateTime.now())
                                    .jobTitle("Software Engineer Intern")
                                    .jobDescription("Develop software applications")
                                    .datePosted(LocalDateTime.now())
                                    .build());
      jobListingRepository.save(JobListing.builder()
                                    .company(company7)
                                    .datePosted(LocalDateTime.now())
                                    .jobTitle("Data Analyst Intern")
                                    .jobDescription("Analyze and interpret data")
                                    .datePosted(LocalDateTime.now())
                                    .build());
      jobListingRepository.save(JobListing.builder()
                                    .company(company8)
                                    .datePosted(LocalDateTime.now())
                                    .jobTitle("Marketing Intern")
                                    .jobDescription("Assist in marketing campaigns")
                                    .datePosted(LocalDateTime.now())
                                    .build());
      jobListingRepository.save(JobListing.builder()
                                    .company(company9)
                                    .datePosted(LocalDateTime.now())
                                    .jobTitle("Human Resources Intern")
                                    .jobDescription("Support HR operations")
                                    .datePosted(LocalDateTime.now())
                                    .build());
      jobListingRepository.save(JobListing.builder()
                                    .company(company10)
                                    .datePosted(LocalDateTime.now())
                                    .jobTitle("Graphic Design Intern")
                                    .jobDescription("Create visual content")
                                    .datePosted(LocalDateTime.now())
                                    .build());
      jobListingRepository.save(JobListing.builder()
                                    .company(company11)
                                    .datePosted(LocalDateTime.now())
                                    .jobTitle("Finance Intern")
                                    .jobDescription("Assist in financial analysis")
                                    .datePosted(LocalDateTime.now())
                                    .build());
      jobListingRepository.save(JobListing.builder()
                                    .company(company12)
                                    .datePosted(LocalDateTime.now())
                                    .jobTitle("Project Management Intern")
                                    .jobDescription("Support project planning and execution")
                                    .datePosted(LocalDateTime.now())
                                    .build());
      jobListingRepository.save(JobListing.builder()
                                    .company(company13)
                                    .datePosted(LocalDateTime.now())
                                    .jobTitle("Customer Service Intern")
                                    .jobDescription("Assist customers with inquiries")
                                    .datePosted(LocalDateTime.now())
                                    .build());
      jobListingRepository.save(JobListing.builder()
                                    .company(company14)
                                    .datePosted(LocalDateTime.now())
                                    .jobTitle("Sales Intern")
                                    .jobDescription("Support sales team")
                                    .datePosted(LocalDateTime.now())
                                    .build());
      jobListingRepository.save(JobListing.builder()
                                    .company(company15)
                                    .datePosted(LocalDateTime.now())
                                    .jobTitle("Quality Assurance Intern")
                                    .jobDescription("Assist in testing software products")
                                    .datePosted(LocalDateTime.now())
                                    .build());


      var companyEvaluation = CompanyEvaluation.builder()
                                  .company(company1)
                                  .evaluatedBy(student)
                                  .dateEvaluated(LocalDateTime.now())
                                  .evaluationTerm(EvaluationTerm.MIDTERM)
                                  .isRecommendedForOJT(false)
                                  .isRecommendedForOJTReason("Lackluster Leadership")
                                  .experienceEvaluation(ExperienceEvaluation.VERY_BAD)
                                  .experienceWithCompany("Despite the promising facade, Alliance Software fell short of expectations. The management's disorganization and lack of clear direction made it challenging to thrive within the company. Communication breakdowns were rampant, resulting in missed deadlines and frustrated team members. Overall, a disappointing experience.")
                                  .build();
      companyEvaluationRepository.save(companyEvaluation);

      var companyEvaluation2 = CompanyEvaluation.builder()
                                   .company(company1)
                                   .evaluatedBy(student)
                                   .dateEvaluated(LocalDateTime.now())
                                   .evaluationTerm(EvaluationTerm.MIDTERM)
                                   .isRecommendedForOJT(false)
                                   .isRecommendedForOJTReason("Mixed Bag")
                                   .experienceEvaluation(ExperienceEvaluation.BAD)
                                   .experienceWithCompany("Alliance Software has its strengths and weaknesses. While the work environment is generally pleasant, there are noticeable inconsistencies in project management and resource allocation. Additionally, the company's growth trajectory seems stagnant, with limited opportunities for career advancement. It's an okay place to work, but there's room for improvement.")
                                   .build();
      companyEvaluationRepository.save(companyEvaluation2);

      var companyEvaluation3 = CompanyEvaluation.builder()
                                   .company(company1)
                                   .evaluatedBy(student)
                                   .dateEvaluated(LocalDateTime.now())
                                   .evaluationTerm(EvaluationTerm.MIDTERM)
                                   .isRecommendedForOJT(true)
                                   .isRecommendedForOJTReason("Valuable Learning Experience")
                                   .experienceEvaluation(ExperienceEvaluation.VERY_GOOD)
                                   .experienceWithCompany("My time as an OJT at Alliance Software was invaluable. The company's commitment to nurturing young talent is commendable. From day one, I was given meaningful tasks and mentorship opportunities that greatly contributed to my professional development. The supportive work culture and knowledgeable colleagues made it a fulfilling experience. Highly recommended for aspiring software professionals.")
                                   .build();
      companyEvaluationRepository.save(companyEvaluation3);

      var companyEvaluation4 = CompanyEvaluation.builder()
                                   .company(company1)
                                   .evaluatedBy(student)
                                   .dateEvaluated(LocalDateTime.now())
                                   .evaluationTerm(EvaluationTerm.MIDTERM)
                                   .isRecommendedForOJT(true)
                                   .isRecommendedForOJTReason("Innovative Solutions")
                                   .experienceEvaluation(ExperienceEvaluation.GOOD)
                                   .experienceWithCompany("Alliance Software stands out for its innovative approach to software development. Working here has exposed me to cutting-edge technologies and methodologies that have enhanced my skills significantly. The collaborative atmosphere fosters creativity and encourages experimentation. While there are occasional challenges, the overall experience has been rewarding. Highly recommend for those seeking a dynamic work environment.")
                                   .build();
      companyEvaluationRepository.save(companyEvaluation4);

      var companyEvaluation5 = CompanyEvaluation.builder()
                                   .company(company1)
                                   .evaluatedBy(student)
                                   .dateEvaluated(LocalDateTime.now())
                                   .evaluationTerm(EvaluationTerm.MIDTERM)
                                   .isRecommendedForOJT(false)
                                   .isRecommendedForOJTReason("Poor Work-Life Balance")
                                   .experienceEvaluation(ExperienceEvaluation.VERY_BAD)
                                   .experienceWithCompany("Working at Alliance Software has been a draining experience due to the lack of work-life balance. The workload is often overwhelming, with tight deadlines and long hours becoming the norm. Additionally, there's little support from management in addressing these issues. Overall, not recommended for those prioritizing their personal well-being.")
                                   .build();
      companyEvaluationRepository.save(companyEvaluation5);

      var companyEvaluation6 = CompanyEvaluation.builder()
                                   .company(company1)
                                   .evaluatedBy(student)
                                   .dateEvaluated(LocalDateTime.now())
                                   .evaluationTerm(EvaluationTerm.MIDTERM)
                                   .isRecommendedForOJT(true)
                                   .isRecommendedForOJTReason("Great Team Collaboration")
                                   .experienceEvaluation(ExperienceEvaluation.GOOD)
                                   .experienceWithCompany("One of the highlights of working at Alliance Software is the exceptional team collaboration. Colleagues are always willing to lend a helping hand and share knowledge, fostering a supportive and inclusive environment. This collaborative spirit greatly contributes to productivity and overall job satisfaction. Highly recommended for those who value teamwork.")
                                   .build();
      companyEvaluationRepository.save(companyEvaluation6);

      var companyEvaluation7 = CompanyEvaluation.builder()
                                   .company(company1)
                                   .evaluatedBy(student)
                                   .dateEvaluated(LocalDateTime.now())
                                   .evaluationTerm(EvaluationTerm.MIDTERM)
                                   .isRecommendedForOJT(true)
                                   .isRecommendedForOJTReason("Professional Growth Opportunities")
                                   .experienceEvaluation(ExperienceEvaluation.VERY_GOOD)
                                   .experienceWithCompany("Alliance Software provides ample opportunities for professional growth and development. The company offers training programs, workshops, and mentorship initiatives aimed at enhancing employees' skills and advancing their careers. Additionally, there are opportunities to work on diverse projects, allowing for exposure to different technologies and industries. Highly recommended for individuals seeking continuous learning and growth.")
                                   .build();
      companyEvaluationRepository.save(companyEvaluation7);
    };
  }
}
