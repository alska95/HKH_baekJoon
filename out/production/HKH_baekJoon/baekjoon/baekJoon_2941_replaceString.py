targetString = input()
allPattern = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for pattern in allPattern:
    targetString = targetString.replace(pattern, '_')
print(len(targetString))
