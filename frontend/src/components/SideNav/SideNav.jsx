import { Avatar, Divider, Link, List, Stack, Typography } from '@mui/joy';
import NavItem from './NavItem';
import { useNavigate } from 'react-router-dom';
import { logout } from '../../utils/authentication';
import { useEffect, useState } from 'react';
import { getLoggedInStudentInfo } from '../../utils/api';

export default function SideNav() {
  const navigate = useNavigate();
  const [username, setUsername] = useState('Loading');

  const onLogOut = () => {
    logout();
    navigate('/sign-in');
  };

  useEffect(() => {
    (async () => {
      try {
        const currentUser = await getLoggedInStudentInfo();
        setUsername(currentUser.accountInformation.firstName);
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
            <NavItem title="Dashboard" to="/dashboard" />
            <NavItem title="OJT Requirements" to="/ojt-requirements" />
            <NavItem title="List of Companies" to="/company-list" />
            <NavItem title="Company Evaluation" to="/company-evaluation" />
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

SideNav.propTypes = {};
