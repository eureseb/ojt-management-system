export default function Star({ color, style = {} }) {
  return (
    <svg
      width="24"
      height="23"
      viewBox="0 0 24 23"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
      style={style}
    >
      <path
        d="M1 11.7357C8.66089 11.7357 12 8.65922 12 1.23572C12 8.65922 15.3159 11.7357 23 11.7357C15.3159 11.7357 12 14.9009 12 22.2357C12 14.9009 8.66089 11.7357 1 11.7357Z"
        stroke={color}
        strokeWidth="1.5"
        strokeLinejoin="round"
      />
    </svg>
  );
}
