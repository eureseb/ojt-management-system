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
  Select,
  Chip,
  Option,
  FormHelperText,
  ChipDelete,
  Checkbox,
  Radio,
  RadioGroup,
} from '@mui/joy';
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {
  getLoggedInStudentInfo,
  updateStudentPreferences,
} from '../../utils/api';
import PropTypes from 'prop-types';

const COMPANY_PREFERENCES = [
  { value: 'Professional Environment', label: 'Professional Environment' },
  { value: 'New Knowledge', label: 'New Knowledge' },
  { value: 'Self Learning', label: 'Self Learning' },
  { value: 'Industry Experience', label: 'Industry Experience' },
  { value: 'Pleasant Experience', label: 'Pleasant Experience' },
  { value: 'Great Experience', label: 'Great Experience' },
  { value: 'Good Mentors', label: 'Good Mentors' },
  { value: 'Systems Development', label: 'Systems Development' },
  { value: 'Allowance', label: 'Allowance' },
  { value: 'Poor Handling', label: 'Poor Handling' },
  { value: 'Unpleasant Experience', label: 'Unpleasant Experience' },
  { value: 'Challenging Experience', label: 'Challenging Experience' },
  { value: 'Web Development', label: 'Web Development' },
  { value: 'Project Management', label: 'Project Management' },
  { value: 'Good Environment', label: 'Good Environment' },
];

const WORK_ENVIRONMENT = [
  { value: 'onsite', label: 'Onsite' },
  { value: 'hybrid', label: 'Hybrid' },
  { value: 'remote', label: 'Remote' },
];

export default function AccountSetUp({ update }) {
  const [companyPreferences, setCompanyPreferences] = useState([]);
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

  useEffect(() => {
    (async () => {
      if (!update) return;
      const student = await getLoggedInStudentInfo();
      setCompanyPreferences(student.companyPreferences || []);
      setFeedbackAndSuggestions(student.feedbackAndSuggestions || '');
      setTechnicalSkillsAndInterests(student.technicalSkillsAndInterests || '');
      setcompensationAndBenefitsPreferences(
        student.compensationAndBenefitsPreferences || ''
      );
      setworkEnvironmentPreferences(student.workEnvironmentPreferences || '');
      setlocationAndCommutePreferences(
        student.locationAndCommutePreferences || ''
      );
    })();
  }, [update]);

  return (
    <Stack padding={5} alignItems="center">
      <Stack gap={4} maxWidth="600px" width="100%">
        {!update && (
          <Stack>
            <Typography level="h3">Start and find your company</Typography>
          </Stack>
        )}
        <Card size="lg">
          <CardContent>
            <Stack gap={3}>
              <FormControl size="lg">
                <FormLabel>Company Preferences: </FormLabel>
                <Select
                  variant="soft"
                  multiple
                  renderValue={() => 'Select at most 3'}
                  placeholder="Select at most 3"
                  value={companyPreferences}
                  onChange={(_, newValue) => {
                    if (newValue.length > 3) return;
                    setCompanyPreferences(newValue);
                  }}
                >
                  {COMPANY_PREFERENCES.map((option) => (
                    <Option key={option.value} value={option.value}>
                      <Checkbox
                        variant="plain"
                        checked={companyPreferences.includes(option.value)}
                      />
                      {option.label}
                    </Option>
                  ))}
                </Select>
                <FormHelperText>
                  {
                    <Stack direction="row" gap={1}>
                      {companyPreferences.map((selectedOption) => (
                        <Chip
                          variant="soft"
                          color="primary"
                          key={selectedOption}
                          endDecorator={
                            <ChipDelete
                              onDelete={() =>
                                setCompanyPreferences((prev) =>
                                  prev.filter(
                                    (option) => option !== selectedOption
                                  )
                                )
                              }
                            />
                          }
                        >
                          {
                            COMPANY_PREFERENCES.find(
                              (option) => option.value === selectedOption
                            ).label
                          }
                        </Chip>
                      ))}
                    </Stack>
                  }
                </FormHelperText>
              </FormControl>
              <FormControl size="lg">
                <FormLabel>Work Environment: </FormLabel>
                <RadioGroup
                  name="work-environment-group"
                  onChange={(e) =>
                    setworkEnvironmentPreferences(e.target.value)
                  }
                  value={workEnvironmentPreferences}
                >
                  {WORK_ENVIRONMENT.map((option) => (
                    <Radio
                      key={option.value}
                      value={option.value}
                      label={option.label}
                      variant="soft"
                    />
                  ))}
                </RadioGroup>
              </FormControl>
              <FormControl size="lg">
                <FormLabel>Location and Commute: </FormLabel>
                <Textarea
                  variant="soft"
                  minRows={3}
                  value={locationAndCommutePreferences}
                  onChange={(e) =>
                    setlocationAndCommutePreferences(e.target.value)
                  }
                  placeholder="How important is the commute time/distance to the workplace for you?"
                />
              </FormControl>
              <FormControl size="lg">
                <FormLabel>Compensation and Benefits: </FormLabel>
                <Textarea
                  variant="soft"
                  minRows={3}
                  value={compensationAndBenefitsPreferences}
                  onChange={(e) =>
                    setcompensationAndBenefitsPreferences(e.target.value)
                  }
                  placeholder="Are you looking for paid or unpaid OJT opportunities?"
                />
              </FormControl>
              <FormControl size="lg">
                <FormLabel>Technical Skills and Interests: </FormLabel>
                <Textarea
                  variant="soft"
                  minRows={3}
                  value={technicalSkillsAndInterests}
                  onChange={(e) =>
                    setTechnicalSkillsAndInterests(e.target.value)
                  }
                  placeholder="What technical skills or areas of expertise are you looking to develop during your OJT?"
                />
              </FormControl>
              <FormControl size="lg">
                <FormLabel>Feedback and Suggestions: </FormLabel>
                <Textarea
                  variant="soft"
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

AccountSetUp.propTypes = {
  update: PropTypes.bool,
};
