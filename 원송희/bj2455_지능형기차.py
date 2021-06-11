temp=input().split(" ")
people=int(temp[1])-int(temp[0])
on_the_bus=[]
on_the_bus.append(people)
for i in range(3):
    temp=input().split(" ")
    off=int(temp[0])
    on=int(temp[1])
    people+=on
    people-=off
    on_the_bus.append(people)
print(max(on_the_bus))
