import {
  Button,
  Card,
  CardContent,
  Chip,
  Divider,
  Input,
  Stack,
  Textarea,
  Typography,
} from '@mui/joy';
import PropTypes from 'prop-types';
import UploadIcon from '../../assets/upload';
import VisuallyHiddenInput from '../../shared/VisuallyHiddenInput';
import { useEffect, useState } from 'react';
import { applyForJob, getLoggedInStudentInfo } from '../../utils/api';

export default function CompanyApplyForm({
  companyName,
  tags,
  contactEmail,
  jobListingId,
  onSuccess,
}) {
  const [subject, setSubject] = useState('');
  const [body, setBody] = useState('');

  useEffect(() => {
    (async () => {
      const user = await getLoggedInStudentInfo();
      const { firstName, lastName } = user.accountInformation;
      setSubject(`${lastName}, ${firstName} - OJT Inquiry`);
    })();
  }, []);

  const handleApply = async () => {
    try {
      await applyForJob({
        jobListingId,
        coverLetterRecipientEmail: contactEmail,
        coverLetterSubject: subject,
        coverLetterBody: body,
      });
      onSuccess();
    } catch (e) {
      console.error(e);
    }
  };

  return (
    <Stack gap={2} maxWidth="800px">
      <Typography level="h4">{companyName}</Typography>
      <Stack gap={1} direction="row">
        {tags.map((tag) => (
          <Chip key={tag} color="primary">
            {tag}
          </Chip>
        ))}
      </Stack>
      <Typography level="body-md">
        <Typography fontWeight="lg">Tags</Typography>: scrum team,
        collaboration, development, process improvement, shippable increment,
        end-user requirements, testing, deployment, troubleshooting, debugging,
        software maintenance, improvement, user feedback, software performance,
        software products, technical documentation
      </Typography>
      <Typography level="title-md">Applicant Cover Letter</Typography>
      <Card variant="outlined">
        <CardContent>
          <Input
            size="lg"
            variant="plain"
            disabled
            startDecorator={
              <Typography level="body-lg" fontWeight="lg">
                To:
              </Typography>
            }
            value={contactEmail}
          />
          <Divider />
          <Input
            size="lg"
            variant="plain"
            startDecorator={
              <Typography level="body-lg" fontWeight="lg">
                Subject:
              </Typography>
            }
            value={subject}
            onChange={(e) => setSubject(e.target.value)}
          />
          <Divider />
          <Textarea
            minRows={10}
            variant="plain"
            size="lg"
            value={body}
            onChange={(e) => setBody(e.target.value)}
          />
        </CardContent>
      </Card>
      <Stack direction="row" justifyContent="space-between">
        <Button
          component="label"
          role={undefined}
          tabIndex={-1}
          variant="outlined"
          color="neutral"
          startDecorator={<UploadIcon />}
          size="lg"
        >
          Upload Resume
          <VisuallyHiddenInput type="file" />
        </Button>
        <Button variant="solid" size="lg" onClick={handleApply}>
          Apply
        </Button>
      </Stack>
    </Stack>
  );
}

CompanyApplyForm.propTypes = {
  companyName: PropTypes.string.isRequired,
  tags: PropTypes.arrayOf(PropTypes.string).isRequired,
  contactEmail: PropTypes.string.isRequired,
  jobListingId: PropTypes.number.isRequired,
  onSuccess: PropTypes.func.isRequired,
};
