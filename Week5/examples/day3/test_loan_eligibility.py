import pytest
from loan_eligibility import assess_loan

def test_happy_path_eligible():
    """All condition False -> ELIGIBLE. One test, many uncovered branches"""
    assert assess_loan(age=30,income=30000,credit_score=700,employed=True) == "ELIGIBLE"

# def test_happy_path_eligible():
#     assert assess_loan(age=30,income=30000) == "ELIGIBLE"

@pytest.mark.parametrize("age, expected", [
    (17, "INELIGIBLE_AGE"),
    (18, "ELIGIBLE"),
    (65, "ELIGIBLE"),
    (66, "INELIGIBLE_AGE"),
])

def test_age_boundaries(age, expected):
    assert assess_loan(age, income=30000, credit_score=700, employed=True) == expected
