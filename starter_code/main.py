from input_validator import validate_password

print(validate_password("Abc123!x"))    # valid
print(validate_password("abc"))         # too short, no upper, no digit, no special
print(validate_password("ABCDEFGH"))    # no lower, no digit, no special
print(validate_password("ABCDefgh1!"))  # valid
