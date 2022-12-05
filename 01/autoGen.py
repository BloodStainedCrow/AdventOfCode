# We have an input file with syntax like this:
# 1000
# 2000
# 3000

# 4000

# 5000
# 6000

# 7000
# 8000
# 9000

# 10000
# This list represents the Calories of the food carried by five Elves:

#     The first Elf is carrying food with 1000, 2000, and 3000 Calories, a total of 6000 Calories.
#     The second Elf is carrying one food item with 4000 Calories.
#     The third Elf is carrying food with 5000 and 6000 Calories, a total of 11000 Calories.
#     The fourth Elf is carrying food with 7000, 8000, and 9000 Calories, a total of 24000 Calories.
#     The fifth Elf is carrying one food item with 10000 Calories.






# print the number of calories of the elv with the most calories

file = open("input.txt", "r", encoding="utf-8")
lines = file.readlines()
file.close()

maxCalories = 0
currentCalories = 0

for line in lines:
    if line == "\n":
        if currentCalories > maxCalories:
            maxCalories = currentCalories
        currentCalories = 0
    else:
        currentCalories += int(line.split()[0])

print(maxCalories)