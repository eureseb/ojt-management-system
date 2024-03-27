import {
  Button,
  Card,
  CardActions,
  CardContent,
  FormControl,
  FormLabel,
  Stack,
  Textarea,
  Typography,
} from '@mui/joy';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { updateStudentPreferences } from '../../utils/api';

export default function AccountSetUp() {
  const [companyPreferences, setCompanyPreferences] = useState('');
  const [workEnvironmentPreferences, setworkEnvironmentPreferences] =
    useState('');
  const [locationAndCommutePreferences, setlocationAndCommutePreferences] =
    useState('');
  const [
    compensationAndBenefitsPreferences,
    setcompensationAndBenefitsPreferences,
  ] = useState('');
  const [technicalSkillsAndInterests, setTechnicalSkillsAndInterests] =
    useState('');
  const [feedbackAndSuggestions, setFeedbackAndSuggestions] = useState('');
  const navigate = useNavigate();

  const onSubmit = async () => {
    try {
      await updateStudentPreferences({
        companyPreferences,
        workEnvironmentPreferences,
        locationAndCommutePreferences,
        compensationAndBenefitsPreferences,
        technicalSkillsAndInterests,
        feedbackAndSuggestions,
      });
      navigate('/dashboard');
    } catch (e) {
      console.error(e);
    }
  };

  return (
    <Stack padding={5} alignItems="center">
      <Stack gap={4} maxWidth="1000px">
        <Stack>
          <Typography level="h1">Hello, User</Typography>
          <Typography level="h3">Start and find your company</Typography>
        </Stack>
        <Card size="lg">
          <CardContent>
            <Stack gap={3}>
              <FormControl>
                <FormLabel>Company Preferences: </FormLabel>
                <Textarea
                  variant="soft"
                  size="sm"
                  minRows={3}
                  sx={{ width: '800px' }}
                  value={companyPreferences}
                  onChange={(e) => setCompanyPreferences(e.target.value)}
                  placeholder="Do you prefer working in a specific industry? (e.g., technology, finance, healthcare, etc.)"
                />
              </FormControl>
              <FormControl>
                <FormLabel>Work Environment: </FormLabel>
                <Textarea
                  variant="soft"
                  size="sm"
                  minRows={3}
                  value={workEnvironmentPreferences}
                  onChange={(e) =>
                    setworkEnvironmentPreferences(e.target.value)
                  }
                  placeholder="Do you prefer a traditional office setup or are you open to remote work/hybrid setups?"
                />
              </FormControl>
              <FormControl>
                <FormLabel>Location and Commute: </FormLabel>
                <Textarea
                  variant="soft"
                  size="sm"
                  minRows={3}
                  value={locationAndCommutePreferences}
                  onChange={(e) =>
                    setlocationAndCommutePreferences(e.target.value)
                  }
                  placeholder="How important is the commute time/distance to the workplace for you?"
                />
              </FormControl>
              <FormControl>
                <FormLabel>Compensation and Benefits: </FormLabel>
                <Textarea
                  variant="soft"
                  size="sm"
                  minRows={3}
                  value={compensationAndBenefitsPreferences}
                  onChange={(e) =>
                    setcompensationAndBenefitsPreferences(e.target.value)
                  }
                  placeholder="Are you looking for paid or unpaid OJT opportunities?"
                />
              </FormControl>
              <FormControl>
                <FormLabel>Technical Skills and Interests: </FormLabel>
                <Textarea
                  variant="soft"
                  size="sm"
                  minRows={3}
                  value={technicalSkillsAndInterests}
                  onChange={(e) =>
                    setTechnicalSkillsAndInterests(e.target.value)
                  }
                  placeholder="What technical skills or areas of expertise are you looking to develop during your OJT?"
                />
              </FormControl>
              <FormControl>
                <FormLabel>Feedback and Suggestions: </FormLabel>
                <Textarea
                  variant="soft"
                  size="sm"
                  minRows={3}
                  value={feedbackAndSuggestions}
                  onChange={(e) => setFeedbackAndSuggestions(e.target.value)}
                  placeholder="Do you have any specific requirements or accommodations that need to be considered?"
                />
              </FormControl>
            </Stack>
          </CardContent>
          <CardActions orientation="horizontal-reverse" buttonFlex="10px 10px">
            <Button size="lg" component="a" onClick={onSubmit}>
              Submit
            </Button>
          </CardActions>
        </Card>
      </Stack>
    </Stack>
  );
}
