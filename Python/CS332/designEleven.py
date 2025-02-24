# Maybe runs in O(n^log_2(4)), not sure.

def minOpportunityCost(listOfPhones):
    # opportunity cost as defined in the problem
    def opportunityCost(phone):
        x, y, z = phone
        return max(max(xi - x, 0) + max(yi - y, 0) + max(zi - z, 0) for xi, yi, zi in listOfPhones)

    def compare(start, end):
        if start == end:
            # if only one phone, return it.
            return opportunityCost(listOfPhones[start]), start + 1
        
        mid = (start + end) // 2
        leftCost, leftIndex = compare(start, mid)
        rightCost, rightIndex = compare(mid + 1, end)

        if leftCost < rightCost:
            return leftCost, leftIndex
        elif rightCost < leftCost:
            return rightCost, rightIndex
        else:
            return leftCost, min(leftIndex, rightIndex)

    return compare(0, len(listOfPhones) - 1)

# Test cases
# from the homework
listOfPhones = [(20, 5, 5), (5, 20, 5), (5, 5, 20), (10, 10, 10)]
print(minOpportunityCost(listOfPhones)) # (10, 4)

# single phone
listOfPhones = [(20, 5, 5)]
print(minOpportunityCost(listOfPhones))

# all same cost
listOfPhones = [(20, 20, 20), (20, 20, 20), (20, 20, 20)]
print(minOpportunityCost(listOfPhones)) # (0, 1)