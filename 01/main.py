file = open("input.txt", "r", encoding="utf-8")

maxCalories = 0
nextLine = file.readline()
currentCalories = 0

while nextLine:
    if nextLine == "\n":
        if currentCalories > maxCalories:
            maxCalories = currentCalories
        currentCalories = 0
    else:
        currentCalories += int(nextLine.split()[0])
    nextLine = file.readline()

print(maxCalories)
file.close()