import { Stack, Typography } from '@mui/joy';
import PropTypes from 'prop-types';
import CompanyListCard from './CompanyListCard';

export default function CompanyList({ jobListings }) {
  return (
    <Stack gap={2}>
      <Stack direction="row" paddingLeft={5}>
        <Typography level="body-md" width="50%" textAlign="left">
          Companies
        </Typography>
        <Typography level="body-md" width="25%" textAlign="left">
          Location
        </Typography>
        <Typography level="body-md">Date</Typography>
      </Stack>
      {jobListings.map((jobListing) => (
        <CompanyListCard
          key={jobListing.id}
          companyName={jobListing.companyName}
          tags={jobListing.tags}
          address1={jobListing.address1}
          address2={jobListing.address2}
          yearEstablished={jobListing.yearEstablished}
          employeeMin={jobListing.employeeMin}
          employeeMax={jobListing.employeeMax}
          datePosted={jobListing.datePosted}
          contactEmail={jobListing.contactEmail}
          jobListingId={jobListing.id}
          companyId={jobListing.companyId}
        />
      ))}
    </Stack>
  );
}

CompanyList.propTypes = {
  jobListings: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      companyName: PropTypes.string.isRequired,
      tags: PropTypes.arrayOf(PropTypes.string).isRequired,
      address1: PropTypes.string.isRequired,
      address2: PropTypes.string.isRequired,
      yearEstablished: PropTypes.number.isRequired,
      employeeMin: PropTypes.number.isRequired,
      employeeMax: PropTypes.number.isRequired,
      datePosted: PropTypes.string.isRequired,
    })
  ).isRequired,
};
