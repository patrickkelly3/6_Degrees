import pandas as pd
import mysql.connector

# Define the path to the file
file = '/Users/patrickkelly/Desktop/6_Degrees/Move_Database/title.basics.tsv'

# Connect to MySQL database
conn = mysql.connector.connect(
    host='localhost',
    user='root',
    password='Hunkerdown0809!',
    database='6_Degrees'
)

cursor = conn.cursor()

# Create table if it doesn't exist
cursor.execute("""
CREATE TABLE IF NOT EXISTS MOVIE (
    movie_ID VARCHAR(20) PRIMARY KEY NOT NULL,
    name VARCHAR(1000),
    genres VARCHAR(100)
)
""")

def process_file(file_path):
    # Load TSV file into a DataFrame
    df = pd.read_csv(file_path, delimiter='\t')
    
    # Replace '\N' and NaN values with None (NULL in MySQL)
    df.replace({'\\N': None, pd.NA: None}, inplace=True)
    
    # Print the first few rows to verify data
    print("Loaded DataFrame:")
    print(df.head())
    
    # Filter out rows with None in the 'primaryName' column
    df_filtered = df[['tconst', 'primaryTitle', 'genres']].dropna(subset=['primaryTitle'])
    
    # Print the filtered DataFrame to verify it's correct
    print("Filtered DataFrame:")
    print(df_filtered.head())
    count = 0
    # Insert data into the table
    try:
        for _, row in df_filtered.iterrows():
            print(f"Inserting: {row['tconst']}, {row['primaryTitle']}, {row['genres']}")
            cursor.execute("""
            INSERT INTO MOVIE (movie_ID, name, genres)
            VALUES (%s, %s, %s)
            """, (row['tconst'], row['primaryTitle'], row['genres']))
            conn.commit()
    except mysql.connector.Error as err:
        print(f"Error: {err}")

    

# Process the file
process_file(file)

# Commit the changes and close the connection
conn.commit()
cursor.close()
conn.close()

print("Data imported successfully.")