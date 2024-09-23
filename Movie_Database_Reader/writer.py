import csv

inputfile = "/Users/patrickkelly/Desktop/6_Degrees/Move_Database/title.principals.tsv"
outputfile = "/Users/patrickkelly/Desktop/6_Degrees/Move_Database/output.tsv"

chunk_size = 100000  # Number of rows to process at a time

def process_chunk(chunk):
    with open(outputfile, 'a', newline='') as outfile:
        writer = csv.writer(outfile, delimiter='\t')
        for row in chunk:
            if row['category'] in ['self', 'actor', 'actress']:
                writer.writerow([row['tconst'], row['nconst']])

try:
    with open(inputfile, 'r', newline='') as infile:
        reader = csv.DictReader(infile, delimiter='\t')
        chunk = []
        for i, row in enumerate(reader):
            chunk.append(row)
            if len(chunk) >= chunk_size:
                process_chunk(chunk)
                chunk = []  # Clear the chunk for the next iteration
        # Process any remaining rows in the final chunk
        if chunk:
            process_chunk(chunk)
    
    print("Processing complete.")
except Exception as e:
    print(f"An error occurred: {e}")


        