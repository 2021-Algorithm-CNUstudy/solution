import sys
seongmin=sys.stdin.readline().rstrip()
seongmin2=""
for s in seongmin:
    if not s.isdigit():
        seongmin2+=s
keyword=sys.stdin.readline().rstrip()
if keyword in seongmin2:
    print(1)
else:
    print(0)
