import re
def validate_password(password) -> dict:

    """Validates password passed as param

        args: password - string

        Evaluation Conditions:
        - at least 8 chars long
        - contains at least 1 uppercase letter
        - contains at least 1 lowercase letter
        - contains at least 1 digit
        - contains at least 1 special character [!@#$%^&*]
    """
    log = {
        "valid":False,
        "errors":[]
    }
    is_uppercase: int = 0
    is_lowercase: int = 0
    is_digit: int = 0
    is_special: int = 0
    special_char = "!@#$%^&*"
    for char in password:
        if char.isupper:
            is_uppercase += 1
        if char.islower:
            is_lowercase += 1
        if char.isdigit:
            is_digit += 1
        if char in special_char:
            is_special += 1
    if is_uppercase == 0:
        log["errors"].append("contains no uppercase characters")

    if is_lowercase == 0:
        log["errors"].append("contains no lowercase characters")

    if is_digit == 0:
        log["errors"].append("contains no digits")

    if is_special == 0:
        log["errors"].append("contains no special digits")

    if len(log["errors"]) == 0:
        log["valid"] = True

    return log
