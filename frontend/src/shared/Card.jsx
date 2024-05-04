import { Card as MuiCard, CardOverflow } from '@mui/joy';
import PropTypes from 'prop-types';

export default function Card({ children, maxWidth, color, highlight }) {
  return (
    <MuiCard
      variant="outlined"
      size="lg"
      orientation="horizontal"
      sx={{
        maxWidth: maxWidth,
        boxShadow: highlight
          ? '0 0 10px 1px color-mix(in srgb, var(--joy-palette-success-400) 33%, white)'
          : 'none',
      }}
    >
      <CardOverflow
        variant="solid"
        sx={{
          minWidth: '15px',
          background: color || 'var(--joy-palette-primary-400)',
        }}
      ></CardOverflow>
      {children}
    </MuiCard>
  );
}

Card.propTypes = {
  children: PropTypes.node.isRequired,
  maxWidth: PropTypes.string,
  color: PropTypes.string,
  highlight: PropTypes.bool,
};
