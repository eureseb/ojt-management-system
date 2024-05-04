package edu.project.intern.config;

import edu.project.intern.CompanyEvaluationStatus.CompanyEvaluationStatus;
import edu.project.intern.CompanyEvaluationStatus.CompanyEvaluationStatusRepository;
import edu.project.intern.company.Company;
import edu.project.intern.company.CompanyRepository;
import edu.project.intern.companyevaluation.CompanyEvaluationRequest;
import edu.project.intern.companyevaluation.CompanyEvaluationService;
import edu.project.intern.companyevaluation.ExperienceEvaluation;
import edu.project.intern.joblisting.JobListing;
import edu.project.intern.joblisting.JobListingRepository;
import edu.project.intern.student.StudentService;
import edu.project.intern.student.StudentSignUpRequest;
import edu.project.intern.teacher.TeacherService;
import edu.project.intern.teacher.TeacherSignUpRequest;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

  @Bean
  public CommandLineRunner runner(CompanyRepository companyRepository,
      StudentService studentService, JobListingRepository jobListingRepository,
      CompanyEvaluationService companyEvaluationService, TeacherService teacherService,
      CompanyEvaluationStatusRepository companyEvaluationStatusRepository) {
    return (String... args) -> {
      companyEvaluationStatusRepository.save(new CompanyEvaluationStatus(1L, true,
          "Final Evaluation", LocalDateTime.now().plusDays(100)));
      var student = studentService
          .signUp(new StudentSignUpRequest("Eurese", "Bustamante", "eurese@gmail.com", "Password#1"));
      TeacherSignUpRequest request =
          new TeacherSignUpRequest("EureseT", "BustamanteT", "eureset@gmail.com", "Password#1");
      teacherService.signUp(request);
      var intellisenseInstituteOfTechnology =
          Company.builder().id(1L).name("Intellisense Institute of Technology")
              .description("Private technical and vocational school offering IT courses.")
              .tags(List.of()).addressLine1("Mandaue City, Cebu, Philippines")
              .addressLine2("IT Park, Asiatown").yearEstablished(2008).noOfEmployeesMin(51)
              .noOfEmployeesMax(150).contactEmail("intellisense@email.com").build();
      intellisenseInstituteOfTechnology = companyRepository.save(intellisenseInstituteOfTechnology);

      var welaOnlineCorporation = Company.builder().id(2L).name("Wela Online Corporation")
          .description("E-commerce platform focused on Philippines").tags(List.of())
          .addressLine1("Pasig City, Metro Manila, Philippines")
          .addressLine2("8th Floor, RCBC Plaza Tower 2").yearEstablished(2015).noOfEmployeesMin(251)
          .noOfEmployeesMax(1000).contactEmail("wela@email.com").build();
      welaOnlineCorporation = companyRepository.save(welaOnlineCorporation);

      var cebuInstituteOfTechnologyUniversity =
          Company.builder().id(4L).name("Cebu Institute of Technology - University")
              .description("University offering various programs including IT degrees")
              .tags(List.of()).addressLine1("Cebu City, Cebu, Philippines")
              .addressLine2("No. 125 Mango Avenue").yearEstablished(1946).noOfEmployeesMin(1001)
              .noOfEmployeesMax(5000).contactEmail("cit@cit.edu").build();
      cebuInstituteOfTechnologyUniversity =
          companyRepository.save(cebuInstituteOfTechnologyUniversity);
      var CITUWildcatInnovationLabs = Company.builder().id(5L).name("CIT-U Wildcat Innovation Labs")
          .description("Branch of Wildcat Innovation Labs affiliated with " + "Cebu"
              + " Institute of Technology")
          .tags(List.of()).addressLine1("Cebu City, Cebu, " + "Philippines")
          .addressLine2("Cebu Institute of Technology - University").yearEstablished(2018)
          .noOfEmployeesMin(21).noOfEmployeesMax(50).contactEmail("cit.wildcatlabs@email.com")
          .build();
      CITUWildcatInnovationLabs = companyRepository.save(CITUWildcatInnovationLabs);
      var ONGSalazarBusiness = Company.builder().id(6L)
          .name("Ong Salazar Business Solution & Accounting Services")
          .description("Accounting and business solutions provider")
          .tags(List.of("Accounting", "Finance")).addressLine1("Cebu City, Cebu, Philippines")
          .addressLine2("JY Square Building, Salinas Drive").yearEstablished(2005)
          .noOfEmployeesMin(21).noOfEmployeesMax(100).contactEmail("ongsalazar@email.com").build();
      ONGSalazarBusiness = companyRepository.save(ONGSalazarBusiness);
      var fullScale = Company.builder().id(7L).name("Full Scale")
          .description("Software development company").tags(List.of("Software Development"))
          .addressLine1("Makati City, Metro Manila, Philippines")
          .addressLine2("Gaya Building, Ayala Triangle").yearEstablished(2012).noOfEmployeesMin(101)
          .noOfEmployeesMax(500).contactEmail("fullscale@email.com").build();
      fullScale = companyRepository.save(fullScale);
      var trustArc = Company.builder().id(8L).name("TrustArc")
          .description("Cloud-based information security company")
          .tags(List.of("Cybersecurity", "Cloud Security"))
          .addressLine1("Santa Clara, California, USA").addressLine2("520 Mathilda Drive")
          .yearEstablished(1996).noOfEmployeesMin(5001).noOfEmployeesMax(10000)
          .contactEmail("trustarc@email.com").build();
      trustArc = companyRepository.save(trustArc);
      var maranga = Company.builder().id(9L).name("Maranga Software Solutions / CodeChum")
          .description("Software development company").tags(List.of("Software Development"))
          .addressLine1("Cebu City, Cebu, Philippines").addressLine2("IT Park, " + "Asiatown")
          .yearEstablished(2010).noOfEmployeesMin(251).noOfEmployeesMax(1000)
          .contactEmail("maranga@email.com").build();
      maranga = companyRepository.save(maranga);
      var goodApps = Company.builder().id(10L).name("GoodApps")
          .description("Mobile application development company")
          .tags(List.of("Mobile App Development"))
          .addressLine1("Mandaluyong City, Metro Manila, Philippines")
          .addressLine2("ϺΕΤΡΟΠΟΛΙΣ (Metropolis) Plaza").yearEstablished(2017).noOfEmployeesMin(51)
          .noOfEmployeesMax(250).contactEmail("goodapps@email.com").build();
      goodApps = companyRepository.save(goodApps);
      var lexmark = Company.builder().id(12L).name("Lexmark Research & Development Corporation")
          .description(
              "Research and development for Lexmark printing and imaging " + "technologies")
          .tags(List.of("Printing", "Imaging Technologies"))
          .addressLine1("Mactan Island, Cebu, Philippines")
          .addressLine2("Mactan Export Processing Zone").yearEstablished(1997)
          .noOfEmployeesMin(1001).noOfEmployeesMax(5000).contactEmail("lexmark@email.com").build();
      lexmark = companyRepository.save(lexmark);

      var rococo = Company.builder().id(13L).name("Rococo Global Technologies")
          .description("Information technology and business process outsourcing company")
          .tags(List.of("IT", "BPO")).addressLine1("Cebu City, Cebu, Philippines")
          .addressLine2("JY Square Building, Salinas Drive").yearEstablished(2003)
          .noOfEmployeesMin(2001).noOfEmployeesMax(10000).contactEmail("rococo@email.com").build();
      rococo = companyRepository.save(rococo);

      var cebuPelisInstitute = Company.builder().id(15L).name("Cebu Pelis Institute")
          .description("Vocational school offering film and media courses")
          .tags(List.of("Film", "Media")).addressLine1("Cebu City, Cebu, Philippines")
          .addressLine2("Gorordo Avenue, Lahug").yearEstablished(1993).noOfEmployeesMin(51)
          .noOfEmployeesMax(250).contactEmail("cebupelis@email.com").build();
      cebuPelisInstitute = companyRepository.save(cebuPelisInstitute);
      var accentureInc = Company.builder().id(16L).name("Accenture, Inc.")
          .description("Multinational professional services company")
          .tags(List.of("Consulting", "Technology")).addressLine1("Multiple locations worldwide")
          .addressLine2("Cebu address - Cebu I.T. Park, Asiatown").yearEstablished(1989)
          .noOfEmployeesMin(100001).noOfEmployeesMax(500000).contactEmail("accenture@email.com")
          .build();
      accentureInc = companyRepository.save(accentureInc);
      var achieveWithoutBorders = Company.builder().id(17L).name("Achieve Without Borders Inc.")
          .description("Non-profit organization focused on education and " + "development")
          .tags(List.of("Non-Profit", "Education")).addressLine1("Cebu City, Cebu, Philippines")
          .addressLine2("Specific address unavailable").yearEstablished(2000).noOfEmployeesMin(21)
          .noOfEmployeesMax(100).contactEmail("achievewithoutborders@email.com").build();
      achieveWithoutBorders = companyRepository.save(achieveWithoutBorders);
      var symph = Company.builder().id(18L).name("Symph").description("Description unavailable")
          .tags(List.of()).addressLine1("Cebu City, Cebu, Philippines")
          .addressLine2("Address unavailable").yearEstablished(2012).noOfEmployeesMin(51)
          .noOfEmployeesMax(250).contactEmail("symph@email.com").build();
      symph = companyRepository.save(symph);
      var makerSpace = Company.builder().id(19L).name("MakerSpace")
          .description("Community workshop and co-working space")
          .tags(List.of("Co-working", "Makerspace"))
          .addressLine1("Mandaluyong City, Metro Manila, Philippines")
          .addressLine2("ϺΕΤΡΟΠΟΛΙΣ (Metropolis) Plaza").yearEstablished(2014).noOfEmployeesMin(11)
          .noOfEmployeesMax(50).contactEmail("makerspace@email.com").build();
      makerSpace = companyRepository.save(makerSpace);
      var southernTaiwanUniversityOfScienceAndTechnologyCebuInstituteofTechnology = Company
          .builder().id(20L)
          .name(
              "Southern Taiwan University of Science & Technology - Cebu Institute of Technology University Makerspace")
          .description("Makerspace affiliated with Cebu Institute of Technology")
          .tags(List.of("Makerspace")).addressLine1("Cebu City, Cebu, Philippines")
          .addressLine2("Cebu Institute of Technology - University").yearEstablished(2018)
          .noOfEmployeesMin(6).noOfEmployeesMax(15)
          .contactEmail("southertaiwanuniversity@email.com").build();

      southernTaiwanUniversityOfScienceAndTechnologyCebuInstituteofTechnology = companyRepository
          .save(southernTaiwanUniversityOfScienceAndTechnologyCebuInstituteofTechnology);

      var allianceSoftwareInc = Company.builder().id(21L).name("Alliance Software, Inc.")
          .description("Software development company").tags(List.of("Software Development"))
          .addressLine1("Cebu City, Cebu, Philippines").addressLine2("IT Park, Asiatown")
          .yearEstablished(1999).noOfEmployeesMin(501).noOfEmployeesMax(2500)
          .contactEmail("alliancesoftware@email.com").build();
      allianceSoftwareInc = companyRepository.save(allianceSoftwareInc);

      var citUniversityMakerspace = Company.builder().id(23L).name("CIT University Makerspace")
          .description("Makerspace affiliated with Cebu Institute of Technology")
          .tags(List.of("Makerspace")).addressLine1("Cebu City, Cebu, Philippines")
          .addressLine2("Cebu Institute of Technology - University").yearEstablished(2016)
          .noOfEmployeesMin(6).noOfEmployeesMax(15)
          .contactEmail("cituniversitymakerspace@email.com").build();
      citUniversityMakerspace = companyRepository.save(citUniversityMakerspace);

      var pearlpay =
          Company.builder().id(26L).name("PearlPay").description("Description " + "unavailable")
              .tags(List.of()).addressLine1("Cebu City, Cebu, Philippines")
              .addressLine2("Address unavailable").yearEstablished(2015).noOfEmployeesMin(51)
              .noOfEmployeesMax(250).contactEmail("pearlpay@email.com").build();
      pearlpay = companyRepository.save(pearlpay);

      var advanceExteriorsAndRenovationInc = Company.builder().id(26L)
          .name("Advance Exteriors and Renovation Inc.").description("Description " + "unavailable")
          .tags(List.of()).addressLine1("Cebu City, Cebu, Philippines")
          .addressLine2("Address unavailable").yearEstablished(2015).noOfEmployeesMin(51)
          .noOfEmployeesMax(250).contactEmail("advanceexteriorsandrenovation@email.com").build();
      advanceExteriorsAndRenovationInc = companyRepository.save(advanceExteriorsAndRenovationInc);

      var primarySoftwareDevelopmentCorporation =
          Company.builder().id(27L).name("Primary Software Development Corporation")
              .description("Description " + "unavailable").tags(List.of())
              .addressLine1("Cebu City, Cebu, Philippines").addressLine2("Address unavailable")
              .yearEstablished(2015).noOfEmployeesMin(51).noOfEmployeesMax(250)
              .contactEmail("primarysoftwaredevelopment@email.com").build();
      primarySoftwareDevelopmentCorporation =
          companyRepository.save(primarySoftwareDevelopmentCorporation);

      var municipalityOfBienUnido = Company.builder().id(28L).name("Municipality of Bien Unido")
          .description("Description " + "unavailable").tags(List.of())
          .addressLine1("Bohol, Philippines").addressLine2("Address unavailable")
          .yearEstablished(2015).noOfEmployeesMin(51).noOfEmployeesMax(250)
          .contactEmail("municipalityofbienunido@email.com").build();
      municipalityOfBienUnido = companyRepository.save(municipalityOfBienUnido);

      var samjangFoodInc = Company.builder().id(29L).name("Samjang Food Inc.")
          .description("Description " + "unavailable").tags(List.of())
          .addressLine1("Cebu City, Cebu, Philippines").addressLine2("Address unavailable")
          .yearEstablished(2015).noOfEmployeesMin(51).noOfEmployeesMax(250)
          .contactEmail("samjangfoodinc@email.com").build();
      samjangFoodInc = companyRepository.save(samjangFoodInc);

      var theUmonicsMethodLtd = Company.builder().id(30L).name("The Umonics Method Ltd.")
          .description("Description " + "unavailable").tags(List.of())
          .addressLine1("Cebu City, Cebu, Philippines").addressLine2("Address unavailable")
          .yearEstablished(2015).noOfEmployeesMin(51).noOfEmployeesMax(250)
          .contactEmail("theumonicsmethod@email.com").build();
      theUmonicsMethodLtd = companyRepository.save(theUmonicsMethodLtd);

      var archivusIncorporated = Company.builder().id(31L).name("Archivus Incorporated")
          .description("Description " + "unavailable").tags(List.of())
          .addressLine1("Cebu City, Cebu, Philippines").addressLine2("Address unavailable")
          .yearEstablished(2015).noOfEmployeesMin(51).noOfEmployeesMax(250)
          .contactEmail("archivusincorporated@email.com").build();
      archivusIncorporated = companyRepository.save(archivusIncorporated);

      jobListingRepository.save(JobListing.builder().company(symph).datePosted(LocalDateTime.now())
          .jobTitle("Software Engineer Intern").jobDescription("Develop software applications")
          .datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(makerSpace)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder()
          .company(southernTaiwanUniversityOfScienceAndTechnologyCebuInstituteofTechnology)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(allianceSoftwareInc)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(citUniversityMakerspace)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(pearlpay)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(advanceExteriorsAndRenovationInc)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(primarySoftwareDevelopmentCorporation)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(municipalityOfBienUnido)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(theUmonicsMethodLtd)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(archivusIncorporated)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());

      jobListingRepository.save(JobListing.builder().company(intellisenseInstituteOfTechnology)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(welaOnlineCorporation)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(accentureInc)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(cebuInstituteOfTechnologyUniversity)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(CITUWildcatInnovationLabs)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(ONGSalazarBusiness)
          .datePosted(LocalDateTime.now()).jobTitle("Software Engineer Intern")
          .jobDescription("Develop software applications").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(fullScale)
          .datePosted(LocalDateTime.now()).jobTitle("Data Analyst Intern")
          .jobDescription("Analyze and interpret data").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(trustArc)
          .datePosted(LocalDateTime.now()).jobTitle("Marketing Intern")
          .jobDescription("Assist in marketing campaigns").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(maranga)
          .datePosted(LocalDateTime.now()).jobTitle("Human Resources Intern")
          .jobDescription("Support HR operations").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(goodApps)
          .datePosted(LocalDateTime.now()).jobTitle("Graphic Design Intern")
          .jobDescription("Create visual content").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(achieveWithoutBorders)
          .datePosted(LocalDateTime.now()).jobTitle("Finance Intern")
          .jobDescription("Assist in financial analysis").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(lexmark)
          .datePosted(LocalDateTime.now()).jobTitle("Project Management Intern")
          .jobDescription("Support project planning and execution").datePosted(LocalDateTime.now())
          .build());
      jobListingRepository.save(JobListing.builder().company(rococo).datePosted(LocalDateTime.now())
          .jobTitle("Customer Service Intern").jobDescription("Assist customers with inquiries")
          .datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(accentureInc)
          .datePosted(LocalDateTime.now()).jobTitle("Sales Intern")
          .jobDescription("Support sales team").datePosted(LocalDateTime.now()).build());
      jobListingRepository.save(JobListing.builder().company(cebuPelisInstitute)
          .datePosted(LocalDateTime.now()).jobTitle("Quality Assurance Intern")
          .jobDescription("Assist in testing software products").datePosted(LocalDateTime.now())
          .build());
      var companyEvaluation1 = new CompanyEvaluationRequest(
          advanceExteriorsAndRenovationInc.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
          "Making a website with customers is a great experience, you will be able to improve "
              + "yourself to have a higher standards and meet the customers' needs. Website "
              + "Performance and Security was the most challenging thing to do in my time of "
              + "training.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation1,
          student.getAccountInformation());

      var companyEvaluation2 = new CompanyEvaluationRequest(maranga.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "My OJT at Maranga Software Solutions was definitely enjoyable. Throughout and after "
              + "my" + " training, I had many realizations. This opportunity provided me with the"
              + " "
              + "opportunity to demonstrate my abilities and knowledge while also learning. I am "
              + "grateful to have had the opportunity to learn about the industry early on and to"
              + " "
              + "have the feeling and experience of a true professional. I am very grateful to be"
              + " "
              + "an intern at Maranga Software Solutions because it has allowed me to grow not "
              + "only"
              + " professionally but also personally. I won't have it any other way. And I'm sure"
              + " " + "that in the future,  I'll look back on my time here with positive feeling.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation2,
          student.getAccountInformation());

      var companyEvaluation3 = new CompanyEvaluationRequest(
          primarySoftwareDevelopmentCorporation.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
          "It's not pressure while I am having my training in this company. I learned "
              + "self-study" + " "
              + "while learning the programming language which are Python and Delphi with fun.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation3,
          student.getAccountInformation());

      var companyEvaluation4 = new CompanyEvaluationRequest(
          primarySoftwareDevelopmentCorporation.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
          "As an Intern, I was both eager and worried, yet inside this organization, I "
              + "discovered"
              + " the work-life balance. I virtually meet the company's CEO and employees. I "
              + "learned a lot of stuff, such as new IDES and programming languages. All I can "
              + "say" + " " + "is that I am prepared to tackle the real-world IT Industry. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation4,
          student.getAccountInformation());

      var companyEvaluation5 = new CompanyEvaluationRequest(rococo.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "At first diving into the ROCOCO the software is familiar to me since i've dealt with"
              + " " + "a"
              + " similar software that ROCOCO used, and actually it was a really pleasant "
              + "experience for especifically on how they handle the interns, for me at least i "
              + "have a very pleasant and i am at ease during my internship due to how "
              + "understanding the coordinators and heads are, at first i have a problem with my "
              + "time schedule and how inconsistent my work is due to internet connection since "
              + "typhoon odette just hit our region, but i've still manage since the company "
              + "understands the situation and overall i have a very pleasant experience with "
              + "ROCOCO as a company and being an intern in ROCOCO as well.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation5,
          student.getAccountInformation());

      var companyEvaluation6 = new CompanyEvaluationRequest(rococo.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "It was a great experience being part of this company. Through this company, I was "
              + "able"
              + " to grow and enhance my knowledge when deploying service requirements. This "
              + "company thought me how to work easy implementation the company requirements and "
              + "operations. Overall, Rococo is a great company for young professionals looking "
              + "to" + " " + "grow their careers. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation6,
          student.getAccountInformation());

      var companyEvaluation7 = new CompanyEvaluationRequest(rococo.getId(), true, "",
          ExperienceEvaluation.GOOD,
          "Overall the new technologies introduced was good and the mentors assigned was "
              + "knowledgeable with the platform but I would have preferred that they do a more "
              + "hands-on approach with the OJT. Would have been nice if assigned to a "
              + "company-client" + " " + "project.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation7,
          student.getAccountInformation());

      var companyEvaluation8 = new CompanyEvaluationRequest(rococo.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I loved it. The environment of the company was friendly and accomodating. They "
              + "assigned us to develop a reservation system. Though it was challenging at first "
              + "because the tech is new to us but then, right after getting to know the tech, I "
              + "realized that it runs so smoothly. Meanwhile, in terms of handling us, it really"
              + " " + "was not pressure. They just let us be with how many tasks are we going to "
              + "complete"
              + " within the week. And most of all, the weekly allowance gave me the strength to "
              + "strive harder hehe. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation8,
          student.getAccountInformation());

      var companyEvaluation9 = new CompanyEvaluationRequest(rococo.getId(), true, "",
          ExperienceEvaluation.GOOD,
          "Rococo Global Technologies is a great company for OJTs. You are given an allowance, "
              + "you "
              + "are given free PhilNITS training and review, and you are also given learning "
              + "modules" + " "
              + "for ServiceNow. At first I did not enjoy my time at the company, simply because "
              + "I" + " " + "was" + " "
              + "not satisfied with the technology used which is ServiceNow and low-code as I "
              + "wanted " + "to"
              + " write code using frameworks based on their website. But overall, my OJT was "
              + "great" + ". "
              + "The only thing that I did not like is how the management handled the interns. "
              + "There " + "is"
              + " barely any interaction between the OJTs and the employees outside of the weekly"
              + " "
              + "progress reports. It would've been nice if Rococo integrated the interns into "
              + "the" + " "
              + "actual teams so that the interns could learn how projects are done, how teams at"
              + " " + "the" + " "
              + "company work. But for the duration of my OJT, we are only given a project and "
              + "that's" + " " + "it.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation9,
          student.getAccountInformation());

      var companyEvaluation10 = new CompanyEvaluationRequest(rococo.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "My experience while training in this company was quite challenging. For the first 10"
              + " "
              + "days, I am tasked with a PhilNITS Review wherein there are pre and post-tests "
              + "given. Afterward, a 3-week training started for the ServiceNow Platform. At "
              + "first,"
              + " I was pretty intimidated when I started exploring the platform since it's a big"
              + " "
              + "platform with lots of different modules, each of which has its own features. I "
              + "was"
              + " confused at first, but I started to get familiar with it later on. and what I "
              + "like about it is that it's very flexible and since it's cloud-based my laptop "
              + "won't stress with the storage unlike before. It's a great experience to learn "
              + "about this kind of platform. I also appreciate the immediate head assigned for "
              + "the"
              + " project that I am tasked for. There were lots of base functionalities that were"
              + " "
              + "given to complete the system, but with the guidance of Ms. Kish and Sir Reymark,"
              + " " + "I"
              + " managed to complete the system with my project partner on time. It is also very"
              + " " + "important to be keen on attendance and to manage your time properly. Every"
              + " " + "Friday,"
              + " there is a weekly progress meeting wherein the system's progress is to be "
              + "reported to everyone. There are set of feedback and suggestions, in such a way "
              + "we'll be able to deliver the application accordingly.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation10,
          student.getAccountInformation());

      // Wela Online Corp - No Recommendation
      var companyEvaluation11 = new CompanyEvaluationRequest(welaOnlineCorporation.getId(), false,
          """
              I think that there are other companies that offer the same training with allowances and have minimal responsibility as interns. In my opinion, I exerted a lot of effort in this training but still got a low grade from them. Sometimes I noticed there was no hierarchy in the management and I didn't really know how to address them or that there was no room for improvement because sometimes the work we do there is all the same sometimes. And when we were given a new task, it was kind of vague, or maybe we had no knowledge of how to do it.\s
              Sometimes one of my mentors (I'm not going to mention his name) responds with sarcasm when I'm trying to politely ask questions. When I try to ask a favor, they get mad because I did not email them my favor and that my request should have been days before my absence. I told them that it was urgent because my high school did not allow emails and that I needed to pass it by hand, but they were still offended.
              One time, I was a little late because I was sick. Instead of addressing it to me directly, they posted it on the channel several times and told me that if it was a real job, we would be fired immediately, so when I asked for an apology (I messaged the head privately), they just told me it was okay. I got confused. I thought they were mad.
              I thought they'd be nice to us since they greeted us nicely during the orientation. They are quite laid back now, which is why I was sure I'd be doing my OJT with this company because they were nice at first.
              """,
          ExperienceEvaluation.GOOD,
          """
              At first I was kind of worried because I thought that my laptop would not be able to perform dual boot because their framework is run through a Linux system. and also whether the storage will be enough for the software needed for the training. I had several trials at first because even though I was not so sure whether my laptop would be able to perform, I was kind of excited to learn a new framework and so it was successful after several attempts.While training, they provided links to resources on what their company uses and some exercises on how to perform basic python functions and such. After training successfully, the intern will be given some credentials to the company's project repository in gitlab to start a task. After that, the project managers will give these new tasks given by different schools (since it's a school system company). It was fun at first, but then I think I got a little burnout from doing some unfinished tasks that will take up much of my time.
              """);
      companyEvaluationService.createCompanyEvaluation(companyEvaluation11,
          student.getAccountInformation());

      var companyEvaluation12 = new CompanyEvaluationRequest(
          cebuInstituteOfTechnologyUniversity.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
          "My training at CITU is more than just a training because I was tasked with "
              + "developing" + " "
              + "a system that will be used by CITU executives in the future.  My task was to "
              + "build"
              + " a data visualizer of CITU enrollment levels and trends using Microsoft Power BI"
              + " "
              + "as the system's foundation. It was not an easy task because, first and foremost,"
              + " " + "I"
              + " am the sole developer of the system, and I must conduct research on every "
              + "aspect" + " "
              + "of the system, including design, user experience, delivery, calculations, and "
              + "data"
              + " visuals. The same is true for my fellow trainees; they each have their own "
              + "project, so we don't help one another; the only person who can assist us is our "
              + "mentor/head coordinator. I was not interested in training at CITU because it is "
              + "where I study; instead, I want to be exposed to external industries so that I "
              + "can" + " "
              + "learn how to interact with people I have never met. However, I realized that "
              + "being"
              + " well-trained is not determined by where you train, but rather by how you train "
              + "and execute yourself in the industry.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation12,
          student.getAccountInformation());

      var companyEvaluation13 = new CompanyEvaluationRequest(accentureInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I totally recommend this Internship Program. This Internship Program by Accenture "
              + "has" + " "
              + "helped me become Industry Ready. I have experience with change and unique "
              + "learning"
              + " opportunities that help me grow my skills, industry knowledge, and capabilities"
              + " " + "that will eventually help to build my career in the future.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation13,
          student.getAccountInformation());

      var companyEvaluation14 = new CompanyEvaluationRequest(welaOnlineCorporation.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "I had fun and a great experience while training in Wela Online Corp. Although I have"
              + " "
              + "met a few challenges doing some tasks, it is not hard to ask them (Supervisors"
              + " " + "and"
              + " other Senior IT Techs) for help. They are very helpful and understanding.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation14,
          student.getAccountInformation());

      var companyEvaluation15 = new CompanyEvaluationRequest(municipalityOfBienUnido.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "I learned a lot from them. There are a lot of things they shared to us especially on"
              + " " + "how to minimize loading time on a website.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation15,
          student.getAccountInformation());

      var companyEvaluation16 = new CompanyEvaluationRequest(municipalityOfBienUnido.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "No pressure is done, They are very Considerate and will train you to easy to hard. "
              + "We" + " "
              + "did our project back in Feb second week and the mentor let us choose to be hard "
              + "or" + " easy. It was a fun experience and the mentor is like our big Kuya who is"
              + " " + "jamming,"
              + " and serious when it comes to work. Overall it was a Very Good experience. "
              + "really" + " " + "recommend this municipality.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation16,
          student.getAccountInformation());

      var companyEvaluation17 = new CompanyEvaluationRequest(municipalityOfBienUnido.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "I really learned a lot in this Municipality as an OJT especially on how to be "
              + "professional in the work place and also, I have enhance my skills in designing "
              + "websites using pure HTML and CSS only. Also, the mentor was approachable and "
              + "really shared his knowledge to us about how to develop a secure and reliable "
              + "website and help us to be a better programmer. We are hoping to work in this "
              + "municipality someday.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation17,
          student.getAccountInformation());

      var companyEvaluation18 = new CompanyEvaluationRequest(municipalityOfBienUnido.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "I learned a lot from training that can be useful for me in the future. The company "
              + "taught me unique techniques to make the system faster, unique ways of coding, "
              + "and" + " "
              + "lastly the company taught me how to handle working with a team of people to have"
              + " " + "teamwork to make the project faster and better.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation18,
          student.getAccountInformation());

      var companyEvaluation19 = new CompanyEvaluationRequest(municipalityOfBienUnido.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "The head and mentor was really friendly to me during my internship and they taught "
              + "me" + " "
              + "a lot about programming languages and its importance. The only challenge I" + " "
              + "experienced working with the organization was to reach them out virtually due to"
              + " "
              + "low-signal but thankfully they still managed to make it on time. It was a great "
              + "experience for me.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation19,
          student.getAccountInformation());

      var companyEvaluation20 = new CompanyEvaluationRequest(municipalityOfBienUnido.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "I experienced on how to learn to adapt within the company by coordinating with the "
              + "groups on how to solve each problems which regards to the work given by our "
              + "instructor. Time also can be a vital piece that is necessary to manage the work "
              + "instead of waiting until the last possible moment. Moreover, organize can also "
              + "be" + " " + "important, too.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation20,
          student.getAccountInformation());

      var companyEvaluation21 = new CompanyEvaluationRequest(municipalityOfBienUnido.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "I learned how to engage and communicate with others through trial and error. It's "
              + "critical to know how to handle and address various difficulties while remaining "
              + "polite in both action and speech. I've also discovered that good time management"
              + " "
              + "is essential since it allows you to avoid stress by completing tasks on time "
              + "rather than waiting until the last minute. I'll be more organized and plan ahead"
              + " " + "of time to better manage my time.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation21,
          student.getAccountInformation());

      var companyEvaluation22 = new CompanyEvaluationRequest(lexmark.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          " I highly recommend this company to other students because they treat their interns "
              + "as"
              + " employees alike. Work is given that is beneficial to the business as well as "
              + "training on what ought our work should be. Opinions from interns are valued and "
              + "they ask for our inputs as well. The people in this company are very kind and "
              + "professional as well. We have a 1x1 meeting with our manager every 2 weeks and "
              + "we" + " "
              + "hold daily standups. I practiced my communication here as well as having "
              + "workarounds in case I hit a wall. Efforts as interns are valuable to them and "
              + "observed by them all throughout the course. In my case, I was offered by our "
              + "manager a place in their and also I was recommended by our manager for the UX "
              + "designer job position in their company. Overall, it's a very great experience "
              + "working with professionals.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation22,
          student.getAccountInformation());

      var companyEvaluation23 = new CompanyEvaluationRequest(lexmark.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I was assigned to a software project and was tasked to code bug fixes and new "
              + "features"
              + " under active supervision of a mentor with a lot of experience in the industry. "
              + "My"
              + " mentor and hiring manager provided insights and feedback about my future career"
              + "." + " "
              + "They were also approachable and you could even ask for life advices and tips. "
              + "When"
              + " I went to the office to submit the physical copy of my requirements, I was "
              + "given" + " " + "a free lunch at Ayala and a quick tour at Lexmark.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation23,
          student.getAccountInformation());

      var companyEvaluation24 = new CompanyEvaluationRequest(lexmark.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "Being an intern in Lexmark is like being at the very first step of becoming a real "
              + "employee in the industry. First, the HR were really hospitable and extremely "
              + "kind" + "."
              + " Second, we were given our official ID badge and were lent our own laptop units "
              + "that we could use to work like the rest of the employees are in our work from "
              + "home" + " setup. And third, we were given allowance every 2 weeks like the other"
              + " " + "employees" + " "
              + "so we had the chance to experience how it feels like to receive those incentives"
              + "." + " "
              + "Aside from these, we also enjoy a flexible working hours (plus and minus 2 hours"
              + " "
              + "of our on the dot schedule which is at 9 am) since our manager is not really so "
              + "strict in terms of our working hours as long as we render 8 hours a day and "
              + "overlap majorly with the other employees.   While training in Lexmark, I was "
              + "able" + " "
              + "to get exposed of how the work environment is like there, specifically in thr "
              + "department where I took my training in. I was not loaded with so many tasks at a"
              + " "
              + "time, instead, the tasks were rather given at a reasonable amount of period. In "
              + "addition to this, I was given tasks that were really important and in lined with"
              + " "
              + "my field of interest. I did not experience being given with tasks which made me "
              + "feel like I was inferior from the rest, because the tasks I worked on were as "
              + "important as theirs. Aside from working on these tasks, I, along with my "
              + "co-interns, were given the chance to attend various free trainings that helped "
              + "us" + " "
              + "get familiar with the tools and workarounds as well as opportunities to gain "
              + "certifications from Microsoft Courses such us Azure Fundamentals, Data "
              + "Engineering, and the like, still for free. . My mentor would always praise me "
              + "for" + " "
              + "my practice of working fast and accurately, but I think the biggest credit must "
              + "be"
              + " to her and the entire team since they always make sure that the tasks are well "
              + "explained and discussed before designating them to me, that is why I get to work"
              + " "
              + "on them with minimal problems. The team was also very considerate of the interns"
              + "." + " "
              + "No matter how busy they were, they would take time to attend to my concerns and "
              + "questions every time I encounter some. I really learned so much in the past "
              + "three" + " "
              + "months by doing and being exposed to real tasks. Even just being an intern, I "
              + "had" + " "
              + "the chance to get to know the benefits of being a part of Lexmark. From the free"
              + " " + "medical assessments as one of the requirement of the hiring process, to the "
              + "bi-monthly allowance, up until the work-life balance they want their employees "
              + "to" + " "
              + "practice, I can really say that Lexmark does treat their employees well and I "
              + "highly recommend them as an Industry Partner for the future internships.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation24,
          student.getAccountInformation());

      var companyEvaluation25 = new CompanyEvaluationRequest(welaOnlineCorporation.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "The company's staffs were all helpful. We were given time to train and familiarize "
              + "ourselves with the new framework, but we were not oriented properly on how their"
              + " "
              + "systems work which resulted in us to keep asking questions. The tasks given were"
              + " "
              + "okay, some tasks are easy, some tasks are moderately hard, and some tasks are "
              + "hard"
              + " but still doable. The company lacks interaction with its interns, there were no"
              + " "
              + "virtual meetings at all after the orientation. We were required to give updates "
              + "during stand-up meetings but it was done through typing. I also think that we "
              + "were"
              + " evaluated too low even if we did our tasks. All in all, it was still a great "
              + "experience for us interns.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation25,
          student.getAccountInformation());

      var companyEvaluation26 = new CompanyEvaluationRequest(samjangFoodInc.getId(), false,
          "I would not recommend this company because an IT/CS students must prefer to go to an IT "
              + "company and deserves to have a proper training for them to be equipped in work life.",
          ExperienceEvaluation.GOOD,
          "My experience was good because I was able to do my tasks based on my background "
              + "knowledge" + " "
              + "from school and applied my learnings on the different tasks and projects assigned "
              + "to" + " "
              + "me during my OJT. My training is not that kind of difficult because I am familiar"
              + " " + "with"
              + " the tools needed to accomplish my tasks and projects. My communication skills was"
              + " "
              + "enhanced during the training because everyday I am communicating with other people"
              + " " + "and"
              + " working on different teams. Even if this company is not IT based they provide us "
              + "IT" + " "
              + "related works for IT students like me but they only offer limited tasks and I "
              + "don't "
              + "really feel the IT experience on this company because it is not on their focus.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation26,
          student.getAccountInformation());

      var companyEvaluation27 = new CompanyEvaluationRequest(samjangFoodInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "It's been really fun and memorable to be in this company. I have learned so many "
              + "things as an intern. They taught me how to be a team player and also how to do "
              + "the"
              + " right time management. I am truly grateful for all the learnings they imparted "
              + "to" + " me.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation27,
          student.getAccountInformation());

      var companyEvaluation28 = new CompanyEvaluationRequest(samjangFoodInc.getId(), true, "",
          ExperienceEvaluation.GOOD,
          "I was able to use my skills in website development in real life. Being able to be "
              + "part" + " " + "of" + " "
              + "a team to implement a POS with inventory system for a restaurant is an honor for"
              + " " + "me.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation28,
          student.getAccountInformation());

      var companyEvaluation29 = new CompanyEvaluationRequest(samjangFoodInc.getId(), false,
          "I believe IT/CS students should go to an IT based company or other companies so that the "
              + "trainings are more efficient.",
          ExperienceEvaluation.GOOD,
          "My experience was good, the handlers were cooperative and always find time to assist "
              + "me "
              + "especially if I have concerns. I was also able to apply the learnings that were "
              + "taught"
              + " in the school and enhance my social skills. The way they handle their interns is"
              + " " + "not" + " "
              + "as strict and as difficult as I thought it would be, because they always gives us"
              + " "
              + "freedom to choose the tools/languages to be used on our assigned tasks. Although "
              + "it " + "is"
              + " not an IT based company, they still provided us IT related tasks, however, the "
              + "tasks" + " "
              + "are limited and I don't think my IT experience is enough for me to recommend this"
              + " " + "company.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation29,
          student.getAccountInformation());

      var companyEvaluation30 = new CompanyEvaluationRequest(theUmonicsMethodLtd.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "The IT department of The Umonics Method has a good environment which can help the "
              + "student grow and learn more about how to work in a company and how to get a long"
              + " " + "with other employees.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation30,
          student.getAccountInformation());

      var companyEvaluation31 = new CompanyEvaluationRequest(lexmark.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "Having my internship in this company is a grateful privilege for me knowing that "
              + "this" + " "
              + "is not just an international company, but also a great place to work with other "
              + "exemplary employees. The head of our area and my manager always ensure that I am"
              + " "
              + "doing well by organizing a meeting, which is also applicable to other regular "
              + "employees. I am part of the Mobile team and my co-workers are very approachable "
              + "wherein they will help me once I need assistance. Regarding the training plan "
              + "made"
              + " by my manager and mentor, they ensure that the intern is not bombarded with "
              + "tasks"
              + " that are only possible for highly experienced developers. For the first two "
              + "weeks, they gave me links for the videos and code lab exercises to work on. "
              + "After" + " "
              + "that, they gave me a choice on what final project to implement so that I can be "
              + "confident and more knowledgeable about the scope of the project. For every "
              + "successful implementation, I am advised by my mentor to organize a meeting for "
              + "my" + " "
              + "demo of the implemented feature. Most of my team members gave their advice if "
              + "there are any, and I am the one who will consider those suggestions. My "
              + "implemented features are then pushed to my GitHub using my corporate account, "
              + "and" + " "
              + "every created Pull Requests (PR) should be reviewed by at least 3 members of the"
              + " "
              + "team before it will be merged to the master or main. There are cases where they "
              + "will comment on the PR for suggestions or recommendations to make my code "
              + "cleaner" + " "
              + "and easier to maintain in the future. My area, Software and Solutions, also have"
              + " "
              + "events wherein I am invited to join. There will be an organized meeting for the "
              + "demos of all the interns in the area. Those demos are our accomplishments from "
              + "day"
              + " 1 up to the scheduled meeting of our internship. The goal of their internship "
              + "is" + " "
              + "to give their trainees a job offer once they are performing well. All the "
              + "employees in my area are very friendly and vibing.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation31,
          student.getAccountInformation());

      var companyEvaluation32 = new CompanyEvaluationRequest(samjangFoodInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "For me, working on that company helped me a lot with my IT course. Although I have "
              + "many challenges during my training, still they provide quality assistance for "
              + "their trainee. Overall it was one of the unforgettable experience because I "
              + "learned a lot from their company that is very helpful to my future works.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation32,
          student.getAccountInformation());

      var companyEvaluation33 = new CompanyEvaluationRequest(samjangFoodInc.getId(), false,
          "The communication is a little bit lackadaisical.", ExperienceEvaluation.GOOD,
          "At first, everything went smoothly. We were given tasks immediately, but I already "
              + "noticed that there is something wrong with the means of communication because it"
              + " "
              + "is hard for us to communicate with our direct head. It would take at least a few"
              + " " + "hours to a few days before we can get a reply if we have concerns about the "
              + "project or tasks. The only time we can exchange communication fast is during "
              + "team/department meetings. We were also assigned HR handlers who are Psych "
              + "Interns" + " "
              + "for other concerns like the documents needed such as weekly logs and other" + " "
              + "requirements which they will forward to the corresponding persons. Their "
              + "internship is shorter than ours, so I was assigned to a total of 4 HR handlers. "
              + "It"
              + " was a little frustrating because I have to tell or inform each one of them "
              + "about" + " "
              + "my requirements and they kept asking me to resend my docs for their record. It "
              + "seems like there is mishandling of documents and it's frustrating because it's "
              + "their job to pass down the documents to the next handler before their "
              + "offboarding" + " "
              + "like how they inform us who our next handler is. All in all, my experience was "
              + "okay. It's not the best, but it's okay.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation33,
          student.getAccountInformation());

      var companyEvaluation34 = new CompanyEvaluationRequest(archivusIncorporated.getId(), true, "",
          ExperienceEvaluation.GOOD,
          "I experienced and learned a lot of things. I learned how to code WordPress themes, coded"
              + " "
              + "in PHP, designed webpages, designed graphics for social media posts, and edited "
              + "product photos. I learned how to be flexible and creative my way. I like how my "
              + "supervisor lets me do things on my own but also helps me when I am struggling. It "
              + "was" + " " + "a fun experience.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation34,
          student.getAccountInformation());

      var companyEvaluation35 = new CompanyEvaluationRequest(theUmonicsMethodLtd.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I became a frontend developer of the first version of mobile app of umonics, and I "
              + "become also a project manager. We encountered a new framework with the team and "
              + "it's called Ionic framework, eventually we find solutions on how we can implement "
              + "and run the designs and "
              + "features of the app. We also make a lot of different version of wireframes and "
              + "mock-ups for the mobile app of umonics. So far, I've enjoyed training with "
              + "umonics"
              + " because our friendship with my team and Head is growing stronger every day. "
              + "Thank" + " you, and God bless you.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation35,
          student.getAccountInformation());

      var companyEvaluation36 = new CompanyEvaluationRequest(theUmonicsMethodLtd.getId(), false,
          "System for their internship isn't well implemented.", ExperienceEvaluation.BAD,
          "IT Head is quite forgetful, has many good plans but forgets implementing them. Told us "
              + "that we were gonna create more UI/UX designs and was gonna teacher newly hired "
              + "interns"
              + " as well but never happened. Every other week I have nothing to do but stay in call "
              + "with everyone in my team muted. Only first few weeks have feedback on the outputs. "
              + "Lackluster schedule for interns.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation36,
          student.getAccountInformation());

      var companyEvaluation37 = new CompanyEvaluationRequest(theUmonicsMethodLtd.getId(), false,
          "The company is good but I think they are not ready to accommodate too many interns. "
              + "Instructions and tasks are all over the place.",
          ExperienceEvaluation.VERY_GOOD,
          "My experience was great and I learned a lot during the training. I also met people, and "
              + "was in a team with a good working environment. I learned how to be responsible and "
              + "how" + " to manage my time properly. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation37,
          student.getAccountInformation());

      var companyEvaluation38 = new CompanyEvaluationRequest(fullScale.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "Overall, I had a great experience in my on-the-job training at Full Scale. Full "
              + "Scale" + " "
              + "Internship Program, in my opinion, provides the best training with excellent and"
              + " "
              + "reliable learning resources. I also appreciate how they provide activities that "
              + "we" + " can participate in to boost our confidence.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation38,
          student.getAccountInformation());

      var companyEvaluation39 = new CompanyEvaluationRequest(symph.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "My internship experience at Symph was worthwhile because over the course of four "
              + "months, I learned, grew, and developed as a developer and as a person. As a "
              + "development intern, I spent the most of my time at Symph working with one "
              + "project" + " "
              + "team, where I felt encouraged and valued. Even though I was still learning the "
              + "tech stack, I was given tasks, which helped me learn better with the guidance of"
              + " "
              + "developers. In addition to the technical skills that I gained, I also learned to"
              + " " + "communicate and to be less afraid of failing. These made a significant "
              + "difference" + " "
              + "in my internship and my life. Overall, working at Symph as an intern was "
              + "enjoyable" + " and meaningful. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation39,
          student.getAccountInformation());

      var companyEvaluation40 = new CompanyEvaluationRequest(fullScale.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I really acquired a lot of valuable skills and learned about various topics that "
              + "weren't fully covered in the previous courses/subjects I took as an IT student. "
              + "There were also a lot of benefits. The employees and our mentor were all really "
              + "encouraging and they really provided us with guidance throughout the duration of"
              + " "
              + "our internship. Our mentor really emphasizes quality over quantity in learning "
              + "through the training courses included in the training plan, which really helped "
              + "us" + " to actually internalize what we're learning about.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation40,
          student.getAccountInformation());

      var companyEvaluation41 = new CompanyEvaluationRequest(
          intellisenseInstituteOfTechnology.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
          "my experience when I joined this company was very enjoyable and challenging because "
              + "in"
              + " this company you need to be keen in working and be positive always so that you "
              + "will be able to finish your work early, because the task they give you requires "
              + "teamwork and positive vibes leads the team to work faster. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation41,
          student.getAccountInformation());

      var companyEvaluation42 = new CompanyEvaluationRequest(
          intellisenseInstituteOfTechnology.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
          "My experience with the company is great, it helps you to have a clearer version on "
              + "the" + " path you will take in the future.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation42,
          student.getAccountInformation());

      var companyEvaluation43 = new CompanyEvaluationRequest(welaOnlineCorporation.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "It was a nice experience. I was exposed to how it is being with a group of Techy "
              + "people. Highly recommended for Interns. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation43,
          student.getAccountInformation());

      var companyEvaluation44 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.VERY_GOOD,
          "A very approachable head who's willing to give advice on what things to improve on "
              + "and"
              + " as well as a very accommodating person. The company has great facilities and "
              + "outstanding supervision. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation44,
          student.getAccountInformation());

      var companyEvaluation45 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.GOOD,
          "I gave them a fair good rating since we were their first batch of interns, they are "
              + "not "
              + "that prepared in handling interns. There are no mentors that guides the interns "
              + "and " + "do"
              + " code reviews. They are too lenient when it comes to people who are clearly lazy"
              + " " + "doing"
              + " their task, resulting to an overdue task. It's a bit unfair to people who works"
              + " " + "hard" + " "
              + "just to pass their assigned tasks. I know they have a lot of potential in "
              + "handling" + " " + "interns in the future.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation45,
          student.getAccountInformation());

      var companyEvaluation46 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.GOOD,
          "My experiences while training in the company was a mixed of different emotions. All "
              + "the "
              + "tasks assigned was all achievable, it's a mix of easy, medium, and hard tasks. "
              + "Some "
              + "takes only hours to do, some days, and there's a few that takes 1-2 weeks to "
              + "figure "
              + "out. The overall experience was all about self-learning and and teamwork. By "
              + "learning" + " "
              + "on my own and understanding the whole system that I was assigned to I got to "
              + "observed" + " "
              + "and realize some things and improve a part of myself for a bit.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation46,
          student.getAccountInformation());

      var companyEvaluation47 = new CompanyEvaluationRequest(ONGSalazarBusiness.getId(), false,
          "Their main business was for accounting but I was accepted as IT OJT due they want to "
              + "have" + " " + "an website for their business.",
          ExperienceEvaluation.VERY_GOOD,
          "we had an meeting if what can of website they want and they will not really give you "
              + "pressure because they want you to learn and feel experience if what it feels like to"
              + " " + "be in company. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation47,
          student.getAccountInformation());

      var companyEvaluation48 = new CompanyEvaluationRequest(fullScale.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "Though we were not exposed to a real project they are currently working on, I can "
              + "say" + " "
              + "that they really value us as they have given as time to review on what we have "
              + "learned and learn new things not taught in our classroom. In doing so, they have"
              + " " + "prepared us for the real battle once we are hired at their company.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation48,
          student.getAccountInformation());

      var companyEvaluation49 = new CompanyEvaluationRequest(municipalityOfBienUnido.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "Good training experience. Being able to work on projects with different people and "
              + "working as a back end developer despite the fact that I am only knowledgeable on"
              + " "
              + "front end. HR and Head of IT Department gives good guidance, approachable, fun"
              + " " + "to" + " "
              + "work and talk with. There are issues such as internet connectivity on their end "
              + "is" + " slow, which results they cannot be contacted in that moment.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation49,
          student.getAccountInformation());

      var companyEvaluation50 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.VERY_GOOD,
          "I am grateful to be a part of the developing team at CIT-U Wildcat Innovation Labs. "
              + "The learnings and friends that I made were a very great experience for me. Even "
              + "though I was not close with my teammates at first and instead of being on the "
              + "frontend side I was given the role of a backend developer. I took the "
              + "opportunity" + " "
              + "to get out of my comfort zone. My team and employers helped me accomplish my "
              + "tasks"
              + " well and be a better developer and a worker. All of these experiences I will "
              + "surely keep and hope to improve on later down the road.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation50,
          student.getAccountInformation());

      var companyEvaluation51 =
          new CompanyEvaluationRequest(trustArc.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
              "Being in this company is such a privilege. You are not considered as an intern "
                  + "because" + " you are exposed to the actual work with the regular employees. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation51,
          student.getAccountInformation());

      var companyEvaluation52 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.VERY_GOOD, "the company overall has a good environment");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation52,
          student.getAccountInformation());

      var companyEvaluation53 = new CompanyEvaluationRequest(maranga.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I really learned a lot while having my ojt in this company. I think that the tasks "
              + "given to me were at the right level. As a start-up company, there were times "
              + "when" + " "
              + "deadlines were tight so one had to work hard. It was also a good experience for "
              + "me" + " that I was able to work on an application that's already deployed. So I "
              + "experienced fixing small or critical bugs, which I think is a good experience "
              + "since analytical and tracing skills are needed. Overall, I was able to hone my "
              + "skills, both soft and technical skills. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation53,
          student.getAccountInformation());

      var companyEvaluation54 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.VERY_GOOD,
          "They made sure that we learn a lot as an OJT and gave us a chance to excel as "
              + "developers.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation54,
          student.getAccountInformation());

      var companyEvaluation55 =
          new CompanyEvaluationRequest(goodApps.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
              "I’ve been working my tasks independently, they are very open to questions.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation55,
          student.getAccountInformation());

      var companyEvaluation56 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.VERY_GOOD,
          "Our OJT coordinator, Mr. Rama is very understanding and helped us a lot with our "
              + "tasks" + ". I've enjoyed every meetings and huddles with him and our team.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation56,
          student.getAccountInformation());

      var companyEvaluation57 = new CompanyEvaluationRequest(
          cebuInstituteOfTechnologyUniversity.getId(), true, "", ExperienceEvaluation.GOOD,
          "Training in this company taught me how to work by myself and learn by myself.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation57,
          student.getAccountInformation());

      var companyEvaluation58 = new CompanyEvaluationRequest(lexmark.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "My experience working in Lexmark has been very fun and fruitful. In a span of just "
              + "three months, I was able to mature not only in terms of work values but also "
              + "personally. I learned how to act accordingly as an employee, not anymore as a "
              + "student. It allowed me to re-evaluate my values in school and connect it into "
              + "the" + " "
              + "corporate life. Just by being able to attend on site meetings at Lexmark brings "
              + "me"
              + " so much comfort and ease. I did not want to end my training without having to "
              + "experience working on site. I was able to present also in front of the managers "
              + "what I have been working on and it gives me so much joy to have been able to "
              + "listen to their positive feedbacks. This experience prepared me into much "
              + "greater" + " "
              + "things ahead because I know there will be a lot of reporting and presentations "
              + "in" + " "
              + "the corporate world. I would not be able to call it fun if it weren't for the "
              + "team"
              + " mates that I have. Although the time was short to get to know them better, I "
              + "was" + " "
              + "able to see and look into their personalities well. Their enthusiasm and their "
              + "open heartedness to accept me in the team made me really comfortable to work in "
              + "the team. It wasn't hard to connect with them even if it was a team of all girls"
              + " "
              + "because they all showed effort to make me feel part of the team. I'm also very "
              + "glad to have known more people outside of the team. It wasn't just me and the "
              + "team"
              + " but me and the department. I was also able to incorporate also my passion and "
              + "hobbies in the workplace which I really appreciate because I always wanted a job"
              + " " + "that keeps my passion burning.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation58,
          student.getAccountInformation());

      // companyEvaluation59
      var companyEvaluation59 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.VERY_GOOD,
          "Great Environment. Flexible time. Helps the trainee the value of teamwork especially"
              + " "
              + "in doing our deliverables on a project that was assigned to us. Our immediate "
              + "head/OJT coordinator is very patient, friendly, approachable and would always "
              + "ask" + " "
              + "for an update at least once a week on our progress so if there's any conflict or"
              + " "
              + "difficult situation we've encountered during the implementation of our task or "
              + "deliverables, he would help us or find a way to help us.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation59,
          student.getAccountInformation());

      // companyEvaluation60
      var companyEvaluation60 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.VERY_GOOD,
          "There is good communication between us interns and our supervisor in the company. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation60,
          student.getAccountInformation());

      // companyEvaluation61
      var companyEvaluation61 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.VERY_GOOD, "Its not as pressure unlike other comapnies");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation61,
          student.getAccountInformation());

      // companyEvaluation62
      var companyEvaluation62 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.VERY_GOOD,
          "Under the Wildcat Innovation Labs, I was challenged to produce a project using a "
              + "framework I have no prior knowledge before. This allowed me to enhance my "
              + "ability" + " "
              + "to read and comprehend a framework's documentation and continually improve my "
              + "study habits. Furthermore, I was able to improve my management skills after I "
              + "was" + " "
              + "assigned to lead the development team of the said project with the help of the "
              + "project manager. The work environment was relaxed, but invites challenge and "
              + "motivates improvement. Our mentors were professional during work and tries to "
              + "connect with us when otherwise. Overall, the experience I got from the company "
              + "was" + " exemplary.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation62,
          student.getAccountInformation());

      // companyEvaluation63
      var companyEvaluation63 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.VERY_GOOD, "Very approachable and understanding");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation63,
          student.getAccountInformation());

      // companyEvaluation64
      var companyEvaluation64 = new CompanyEvaluationRequest(CITUWildcatInnovationLabs.getId(),
          true, "", ExperienceEvaluation.VERY_GOOD,
          "Daunting at first because it might be your first time working in a professional "
              + "environment but Wildcats is friendly and kind enough to guide you in the "
              + "projects" + " " + "assigned to you and your team");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation64,
          student.getAccountInformation());

      // companyEvaluation65
      var companyEvaluation65 = new CompanyEvaluationRequest(
          cebuInstituteOfTechnologyUniversity.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
          "My overall experience as a trainee in CIT-U was exciting and at the same time "
              + "challenging since the project that I am assigned is a great help for the "
              + "employees"
              + " of CIT-U that are working from home. The department really handled me well.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation65,
          student.getAccountInformation());

      // companyEvaluation66
      var companyEvaluation66 = new CompanyEvaluationRequest(
          cebuInstituteOfTechnologyUniversity.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
          "Very open and considerate. Given the right circumstances, I could have done a lot "
              + "better because this company is excellent in handling their trainees.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation66,
          student.getAccountInformation());

      // companyEvaluation67 (assuming you want to continue numbering sequentially)
      var companyEvaluation67 = new CompanyEvaluationRequest(rococo.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "They're very accomodating to their trainees, they treat us professionally with "
              + "respect"
              + " and we have no problems in regards to inquiries and questions during our work "
              + "because they're very responsive and able to address our concerns right away.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation67,
          student.getAccountInformation());

      // companyEvaluation68
      var companyEvaluation68 = new CompanyEvaluationRequest(rococo.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I learned a lot during my internship with ROCOCO and I'm grateful for the "
              + "opportunity" + " "
              + "they had given me to work with them. They were very accommodating, kind, and "
              + "approachable. They answered every question we had and would make sure that we "
              + "had" + " "
              + "understood their instructions. They let us feel welcomed and I had a lot of fun "
              + "participating in their company activities such as their daily Chorei and their "
              + "monthly game event. I also learned a lot of useful things that I'm sure will "
              + "benefit me in the future. Overall, ROCOCO is a wonderful company to intern with.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation68,
          student.getAccountInformation());

      // companyEvaluation69
      var companyEvaluation69 = new CompanyEvaluationRequest(cebuPelisInstitute.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "Well, it was very indeed challenging and a fun experience overall. Since, I need to "
              + "learn a new framework from scratch, and apply it right away in the project. Even"
              + " "
              + "though the project is so pressure, the environment still is very positive and "
              + "still wants the best of me to learn and develop my technical skills.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation69,
          student.getAccountInformation());

      var companyEvaluation70 = new CompanyEvaluationRequest(accentureInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I received various trainings from the company. I also experience manual testing and "
              + "automation testing. I enjoyed the automation testing since I got the chance to "
              + "use" + " my programming skills. My supervisor and the company's HR are also very"
              + " " + "approachable and supportive.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation70,
          student.getAccountInformation());

      // companyEvaluation71
      var companyEvaluation71 = new CompanyEvaluationRequest(accentureInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I learned a lot working for this company. I learned about automation testing, the "
              + "work"
              + " of a test developer, and especially, what it feels like to be an employee for "
              + "the"
              + " first time. Moreover, our supervisor was really supportive and approachable. He"
              + " " + "shared his knowledge with us, his tips/techniques, and what the industry "
              + "prefers/common industry practices in terms of code. I gained worthwhile "
              + "experience"
              + " from them as they provided me with valuable skills and learning opportunities. "
              + "I" + " "
              + "am grateful that I applied to this company and I will surely utilize all the "
              + "learnings I gained in the future.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation71,
          student.getAccountInformation());

      // companyEvaluation72
      var companyEvaluation72 = new CompanyEvaluationRequest(rococo.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I was glad to be accepted as one of the interns for RGTC. The company prepared "
              + "materials for us to study and learn from every week. Our internship program was "
              + "focused on: PhilNITS Training and ServiceNow Training.  For the PhilNITS "
              + "Training,"
              + " we were given materials to review and we had to take an exam every morning and "
              + "afternoon for two weeks. Some questions are difficult and require more reading "
              + "and" + " studying. On the other hand, for our ServiceNow training, we started by"
              + " " + "studying" + " "
              + "the modules prepared in the platform. This is the first time I’ve heard of the "
              + "ServiceNow platform thus it took me time to get used to it. The learnings that I"
              + " " + "got from school were applicable during the whole period of our internship "
              + "program" + "."
              + " For our final project, we were given a week to finish the requirements/specs of"
              + " " + "our application. It was doable because we were divided into groups. Some "
              + "problems" + " "
              + "and issues occurred during the process but eventually, we find the right "
              + "solutions"
              + " to solve them. Our Supervisors were also approachable and kind to help and "
              + "answer"
              + " if ever we have problems or questions. Overall, it was a good experience "
              + "because" + " "
              + "I get to learn new things and was exposed to a little bit of Japanese culture. "
              + "Despite the pandemic happening, I’m really grateful that there is still a "
              + "company" + " " + "that accepts student interns and train them well. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation72,
          student.getAccountInformation());

      // companyEvaluation73
      var companyEvaluation73 = new CompanyEvaluationRequest(cebuPelisInstitute.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I learned a lot about making an application, pricing of an app and website, how we "
              + "should have a clear plan about everything to meet deadlines and finally, I "
              + "learned"
              + " to sort of deal with a client, sometimes they test your patience because they "
              + "can"
              + " be indecisive about things but of course we have to compose ourselves but it "
              + "was" + " " + "a good OJT experience nevertheless");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation73,
          student.getAccountInformation());

      // companyEvaluation74
      var companyEvaluation74 = new CompanyEvaluationRequest(rococo.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "Our supervisor and mentors were really approachable and they were keen in guiding us"
              + " " + "and how we were performing our activities. The activities for our OJT was "
              + "plotted" + " "
              + "in a way that it would not overwhelm us and which springs learning and "
              + "self-understanding in us trainees. I also had fun in experiencing the culture in"
              + " " + "this Japanese company. The way they handled the work-from-home set up was "
              + "amazing,"
              + " too good that it feels like we were working at the real office. Thus for "
              + "everything, I thank my host company Rococo.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation74,
          student.getAccountInformation());

      // companyEvaluation75
      var companyEvaluation75 =
          new CompanyEvaluationRequest(rococo.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
              "You can interact with them for any clarifications pretty much anytime during work. I"
                  + " "
                  + "think that's wonderful because it doesn't make you feel left out and there's "
                  + "always some guidance from them.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation75,
          student.getAccountInformation());

      // companyEvaluation76
      var companyEvaluation76 = new CompanyEvaluationRequest(accentureInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD, "I experienced automation scripting and testing.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation76,
          student.getAccountInformation());

      var companyEvaluation77 = new CompanyEvaluationRequest(cebuPelisInstitute.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "It was very nerve wracking, because it was a real job, and one mistake can mess up "
              + "the"
              + " whole team. It was not like you'll be trained closely by a supervisor, you have"
              + " "
              + "to learn everything by yourself. But nonetheless, it was a great experience. I"
              + " " + "got"
              + " to get a glimpse of what a real job looks like, how to handle clients' demands,"
              + " "
              + "how to be patient. I was able to practice what I learned in school in real life "
              + "settings and work with a team that is different to what my usual go-to group.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation77,
          student.getAccountInformation());

      // companyEvaluation78
      var companyEvaluation78 = new CompanyEvaluationRequest(accentureInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "It was a fun experience with also a lot of frustrating moments. Although I know some"
              + " "
              + "basics in coding, adapting to the company's standards and the platform they were"
              + " " + "using were really hard.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation78,
          student.getAccountInformation());

      // companyEvaluation79
      var companyEvaluation79 = new CompanyEvaluationRequest(achieveWithoutBorders.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "As an OJT Trainee, they gave me a task of making test cases for the new features "
              + "that" + " "
              + "they’ve implemented in their software product. I had a hard time understanding "
              + "before what Quality Assurance professionals does. So, I was concerned on how to "
              + "test the new features assigned to me and how to create test cases as well. I had"
              + " "
              + "to look at different perspective as a Quality Assurance intern. Aside from my "
              + "tasks, the atmosphere of the company was really great. They weren't just my "
              + "superiors or seniors in the company, they are also like ate's/kuya's. They are "
              + "very welcoming and always willing to help if I'm struggling with my tasks "
              + "especially if there are errors with the tools I am using. Aside from that, they "
              + "also told me that even though I'm done with my OJT in the company, I can still "
              + "contact them to ask questions or advice with regards to my career or any other "
              + "things. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation79,
          student.getAccountInformation());

      var companyEvaluation80 = new CompanyEvaluationRequest(accentureInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "My internship experience in the company was great. I had fun at the same time I "
              + "learned a lot during my internship especially the industry setting, the code "
              + "standard as well as working on a project and colleagues. I highly recommend the "
              + "company for the future student interns.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation80,
          student.getAccountInformation());

      // companyEvaluation81
      var companyEvaluation81 = new CompanyEvaluationRequest(accentureInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "As an intern to Accenture, I tested applications that were utilized by the company. "
              + "I" + " "
              + "am also included in team meetings and recreational activities, the team valued "
              + "my" + " " + "inputs, and I really felt to be part of the team.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation81,
          student.getAccountInformation());

      // companyEvaluation82
      var companyEvaluation82 = new CompanyEvaluationRequest(cebuPelisInstitute.getId(), true, "",
          ExperienceEvaluation.GOOD,
          "Since the company is more of a client, we had to learn to do anything ourselves and "
              + "I" + " "
              + "really learned alot because of this. I am always occupied by alot of tasks so we"
              + " "
              + "always have something to do like I'm actually working and not just waiting for "
              + "our" + " "
              + "supervisor to give me tasks. I learned alot in the field of graphic designing "
              + "and" + " "
              + "coding the front end of the application. I also learned alot like im actually in "
              + "a" + " "
              + "working environment like we have our daily meetings to keep track of our tasks "
              + "and" + " " + "we" + " "
              + "have tasks management applications for the tasks we are doing. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation82,
          student.getAccountInformation());

      // companyEvaluation83
      var companyEvaluation83 = new CompanyEvaluationRequest(cebuPelisInstitute.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "We experienced making an actual application and dealing with problems both on "
              + "programming and client-customer side");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation83,
          student.getAccountInformation());

      // companyEvaluation84
      var companyEvaluation84 = new CompanyEvaluationRequest(cebuPelisInstitute.getId(), true,
          "Because they are not an IT company and we are only working there for the system of the "
              + "company and most likely they will not have any IT-related endeavors in the future.",
          ExperienceEvaluation.VERY_GOOD,
          "It was a very useful experience since this is a real part time job rather than a "
              + "training of some sort. We are met with deadlines that can affect the salary we "
              + "would get. So we are expected to deliver well.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation84,
          student.getAccountInformation());

      // companyEvaluation85
      var companyEvaluation85 =
          new CompanyEvaluationRequest(symph.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
              "The company has a very good culture for employees and interns where they can learn "
                  + "from each other and those in the top can uplift them as well.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation85,
          student.getAccountInformation());

      // companyEvaluation86
      var companyEvaluation86 = new CompanyEvaluationRequest(makerSpace.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "It was hard at first since we only have more or less 2 months to work on the project"
              + "." + " " + "And I don't have enough knowledge about machine learning and instance "
              + "segmentation, but the project was made possible due to teamwork and planning "
              + "your" + " "
              + "goals every week. I learned a lot and gained deeper knowledge about image "
              + "processing.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation86,
          student.getAccountInformation());

      // companyEvaluation87
      var companyEvaluation87 = new CompanyEvaluationRequest(citUniversityMakerspace.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "The training is like what we have been trained at school. I already have a little "
              + "assurance that I am ready to have a job after graduation.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation87,
          student.getAccountInformation());

      // companyEvaluation88
      var companyEvaluation88 = new CompanyEvaluationRequest(makerSpace.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "I learned new things during my ojt in this company. It helped me explore more on "
              + "strategies in implementing a project given. I was able to apply my learnings in "
              + "a" + " "
              + "real world problem specifically on people with visual impairments and blind.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation88,
          student.getAccountInformation());

      // companyEvaluation89
      var companyEvaluation89 = new CompanyEvaluationRequest(
          southernTaiwanUniversityOfScienceAndTechnologyCebuInstituteofTechnology.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "It was very exciting and there was too much knowledge that can be obtain while "
              + "working"
              + " with them. By giving us unique ideas we come up with solutions to the problems "
              + "that "
              + "we are working with. To be able to independently decide the best solution to the"
              + " " + "problem was a skill that I have obtained by working with the STUST group.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation89,
          student.getAccountInformation());

      // companyEvaluation90
      var companyEvaluation90 = new CompanyEvaluationRequest(citUniversityMakerspace.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "I was able to learn a lot from this OJT. With the help and guidance from our "
              + "mentors," + " "
              + "we were able to learn different techniques that helped us in creating a project "
              + "that "
              + "can help visually impaired students to feel and understand the world more.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation90,
          student.getAccountInformation());

      // companyEvaluation91
      var companyEvaluation91 = new CompanyEvaluationRequest(allianceSoftwareInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "Training in this company really helped me a lot. I got to learn lots of knowledge "
              + "and" + " "
              + "valuable experience. Also, the training they will give is beginner friendly or "
              + "really" + " good for new people in the IT industry.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation91,
          student.getAccountInformation());

      // companyEvaluation92
      var companyEvaluation92 = new CompanyEvaluationRequest(citUniversityMakerspace.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "It was fun, seeing that our experiences learned in classes actually bringing "
              + "outstanding output for the people wanting our outputs");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation92,
          student.getAccountInformation());

      // companyEvaluation93
      var companyEvaluation93 = new CompanyEvaluationRequest(makerSpace.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "Sir alliac and STUST teams always give advices to make other project easy to manage.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation93,
          student.getAccountInformation());

      // companyEvaluation94
      var companyEvaluation94 = new CompanyEvaluationRequest(allianceSoftwareInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "The experience was great. We were able to learn a lot from our project leads "
              + "especially on things related to technical skills. I got better understanding on "
              + "C#" + " "
              + "and learned how to use Moqups, a wireframing tool. I was also introduced to some"
              + " " + "of "
              + "the applications used in the industry like TFS and PowerBuilder. Even if" + " "
              + "everything"
              + " was done virtually, I made connections with my batch mates which is not that "
              + "expected because of the setup. I also managed to carry out the tasks assigned to"
              + " "
              + "me before the deadlines and lucky enough to be awarded with certificate of merit"
              + ".  Overall, there's no regret in my choice of host company for my internship. "
              + "Again I learned a lot and I got a better idea what it's like to be in the "
              + "industry and how to act appropriately as a professional.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation94,
          student.getAccountInformation());

      // companyEvaluation95
      var companyEvaluation95 = new CompanyEvaluationRequest(citUniversityMakerspace.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "I had a lot of freedom with my time. I was able to balance out personal tasks and at"
              + " "
              + "the same time, finish the tasks I was assigned to do. Because of the freedom "
              + "with" + " "
              + "what tasks I can do for the day and when I can do them, I was able to put variety"
              + " " + "in"
              + " how I use my time, which in effect, made it a lot less boring. I also "
              + "appreciate" + " "
              + "that the people in charge did not apply too much pressure to the trainees. It "
              + "was" + " "
              + "just enough to make them do what they are assigned to, which shows that they "
              + "trust the trainees.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation95,
          student.getAccountInformation());

      // companyEvaluation96
      var companyEvaluation96 = new CompanyEvaluationRequest(allianceSoftwareInc.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "It was a good learning experience. I was able to learn a lot about the industry and "
              + "the general processes of software development involved therein. I was able to "
              + "exercise what I've learned at school as well as learn new technical frameworks "
              + "and" + " "
              + "platforms utilized by the company and the industry as a whole. I was able to "
              + "collaborate and meet fellow trainees from other schools as well and some "
              + "professionals in the field that helped me through the project development phase"
              + ". ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation96,
          student.getAccountInformation());

      // companyEvaluation97
      var companyEvaluation97 = new CompanyEvaluationRequest(citUniversityMakerspace.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "It was a nice experience working in the makerspace.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation97,
          student.getAccountInformation());

      // companyEvaluation98
      var companyEvaluation98 = new CompanyEvaluationRequest(citUniversityMakerspace.getId(), true,
          "", ExperienceEvaluation.VERY_GOOD,
          "Sir Aliac is accomodating as well as the STUST professors and mentors");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation98,
          student.getAccountInformation());

      // companyEvaluation99
      var companyEvaluation99 = new CompanyEvaluationRequest(makerSpace.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "Everything happened in the training was smooth and awesome. I've learned a lot in "
              + "using different tools and repositories in terms of creating a project(i.e. "
              + "Project" + " "
              + "Tales). The collaboration with STUST was a very nice experience. Hoping for more"
              + " " + "collaboration with other international universities.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation99,
          student.getAccountInformation());

      // companyEvaluation100
      var companyEvaluation100 =
          new CompanyEvaluationRequest(maranga.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
              "I learned a lot in CodeChum not in my technical skills (programming, etc.) but also "
                  + "in"
                  + " my well-being (by reading books, workout, and other ways that can improve my "
                  + "well-being).");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation100,
          student.getAccountInformation());

      // companyEvaluation101
      var companyEvaluation101 = new CompanyEvaluationRequest(
          southernTaiwanUniversityOfScienceAndTechnologyCebuInstituteofTechnology.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "We were assigned under Prof. Eli Yang. He was very approachable and helpful in "
              + "accomplishing our given tasks. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation101,
          student.getAccountInformation());

      // companyEvaluation102
      var companyEvaluation102 = new CompanyEvaluationRequest(
          southernTaiwanUniversityOfScienceAndTechnologyCebuInstituteofTechnology.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "Very good, was given so much freedom. Mentors allowed us to solve the problems on "
              + "our" + " "
              + "own. Learned a lot in such a short amount of time and of my own volition");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation102,
          student.getAccountInformation());

      // companyEvaluation103
      var companyEvaluation103 =
          new CompanyEvaluationRequest(makerSpace.getId(), true, "", ExperienceEvaluation.VERY_GOOD,
              "I really learned a lot from my mentors, and from my team. They really showed up how "
                  + "important job specification was.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation103,
          student.getAccountInformation());

      // companyEvaluation104
      var companyEvaluation104 = new CompanyEvaluationRequest(makerSpace.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD, "It was fun and I learned a lot of things.");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation104,
          student.getAccountInformation());

      // companyEvaluation105
      var companyEvaluation105 = new CompanyEvaluationRequest(cebuPelisInstitute.getId(), false,
          "Our project was a contract meaning that it was only one time, and given that the company "
              + "is not CS/IT related, it is not recommendable for CS/IT students to have their OJT in the"
              + " company. ",
          ExperienceEvaluation.VERY_GOOD,
          "In the project, my responsibility was to be the lead programmer; and having no experience "
              + "leading a team of software developers under me, I had to learn a lot of things very fast,"
              + " do all of the grunt work behind the scenes (setup and maintain codebases and deployment"
              + " pipelines) and do all of the technical decisions. There are two key things that I got "
              + "from my experience: accountability and ownership. Having to do all the technical "
              + "decisions means that I was accountable for any mishaps that happen to my teammates "
              + "(bad developer experience) so I really had to do my due diligence and research to be"
              + " able to make well-informed decisions. Accountability also means that I am "
              + "accountable for being late on deadlines. Writing software means that you are an "
              + "author, it means that you own the code that you write and what you do write says "
              + "a lot about you, technically and personally. So I really try to practice proper "
              + "coding principles to the best of my abilities. ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation105,
          student.getAccountInformation());

      // companyEvaluation106
      var companyEvaluation106 = new CompanyEvaluationRequest(pearlpay.getId(), true, "",
          ExperienceEvaluation.VERY_GOOD,
          "Before I was given tickets, I was task to review their technologies used for 1 - 2 "
              + "weeks and create a project out of it and present to lead developer. I've learned"
              + " " + "a" + " "
              + "lot on how banking works. To be honest, it was very challenging since there a "
              + "lot" + " " + "of"
              + " terminologies about finance which I am not familiar with but when I l listened "
              + "to" + " "
              + "my assigned business analyst (who is very patient in answering my queries), the "
              + "concepts and the flow of the application become clearer to me as the time goes "
              + "by"
              + ". Aside from this, the application itself is very challenging since it can be "
              + "considered a legacy system. However, the lead developers were very patient in "
              + "explaining the code. They answer my queries very quickly and initiated calls "
              + "if my concern is complicated.  ");
      companyEvaluationService.createCompanyEvaluation(companyEvaluation106,
          student.getAccountInformation());

    };
  }
}
