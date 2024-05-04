import { Box } from '@mui/joy';
import PropTypes from 'prop-types';

const size = '2em';

export default function RankBadge({ rank }) {
  return (
    <div style={{ position: 'relative', height: size, width: size }}>
      <div>
        <Decagram />
      </div>
      <Box
        sx={{
          position: 'absolute',
          top: '50%',
          left: '50%',
          transform: 'translate(-50%, -50%)',
          color: 'white',
          fontSize: '0.75em',
          fontWeight: 'bold',
        }}
      >
        {rank}
      </Box>
    </div>
  );
}

RankBadge.propTypes = {
  rank: PropTypes.number.isRequired,
};

function Decagram() {
  return (
    <svg
      xmlns="http://www.w3.org/2000/svg"
      width={size}
      height={size}
      viewBox="0 0 24 24"
    >
      <path
        fill="#ffb900"
        d="m23 12l-2.44-2.78l.34-3.68l-3.61-.82l-1.89-3.18L12 3L8.6 1.54L6.71 4.72l-3.61.81l.34 3.68L1 12l2.44 2.78l-.34 3.69l3.61.82l1.89 3.18L12 21l3.4 1.46l1.89-3.18l3.61-.82l-.34-3.68z"
      />
    </svg>
  );
}
