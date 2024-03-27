import { Stack, Typography, Button, Divider, useTheme } from '@mui/joy';
import Card from '../../shared/Card';
import { CheckCircle } from '@mui/icons-material';
import CancelIcon from '@mui/icons-material/Cancel';
import DownloadIcon from '@mui/icons-material/Download';
import CloudUploadIcon from '@mui/icons-material/CloudUpload';
import PropTypes from 'prop-types';
import getColorFromId from '../../utils/getColorFromId';
import downloadResources from '../../utils/downloadResource';

export default function RequirementCard({
  title,
  description,
  referenceLink,
  isComplete,
  dueDate,
  id,
}) {
  const theme = useTheme();
  return (
    <Card
      maxWidth="350px"
      color={
        isComplete ? theme.vars.palette.neutral[200] : getColorFromId(id, theme)
      }
    >
      <Stack width="100%" gap={3}>
        <Stack gap={2}>
          <Stack
            direction="row"
            justifyContent="space-between"
            alignItems="center"
          >
            <Typography level="title-lg">{title}</Typography>
            {isComplete ? (
              <CheckCircle color="success" />
            ) : (
              <CancelIcon color="danger" />
            )}
          </Stack>
          <Divider />
          <Stack>
            <Typography level="body-md">
              Due on {dueDate.toLocaleString()}
            </Typography>
            <Typography level="body-sm">{description}</Typography>
          </Stack>
        </Stack>
        <Stack gap={1}>
          <Button
            sx={{ alignSelf: 'flex-start' }}
            variant="outlined"
            startDecorator={<DownloadIcon />}
            onClick={() => downloadResources()}
          >
            Download Reference Materials
          </Button>
          <Button
            sx={{ alignSelf: 'flex-start' }}
            startDecorator={<CloudUploadIcon />}
          >
            Upload
          </Button>
        </Stack>
      </Stack>
    </Card>
  );
}

RequirementCard.propTypes = {
  title: PropTypes.string,
  description: PropTypes.string,
  referenceLink: PropTypes.string,
  isComplete: PropTypes.bool,
  dueDate: PropTypes.instanceOf(Date),
  id: PropTypes.number,
};
