function isDateWithinCurrentWeek(date) {
  const inputDate = new Date(date);
  const currentDate = new Date();

  inputDate.setHours(0, 0, 0, 0);
  currentDate.setHours(0, 0, 0, 0);

  const previousSunday = new Date(currentDate);
  previousSunday.setDate(currentDate.getDate() - currentDate.getDay());
  const upcomingSunday = new Date(currentDate);
  upcomingSunday.setDate(previousSunday.getDate() + 7);

  return inputDate >= previousSunday && inputDate < upcomingSunday;
}

export default isDateWithinCurrentWeek;
