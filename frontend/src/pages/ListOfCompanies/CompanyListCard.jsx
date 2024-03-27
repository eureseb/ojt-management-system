import {
  Button,
  CardActions,
  CardContent,
  Chip,
  Modal,
  ModalClose,
  ModalDialog,
  Stack,
  Typography,
} from '@mui/joy';
import PropTypes from 'prop-types';
import { useState } from 'react';
import CompanyApplyForm from './CompanyApplyForm';
import Card from '../../shared/Card';
import timeAgo from '../../utils/timeAgo';
import { Link } from 'react-router-dom';

export default function CompanyListCard({
  companyName,
  tags,
  address1,
  address2,
  yearEstablished,
  employeeMin,
  employeeMax,
  datePosted,
  contactEmail,
  jobListingId,
  companyId,
}) {
  const [isApplyModalOpen, setIsApplyModalOpen] = useState(false);

  return (
    <Card>
      <Stack width="100%">
        <CardContent orientation="horizontal">
          <Stack width="50%" alignItems="flex-start" gap={2}>
            <Link
              to={`/company-list/${companyId}`}
              style={{ textDecoration: 'none' }}
            >
              <Typography level="title-lg">{companyName}</Typography>
            </Link>
            <Stack gap={1}>
              {tags.map((tag) => (
                <Chip key={tag} color="primary">
                  {tag}
                </Chip>
              ))}
            </Stack>
          </Stack>
          <Stack direction="row" width="50%" gap={3}>
            <Stack width="50%">
              <Typography level="body-md" textAlign="left" marginBottom={1}>
                {address1}
              </Typography>
              <Typography level="body-sm" textAlign="left">
                {address2}
              </Typography>
              <Typography level="body-sm" textAlign="left">
                Established in {yearEstablished}
              </Typography>
              <Typography level="body-sm" textAlign="left">
                {employeeMin}-{employeeMax} employees
              </Typography>
            </Stack>
            <Stack justifyContent="space-between" flexGrow={1}>
              <Typography level="body-md" textAlign="left">
                {timeAgo.format(datePosted)}
              </Typography>
            </Stack>
          </Stack>
        </CardContent>
        <CardActions orientation="horizontal-reverse" buttonFlex="10px 10px">
          <Button variant="solid" onClick={() => setIsApplyModalOpen(true)}>
            Apply
          </Button>
        </CardActions>
      </Stack>
      <Modal
        open={isApplyModalOpen}
        onClose={() => setIsApplyModalOpen(false)}
        sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}
      >
        <ModalDialog>
          <ModalClose />
          <CompanyApplyForm
            companyName={companyName}
            tags={tags}
            contactEmail={contactEmail}
            jobListingId={jobListingId}
            onSuccess={() => setIsApplyModalOpen(false)}
          />
        </ModalDialog>
      </Modal>
    </Card>
  );
}

CompanyListCard.propTypes = {
  companyName: PropTypes.string.isRequired,
  tags: PropTypes.arrayOf(PropTypes.string).isRequired,
  address1: PropTypes.string.isRequired,
  address2: PropTypes.string.isRequired,
  yearEstablished: PropTypes.number.isRequired,
  employeeMin: PropTypes.number.isRequired,
  employeeMax: PropTypes.number.isRequired,
  datePosted: PropTypes.instanceOf(Date).isRequired,
  contactEmail: PropTypes.string.isRequired,
  jobListingId: PropTypes.number.isRequired,
  companyId: PropTypes.number.isRequired,
};
