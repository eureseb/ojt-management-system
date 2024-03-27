import { Stack } from '@mui/joy';
import Header from '../Header/Header';
import { Outlet } from 'react-router-dom';

export default function LandingLayout() {
  return (
    <Stack height="100%" maxWidth={1330} margin="auto">
      <Header />
      <Outlet />
    </Stack>
  );
}
