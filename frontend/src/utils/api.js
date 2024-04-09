import axios from 'axios';
import { getAuthHeader } from './authentication';
import {
  COMPANY_EVALUATION_STATUS_URL,
  COMPANY_EVALUATION_URL,
  COMPANY_URL,
  COMPANY_URL_ALL,
  JOB_APPLICATION_URL,
  JOB_LISTING_URL,
  LOGGED_IN_STUDENT_INFO,
  LOGGED_IN_USER_INFO,
  STUDENT_PREFERENCES_UPDATE_URL,
  STUDENT_URL,
} from './links';
import dayjs from 'dayjs';
import { Roles } from './constants';

export function updateStudentPreferences({
  companyPreferences,
  workEnvironmentPreferences,
  locationAndCommutePreferences,
  compensationAndBenefitsPreferences,
  technicalSkillsAndInterests,
  feedbackAndSuggestions,
}) {
  return axios.post(
    STUDENT_PREFERENCES_UPDATE_URL,
    {
      companyPreferences,
      workEnvironmentPreferences,
      locationAndCommutePreferences,
      compensationAndBenefitsPreferences,
      technicalSkillsAndInterests,
      feedbackAndSuggestions,
    },
    {
      headers: {
        Authorization: getAuthHeader(),
      },
    }
  );
}

export async function getLoggedInStudentInfo() {
  const res = await axios.get(LOGGED_IN_STUDENT_INFO, {
    headers: {
      Authorization: getAuthHeader(),
    },
  });
  return res.data;
}

export async function getLoggedInUserInfo() {
  const res = await axios.get(LOGGED_IN_USER_INFO, {
    headers: {
      Authorization: getAuthHeader(),
    },
  });
  return res.data;
}

export async function getRole() {
  const userInfo = await getLoggedInUserInfo();
  const isStudent =
    userInfo.authorities.filter((role) => role.authority === 'ROLE_STUDENT')
      .length > 0;
  const isTeacher =
    userInfo.authorities.filter((role) => role.authority === 'ROLE_TEACHER')
      .length > 0;
  return isStudent ? Roles.STUDENT : isTeacher ? Roles.TEACHER : undefined;
}

export async function getJobListings(page) {
  const res = await axios.get(`${JOB_LISTING_URL}?page=${page}&size=10`, {
    headers: {
      Authorization: getAuthHeader(),
    },
  });
  return res.data;
}

export async function applyForJob({
  jobListingId,
  coverLetterRecipientEmail,
  coverLetterSubject,
  coverLetterBody,
}) {
  return axios.post(
    JOB_APPLICATION_URL,
    {
      jobListingId,
      coverLetterRecipientEmail,
      coverLetterSubject,
      coverLetterBody,
    },
    {
      headers: {
        Authorization: getAuthHeader(),
      },
    }
  );
}

export async function getAllCompanies() {
  const res = await axios.get(COMPANY_URL_ALL, {
    headers: {
      Authorization: getAuthHeader(),
    },
  });
  return res.data;
}

export async function submitCompanyEvaluation({
  companyId,
  isRecommendedForOJT,
  isRecommendedForOJTReason,
  experienceEvaluation,
  experienceWithCompany,
  evaluationTerm,
}) {
  return axios.post(
    COMPANY_EVALUATION_URL,
    {
      isRecommendedForOJT,
      isRecommendedForOJTReason,
      experienceEvaluation,
      experienceWithCompany,
      companyId,
      evaluationTerm,
    },
    {
      headers: {
        Authorization: getAuthHeader(),
      },
    }
  );
}

export async function getCompany(id) {
  const res = await axios.get(`${COMPANY_URL}/${id}`, {
    headers: {
      Authorization: getAuthHeader(),
    },
  });
  return res.data;
}

export async function getCompanyEvaluations(companyId, page) {
  const res = await axios.get(
    `${COMPANY_EVALUATION_URL}?page=${page}&companyId=${companyId}&sort=dateEvaluated,desc`,
    {
      headers: {
        Authorization: getAuthHeader(),
      },
    }
  );
  return res.data.content;
}

export async function getJobApplications(page) {
  const res = await axios.get(`${JOB_APPLICATION_URL}?size=10&page=${page}`, {
    headers: {
      Authorization: getAuthHeader(),
    },
  });
  return res.data;
}

export async function acceptJobApplication(jobApplicationId) {
  return axios.patch(
    `${JOB_APPLICATION_URL}/${jobApplicationId}/status?status=ACCEPTED`,
    {},
    {
      headers: {
        Authorization: getAuthHeader(),
      },
    }
  );
}

export async function rejectJobApplication(jobApplicationId) {
  return axios.patch(
    `${JOB_APPLICATION_URL}/${jobApplicationId}/status?status=REJECTED`,
    {},
    {
      headers: {
        Authorization: getAuthHeader(),
      },
    }
  );
}

export async function getStudents(page) {
  const res = await axios.get(`${STUDENT_URL}?size=10&page=${page}`, {
    headers: {
      Authorization: getAuthHeader(),
    },
  });
  return res.data;
}

export async function removeStudentFromCompany(studentId) {
  const res = await axios.delete(`${STUDENT_URL}/${studentId}/company`, {
    headers: {
      Authorization: getAuthHeader(),
    },
  });
  return res.data;
}

export async function getCompanies({ page = 0 }) {
  const res = await axios.get(`${COMPANY_URL}?size=10&page=${page}`, {
    headers: {
      Authorization: getAuthHeader(),
    },
  });
  return res.data;
}

export async function createCompany({
  name,
  description,
  contactEmail,
  addressLine1,
  addressLine2,
}) {
  return await axios.post(
    COMPANY_URL,
    {
      name,
      description,
      contactEmail,
      addressLine1,
      addressLine2,
    },
    {
      headers: {
        Authorization: getAuthHeader(),
      },
    }
  );
}

export async function updateCompany({
  name,
  description,
  contactEmail,
  addressLine1,
  addressLine2,
  companyId,
}) {
  return await axios.put(
    `${COMPANY_URL}/${companyId}`,
    {
      name,
      description,
      contactEmail,
      addressLine1,
      addressLine2,
    },
    {
      headers: {
        Authorization: getAuthHeader(),
      },
    }
  );
}

export async function deleteCompany(companyId) {
  return await axios.delete(`${COMPANY_URL}/${companyId}`, {
    headers: {
      Authorization: getAuthHeader(),
    },
  });
}

export async function getCompanyEvaluationStatus() {
  const res = await axios.get(COMPANY_EVALUATION_STATUS_URL, {
    headers: {
      Authorization: getAuthHeader(),
    },
  });
  if (res.data.dueDate) {
    res.data.dueDate = dayjs(res.data.dueDate + 'Z');
  }
  return res.data;
}

export async function updateCompanyEvaluationStatus({
  isEnabled,
  title,
  dueDate,
}) {
  return await axios.put(
    COMPANY_EVALUATION_STATUS_URL,
    {
      isEnabled,
      title,
      dueDate,
    },
    {
      headers: {
        Authorization: getAuthHeader(),
      },
    }
  );
}
