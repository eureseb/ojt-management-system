# AI Folder

This folder contains files related to our AI project.

## Contents

- `src/main` - Main source code directory.
  - `companyranking` - Folder containing files related to company ranking.
    - `company_controller.py` - Controller for handling company ranking endpoints.
    - `company_service.py` - Service for fetching company ranking data.
    - `company.py` - Definition of the Company class.
  - `companysuggestion` - Folder containing files related to company suggestions.
    - `companysuggestion_controller.py` - Controller for handling company suggestion endpoints.
    - `companysuggestion_service.py` - Service for generating company suggestions.
    - `companysuggestion.py` - Definition of the CompanySuggestion class.
- `server.py` - Main Flask server file.

## Dependencies

- Flask - Web framework for Python.
- requests - Library for making HTTP requests.
- psycopg2 - Library for interacting with PostgreSQL databases.

## Setup

1. Install Python and required dependencies.
2. Set up a PostgreSQL database and configure the connection in `company_service.py`.
3. Run the Flask server using `server.py`.

## Usage

1. Access company ranking data at `/api/companyranking`.
2. Access company suggestions at `/api/companysuggestion`.
3. Send POST requests to `/api/companysuggestion` with appropriate parameters to generate suggestions.

POST
{
    "tags": [
            "ProfessionalEnvironment",
            "NewKnowledge",
            "Selflearning",
            "PoorHandling"     
        ]
}

