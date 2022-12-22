# 모든 vertex를 방문 했나요?
def check_all(check):
    for i in check:
        if i == False:
            return False
    return True


def BFS(graph, start_vertex, delte_vertex):

    # 지우기 전에 그 vertex가 갈 수 있는 vertex들을 temp에 저장한다.
    temp = graph[delte_vertex]
    # 해당 vertex를 지운다.
    graph[delte_vertex]=[]

    # check[n]이 False라면 n번 vertex에는 방문하지 않은 것이다.
    check = [False for _ in range(len(graph))]

    queue = [start_vertex]
    check[start_vertex]=True
    # 지운 vertex는 도달하지 못할 수도 있기에 True로 바꿔준다.
    check[delte_vertex]=True

    while len(queue) > 0:
        current_node = queue.pop(0)
        check[current_node] = True
        if check[current_node] == False:
            for node in graph[current_node]:
            queue.append(node)
        
    # 지운 vertex를 다시 붙여준다.
    graph[delte_vertex]=temp

    return not check_all(check)

try:
    testcase = 1
    while True:
        vertex_num = int(input())

        if vertex_num == 0:
            exit()

        vertex_list = []

        for i in range(vertex_num):
            vertex_name = input()
            vertex_list.append(vertex_name)

        graph = [[] for i in range(vertex_num)]

        edge_num = int(input())
        for _ in range(edge_num):
            v1, v2 = input().split()
            v1_index = vertex_list.index(v1)
            v2_index = vertex_list.index(v2)

            # 양방향 그래프이기에 둘 다 append 해준다
            graph[v1_index].append(v2_index)
            graph[v2_index].append(v1_index)
      
#         # cctv가 있는 도시에 대해 넣을 list
        city_list = []

        # 어떤 vertex를 지웠을 때, 모든 vertex를 갈 수 없다면(graph가 두개로 쪼개진다면) 지운 vertex에 cctv가 있다는 것을 의미한다.
        for i in range(vertex_num):

            # 0번을 지울 때에는 1로, 그 외에는 0에서 BFS를 진행한다.
            if i == 0:
                split = BFS(graph, 1, i)
            else:
                split = BFS(graph, 0, i)

            if split:
                city_list.append(vertex_list[i])

        # 출력
        print(f"City map #{testcase}: {len(city_list)} camera(s) found")
        for i in sorted(city_list):
            print(i)
        print()

        testcase+=1


except EOFError:
    exit()