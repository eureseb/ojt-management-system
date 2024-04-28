from dataclasses import dataclass

@dataclass
class Company:
    companyID: int
    experience_evaluation: str
    tags: dict
    rank: int
