import {
  Button,
  Card,
  CardOverflow,
  Input,
  Stack,
  Typography,
  CardCover,
  IconButton,
  CardContent,
} from '@mui/joy';
import { useState } from 'react';
import { Link, useNavigate, useSearchParams } from 'react-router-dom';
import {
  login,
  registerStudent,
  registerTeacher,
} from '../../utils/authentication';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew';

export default function SignUp() {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [institutionalEmail, setInstitutionalEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const navigate = useNavigate();
  const [searchParams, setSearchParams] = useSearchParams();
  const signUpAsStudent = searchParams.get('signUpAs') === 'student';
  const signUpAsTeacher = searchParams.get('signUpAs') === 'teacher';

  const onSignUpAsStudent = async () => {
    if (password !== confirmPassword) {
      alert('Passwords do not match');
      return;
    }
    try {
      await registerStudent(firstName, lastName, institutionalEmail, password);
      await login(institutionalEmail, password);
      navigate('/account-set-up');
    } catch (e) {
      console.error(e);
    }
  };

  const onSignUpAsTeacher = async () => {
    if (password !== confirmPassword) {
      alert('Passwords do not match');
      return;
    }
    try {
      await registerTeacher(firstName, lastName, institutionalEmail, password);
      await login(institutionalEmail, password);
      navigate('/admin/manage-students');
    } catch (e) {
      console.error(e);
    }
  };

  return (
    <Stack width="100%" alignItems="center" padding={3}>
      <Card size="lg" orientation="horizontal" sx={{ position: 'relative' }}>
        <CardOverflow sx={{ width: 'calc(50% + 50px)', padding: '0px' }}>
          <Card
            sx={{
              height: '100%',
              padding: '25px 50px 25px 50px',
              outline: 'none',
            }}
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
                <Link to="/sign-in">
                  <Button component="a" size="lg">
                    Sign In
                  </Button>
                </Link>
                <Stack gap={2} justifyContent="center">
                  <Typography level="h1" fontSize={50}>
                    Welcome Back!
                  </Typography>
                  <Typography level="body-lg" color="neutral" maxWidth="300px">
                    To keep connected with us please log in with your personal
                    info
                  </Typography>
                </Stack>
              </Stack>
            </CardContent>
          </Card>
        </CardOverflow>
        <Stack
          width="50%"
          justifyContent="space-between"
          alignItems="center"
          paddingBottom={3}
        >
          {signUpAsStudent && (
            <Stack gap={4} alignItems="center" padding={3}>
              <Typography level="h1" textAlign="center" fontSize={45}>
                SIGN <Typography textColor="#FF0000">U</Typography>P
              </Typography>
              <Stack gap={1} alignItems="center" width="100%">
                <Input
                  placeholder="First Name"
                  sx={{ width: '230px' }}
                  value={firstName}
                  onChange={(e) => setFirstName(e.target.value)}
                />
                <Input
                  placeholder="Last Name"
                  sx={{ width: '230px' }}
                  value={lastName}
                  onChange={(e) => setLastName(e.target.value)}
                />
                <Input
                  placeholder="Institutional Email"
                  sx={{ width: '230px' }}
                  value={institutionalEmail}
                  onChange={(e) => setInstitutionalEmail(e.target.value)}
                />
                <Input
                  placeholder="Password"
                  sx={{ width: '230px' }}
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  type="password"
                />
                <Input
                  placeholder="Confirm Password"
                  sx={{ width: '230px' }}
                  value={confirmPassword}
                  onChange={(e) => setConfirmPassword(e.target.value)}
                  type="password"
                />
              </Stack>
            </Stack>
          )}
          {signUpAsTeacher && (
            <Stack gap={4} alignItems="center" padding={3}>
              <Typography level="h1" textAlign="center" fontSize={45}>
                SIGN <Typography textColor="#FF0000">U</Typography>P
              </Typography>
              <Stack gap={1} alignItems="center" width="100%">
                <Input
                  placeholder="First Name"
                  sx={{ width: '230px' }}
                  value={firstName}
                  onChange={(e) => setFirstName(e.target.value)}
                />
                <Input
                  placeholder="Last Name"
                  sx={{ width: '230px' }}
                  value={lastName}
                  onChange={(e) => setLastName(e.target.value)}
                />
                <Input
                  placeholder="Institutional Email"
                  sx={{ width: '230px' }}
                  value={institutionalEmail}
                  onChange={(e) => setInstitutionalEmail(e.target.value)}
                />
                <Input
                  placeholder="Password"
                  sx={{ width: '230px' }}
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  type="password"
                />
                <Input
                  placeholder="Confirm Password"
                  sx={{ width: '230px' }}
                  value={confirmPassword}
                  onChange={(e) => setConfirmPassword(e.target.value)}
                  type="password"
                />
              </Stack>
            </Stack>
          )}
          {!signUpAsStudent && !signUpAsTeacher && (
            <Stack gap={2} alignItems="center" padding={3}>
              <Typography level="h1" textAlign="center" fontSize={45}>
                SIGN <Typography textColor="#FF0000">U</Typography>P
              </Typography>
              <Typography level="body-md" color="neutral" maxWidth="300px">
                as
              </Typography>
              <Stack direction="row" gap={1}>
                <Button
                  size="lg"
                  color="success"
                  onClick={() => setSearchParams({ signUpAs: 'student' })}
                  startDecorator={
                    <AccountCircleIcon sx={{ fontSize: '90px' }} />
                  }
                  sx={{
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                    '.MuiButton-startDecorator': {
                      marginRight: '0px',
                    },
                    width: '150px',
                    height: '200px',
                  }}
                >
                  <Typography level="h3" textColor="#FFF">
                    Student
                  </Typography>
                </Button>
                <Button
                  size="lg"
                  color="success"
                  onClick={() => setSearchParams({ signUpAs: 'teacher' })}
                  startDecorator={
                    <AccountCircleIcon sx={{ fontSize: '90px' }} />
                  }
                  sx={{
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                    '.MuiButton-startDecorator': {
                      marginRight: '0px',
                    },
                    width: '150px',
                    height: '200px',
                  }}
                >
                  <Typography level="h3" textColor="#FFF">
                    Teacher
                  </Typography>
                </Button>
              </Stack>
            </Stack>
          )}
          {(signUpAsTeacher || signUpAsStudent) && (
            <Button
              size="lg"
              sx={{ width: 'fit-content' }}
              color="success"
              onClick={signUpAsStudent ? onSignUpAsStudent : onSignUpAsTeacher}
            >
              Sign Up
            </Button>
          )}
        </Stack>
        {(signUpAsStudent || signUpAsTeacher) && (
          <IconButton
            sx={{ position: 'absolute', top: '25px', right: '330px' }}
            variant="plain"
            size="sm"
            onClick={() => navigate(-1)}
          >
            <ArrowBackIosNewIcon />
          </IconButton>
        )}
      </Card>
    </Stack>
  );
}
