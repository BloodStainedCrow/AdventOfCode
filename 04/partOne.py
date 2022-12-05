# Open input.txt
file = open("input.txt", "r", encoding="utf-8")

numContained = 0

# for each line in the file
for line in file:
    firstRange = line.split(",")[0]
    secondRange = line.split(",")[1]

    firstRangeStart = int(firstRange.split("-")[0])
    firstRangeEnd = int(firstRange.split("-")[1])
    secondRangeStart = int(secondRange.split("-")[0])
    secondRangeEnd = int(secondRange.split("-")[1])

    if firstRangeStart >= secondRangeStart and firstRangeEnd <= secondRangeEnd:
        print("Contained")
        print(line)
        numContained += 1
    elif secondRangeStart >= firstRangeStart and secondRangeEnd <= firstRangeEnd:
        print("Contained")
        print(line)
        numContained += 1


print("Number of contained ranges: " + str(numContained))