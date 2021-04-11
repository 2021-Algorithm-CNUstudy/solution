import sys
import bisect
n=int(sys.stdin.readline())
num=sys.stdin.readline().split(" ")
num_list=list(map(int, num)) #int형으로 변환
only_one_list=list(set(num_list))
only_one_list=sorted(only_one_list)
for i in range(len(num_list)):
    print(bisect.bisect_left(only_one_list, num_list[i]), end=' ')
