import csv
import json


##
# Read csv file into dict
#
def read_csv_file(filename):
    try:
        file = open(filename, "r")
        rows = csv.DictReader(file)
        return rows
    except IOError:
        print("Error opening file ", filename)
        return []


##
# Convert Dict array to JSON array
#
def convert_to_json(rows):

    data = []
    for row in rows:
        data.append(json.dumps(row))

    return data
