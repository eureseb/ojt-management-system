import { DialogContent, Stack } from '@mui/joy';
import Header from '../Header/Header';
import SideNav from '../SideNav/SideNav';
import { Outlet } from 'react-router-dom';
import PropTypes from 'prop-types';

export default function MainLayout({ isAdmin = false }) {
  return (
    <Stack height="100%" maxWidth={1500} margin="auto">
      <Header />
      <Stack height="100%" direction="row">
        <SideNav isAdmin={isAdmin} />
        <DialogContent
          sx={{
            maxHeight: 'calc(100vh - 125px)',
            '&::-webkit-scrollbar': {
              width: '10px',
            },
            '&::-webkit-scrollbar-thumb': {
              backgroundColor: '#f1f1f1',
              borderRadius: '20px',
            },
          }}
        >
          <Outlet />
        </DialogContent>
      </Stack>
    </Stack>
  );
}

MainLayout.propTypes = {
  isAdmin: PropTypes.bool,
};
