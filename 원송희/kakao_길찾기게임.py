class Tree:
    def __init__(self):
        self.left=None
        self.right=None
        self.x=None
        self.idx=None
def PreOrder(root, visited):
    if root==None:
        return visited
    visited.append(root.idx)
    PreOrder(root.left, visited)
    PreOrder(root.right, visited)
    return visited

def PostOrder(root, visited):
    if root==None:
        return visited
    PostOrder(root.left, visited)
    PostOrder(root.right, visited)
    visited.append(root.idx)
    return visited

def solution(nodeinfo):
    answer = []
    for i in range(len(nodeinfo)):
        nodeinfo[i].append(i+1) #인덱스 부여
    nodeinfo = sorted(nodeinfo, key=lambda x: x[1], reverse=True) #y값으로 정렬
    root=None
    for i, info in enumerate(nodeinfo):
        tree=Tree()
        tree.idx=info[2] #부여해둔 인덱스를 저장
        tree.x=info[0] #x좌표 저장
        if root==None:
            root=tree
        else:
            parent=root
            while 1:
                if parent.x<tree.x:
                    if parent.right==None:
                        parent.right=tree
                        tree.parent=parent
                        break
                    else:
                        parent=parent.right
                else:
                    if parent.left==None:
                        parent.left=tree
                        tree.parent=parent
                        break
                    else:
                        parent=parent.left
    pre=PreOrder(root, [])
    post=PostOrder(root, [])
    answer.append(pre)
    answer.append(post)
    return answer

info=[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]
print(solution(info))
