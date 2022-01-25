##
# Check if the given string is an integer
#
def is_integer(value):

    try:
        float(value)
    except (TypeError, ValueError):
        return False
    else:
        return float(value).is_integer()
