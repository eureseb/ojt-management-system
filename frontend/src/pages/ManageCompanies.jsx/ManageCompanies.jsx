import { useEffect, useState } from 'react';
import { Stack, Table, Button, Modal, ModalDialog } from '@mui/joy';
import { createCompany, getCompanies, updateCompany } from '../../utils/api';
import CompanyForm from './CompanyForm';
import Pagination from '../../components/Pagination/Pagination';
import usePagination from '../../utils/usePagination';
import AddIcon from '@mui/icons-material/Add';

export default function ManageCompanies() {
  const [companies, setCompanies] = useState([]);
  const [showCompanyForm, setShowCompanyForm] = useState(false);
  const [companyToUpdate, setCompanyToUpdate] = useState(null);
  const [shouldUpdate, setShouldUpdate] = useState(false);

  const {
    totalNumberOfItems,
    totalNumberOfPages,
    setTotalNumberOfItems,
    setTotalNumberOfPages,
    currentPage,
    onPageChange,
  } = usePagination();

  useEffect(() => {
    (async () => {
      const {
        content: companies,
        totalPages,
        totalElements,
      } = await getCompanies({ page: currentPage - 1 });
      setCompanies(companies);
      setTotalNumberOfPages(totalPages);
      setTotalNumberOfItems(totalElements);
    })();
  }, [currentPage, setTotalNumberOfItems, setTotalNumberOfPages]);

  const handleAddNewCompanyClick = () => {
    setShouldUpdate(false);
    setCompanyToUpdate(null);
    setShowCompanyForm(true);
  };

  const handleUpdateCompanyClick = (company) => {
    setCompanyToUpdate(company);
    setShouldUpdate(true);
    setShowCompanyForm(true);
  };

  const handleCompanyFormSubmit = async ({
    name,
    description,
    contactEmail,
    addressLine1,
    addressLine2,
  }) => {
    if (shouldUpdate) {
      await updateCompany({
        name,
        description,
        contactEmail,
        addressLine1,
        addressLine2,
        companyId: companyToUpdate.id,
      });
    } else {
      await createCompany({
        name,
        description,
        contactEmail,
        addressLine1,
        addressLine2,
      });
    }
    window.location.reload();
  };

  return (
    <Stack padding={3} gap={2}>
      <Stack direction="row" justifyContent="space-between">
        <Button
          startDecorator={<AddIcon />}
          onClick={handleAddNewCompanyClick}
          sx={{ width: 'fit-content' }}
        >
          Add New Company
        </Button>
        <Pagination
          totalPages={totalNumberOfPages}
          currentPage={currentPage}
          totalCount={totalNumberOfItems}
          totalDisplayed={10}
          onPageChange={onPageChange}
        />
      </Stack>
      <Table size="lg">
        <thead>
          <tr>
            <th>Name</th>
            <th>Location</th>
            <th>Employees</th>
            <th>Contact</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {companies.map((company) => (
            <tr key={company.id}>
              <td>{company.name}</td>
              <td>{company.addressLine1}</td>
              <td>
                {company.noOfEmployeesMin} - {company.noOfEmployeesMax}
              </td>
              <td>{company.contactEmail}</td>
              <td>
                <Stack gap={1} direction="row" justifyContent="flex-end">
                  <Button
                    onClick={() => handleUpdateCompanyClick(company)}
                    variant="outlined"
                  >
                    Edit
                  </Button>
                </Stack>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
      <Modal open={showCompanyForm} onClose={() => setShowCompanyForm(false)}>
        <ModalDialog size="lg">
          <CompanyForm
            update={shouldUpdate}
            companyToUpdate={companyToUpdate}
            onSubmit={handleCompanyFormSubmit}
          />
        </ModalDialog>
      </Modal>
    </Stack>
  );
}
