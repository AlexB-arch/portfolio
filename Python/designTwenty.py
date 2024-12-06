# Runs in O(n) assuming the intervals are given sorted by end time
def minAnnouncements(intervals):
    announcements = []
    lastAnnouncement = None
    
    for interval in intervals:
        start, end = interval
        if lastAnnouncement is None or start > lastAnnouncement:
            # Make an announcement at the end time of the current class
            lastAnnouncement = end
            announcements.append(lastAnnouncement)
    
    return announcements
    
    return announcements

# Test case (sorted by end time)
classIntervals = [
    (1, 8), (4, 9), (1, 10), (2, 13), (2, 19),
    (11, 20), (15, 25), (18, 27), (31, 37), (20, 35),
    (24, 40), (28, 40)
]
print("Announcement times:", minAnnouncements(classIntervals))