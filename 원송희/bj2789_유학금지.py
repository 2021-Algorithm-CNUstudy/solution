import sys
temp="CAMBRIDGE"
banned=list(temp)
mail=sys.stdin.readline()
for i in range(len(mail)):
    if mail[i] in banned:
        continue
    else:
        print(mail[i], end="")
