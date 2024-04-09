import {
  Button,
  Card,
  CardOverflow,
  Link as MuiLink,
  Input,
  Stack,
  Typography,
  CardCover,
  CardContent,
} from '@mui/joy';
import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { login } from '../../utils/authentication';
import { getLoggedInUserInfo, getRole } from '../../utils/api';
import { Roles } from '../../utils/constants';

export default function SignIn() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleSignIn = async () => {
    try {
      await login(email, password);
      const role = await getRole();
      if (role == Roles.STUDENT) navigate('/dashboard');
      else if (role == Roles.TEACHER) navigate('/admin/manage-students');
    } catch (e) {
      console.error(e);
    }
  };

  return (
    <Stack width="100%" alignItems="center" padding={3}>
      <Card size="lg" orientation="horizontal">
        <Stack width="50%" gap={4} alignItems="center" padding={3}>
          <Typography level="h1" textAlign="center" fontSize={45}>
            SIGN <Typography textColor="#FF0000">I</Typography>N
          </Typography>
          <Stack gap={1} alignItems="center" width="100%">
            <Input placeholder="Enter Roomcode" sx={{ width: '230px' }} />
            <Typography level="body-md">or use your account</Typography>
            <Input
              placeholder="Institute Email"
              sx={{ width: '230px' }}
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
            <Input
              placeholder="Password"
              sx={{ width: '230px' }}
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              type="password"
            />
            <Link to="/forgot-password" style={{ textDecoration: 'none' }}>
              <MuiLink>
                <Typography level="body-md">Forgot Password?</Typography>
              </MuiLink>
            </Link>
          </Stack>
          <Button
            size="lg"
            sx={{ width: 'fit-content' }}
            color="success"
            onClick={handleSignIn}
          >
            Sign In
          </Button>
        </Stack>
        <CardOverflow sx={{ width: 'calc(50% + 50px)', padding: '0px' }}>
          <Card
            sx={{ height: '100%', padding: '25px 50px 25px 50px' }}
            variant="solid"
            invertedColors
            color="primary"
            size="lg"
          >
            <CardCover
              sx={{
                background:
                  'linear-gradient(152.1deg, #800000 19.07%, #FFFFFF 106.69%, rgba(255, 61, 0, 0) 106.7%)',
                backdropFilter: 'blur(1px)',
              }}
            ></CardCover>
            <CardContent>
              <Stack
                height="100%"
                alignItems="center"
                padding="24px 0px 24px 0px"
                direction="column-reverse"
                gap={14}
              >
                <Link to="/sign-up">
                  <Button size="lg">Sign Up</Button>
                </Link>
                <Stack gap={2} justifyContent="center">
                  <Typography level="h1" fontSize={50}>
                    HELLO, INTERN
                  </Typography>
                  <Typography level="body-lg" color="neutral" maxWidth="300px">
                    Enter your personal details and start your journey with us
                  </Typography>
                </Stack>
              </Stack>
            </CardContent>
          </Card>
        </CardOverflow>
      </Card>
    </Stack>
  );
}
