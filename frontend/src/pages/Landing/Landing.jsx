import {
  Box,
  Button,
  Card,
  CardActions,
  CardContent,
  CardOverflow,
  Stack,
  Typography,
} from '@mui/joy';
import Girl from '../../assets/girl.png';
import Computer from '../../assets/computer.svg';
import ComputerBox from '../../assets/computer-box.svg';
import House from '../../assets/house.svg';
import HouseBox from '../../assets/house-box.svg';
import Engineer from '../../assets/engineer.svg';
import EngineerBox from '../../assets/engineer-box.svg';
import Star from '../../assets/star.svg';
import BgRadiant from '../../assets/bg-radiant.png';
import People from '../../assets/people.png';

export default function Landing() {
  return (
    <Stack padding="50px 100px" gap={10}>
      <Stack direction="row" justifyContent="space-between">
        <Stack alignItems="flex-start" justifyContent="space-between">
          <Stack gap={5}>
            <Typography level="h1" fontSize={70}>
              Search with <Typography textColor="#ff0000">Ease</Typography>,{' '}
              <Typography textColor="#ffde59">Discover </Typography>
              with <Typography textColor="#5ce1e6">Confidence</Typography>
            </Typography>
            <Typography level="body-sm" marginRight="250px">
              With CAT, you can navigate the OJT landscape with confidence,
              knowing that you&apos;re making informed decisions based on
              data-driven insights. Experience the power of AI and discover the
              perfect OJT opportunity for your future success.
            </Typography>
          </Stack>
          <Button size="lg">Join Now</Button>
        </Stack>
        <div
          style={{
            position: 'relative',
            width: '280px',
            height: '500px',
            flexShrink: 0,
          }}
        >
          <img
            src={Girl}
            height="500px"
            style={{
              position: 'absolute',
              top: 0,
              right: '-50px',
            }}
          ></img>
        </div>
      </Stack>
      <Stack gap={2}>
        <Typography level="h2">Popular</Typography>
        <Stack
          direction="row"
          justifyContent="space-between"
          flexWrap="wrap"
          gap={3}
        >
          <Card
            variant="soft"
            sx={{
              background: '#ffeda3',
              borderRadius: '0px 15% 15% 15%',
              width: '330px',
              height: '330px',
            }}
            size="lg"
          >
            <CardOverflow sx={{ padding: '0px' }}>
              <Box position="relative" width="min-content">
                <img src={ComputerBox} width="100px" />
                <img
                  src={Computer}
                  style={{
                    position: 'absolute',
                    top: '50%',
                    left: '50%',
                    transform: 'translate(-50%, -50%)',
                  }}
                  width="40px"
                />
              </Box>
            </CardOverflow>
            <CardContent>
              <Typography level="title-md">IT / Computer Related</Typography>
              <Typography level="body-sm">
                Immerse yourself in the dynamic world of technology, gaining
                hands-on experience in software development, web design, or IT
                infrastructure management.
              </Typography>
            </CardContent>
            <CardActions orientation="horizontal-reverse">
              <img src={Star} />
            </CardActions>
          </Card>
          <Card
            variant="soft"
            sx={{
              background: '#c5ffff',
              borderRadius: '0px 15% 15% 15%',
              width: '330px',
              height: '330px',
            }}
            size="lg"
          >
            <CardOverflow sx={{ padding: '0px' }}>
              <Box position="relative" width="min-content">
                <img src={HouseBox} width="100px" />
                <img
                  src={House}
                  style={{
                    position: 'absolute',
                    top: '50%',
                    left: '50%',
                    transform: 'translate(-50%, -50%)',
                  }}
                  width="40px"
                />
              </Box>
            </CardOverflow>
            <CardContent>
              <Typography level="title-md">Architecture</Typography>
              <Typography level="body-sm">
                Shape the future of the built environment, collaborating with
                experienced architects to design and conceptualize innovative
                structures.
              </Typography>
            </CardContent>
            <CardActions orientation="horizontal-reverse">
              <img src={Star} />
            </CardActions>
          </Card>
          <Card
            variant="soft"
            sx={{
              background: '#cfffd3',
              borderRadius: '0px 15% 15% 15%',
              width: '330px',
              height: '330px',
            }}
            size="lg"
          >
            <CardOverflow sx={{ padding: '0px' }}>
              <Box position="relative" width="min-content">
                <img src={EngineerBox} width="100px" />
                <img
                  src={Engineer}
                  style={{
                    position: 'absolute',
                    top: '50%',
                    left: '50%',
                    transform: 'translate(-50%, -50%)',
                  }}
                  width="40px"
                />
              </Box>
            </CardOverflow>
            <CardContent>
              <Typography level="title-md">Engineering</Typography>
              <Typography level="body-sm">
                Apply your technical expertise to real-world projects, from
                civil engineering and construction to mechanical engineering and
                electrical engineering.
              </Typography>
            </CardContent>
            <CardActions orientation="horizontal-reverse">
              <img src={Star} />
            </CardActions>
          </Card>
        </Stack>
      </Stack>
      <Stack gap={2} sx={{ position: 'relative', overflow: 'hidden' }}>
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
