const getHashCode = function (someString) {
  let hash = 0,
    i,
    chr;
  if (someString.length === 0) return hash;
  for (i = 0; i < someString.length; i++) {
    chr = someString.charCodeAt(i);
    hash = (hash << 5) - hash + chr;
    hash |= 0;
  }
  return hash;
};

function getColorFromId(id, theme) {
  const primaryColors = [];
  for (let i = 301; i <= 310; i++) {
    primaryColors.push(theme.vars.palette.primary[i]);
  }

  const hashCode = getHashCode(`${id}`);
  const randomInt = Math.abs(hashCode) % 10;
  return primaryColors[randomInt];
}

export default getColorFromId;
