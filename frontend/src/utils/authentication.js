import axios from 'axios';
import { SIGNIN_URL, STUDENT_SIGNUP_URL, TEACHER_SIGNUP_URL } from './links';

export async function login(email, password) {
  const authHeader = 'Basic ' + btoa(email + ':' + password);
  await axios.post(
    SIGNIN_URL,
    {},
    {
      withCredentials: true,
      headers: {
        Authorization: authHeader,
      },
    }
  );
  localStorage.setItem('authHeader', authHeader);
}

export function logout() {
  localStorage.removeItem('authHeader');
}

export async function isLoggedIn() {
  const authHeader = localStorage.getItem('authHeader');
  if (authHeader === null) return false;
  try {
    await axios.post(
      SIGNIN_URL,
      {},
      {
        withCredentials: true,
        headers: {
          Authorization: authHeader,
        },
      }
    );
    return true;
  } catch (e) {
    return false;
  }
}

export function getAuthHeader() {
  return localStorage.getItem('authHeader');
}

export function registerStudent(firstName, lastName, email, password) {
  return axios.post(STUDENT_SIGNUP_URL, {
    firstName,
    lastName,
    email,
    password,
  });
}

export function registerTeacher(firstName, lastName, email, password) {
  return axios.post(TEACHER_SIGNUP_URL, {
    firstName,
    lastName,
    email,
    password,
  });
}

export function getCurrentUser() {}
