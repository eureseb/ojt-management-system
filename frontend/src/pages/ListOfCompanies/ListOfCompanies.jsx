import { Stack, Autocomplete } from '@mui/joy';
import CompanyList from './CompanyList';
import { useEffect, useState } from 'react';
import {
  getAllCompanies,
  getJobListings,
  getLoggedInStudentInfo,
} from '../../utils/api';
import parseJobListings from '../../utils/parseJobListings';
import Pagination from '../../components/Pagination/Pagination';
import SearchIcon from '@mui/icons-material/Search';
import { useNavigate } from 'react-router-dom';
import usePagination from '../../utils/usePagination';

export default function ListOfCompanies() {
  const [jobListings, setJobListings] = useState([]);
  const [companies, setCompanies] = useState([]);
  const [suggestedCompanyId, setSuggestedCompanyId] = useState(-1);
  const navigate = useNavigate();
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
      const student = await getLoggedInStudentInfo();
      if (student.suggestedCompanyId > -1)
        setSuggestedCompanyId(student.suggestedCompanyId || []);
      const page = currentPage;
      const {
        content: rawJobListings,
        totalElements,
        totalPages,
      } = await getJobListings(page - 1);
      setTotalNumberOfPages(totalPages);
      setTotalNumberOfItems(totalElements);
      const jobListings = parseJobListings(rawJobListings);
      setJobListings(jobListings);
    })();
    (async () => {
      const companies = await getAllCompanies();
      setCompanies(companies);
    })();
  }, [currentPage, setTotalNumberOfItems, setTotalNumberOfPages]);

  return (
    <Stack padding={5} gap={3} width="100%">
      <Stack direction="row" justifyContent="space-between">
        <Autocomplete
          placeholder="Search for companies"
          freeSolo
          variant="outlined"
          openOnFocus={false}
          options={companies.map((company) => ({
            label: company.name,
            id: company.id,
          }))}
          disabled={companies.length === 0}
          startDecorator={<SearchIcon />}
          sx={{ width: '400px' }}
          value=""
          onChange={(_, newValue) => {
            navigate(`/company-list/${newValue.id}`);
          }}
        ></Autocomplete>
        <Pagination
          totalPages={totalNumberOfPages}
          currentPage={currentPage}
          totalCount={totalNumberOfItems}
          totalDisplayed={10}
          onPageChange={onPageChange}
        />
      </Stack>
      <CompanyList
        jobListings={jobListings}
        suggestedCompanyId={suggestedCompanyId}
      />
    </Stack>
  );
}
