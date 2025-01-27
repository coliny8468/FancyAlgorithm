def dd(li):
    count=0
    for i in li:
        if 'i' == i or 'I' == i or 'U' == i or 'A' == i or 'E' == i  or 'O' == i or 'u' == i  or 'a' == i  or 'e' == i or 'o' == i:
            count+=1
    return count

while True:
    tmp=input()
    if tmp=='#':
        break
    print(dd(tmp))
