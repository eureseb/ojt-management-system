import { Stack, Typography } from '@mui/joy';
import CompanyList from './CompanyList';
import internshipCategories from '../../mockData/internshipCategories';
import InternshipCategories from './InternshipCategories';
import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import { getJobListings } from '../../utils/api';
import parseJobListings from '../../utils/parseJobListings';

export default function ListOfCompanies() {
  const [searchParams] = useSearchParams();
  const [jobListings, setJobListings] = useState([]);

  useEffect(() => {
    (async () => {
      const page = searchParams.get('page') || 0;
      const rawJobListings = await getJobListings(page);
      const jobListings = parseJobListings(rawJobListings);
      setJobListings(jobListings);
    })();
  }, [searchParams]);

  return (
    <Stack gap={5} padding={5}>
      <Stack>
        <Typography level="h1">Hello, User</Typography>
        <Typography level="h3">Start and find your company</Typography>
      </Stack>
      <Stack direction="row">
        <Stack gap={2}>
          <Typography level="title-lg">Intern hiring in Cebu</Typography>
          <Typography level="body-md">
            CAT is an always-updated OJT hiring website with integration of AI
            analytics where you can easily find job listings by locality and by
            specialty. Here on this page, you&apos;ll be able to discover urgent
            listings for OJT opportunities based in the Province of Cebu. Jobs
            are sorted in several ways: according to the city they&apos;re
            located in, according to the field or discipline they pertain to, or
            according to the experience level needed from the candidate.
          </Typography>
          <CompanyList jobListings={jobListings} />
        </Stack>
        <InternshipCategories internshipCategories={internshipCategories} />
      </Stack>
    </Stack>
  );
}
