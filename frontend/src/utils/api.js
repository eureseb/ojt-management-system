import axios from 'axios';
import { getAuthHeader } from './authentication';
import {
  COMPANY_EVALUATION_URL,
  COMPANY_URL,
  COMPANY_URL_ALL,
  JOB_APPLICATION_URL,
  JOB_LISTING_URL,
  LOGGED_IN_STUDENT_INFO,
  STUDENT_PREFERENCES_UPDATE_URL,
} from './links';

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
