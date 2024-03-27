import {
  Autocomplete,
  Button,
  CardActions,
  FormControl,
  FormHelperText,
  FormLabel,
  Card as MuiCard,
  Radio,
  RadioGroup,
  Stack,
  Textarea,
  Typography,
} from '@mui/joy';
import PropTypes from 'prop-types';
import { useEffect, useState } from 'react';
import { getAllCompanies, submitCompanyEvaluation } from '../../utils/api';

export default function CompanyEvaluationForm({
  evaluationTitle,
  evaluationTerm,
  onSuccess,
}) {
  const [companies, setCompanies] = useState([]);
  const [selectedCompany, setSelectedCompany] = useState(null);
  const [isRecommendedForOJT, setIsRecommendedForOJT] = useState(null);
  const [isRecommendedForOJTReason, setIsRecommendedForOJTReason] =
    useState('');
  const [experienceEvaluation, setExperienceEvaluation] = useState(null);
  const [experienceWithCompany, setExperienceWithCompany] = useState('');

  useEffect(() => {
    (async () => {
      const companies = await getAllCompanies();
      setCompanies(companies);
    })();
  }, []);

  const onSubmit = async () => {
    try {
      await submitCompanyEvaluation({
        companyId: selectedCompany.id,
        isRecommendedForOJT,
        isRecommendedForOJTReason,
        experienceEvaluation,
        experienceWithCompany,
        evaluationTerm,
      });
      onSuccess();
    } catch (e) {
      console.error(e);
    }
  };

  return (
    <Stack gap={2} maxWidth="800px">
      <MuiCard variant="soft" sx={{ width: '100%' }}>
        <Typography level="title-md">{evaluationTitle}</Typography>
      </MuiCard>
      <Typography level="body-sm"> Due on Dec 31, 2024 at 11:00 PM</Typography>
      <Typography level="title-md">
        Harness the Power of AI to Evaluate Company Internship Performance
      </Typography>
      <Typography level="body-sm">
        Our cutting-edge AI algorithms delve into the depths of online data,
        meticulously analyzing employee reviews, social media conversations, and
        industry news to generate a comprehensive sentiment analysis for each
        company listed on our platform. This invaluable intelligence empowers
        you to make informed decisions about your internship journey.
      </Typography>
      <FormControl>
        <FormLabel>Company Name</FormLabel>
        <Autocomplete
          placeholder="Enter your answer"
          options={companies.map((company) => ({
            label: company.name,
            id: company.id,
          }))}
          isOptionEqualToValue={(option, value) => option.id === value.id}
          variant="soft"
          size="sm"
          value={selectedCompany}
          onChange={(e, option) => setSelectedCompany(option)}
        />
      </FormControl>
      <FormControl>
        <FormLabel>
          Would you recommend IT/CS students to their OJT in this company
        </FormLabel>
        <RadioGroup
          defaultValue="medium"
          name="radio-buttons-group"
          value={isRecommendedForOJT}
          onChange={(e) => setIsRecommendedForOJT(e.target.value)}
        >
          <Radio value={true} label="Yes" size="sm" />
          <Radio value={false} label="No" size="sm" />
        </RadioGroup>
      </FormControl>
      <FormControl>
        <FormLabel>Tell us why or why not?</FormLabel>
        <Textarea
          minRows={4}
          variant="soft"
          placeholder="Enter your answer"
          size="sm"
          value={isRecommendedForOJTReason}
          onChange={(e) => setIsRecommendedForOJTReason(e.target.value)}
        ></Textarea>
      </FormControl>
      <FormControl>
        <FormLabel>How will you rate your experience?</FormLabel>
        <RadioGroup
          defaultValue="medium"
          name="radio-buttons-group"
          value={experienceEvaluation}
          onChange={(e) => setExperienceEvaluation(e.target.value)}
        >
          <Radio value="VERY_GOOD" label="Very Good" size="sm" />
          <Radio value="GOOD" label="Good" size="sm" />
          <Radio value="BAD" label="Bad" size="sm" />
          <Radio value="VERY_BAD" label="Very Bad" size="sm" />
        </RadioGroup>
      </FormControl>
      <FormControl>
        <FormLabel>
          Share your experience while training in this company.
        </FormLabel>
        <Textarea
          minRows={4}
          variant="soft"
          placeholder="Enter your answer"
          size="sm"
          value={experienceWithCompany}
          onChange={(e) => setExperienceWithCompany(e.target.value)}
        ></Textarea>
        <FormHelperText>
          Please provide detailed information, as this will serve as the
          reference for our rating company
        </FormHelperText>
      </FormControl>
      <CardActions orientation="horizontal-reverse" buttonFlex="10px 10px">
        <Button onClick={onSubmit}>Submit</Button>
      </CardActions>
    </Stack>
  );
}

CompanyEvaluationForm.propTypes = {
  evaluationTitle: PropTypes.string,
  evaluationTerm: PropTypes.string,
  onSuccess: PropTypes.func,
};
