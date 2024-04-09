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
  ModalOverflow,
} from '@mui/joy';
import Card from '../../shared/Card';
import LockIcon from '@mui/icons-material/Lock';
import { useEffect, useState } from 'react';
import CompanyEvaluationForm from './CompanyEvaluationForm';
import { getCompanyEvaluationStatus } from '../../utils/api';

export default function CompanyEvaluation() {
  const [isFinalEvaluationModalOpen, setIsFinalEvaluationModalOpen] =
    useState(false);

  const [companyEvaluationStatus, setCompanyEvaluationStatus] = useState(null);

  useEffect(() => {
    (async () => {
      const companyEvaluationStatus = await getCompanyEvaluationStatus();
      setCompanyEvaluationStatus(companyEvaluationStatus);
    })();
  }, []);

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
                startDecorator={
                  !companyEvaluationStatus.isEnabled && (
                    <LockIcon fontSize="small" />
                  )
                }
                onClick={() => setIsFinalEvaluationModalOpen(true)}
                disabled={!companyEvaluationStatus.isEnabled}
              >
                Submit Evaluation
              </Button>
            </CardActions>
          </Stack>
        </Card>
      )}
      {companyEvaluationStatus && (
        <Modal
          open={isFinalEvaluationModalOpen}
          onClose={() => setIsFinalEvaluationModalOpen(false)}
          sx={{
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
          }}
        >
          <ModalOverflow>
            <ModalDialog>
              <CompanyEvaluationForm
                evaluationTitle="Final Evaluation"
                evaluationTerm="FINAL"
                onSuccess={() => setIsFinalEvaluationModalOpen(false)}
              />
            </ModalDialog>
          </ModalOverflow>
        </Modal>
      )}
    </Stack>
  );
}
