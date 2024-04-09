import React, { useEffect } from 'react';
import {
  Card as MuiCard,
  List,
  ListItem,
  Stack,
  Typography,
  CardContent,
  CardActions,
  Button,
  Modal,
  ModalDialog,
  FormControl,
  FormLabel,
} from '@mui/joy';
import Card from '../../shared/Card';
import LockIcon from '@mui/icons-material/Lock';
import LockOpenIcon from '@mui/icons-material/LockOpen';
import { useState } from 'react';
import {
  getCompanyEvaluationStatus,
  updateCompanyEvaluationStatus,
} from '../../utils/api';
import '@mantine/core/styles.css';
import '@mantine/dates/styles.css';
import { DatePicker } from '@mantine/dates';
import { TimeInput } from '@mantine/dates';
import dayjs from 'dayjs';

export default function ManageEvaluation() {
  const [companyEvaluationStatus, setCompanyEvaluationStatus] = useState(null);
  const [
    isUpdateCompanyEvaluationModalOpen,
    setIsUpdateCompanyEvaluationModalOpen,
  ] = useState(false);
  const [dueDateSelected, setDueDateSelected] = useState(null);
  const dueTimeRef = React.useRef(null);

  useEffect(() => {
    (async () => {
      const companyEvaluationStatus = await getCompanyEvaluationStatus();
      setCompanyEvaluationStatus(companyEvaluationStatus);
    })();
  }, []);

  const handleDisableClick = async () => {
    await updateCompanyEvaluationStatus({
      isEnabled: false,
      dueDate: null,
      title: 'Final Evaluation',
    });
    window.location.reload();
  };
  const handleEnableClick = async () => {
    setIsUpdateCompanyEvaluationModalOpen(true);
  };

  const handleFinalEnableCick = async () => {
    const dateTime = dayjs()
      .year(dueDateSelected.getFullYear())
      .month(dueDateSelected.getMonth())
      .date(dueDateSelected.getDate())
      .hour(dueTimeRef.current.value.split(':')[0])
      .minute(dueTimeRef.current.value.split(':')[1]);
    await updateCompanyEvaluationStatus({
      isEnabled: true,
      dueDate: dateTime.toISOString(),
      title: 'Final Evaluation',
    });
    window.location.reload();
  };

  return (
    <Stack gap={5} padding={5}>
      <Stack>
        <Typography level="h1">Hello, User</Typography>
        <Typography level="h3">Go ahead and submit evaluation</Typography>
      </Stack>
      <Stack gap={2}>
        <Typography level="title-lg">OJT Requirements</Typography>
        <Typography level="body-md">
          Our innovative AI algorithms analyze vast amounts of online data,
          including employee reviews, social media conversations, and industry
          news, to generate a comprehensive sentiment analysis for each company
          listed on our platform. This invaluable information empowers you to:
        </Typography>
        <List marker="disc">
          <ListItem>
            Assess company culture and employee satisfaction: Gain a deeper
            understanding of the work environment and how employees feel about
            their jobs.
          </ListItem>
          <ListItem>
            Identify potential red flags: Uncover any negative sentiment or
            recurring issues that may indicate underlying problems within the
            company.
          </ListItem>
          <ListItem>
            Make informed decisions: Choose OJT opportunities that align with
            your values and career aspirations.
          </ListItem>
        </List>
      </Stack>
      {companyEvaluationStatus && (
        <Card>
          <Stack gap={2}>
            <MuiCard variant="soft" sx={{ width: '100%' }}>
              <Stack justifyContent="space-between" direction="row">
                <Typography level="title-md">
                  {companyEvaluationStatus.title}
                </Typography>
                <Typography level="body-sm">
                  {' '}
                  {companyEvaluationStatus.isEnabled
                    ? `Due on ${companyEvaluationStatus.dueDate.format(
                        'MMM D, YYYY [at] h:mm a'
                      )}`
                    : ''}
                </Typography>
              </Stack>
            </MuiCard>
            <CardContent>
              <Typography level="title-md">
                Harness the Power of AI to Evaluate Company Internship
                Performance
              </Typography>
              <Typography level="body-sm">
                Our cutting-edge AI algorithms delve into the depths of online
                data, meticulously analyzing employee reviews, social media
                conversations, and industry news to generate a comprehensive
                sentiment analysis for each company listed on our platform. This
                invaluable intelligence empowers you to make informed decisions
                about your internship journey.
              </Typography>
            </CardContent>
            <CardActions
              orientation="horizontal-reverse"
              buttonFlex="10px 10px"
            >
              <Button
                variant="solid"
                color={
                  companyEvaluationStatus.isEnabled ? 'primary' : 'success'
                }
                onClick={
                  companyEvaluationStatus.isEnabled
                    ? handleDisableClick
                    : handleEnableClick
                }
                startDecorator={
                  companyEvaluationStatus.isEnabled ? (
                    <LockIcon fontSize="small" />
                  ) : (
                    <LockOpenIcon fontSize="small" />
                  )
                }
              >
                {companyEvaluationStatus.isEnabled ? 'Close' : 'Enable'}
              </Button>
            </CardActions>
          </Stack>
          <Modal
            open={isUpdateCompanyEvaluationModalOpen}
            onClose={() => setIsUpdateCompanyEvaluationModalOpen(false)}
          >
            <ModalDialog size="lg">
              <FormControl size="lg">
                <FormLabel>Select date due:</FormLabel>
                <DatePicker
                  value={dueDateSelected}
                  onChange={setDueDateSelected}
                />
              </FormControl>
              <FormControl size="lg">
                <FormLabel>Set time due:</FormLabel>
                <TimeInput ref={dueTimeRef} />
              </FormControl>
              <Button color="success" onClick={handleFinalEnableCick}>
                Enable Evaluations
              </Button>
            </ModalDialog>
          </Modal>
        </Card>
      )}
    </Stack>
  );
}
