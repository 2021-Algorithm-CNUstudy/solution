import sys
import heapq
N=int(sys.stdin.readline())
left=[]
right=[]
answer=[]
for _ in range(N):
    number=int(sys.stdin.readline())
    if len(left)==len(right):
        heapq.heappush(left, (-1*number, number))
    else:
        heapq.heappush(right, (number, number))
    if right and left[0][1]>right[0][0]:
        minimum=heapq.heappop(right)[0]
        maximum=heapq.heappop(left)[1]
        heapq.heappush(left, (-minimum, minimum))
        heapq.heappush(right, (maximum, maximum))
    answer.append(left[0][1])
for a in answer:
    print(a)
