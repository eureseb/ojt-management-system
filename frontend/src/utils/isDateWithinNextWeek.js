function isDateWithinNextWeek(date) {
  const inputDate = new Date(date);
  const currentDate = new Date();

  inputDate.setHours(0, 0, 0, 0);
  currentDate.setHours(0, 0, 0, 0);

  const nextSunday = new Date(currentDate);
  nextSunday.setDate(currentDate.getDate() - currentDate.getDay() + 7);
  const nextNextSunday = new Date(currentDate);
  nextNextSunday.setDate(nextSunday.getDate() + 14);

  return inputDate >= nextSunday && inputDate < nextNextSunday;
}

export default isDateWithinNextWeek;
