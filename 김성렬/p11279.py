import heapq
import sys

heap = []
for _ in range(int(sys.stdin.readline())):
    x = int(sys.stdin.readline())
    if x == 0:
        try:
            print(heapq.heappop(heap)[1])
        except:
            print(0)
    else:
        heapq.heappush(heap, (-x, x))