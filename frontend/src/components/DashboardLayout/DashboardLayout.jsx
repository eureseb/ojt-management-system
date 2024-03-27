import { DialogContent, Stack } from '@mui/joy';
import Header from '../Header/Header';
import SideNav from '../SideNav/SideNav';
import { Outlet } from 'react-router-dom';

export default function MainLayout() {
  return (
    <Stack height="100%" maxWidth={1900} margin="auto">
      <Header />
      <Stack height="100%" direction="row">
        <SideNav />
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
