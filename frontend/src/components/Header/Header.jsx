import { Stack } from '@mui/joy';
import Logo from '../../assets/logo.png';
import { Link } from 'react-router-dom';
import { Link as MuiLink } from '@mui/joy';
import { isLoggedIn as fetchIsLoggedIn } from '../../utils/authentication';
import { useEffect, useState } from 'react';

export default function Header() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  useEffect(() => {
    (async () => {
      setIsLoggedIn(await fetchIsLoggedIn());
    })();
  }, [isLoggedIn]);

  const path = window.location.pathname;

  return (
    <Stack
      padding="30px 70px 20px"
      direction="row"
      alignItems="center"
      justifyContent="space-between"
      sx={{
        borderBottom: '1px solid #E0E0E0',
      }}
    >
      <Link to="/">
        <img src={Logo} alt="INTern" width="140px" />
      </Link>
      <Stack direction="row" gap={5}>
        {(!isLoggedIn ||
          path === '/' ||
          path === '/sign-in' ||
          path === '/sign-up') && (
          <>
            <Link to="/sign-in" style={{ textDecoration: 'none' }}>
              <MuiLink
                level="title-md"
                color={path === '/sign-in' ? 'primary' : 'neutral'}
              >
                Sign In
              </MuiLink>
            </Link>
            <Link to="/sign-up" style={{ textDecoration: 'none' }}>
              <MuiLink
                level="title-md"
                color={path === '/sign-up' ? 'primary' : 'neutral'}
              >
                Sign Up
              </MuiLink>
            </Link>
          </>
        )}
      </Stack>
    </Stack>
  );
}
