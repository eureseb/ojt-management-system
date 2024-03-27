import { Divider, Stack, Typography } from '@mui/joy';
import RequirementCard from './RequirementCard';
import requirements from '../../mockData/requirements';
import isDateWithinCurrentWeek from '../../utils/isDateWithinCurrentWeek';
import isDateWithinNextWeek from '../../utils/isDateWithinNextWeek';

export default function OJTRequirements() {
  const parsedRequirements = requirements.map((requirement) => ({
    ...requirement,
    dueDate: new Date(requirement.dueDate),
  }));
  const requirementsThisWeek = parsedRequirements.filter((requirement) => {
    return isDateWithinCurrentWeek(requirement.dueDate);
  });
  const requirementsNextWeek = parsedRequirements.filter((requirement) => {
    return isDateWithinNextWeek(requirement.dueDate);
  });
  const otherRequirements = parsedRequirements.filter(
    (requirement) =>
      !isDateWithinCurrentWeek(requirement.dueDate) &&
      !isDateWithinNextWeek(requirement.dueDate) &&
      requirement.dueDate >= new Date()
  );

  return (
    <Stack gap={5} padding={5}>
      <Stack>
        <Typography level="h1">Hello, User</Typography>
        <Typography level="h3">
          Go ahead and submit necessary requirements
        </Typography>
      </Stack>
      <Stack gap={2}>
        <Typography level="title-lg">OJT Requirements</Typography>
        <Typography level="body-md">
          CAT is an always-updated OJT hiring website with integration of AI
          analytics where you can easily find job listings by locality and by
          specialty. Here on this page, you&apos;ll be able to discover urgent
          listings for OJT opportunities based in the Province of Cebu. Jobs are
          sorted in several ways: according to the city they&apos;re located in,
          according to the field or discipline they pertain to, or according to
          the experience level needed from the candidate.
        </Typography>
      </Stack>
      <Stack gap={2}>
        <Divider sx={{ '--Divider-childPosition': '0%' }}>
          <Typography level="title-md" color="neutral">
            Due this week
          </Typography>
        </Divider>
        <Stack direction="row" gap={4} flexWrap="wrap">
          {requirementsThisWeek.map((requirement) => (
            <RequirementCard
              key={requirement.id}
              title={requirement.title}
              description={requirement.description}
              referenceLink={requirement.referenceLink}
              isComplete={requirement.isComplete}
              dueDate={requirement.dueDate}
              id={requirement.id}
            />
          ))}
        </Stack>
        <Divider sx={{ '--Divider-childPosition': '0%' }}>
          <Typography level="title-md" color="neutral">
            Due next week
          </Typography>
        </Divider>
        <Stack direction="row" gap={4} flexWrap="wrap">
          {requirementsNextWeek.map((requirement) => (
            <RequirementCard
              key={requirement.id}
              title={requirement.title}
              description={requirement.description}
              referenceLink={requirement.referenceLink}
              isComplete={requirement.isComplete}
              dueDate={requirement.dueDate}
              id={requirement.id}
            />
          ))}
        </Stack>
        <Divider sx={{ '--Divider-childPosition': '0%' }}>
          <Typography level="title-md" color="neutral">
            Upcoming
          </Typography>
        </Divider>
        <Stack direction="row" gap={4} flexWrap="wrap">
          {otherRequirements.map((requirement) => (
            <RequirementCard
              key={requirement.id}
              title={requirement.title}
              description={requirement.description}
              referenceLink={requirement.referenceLink}
              isComplete={requirement.isComplete}
              dueDate={requirement.dueDate}
              id={requirement.id}
            />
          ))}
        </Stack>
      </Stack>
    </Stack>
  );
}
