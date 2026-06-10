"""
Week 2 Exercise — CSV processing with context managers.

TODO:
1. Read starter_code/data/sales.csv using csv.DictReader and with open(...).
2. Compute rows count, grand total (sum of units * unit_price), average line revenue.
3. Find SKU with max line revenue (tie: first in file).
4. Write output/summary.txt using with open(..., "w", encoding="utf-8").
"""

from __future__ import annotations
import csv
from csv import DictReader

def main() -> None:

    result = []
    grand_total = []
    average_line_revenue = []
    row_count = 0
    # Your implementation here
    with open(r"C:\Users\scoty\Desktop\Career\Revature\Dev\Training_2424\Week2\exercise\1-monday\exercise_file_processing\starter_code\data\sales.csv", "r") as file:
        data=csv.DictReader(file) 
        for row in data:
            print(row)
            
            row_count += 1

            unit_count = int(row['units'])
            unit_price = float(row['unit_price'])
            
            # sku_max_revenue = {(row['sku']) : round(unit_count * unit_price)}
            
            grand_total.append(unit_count * unit_price)
        average_line_revenue = round(sum(grand_total) / row_count)
        
        result = [{"row_count": row_count, "total":sum(grand_total), "average_line_revenue": average_line_revenue}]
        

    with open(r"C:\Users\scoty\Desktop\Career\Revature\Dev\Training_2424\Week2\exercise\1-monday\exercise_file_processing\starter_code\output\summary.txt", "w", encoding="UTF-8") as file:
        
        file.write(f"Row count: {row_count}\nTotal: {grand_total}\nLine average: {average_line_revenue} ")



if __name__ == "__main__":
    main()
