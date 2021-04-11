import heapq
from sys import stdin

n = int(stdin.readline())
heap=[]

for _ in range(0, n, 1):
    num = int(stdin.readline())
    if num < 0:
        heapq.heappush(heap, [-1*num, num])
    elif num > 0:
        heapq.heappush(heap, [num, num])
    else:
        try:
            pop=heapq.heappop(heap)
            print(pop[1])
        except:
            print('0')
