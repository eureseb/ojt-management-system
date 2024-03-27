export default function parseCompanies(rawCompanies) {
  return rawCompanies.map((company) => ({
    id: company.id,
    companyName: company.name,
    tags: ['Computer Science', 'OJT'],
    address1: company.addressLine1,
    address2: company.addressLine2,
    yearEstablished: company.yearEstablished,
    employeeMin: company.noOfEmployeesMin,
    employeeMax: company.noOfEmployeesMax,
    datePosted: new Date(company.datePosted),
    contactEmail: company.contactEmail,
  }));
}
