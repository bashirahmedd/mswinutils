import os
from PyPDF2 import PdfReader, PdfWriter

directory = r"C:\\Users\\naji\\bashir_workspace\\TBC\\utilities\\extract_pdf_pages\\"
pdf_file = r"csharp_course_book.pdf"
full_path = directory + pdf_file

output_dir = ".\\output\\"

# Check if the file exists
if not os.path.exists(full_path):
    print(f"File not found: {full_path}")
    exit()

reader = PdfReader(full_path)
writer = PdfWriter()

start_page = 65
end_page = 75    # 75 is not included, goes up to 74

for page in range(start_page, end_page):  
    writer.add_page(reader.pages[page - 1])

with open(output_dir+"output.pdf", "wb") as output_file:
    writer.write(output_file)
