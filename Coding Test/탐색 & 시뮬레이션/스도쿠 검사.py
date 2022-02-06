
for i in range(n):
    for j in range(n):
        if a[i][j] and a[j][i] == 55:
            for x in range(3):
                for y in range(3):
                    y = y*3
                    a[i][j]