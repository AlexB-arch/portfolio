def maximizeRequests(requests):
    # Sort requests based on end time
    sortedRequests = sorted(requests, key=lambda x: x[1])
    
    approved = []
    lastEndTime = 0
    
    for request in sortedRequests:
        if request[0] >= lastEndTime:
            approved.append(request)
            lastEndTime = request[1]
    
    return approved

# Example usage
requests = [(1, 5), (14, 20), (3, 10), (8, 12), (19, 22), (7, 9), (11, 13)]
print("Approved Requests:", maximizeRequests(requests))