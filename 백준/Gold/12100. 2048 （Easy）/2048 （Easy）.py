import copy

N = list(map(int, input().split()))[0]

data_array = []

for i in range(N):
  data_array.append(list(map(int, input().split())))

MAX_VAL = 0


def Move(data) :
    for i in range(N) :
        spc = 0
        for j in range(spc+1, N) :
            if data[i][spc] == 0 and data[i][j] != 0 :
                data[i][spc] = data[i][j]
                data[i][j] = 0
                spc += 1
            elif data[i][spc] != 0 :
                spc += 1
    for i in range(N) :
        for j in range(N-1) :
            if data[i][j] == data[i][j+1] :
                data[i][j] += data[i][j+1]
                data[i][j+1] = 0
    for i in range(N) :
        spc = 0
        for j in range(spc+1, N) :
            if data[i][spc] == 0 and data[i][j] != 0 :
                data[i][spc] = data[i][j]
                data[i][j] = 0
                spc += 1
            elif data[i][spc] != 0 :
                spc += 1
    FindMax(data)
    return data

def Left(data) :
    data = copy.deepcopy(data)
    data = Move(data)
    return data

def Right(data) :
    data = copy.deepcopy(data)
    for i in range(N) :
        data[i].reverse()
    data = Move(data)
    for i in range(N) :
        data[i].reverse()
    return data

def Up(data) :
    data = copy.deepcopy(data)
    for i in range(N) :
        for j in range(i, N) :
            data[i][j], data[j][i] = data[j][i], data[i][j]
    data = Move(data)
    for i in range(N) :
        for j in range(i, N) :
            data[i][j], data[j][i] = data[j][i], data[i][j]
    return data

def Down(data) :
    data = copy.deepcopy(data)
    for i in range(N) :
        for j in range(i, N) :
            data[i][j], data[j][i] = data[j][i], data[i][j]
    data = Right(data)
    for i in range(N) :
        for j in range(i, N) :
            data[i][j], data[j][i] = data[j][i], data[i][j]
    return data

def move_step(data):
    return Left(data), Right(data), Up(data), Down(data)

def FindMax(data) :
    global MAX_VAL
    for i in range(N) :
        for j in range(N) :
            if MAX_VAL < data[i][j] :
                MAX_VAL = data[i][j]      

results = [data_array,]
for _ in range(5) :
    _results, results = results, []
    for data in _results :
        for result in move_step(data) :
            results.append(result)

print(MAX_VAL)