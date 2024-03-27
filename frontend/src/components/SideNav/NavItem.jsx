import { ListItemButton, Stack } from '@mui/joy';
import PropTypes from 'prop-types';
import { useNavigate } from 'react-router-dom';

export default function NavItem({ title, to }) {
  const navigate = useNavigate();
  const path = window.location.pathname;

  return (
    <ListItemButton
      onClick={() => navigate(to)}
      selected={to === path}
      variant={to === path ? 'solid' : 'plain'}
      color={to === path ? 'primary' : 'neutral'}
    >
      <Stack paddingLeft="20px" width="100%">
        {title}
      </Stack>
    </ListItemButton>
  );
}

NavItem.propTypes = {
  title: PropTypes.string.isRequired,
  to: PropTypes.string.isRequired,
};
