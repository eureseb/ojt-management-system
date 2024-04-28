from dataclasses import dataclass

@dataclass
class Company:
    companyID: int
    experience_evaluation: list
    tags: dict
    rank: int
