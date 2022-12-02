#ifndef CIRCULARLIST_HPP
#define CIRCULARLIST_HPP
#include "Link.hpp"

class CircularList
{
private:
int first_free; // holds index of first avaible position
int head;
int tail;
bool empty;
Link* list[20]{0};
public:
    CircularList();
    bool isEmpty();
    void add(Link* item);
    void tag(int ID); //prints object with the given ID
    void setTail(int ID); //sets tail to given ID. Needed for in case last element is deleted
    Link* getHead();
    Link* getTail();
    bool search(int ID);//if false not in list if true in list
    void updCoef(int ID, double coef, string Title);
    void remove(int ID);
    Link* control(int position);
    ~CircularList();

};

#endif // CIRCULARLIST_HPP
