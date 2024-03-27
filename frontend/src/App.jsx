import './App.css';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import MainLayout from './components/DashboardLayout/DashboardLayout';
import ListOfCompanies from './pages/ListOfCompanies/ListOfCompanies';
import CompanyEvaluation from './pages/CompanyEvaluation/CompanyEvaluation';
import OJTRequirements from './pages/OJTRequirements/OJTRequirements';
import Landing from './pages/Landing/Landing';
import LandingLayout from './components/LandingLayout/LandingLayout';
import SignIn from './pages/SignIn/SignIn';
import SignUp from './pages/SignUp/SignUp';
import AccountSetUp from './pages/AccountSetUp/AccountSetUp';
import Company from './pages/Company/Company';

const router = createBrowserRouter([
  {
    path: '/dashboard',
    element: <MainLayout />,
    children: [{ index: true, element: <h1>Dashboard</h1> }],
  },
  {
    path: '/company-list/:companyId',
    element: <MainLayout />,
    children: [{ index: true, element: <Company /> }],
  },
  {
    path: '/company-list',
    element: <MainLayout />,
    children: [{ index: true, element: <ListOfCompanies /> }],
  },
  {
    path: '/company-evaluation',
    element: <MainLayout />,
    children: [{ index: true, element: <CompanyEvaluation /> }],
  },
  {
    path: '/ojt-requirements',
    element: <MainLayout />,
    children: [{ index: true, element: <OJTRequirements /> }],
  },
  {
    path: '/sign-in',
    element: <LandingLayout />,
    children: [{ index: true, element: <SignIn /> }],
  },
  {
    path: '/sign-up',
    element: <LandingLayout />,
    children: [{ index: true, element: <SignUp /> }],
  },
  {
    path: '/account-set-up',
    element: <LandingLayout />,
    children: [{ index: true, element: <AccountSetUp /> }],
  },
  {
    path: '/',
    element: <LandingLayout />,
    children: [
      {
        index: true,
        element: <Landing />,
      },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}
export default App;
