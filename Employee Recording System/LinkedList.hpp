#ifndef LINKEDLIST_HPP
#define LINKEDLIST_HPP
#include "Node.hpp"

class LinkedList
{
private:
Node* head;
Node* tail;
public:
    LinkedList();
    void insert(Node* element); //sorts list by appointment date
    void inID(Node* element); //sorts list by employee ID
    void reverse(Node* element); //reverses a list which is sorted by appointment date
    bool search(int ID); 
    void tag(int ID); //prints the employee with given ID
    void remove(int ID);
    void changeCoef(int ID, double coef, string Title);
    friend ostream& operator<<(ostream& os, const LinkedList list);
    Node* getHead();
    ~LinkedList();

};

#endif // LINKEDLIST_HPP
