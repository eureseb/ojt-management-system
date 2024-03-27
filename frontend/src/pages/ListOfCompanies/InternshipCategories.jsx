import { List, ListItem, Stack, Typography } from '@mui/joy';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

export default function InternshipCategories({ internshipCategories }) {
  return (
    <Stack minWidth={300} alignItems="flex-end">
      <Typography level="title-sm" sx={{ paddingRight: 2 }}>
        INTERNSHIP CATEGORY
      </Typography>
      <List>
        {internshipCategories.map((category) => (
          <ListItem key={category.id} sx={{ justifyContent: 'flex-end' }}>
            <Link>
              <Typography level="body-sm">
                {category.title} ({category.count})
              </Typography>
            </Link>
          </ListItem>
        ))}
      </List>
    </Stack>
  );
}

InternshipCategories.propTypes = {
  internshipCategories: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.string.isRequired,
      title: PropTypes.string.isRequired,
      count: PropTypes.number.isRequired,
    })
  ).isRequired,
};
