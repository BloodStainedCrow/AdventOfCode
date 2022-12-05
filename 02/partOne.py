file = open("input.txt", "r", encoding="utf-8")
lines = file.readlines()
file.close()

score = 0
# X for Rock, Y for Paper, and Z for Scissors for our pick
# A for Rock, B for Paper, and C for Scissors for their pick

# The score for a single round is the score for the shape you selected(1 for Rock, 2 for Paper, and 3 for Scissors) plus the score for the outcome of the round(0 if you lost, 3 if the round was a draw, and 6 if you won)

for line in lines:
    enemyPick = line[0]
    myPick = line[2]
    if myPick == "X":
        score += 1
        if enemyPick == "A":
            score += 3
        elif enemyPick == "B":
            score += 0
        elif enemyPick == "C":
            score += 6
    elif myPick == "Y":
        score += 2
        if enemyPick == "A":
            score += 6
        elif enemyPick == "B":
            score += 3
        elif enemyPick == "C":
            score += 0
    elif myPick == "Z":
        score += 3
        if enemyPick == "A":
            score += 0
        elif enemyPick == "B":
            score += 6
        elif enemyPick == "C":
            score += 3


print(score)