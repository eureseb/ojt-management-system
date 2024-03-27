import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getCompany, getCompanyEvaluations } from '../../utils/api';
import { Card, CardContent, Chip, Divider, Stack, Typography } from '@mui/joy';
import PeopleIcon from '@mui/icons-material/People';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import SentimentVeryDissatisfiedIcon from '@mui/icons-material/SentimentVeryDissatisfied';
import SentimentDissatisfiedIcon from '@mui/icons-material/SentimentDissatisfied';
import SentimentSatisfiedIcon from '@mui/icons-material/SentimentSatisfied';
import SentimentVerySatisfiedIcon from '@mui/icons-material/SentimentVerySatisfied';
import ThumbUpOffAltIcon from '@mui/icons-material/ThumbUpOffAlt';
import ThumbDownOffAltIcon from '@mui/icons-material/ThumbDownOffAlt';

export default function Company() {
  const params = useParams();
  const [company, setCompany] = useState(null);
  const [evaluations, setEvaluations] = useState([]);
  const [isCompanyLoading, setIsCompanyLoading] = useState(true);
  const [areEvaluationsLoading, setAreEvaluationsLoading] = useState(true);
  useEffect(() => {
    (async () => {
      try {
        setIsCompanyLoading(true);
        const company = await getCompany(params.companyId);
        setCompany(company);
        console.log(company);
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
        console.log(companyEvaluations);
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
      <Stack gap={1}>
        <Typography level="h1">{company.name}</Typography>
        <Stack direction="row" gap={1} flexWrap="wrap">
          {company.tags.map((tag) => (
            <Chip key={tag}>
              {tag} ({tag.length})
            </Chip>
          ))}
        </Stack>
      </Stack>
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
      <Typography level="body-md">{company.description}</Typography>
      <Stack gap={2}>
        {evaluations.map((evaluation) => (
          <Card key={evaluation.id}>
            <CardContent>
              <Stack gap={3}>
                <Typography level="title-lg">
                  {evaluation.evaluationTerm}
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
    </Stack>
  );
}
