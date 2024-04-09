import { BarChart as RechartsBarChart, Legend, Bar, YAxis } from 'recharts';
import PropTypes from 'prop-types';
import './BarChart.css';

export default function BarChart({ values, labels, colors }) {
  const data = {};
  values.forEach((value, index) => {
    data[labels[index]] = value;
  });
  return (
    <div>
      <RechartsBarChart width={240} height={100} data={[data]}>
        <YAxis domain={[0, 'dataMax']} hide />
        <Legend verticalAlign="middle" layout="vertical" align="right" />
        {values.map((value, index) => (
          <Bar
            key={labels[index]}
            dataKey={labels[index]}
            fill={colors[index]}
            radius={[3, 3, 3, 3]}
            barSize={20}
          />
        ))}
      </RechartsBarChart>
    </div>
  );
}

BarChart.propTypes = {
  values: PropTypes.array.isRequired,
  labels: PropTypes.array.isRequired,
  colors: PropTypes.array.isRequired,
};
