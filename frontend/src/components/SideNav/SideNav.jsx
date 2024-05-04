import { Avatar, Divider, Link, List, Stack, Typography } from '@mui/joy';
import NavItem from './NavItem';
import { useNavigate } from 'react-router-dom';
import { logout } from '../../utils/authentication';
import { useEffect, useState } from 'react';
import { getLoggedInUserInfo } from '../../utils/api';
import PropTypes from 'prop-types';

export default function SideNav({ isAdmin = false }) {
  const navigate = useNavigate();
  const [username, setUsername] = useState('Loading');

  const onLogOut = () => {
    logout();
    navigate('/sign-in');
  };

  useEffect(() => {
    (async () => {
      try {
        const currentUser = await getLoggedInUserInfo();
        setUsername(currentUser.firstName);
      } catch (e) {
        navigate('/sign-in');
      }
    })();
  }, [navigate]);
  return (
    <Stack
      justifyContent="space-between"
      height="100%"
      maxHeight="calc(100vh - 125px)"
      sx={{ borderRight: '1px solid #E0E0E0' }}
    >
      <Stack width="240px" height="100%" justifyContent="space-between">
        <Stack alignItems="flex-start">
          <Stack direction="row" gap={2} alignItems="center" padding={3}>
            <Avatar size="lg" variant="outlined" color="success" />
            <Stack>
              <Typography level="title-lg">{username}</Typography>
              <Typography level="body-sm">BS Computer Science</Typography>
            </Stack>
          </Stack>
          <Divider />
          <List
            component="nav"
            sx={{
              width: '100%',
            }}
            size="md"
          >
            {isAdmin ? (
              <>
                <NavItem title="Manage Students" to="/admin/manage-students" />
                <NavItem
                  title="Manage Applications"
                  to="/admin/manage-applications"
                />
                <NavItem
                  title="Manage Companies"
                  to="/admin/manage-companies"
                />
                <NavItem
                  title="Company Evaluation"
                  to="/admin/manage-evaluation"
                />
              </>
            ) : (
              <>
                <NavItem title="Dashboard" to="/dashboard" />
                <NavItem title="OJT Requirements" to="/ojt-requirements" />
                <NavItem title="List of Companies" to="/company-list" />
                <NavItem title="Company Evaluation" to="/company-evaluation" />
                <NavItem title="Update Preferences" to="/update-preferences" />
              </>
            )}
          </List>
        </Stack>
        <Stack padding={3} alignItems="center">
          <Link level="title-md" color="neutral" onClick={onLogOut}>
            Log out
          </Link>
        </Stack>
      </Stack>
    </Stack>
  );
}

SideNav.propTypes = {
  isAdmin: PropTypes.bool,
};
