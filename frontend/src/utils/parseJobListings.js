export default function parseJobListings(rawJobListings) {
  return rawJobListings.map((jobListing) => ({
    id: jobListing.id,
    companyName: jobListing.company.name,
    companyId: jobListing.company.id,
    tags: jobListing.company.tags,
    address1: jobListing.company.addressLine1,
    address2: jobListing.company.addressLine2,
    yearEstablished: jobListing.company.yearEstablished,
    employeeMin: jobListing.company.noOfEmployeesMin,
    employeeMax: jobListing.company.noOfEmployeesMax,
    datePosted: new Date(jobListing.datePosted),
    contactEmail: jobListing.company.contactEmail,
    jobTitle: jobListing.jobTitle,
    jobDescription: jobListing.jobDescription,
  }));
}
