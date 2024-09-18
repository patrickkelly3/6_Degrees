import csv

# Open .tsv file
with open("/Users/patrickkelly/Desktop/6_Degrees/Move_Database/title.principals.tsv", 'r', newline='') as file:
    # Use DictReader to parse the TSV file
    reader = csv.DictReader(file, delimiter='\t')

    # Iterate over each row in the reader
    for row in reader:
        # You can now access the data in each row as a dictionary
        print(row)

