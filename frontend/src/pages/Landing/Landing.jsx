import {
  Box,
  Button,
  Card,
  CardContent,
  CardOverflow,
  Stack,
  Typography,
} from '@mui/joy';
import { useMediaQuery } from 'react-responsive';
import Girl from '../../assets/girl.png';
import Computer from '../../assets/computer.svg';
import ComputerBox from '../../assets/computer-box.svg';
import ResumeBox from '../../assets/resume-box.svg';
import Resume from '../../assets/resume.svg';
import SearchBox from '../../assets/search-box.svg';
import Search from '../../assets/search.svg';
import CheckBox from '../../assets/check-box.svg';
import Check from '../../assets/check.svg';
import BgRadiant from '../../assets/bg-radiant.png';
import People from '../../assets/people.png';
import Star from './Star';

export default function Landing() {
  const isMobile = useMediaQuery({ query: '(max-width: 1224px)' });
  return (
    <Stack gap={10} sx={{ position: 'relative' }}>
      <Stack
        direction="row"
        justifyContent="space-between"
        sx={{
          backgroundImage: 'url(/landing-background.png)',
          backgroundSize: 'cover',
          paddingTop: '50px',
        }}
      >
        <Stack
          alignItems="flex-start"
          justifyContent="space-between"
          width="100%"
        >
          <Typography
            level="h1"
            fontSize={isMobile ? 40 : 70}
            sx={{ marginLeft: '100px', maxWidth: isMobile ? '50%' : '68%' }}
          >
            Search with <Typography textColor="#ff0000">Ease</Typography>,{' '}
            <Typography textColor="#ffde59">Discover </Typography>
            with <Typography textColor="#5ce1e6">Confidence</Typography>
          </Typography>
          <Stack gap={2} alignItems="flex-start">
            <Stack
              sx={{
                width: '100%',
                height: '100%',
                background: 'rgba(255,255,255,0.8)',
                padding: '20px 100px',
              }}
              gap={2}
              alignItems={'flex-start'}
            >
              <Typography
                level="body-sm"
                sx={{
                  maxWidth: isMobile ? '40%' : '50%',
                }}
                textColor="#9a9595"
              >
                With{' '}
                <Typography
                  level="body-sm"
                  textColor="#800000"
                  fontWeight="bolder"
                >
                  Wildcats #INTern
                </Typography>
                , you can navigate the OJT landscape with confidence, knowing
                that you're making informed decisions based on data-driven
                insights. Experience the power of AI and discover the perfect
                OJT opportunity for your future success.
              </Typography>
              <Button
                size="lg"
                sx={{
                  borderRadius: '50px',
                  padding: '10px 30px',
                  fontWeight: 'bolder',
                }}
              >
                Join Now
              </Button>
            </Stack>
          </Stack>
        </Stack>
        <div
          style={{
            position: 'relative',
            width: '0px',
            height: isMobile ? '400px' : '500px',
            flexShrink: 0,
          }}
        >
          <img
            src={Girl}
            height={isMobile ? '400px' : '500px'}
            style={{
              position: 'absolute',
              top: 0,
              right: '-50px',
              marginRight: '100px',
            }}
          ></img>
        </div>
      </Stack>
      <Stack
        gap={5}
        padding="50px 100px"
        direction={{ sm: 'column', md: 'row' }}
        alignItems={'center'}
      >
        <Stack
          minWidth={isMobile ? '30%' : '50%'}
          alignItems="center"
          justifyContent="center"
        >
          <Stack
            maxWidth="80%"
            position="relative"
            sx={{ transform: 'translateY(-12%)' }}
          >
            <Typography level="h2">How It Works</Typography>
            <Typography
              level="h1"
              fontSize={isMobile ? '3rem' : '5rem'}
              fontWeight="700"
            >
              Follow 4 Easy Steps
            </Typography>
            <Star
              color="#db00ff"
              style={{
                position: 'absolute',
                top: '-20%',
                right: '70%',
                transform: 'rotate(10deg)',
              }}
            />
            <Star
              color="#70ff00"
              style={{
                position: 'absolute',
                top: '20%',
                right: '20%',
                transform: 'scale(1.3)',
              }}
            />
            <Star
              color="#ffb900"
              style={{
                position: 'absolute',
                bottom: '-20%',
                right: '50%',
                transform: 'scale(3)',
              }}
            />
            <Star
              color="#ff0000"
              style={{
                position: 'absolute',
                bottom: '-40%',
                left: '0%',
                transform: 'scale(2.5)',
              }}
            />
            <Star
              color="#00ffff"
              style={{
                position: 'absolute',
                bottom: '-10%',
                left: '-30%',
                transform: 'scale(1.3)',
              }}
            />
          </Stack>
        </Stack>
        <Stack
          direction="row"
          justifyContent="center"
          alignItems="center"
          flexWrap="wrap"
          gap={3}
          maxWidth={'430px'}
        >
          <Box
            style={{
              background: '#fff5cc',
              borderRadius: '0px 15% 15% 15%',
              transform: 'translate(-20px,-20px)',
            }}
          >
            <Card
              variant="soft"
              sx={{
                background: '#ffeda3',
                borderRadius: '0px 25% 25% 25%',
                width: '200px',
                height: '200px',
              }}
              size="lg"
            >
              <CardOverflow sx={{ padding: '0px' }}>
                <Box position="relative" width="min-content">
                  <img src={ComputerBox} width="70px" />
                  <img
                    src={Computer}
                    style={{
                      position: 'absolute',
                      top: '50%',
                      left: '50%',
                      transform: 'translate(-50%, -50%)',
                    }}
                    width="30px"
                  />
                </Box>
              </CardOverflow>
              <CardContent>
                <Typography level="title-lg">Create Account</Typography>
                <Typography level="body-sm">
                  Create account with your institutional email
                </Typography>
              </CardContent>
            </Card>
          </Box>
          <Box
            style={{
              background: '#e0ffff',
              borderRadius: '0px 15% 15% 15%',
              transform: 'translate(-20px,0px)',
            }}
          >
            <Card
              variant="soft"
              sx={{
                background: '#c5ffff',
                borderRadius: '0px 25% 25% 25%',
                width: '200px',
                height: '200px',
              }}
              size="lg"
            >
              <CardOverflow sx={{ padding: '0px' }}>
                <Box position="relative" width="min-content">
                  <img src={ResumeBox} width="70px" />
                  <img
                    src={Resume}
                    style={{
                      position: 'absolute',
                      top: '50%',
                      left: '50%',
                      transform: 'translate(-50%, -50%)',
                    }}
                    width="30px"
                  />
                </Box>
              </CardOverflow>
              <CardContent>
                <Typography level="title-lg">CV/Resume</Typography>
                <Typography level="body-sm">
                  Upload your Best CV/Resume
                </Typography>
              </CardContent>
            </Card>
          </Box>
          <Box
            style={{
              background: '#e0ffec',
              borderRadius: '0px 15% 15% 15%',
              transform: 'translate(0px,-20px)',
            }}
          >
            <Card
              variant="soft"
              sx={{
                background: '#c5ffdb',
                borderRadius: '0px 25% 25% 25%',
                width: '200px',
                height: '200px',
              }}
              size="lg"
            >
              <CardOverflow sx={{ padding: '0px' }}>
                <Box position="relative" width="min-content">
                  <img src={SearchBox} width="70px" />
                  <img
                    src={Search}
                    style={{
                      position: 'absolute',
                      top: '50%',
                      left: '50%',
                      transform: 'translate(-50%, -50%)',
                    }}
                    width="30px"
                  />
                </Box>
              </CardOverflow>
              <CardContent>
                <Typography level="title-lg">Search Internship</Typography>
                <Typography level="body-sm">
                  Find your company using recommended list
                </Typography>
              </CardContent>
            </Card>
          </Box>
          <Box
            style={{
              background: '#ffe0e0',
              borderRadius: '0px 15% 15% 15%',
            }}
          >
            <Card
              variant="soft"
              sx={{
                background: '#ffc5c5',
                borderRadius: '0px 25% 25% 25%',
                width: '200px',
                height: '200px',
              }}
              size="lg"
            >
              <CardOverflow sx={{ padding: '0px' }}>
                <Box position="relative" width="min-content">
                  <img src={CheckBox} width="70px" />
                  <img
                    src={Check}
                    style={{
                      position: 'absolute',
                      top: '50%',
                      left: '50%',
                      transform: 'translate(-50%, -50%)',
                    }}
                    width="30px"
                  />
                </Box>
              </CardOverflow>
              <CardContent>
                <Typography level="title-lg">Apply Them</Typography>
                <Typography level="body-sm">
                  Find to your job and enjoy
                </Typography>
              </CardContent>
            </Card>
          </Box>
        </Stack>
      </Stack>
      <Stack
        gap={2}
        sx={{ position: 'relative', overflow: 'hidden' }}
        padding="50px 100px"
      >
        <img
          src={BgRadiant}
          style={{
            position: 'absolute',
            width: '100%',
            zIndex: -1,
          }}
        />
        <Typography level="h2">
          Why sentiment analysis is a valuable feature for an OJT hiring app:
        </Typography>
        <Stack direction="row" alignItems="flex-end">
          <img src={People} width="50%" />
          <Stack gap={2} padding={3}>
            <Card
              variant="plain"
              sx={{
                background: 'rgba(255,255,255,0.7)',
              }}
            >
              <Typography level="body-sm">
                <Typography fontWeight="lg">
                  Understand company culture and identify potential red flags:{' '}
                </Typography>
                Gain insights into how employees feel about their jobs and the
                overall work environment. Identify potential concerns such as
                high turnover rates or poor management practices.
              </Typography>
            </Card>
            <Card
              variant="plain"
              sx={{
                background: 'rgba(255,255,255,0.7)',
              }}
            >
              <Typography level="body-sm">
                <Typography fontWeight="lg">
                  Make informed decisions based on real-world insights:{' '}
                </Typography>
                Go beyond traditional job listings and company brochures. Make
                decisions based on data-driven insights about company culture
                and employee satisfaction.
              </Typography>
            </Card>
            <Card
              variant="plain"
              sx={{
                background: 'rgba(255,255,255,0.7)',
              }}
            >
              <Typography level="body-sm">
                <Typography fontWeight="lg">
                  Empower OJT seekers to make the right choices:{' '}
                </Typography>
                Find a successful and rewarding internship experience. Enhance
                the overall OJT hiring experience.
              </Typography>
            </Card>
          </Stack>
        </Stack>
      </Stack>
    </Stack>
  );
}
