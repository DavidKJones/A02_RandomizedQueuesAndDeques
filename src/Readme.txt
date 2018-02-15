/******************************************************************************
 *  Name: David Jones
 *  NetID:   
 *  Precept: 
 *
 *  Partner Name: Mason Parry    
 *  Partner NetID:    
 *  Partner Precept:  
 *
 *  Hours to complete assignment (optional): 
 *
 ******************************************************************************/

Programming Assignment 2: Deques and Randomized Queues


/******************************************************************************
 * Randomized queue was implemented with a double linked list structure due to the fact it would have to dynamically dequeue random items. (David)
 * Deque was also implemented with a double linked list structure because it has to be able to remove items from the first or last spot. (Mason)
 *****************************************************************************/


/******************************************************************************
 *  How much memory (in bytes) do your data types use to store n items
 *  in the worst case? Use the 64-bit memory cost model from Section
 *  1.4 of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers and show your work.
 *
 *  Do not include the memory for the items themselves (as this
 *  memory is allocated by the client and depends on the item type)
 *  or for any iterators, but do include the memory for the references
 *  to the items (in the underlying array or linked list).
 *****************************************************************************/

Randomized Queue:   ~ 32N + 20  bytes (The class references two node pointers and 1 integer for the size. Each innder class Node has a reference to two nodes and an item.)

Deque:              ~ 32N + 20  bytes (The class references two node pointers and 1 integer for the size. Each innder class Node has a reference to two nodes and an item.)

/******************************************************************************
 *  RandomizedQueue will run at O(n) at best since it have to iterate throught the list to get the desired random item (David).
 *  Double Linked list uses more memory than sinle linked list. (Mason)
 *****************************************************************************/


/******************************************************************************
 *  My trusty whiteboard so I can draw out diagrams. (David)
 *  David and I helped each other out. (Mason)
 *  We also looked at Seidwick's classes as references to understand the Iterator interface and data structures.
 *****************************************************************************/



/******************************************************************************
 * Mason did the Deque class implementation and I did the RandomizedQueue class implementation and we helped each other on any problems we had.(David)
 *****************************************************************************/



/******************************************************************************
 *  At first it was hard to firmly decide what data structure to use. (David)
 *  Learning how to use the iterator properly. (Mason)                    
 *****************************************************************************/



/******************************************************************************
 *  This project helped give us a better understanding on data structures and iterators.                                 
 *****************************************************************************/