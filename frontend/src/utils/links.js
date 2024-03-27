const BACKEND_ROOT = import.meta.env.VITE_BACKEND_URL;

export const COMPANY_URL = `${BACKEND_ROOT}/companies`;
export const COMPANY_URL_ALL = `${BACKEND_ROOT}/companies/all`;
export const COMPANY_EVALUATION_URL = `${BACKEND_ROOT}/company-evaluations`;
export const JOB_LISTING_URL = `${BACKEND_ROOT}/job-listings`;
export const SIGNIN_URL = `${BACKEND_ROOT}/auth/sign-in`;
export const STUDENT_SIGNUP_URL = `${BACKEND_ROOT}/student`;
export const STUDENT_PREFERENCES_UPDATE_URL = `${BACKEND_ROOT}/student/preferences`;
export const LOGGED_IN_STUDENT_INFO = `${BACKEND_ROOT}/student/me`;
export const JOB_APPLICATION_URL = `${BACKEND_ROOT}/job-applications`;
