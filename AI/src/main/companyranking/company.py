from dataclasses import dataclass

@dataclass
class Company:
    companyID: int
    name: str
    tags: dict
    rank: int
