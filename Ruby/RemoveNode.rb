# Definition for singly-linked list.
class ListNode
  attr_accessor :val, :next

  def initialize(val = 0, next_node = nil)
    @val = val
    @next = next_node
  end
end

def remove_nth_from_end(head, n)
  dummy = ListNode.new(0, head)
  first = dummy
  second = dummy

  # Move first pointer n+1 steps ahead so there is a gap of n between first and second.
  (n + 1).times { first = first.next }

  while first
    first = first.next
    second = second.next
  end

  # second.next is the node to remove.
  second.next = second.next.next

  dummy.next
end

# Helper function to convert array to list
def array_to_list(arr)
  dummy = ListNode.new
  current = dummy
  arr.each do |val|
    current.next = ListNode.new(val)
    current = current.next
  end
  dummy.next
end

# Helper function to convert list to array
def list_to_array(head)
  arr = []
  while head
    arr << head.val
    head = head.next
  end
  arr
end

# Uncomment below lines to test the method:
# head = array_to_list([1,2,3,4,5])
# new_head = remove_nth_from_end(head, 2)
# p list_to_array(new_head)   # Expected output: [1,2,3,5]

# head = array_to_list([1])
# new_head = remove_nth_from_end(head, 1)
# p list_to_array(new_head)   # Expected output: []

# head = array_to_list([1,2])
# new_head = remove_nth_from_end(head, 1)
# p list_to_array(new_head)   # Expected output: [1]
