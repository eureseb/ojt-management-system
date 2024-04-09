import { useEffect, useState } from 'react';
import { Stack, Table, Button } from '@mui/joy';
import { getStudents, removeStudentFromCompany } from '../../utils/api';
import usePagination from '../../utils/usePagination';
import Pagination from '../../components/Pagination/Pagination';

export default function ManageStudents() {
  const [students, setStudents] = useState([]);

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
        content: students,
        totalPages,
        totalElements,
      } = await getStudents();
      setStudents(students);
      setTotalNumberOfPages(totalPages);
      setTotalNumberOfItems(totalElements);
    })();
  }, [currentPage, setTotalNumberOfItems, setTotalNumberOfPages]);

  const handleRemoveFromCompany = async (studentId) => {
    await removeStudentFromCompany(studentId);
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
            <th>First Name</th>
            <th>Last Name</th>
            <th>Current Company</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.accountInformation.firstName}</td>
              <td>{student.accountInformation.lastName}</td>
              <td>{student.currentCompany?.name || 'None'}</td>
              <td>
                <Stack direction="row" gap={1} justifyContent="flex-end">
                  {student.currentCompany?.name && (
                    <Button
                      variant="outlined"
                      onClick={() => handleRemoveFromCompany(student.id)}
                    >
                      Remove from Company
                    </Button>
                  )}
                </Stack>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Stack>
  );
}
