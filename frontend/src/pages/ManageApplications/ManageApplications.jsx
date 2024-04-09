import { useEffect, useState } from 'react';
import { Stack, Table, Button } from '@mui/joy';
import { acceptJobApplication, getJobApplications } from '../../utils/api';
import Pagination from '../../components/Pagination/Pagination';
import usePagination from '../../utils/usePagination';

export default function ManageApplications() {
  const [jobApplications, setJobApplications] = useState([]);
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
        content: result,
        totalPages,
        totalElements,
      } = await getJobApplications(currentPage - 1);
      setJobApplications(result);
      setTotalNumberOfPages(totalPages);
      setTotalNumberOfItems(totalElements);
    })();
  }, [currentPage, setTotalNumberOfItems, setTotalNumberOfPages]);

  const handleAccept = async (jobApplicationId) => {
    await acceptJobApplication(jobApplicationId);
    window.location.reload();
  };
  return (
    <Stack padding={3} gap={2}>
      <Stack alignItems="flex-end">
        <Pagination
          totalPages={totalNumberOfPages}
          currentPage={currentPage}
          totalCount={totalNumberOfItems}
          totalDisplayed={10}
          onPageChange={onPageChange}
        />
      </Stack>
      <Table borderAxis="xBetween" size="lg">
        <thead>
          <tr>
            <th>Student</th>
            <th>Company</th>
            <th>Title</th>
            <th>Status</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {jobApplications.map((jobApplication) => (
            <tr key={jobApplication.id}>
              <td>
                {jobApplication.student.accountInformation.firstName}{' '}
                {jobApplication.student.accountInformation.lastName}
              </td>
              <td>{jobApplication.jobListing.company.name}</td>
              <td>{jobApplication.jobListing.jobTitle}</td>
              <td>{jobApplication.status}</td>
              <td>
                {jobApplication.status === 'PENDING' && (
                  <Stack direction="row" gap={1} justifyContent="flex-end">
                    <Button variant="outlined">Reject</Button>
                    <Button
                      variant="outlined"
                      onClick={() => handleAccept(jobApplication.id)}
                    >
                      Accept
                    </Button>
                  </Stack>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Stack>
  );
}
