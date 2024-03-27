import { IconButton, Stack, Typography } from '@mui/joy';
import NavigateNextIcon from '@mui/icons-material/NavigateNext';
import NavigateBeforeIcon from '@mui/icons-material/NavigateBefore';
import PropTypes from 'prop-types';

export default function Pagination({
  currentPage,
  totalPages,
  totalCount,
  totalDisplayed,
  onPageChange,
}) {
  const onNext = () => {
    if (currentPage === totalPages) return;
    onPageChange(currentPage + 1);
  };
  const onPrevious = () => {
    if (currentPage === 1) return;
    onPageChange(currentPage - 1);
  };
  const onNumberClick = (pageNumber) => {
    onPageChange(pageNumber);
  };
  const maxElementInPage =
    currentPage * totalDisplayed > totalCount
      ? totalCount
      : currentPage * totalDisplayed;
  return (
    <Stack direction="row" alignItems="center" gap={1} alignSelf="flex-end">
      <Typography level="body-sm">
        {(currentPage - 1) * totalDisplayed}-{maxElementInPage} of {totalCount}
      </Typography>
      <IconButton disabled={currentPage === 1} onClick={onPrevious} size="sm">
        <NavigateBeforeIcon />
      </IconButton>
      {Array.from({ length: totalPages }, (_, i) => (
        <IconButton
          size="sm"
          key={i}
          color={i + 1 === currentPage ? 'primary' : 'neutral'}
          variant={i + 1 === currentPage ? 'solid' : 'plain'}
          disabled={i + 1 === currentPage}
          onClick={() => onNumberClick(i + 1)}
        >
          {i + 1}
        </IconButton>
      ))}
      <IconButton
        disabled={currentPage === totalPages}
        onClick={onNext}
        size="sm"
      >
        <NavigateNextIcon />
      </IconButton>
    </Stack>
  );
}

Pagination.propTypes = {
  currentPage: PropTypes.number.isRequired,
  totalPages: PropTypes.number.isRequired,
  totalCount: PropTypes.number.isRequired,
  totalDisplayed: PropTypes.number.isRequired,
  onPageChange: PropTypes.func.isRequired,
};
