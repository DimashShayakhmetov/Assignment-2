#Assignment 2

#Description:
Implementaion of MyArrayList,MyLinkedList classes based on MyList interface
Creating custom versions of java Stack,Heap,Queue utils.

#Functionality of MyList:

This interface defines the pattern that Array and Linked lists implement. The methods:

adding and removing elements (add, remove, addFirst, addLast, etc.),

index access (get, set, getFirst, getLast),

search (indexOf, lastIndexOf, exists),

sorting (sort),

converting to an array (toArray),

cleaning (clear),

iteration (iterator).


#Functionality of MyArrayList:

ensureCapacity() – doubles the array if it is full.

add(T item) – adds the item to the end.

add(int index, T item) – inserts by index, shifting the rest.

addFirst, addLast – add to the beginning or end.

set(index, item) – replaces the item.

get(index), getFirst(), getLast() – get the element.

remove(index) – removes an element with a shift of all the following.

sort() – bubble sort.

indexOf, lastIndexOf, exists – element search.

toArray() – copies the contents to a new array.

clear() – clears the list.

iterator() – returns an iterator over the array.


#Functionality of MyLinkedList:

add(T item) = addLast(item) – adds to the end.

addFirst, addLast – to the beginning/end.

add(index, item) – inserts it at the specified position.

set(index, item) – replaces the item.

get(index), getFirst(), getLast() – get the element.

remove(index) – removes the node, updating the prev and next links.

sort() – bubble sort, iterates through the nodes.

indexOf, lastIndexOf, exists – search.

toArray() – creates an array of list items.

clear() – resets references to head, tail, size.

iterator() – iterates through the nodes from the beginning.




#MyStack:

push(T item) — adds an item to the stack

pop() — removes and returns the top element.

peek() — returns the top element without deleting it.

isEmpty() — checks if the stack is empty.

size() — the number of elements.

toArray() — returns the stack as an array

printStack() — prints stack elements 

#MyQueue:

offer(T item) — adds an item (without exceptions, returns false if item is null)

add(T item) — adds an item (throws an exception when null)

poll() — returns and deletes the first element, or null if the queue is empty.

remove() is like poll(), but throws an exception if the queue is empty.

peek() — returns the first element without deletion or null

element() is like peek(), but throws an exception when the queue is empty.

isEmpty() — check if the list is empty else returns boolean 

size() — returns the number of elements.

toArray() — returns the queue as an array

PrintQueue() — prints queue elements




#MyMinHeap:

Public methods:

insert(T item) — adds an item to the heap

getMin() — returns the minimum element(root)

extractMin() — deletes and returns the minimum element.

size() — returns the size of the heap.

empty() — checks if the heap is empty.

Private methods (internal algorithms):

heapify(int index) — restores the heap structure from top to bottom

traverseUp(int index) — restores the heap from bottom to top after insertion

leftChildOf, rightChildOf, parentOf — returns the indexes of child/parent 

swap(index1, index2) — swaps two elements