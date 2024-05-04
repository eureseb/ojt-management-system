import { useEffect, useState } from 'react';
import { useParams, useSearchParams } from 'react-router-dom';
import { getCompany, getCompanyEvaluations } from '../../utils/api';
import {
  Card,
  CardContent,
  Chip,
  Divider,
  Stack,
  Typography,
  Button,
  Modal,
  ModalOverflow,
  ModalDialog,
  ModalClose,
} from '@mui/joy';
import PeopleIcon from '@mui/icons-material/People';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import SentimentVeryDissatisfiedIcon from '@mui/icons-material/SentimentVeryDissatisfied';
import SentimentDissatisfiedIcon from '@mui/icons-material/SentimentDissatisfied';
import SentimentSatisfiedIcon from '@mui/icons-material/SentimentSatisfied';
import SentimentVerySatisfiedIcon from '@mui/icons-material/SentimentVerySatisfied';
import ThumbUpOffAltIcon from '@mui/icons-material/ThumbUpOffAlt';
import ThumbDownOffAltIcon from '@mui/icons-material/ThumbDownOffAlt';
import BarChart from './BarChart';
import PieChart from './PieChart';
import CompanyApplyForm from '../ListOfCompanies/CompanyApplyForm';

export default function Company() {
  const params = useParams();
  const [company, setCompany] = useState(null);
  const [evaluations, setEvaluations] = useState([]);
  const [isCompanyLoading, setIsCompanyLoading] = useState(true);
  const [areEvaluationsLoading, setAreEvaluationsLoading] = useState(true);
  const [searchParams, setSearchParams] = useSearchParams();
  const version = searchParams.get('ver');
  const [isApplyModalOpen, setIsApplyModalOpen] = useState(false);

  useEffect(() => {
    (async () => {
      try {
        setIsCompanyLoading(true);
        const company = await getCompany(params.companyId);
        setCompany(company);
      } catch (e) {
        console.error(e);
      } finally {
        setIsCompanyLoading(false);
      }
    })();
    (async () => {
      try {
        setAreEvaluationsLoading(true);
        const companyEvaluations = await getCompanyEvaluations(
          params.companyId,
          0
        );
        setEvaluations(companyEvaluations);
      } catch (e) {
        console.error(e);
      } finally {
        setAreEvaluationsLoading(false);
      }
    })();
  }, [params.companyId]);
  if (isCompanyLoading) return <></>;

  return (
    <Stack gap={3} padding={5}>
      <Stack direction="row" justifyContent="space-between">
        <Stack gap={3}>
          <Stack gap={1}>
            <Typography level="h1">{company.name}</Typography>
            <Stack direction="row" gap={1} flexWrap="wrap">
              {company.tags.map((tag) => (
                <Chip key={tag}>{tag}</Chip>
              ))}
            </Stack>
          </Stack>
          <Button
            size="md"
            sx={{ width: 'fit-content' }}
            onClick={() => {
              setIsApplyModalOpen(true);
            }}
          >
            Apply
          </Button>
          <Stack>
            <Stack direction="row" alignItems="center" gap={1}>
              <PeopleIcon />
              <Typography level="body-sm">
                {company.noOfEmployeesMin} - {company.noOfEmployeesMax}
              </Typography>
            </Stack>
            <Stack direction="row" alignItems="center" gap={1}>
              <LocationOnIcon />
              <Typography level="body-sm">
                {company.addressLine1} {company.addressLine2}
              </Typography>
            </Stack>
          </Stack>
        </Stack>
        <Stack gap={1} alignItems="flex-end">
          {/* <Card variant="plain"> */}
          {version !== '2' ? (
            <Stack gap={3} alignItems="flex-end" direction="row">
              <Stack alignItems="flex-start">
                <Typography level="title-md">Overall Recommendation</Typography>
                <BarChart
                  values={[
                    company.isRecommendedForOJTCount,
                    company.isNotRecommendedForOJTCount,
                  ]}
                  labels={['Recommended', 'Not Recommended']}
                  colors={['#5aaf2b', '#e43e3d']}
                />
              </Stack>
              <Divider orientation="vertical" />
              <Stack alignItems="flex-start">
                <Typography level="title-md">Overall Experience</Typography>
                <BarChart
                  values={[
                    company.veryGoodExperienceCount,
                    company.goodExperienceCount,
                    company.badExperienceCount,
                    company.veryBadExperienceCount,
                  ]}
                  labels={['Very Good', 'Good', 'Bad', 'Very Bad']}
                  colors={['#5aaf2b', '#c1cc36', '#ef874c', '#e43e3d']}
                />
              </Stack>
            </Stack>
          ) : (
            <Stack direction="row" gap={3}>
              <Stack alignItems="flex-start">
                <Typography level="title-md">Overall Recommendation</Typography>
                <PieChart
                  values={[
                    company.isRecommendedForOJTCount,
                    company.isNotRecommendedForOJTCount,
                  ]}
                  labels={['Recommended', 'Not Recommended']}
                  colors={['#5aaf2b', '#e43e3d']}
                />
              </Stack>
              <Divider orientation="vertical" />
              <Stack alignItems="flex-start" width="190px">
                <Typography level="title-md">Overall Experience</Typography>
                <PieChart
                  legendWidth={160}
                  values={[
                    company.veryGoodExperienceCount,
                    company.goodExperienceCount,
                    company.badExperienceCount,
                    company.veryBadExperienceCount,
                  ]}
                  labels={['Very Good', 'Good', 'Bad', 'Very Bad']}
                  colors={['#5aaf2b', '#c1cc36', '#ef874c', '#e43e3d']}
                />
              </Stack>
            </Stack>
          )}
          {/* </Card> */}
          <Button
            sx={{ width: 'fit-content' }}
            variant="soft"
            onClick={() => {
              setSearchParams({ ver: version === '2' ? '1' : '2' });
            }}
            size="sm"
          >
            Change Chart
          </Button>
        </Stack>
      </Stack>
      <Stack alignItems="flex-start" gap={1}>
        <Typography level="title-md">Summary of Reviews</Typography>
        <Typography level="body-md">{company.reviewSummary}</Typography>
      </Stack>
      <Stack gap={2}>
        {evaluations.map((evaluation) => (
          <Card key={evaluation.id}>
            <CardContent>
              <Stack gap={3}>
                <Typography level="title-lg">
                  {evaluation.evaluatedBy}
                </Typography>
                <Stack direction="row" gap={2} alignItems="center">
                  <Stack direction="row" gap={1} alignItems="center">
                    {evaluation.experienceEvaluation === 'VERY_GOOD' && (
                      <>
                        <SentimentVerySatisfiedIcon sx={{ color: '#5aaf2b' }} />
                        <Typography level="title-sm">Very Good</Typography>
                      </>
                    )}
                    {evaluation.experienceEvaluation === 'GOOD' && (
                      <>
                        <SentimentSatisfiedIcon sx={{ color: '#c1cc36' }} />
                        <Typography level="title-sm">Good</Typography>
                      </>
                    )}
                    {evaluation.experienceEvaluation === 'BAD' && (
                      <>
                        <SentimentDissatisfiedIcon sx={{ color: '#ef874c' }} />
                        <Typography level="title-sm">Bad</Typography>
                      </>
                    )}
                    {evaluation.experienceEvaluation === 'VERY_BAD' && (
                      <>
                        <SentimentVeryDissatisfiedIcon
                          sx={{ color: '#e43e3d' }}
                        />
                        <Typography level="title-sm">Very Bad</Typography>
                      </>
                    )}
                  </Stack>
                  <Divider orientation="vertical" />
                  <Stack direction="row" gap={1} alignItems="center">
                    {evaluation.isRecommendedForOJT ? (
                      <>
                        <ThumbUpOffAltIcon sx={{ color: '#5aaf2b' }} />
                        <Typography level="title-sm">Recommended</Typography>
                      </>
                    ) : (
                      <>
                        <ThumbDownOffAltIcon sx={{ color: '#e43e3d' }} />
                        <Typography level="title-sm">
                          Not Recommended
                        </Typography>
                      </>
                    )}
                  </Stack>
                </Stack>
                <Stack>
                  <Typography level="title-md">
                    Reason for recommendation
                  </Typography>
                  <Typography level="body-sm">
                    {evaluation.isRecommendedForOJTReason}
                  </Typography>
                </Stack>
                <Stack>
                  <Typography level="title-md">
                    Experience with the company
                  </Typography>
                  <Typography level="body-sm">
                    {evaluation.experienceWithCompany}
                  </Typography>
                </Stack>
              </Stack>
            </CardContent>
          </Card>
        ))}
      </Stack>
      <Modal
        open={isApplyModalOpen}
        onClose={() => setIsApplyModalOpen(false)}
        sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}
      >
        <ModalOverflow>
          <ModalDialog>
            <ModalClose />
            <CompanyApplyForm
              companyName={company.name}
              tags={company.tags}
              contactEmail={company.contactEmail}
              jobListingId={1}
              onSuccess={() => setIsApplyModalOpen(false)}
            />
          </ModalDialog>
        </ModalOverflow>
      </Modal>
    </Stack>
  );
}
