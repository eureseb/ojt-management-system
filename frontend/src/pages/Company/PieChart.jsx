import { PieChart as RechartsPieChart, Pie, Cell, Legend } from 'recharts';
import PropTypes from 'prop-types';

export default function PieChart({ values, labels, colors, legendWidth }) {
  const data = values.map((value, index) => ({
    name: labels[index],
    value: value,
    color: colors[index],
  }));

  return (
    <RechartsPieChart width={265} height={100}>
      <Legend
        verticalAlign="middle"
        layout="vertical"
        align="right"
        width={legendWidth || 160}
      />
      <Pie
        data={data}
        dataKey="value"
        nameKey="name"
        fill="#8884d8"
        innerRadius={20}
      >
        {data.map((entry) => (
          <Cell key={entry.name} fill={entry.color} />
        ))}
      </Pie>
    </RechartsPieChart>
  );
}

PieChart.propTypes = {
  values: PropTypes.array.isRequired,
  labels: PropTypes.array.isRequired,
  colors: PropTypes.array.isRequired,
  legendWidth: PropTypes.number,
};
