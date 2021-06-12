testcase=int(input())
for i in range (testcase):
    sentence=input()
    word=sentence.split(" ")
    for w in word:
        print(w[::-1], end=" ")
    print()
