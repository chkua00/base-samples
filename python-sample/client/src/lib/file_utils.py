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
# Write dict into csv file
#
def write_csv_file(filename, data):
    try:
        file = open(filename, "w")
        fieldnames = data[0].keys()
        writer = csv.DictWriter(file, fieldnames=fieldnames)
        writer.writeheader()
        writer.writerows(data)
        file.close
        return True
    except IOError:
        print("Error write file to ", filename)
        return False
    except IndexError:
        print("Received empty data.")
        return False


##
# Convert JSON array to Dict array
#
def convert_to_dict(rows):

    data = []
    for row in rows:
        data.append(json.loads(row))

    return data
