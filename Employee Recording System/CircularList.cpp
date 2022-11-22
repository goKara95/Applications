#include <iostream>
#include "CircularList.hpp"

CircularList::CircularList(){
    first_free=0;
    head = 0;
    tail = 0;
    empty = true;
    };
    
bool CircularList::search(int ID){
    if(empty){
        return false;
        }
    Link* temp = list[head];
    while(true){
        if(temp->info.getID() == ID){
            return true;
            }
        else if(temp->next == head){
            return false;
            }
        temp = list[temp->next];
        }
        }

void CircularList::setTail(int ID){
    Link* temp = list[head];
    while(true){
        if(list[temp->next]->info.getID() == ID){
            tail = temp->next;
            return;
        }
        temp = list[temp->next];
}}

void CircularList::add(Link* item){
    if(empty){//liste boşsa
    list[first_free] = item;
    item->next = head;
    for(int i = first_free; i<20; i++){if(list[i]==NULL){first_free=i;i=99;}}
    empty = false;
    return;
    }
    else if(item->info.getID() < list[head]->info.getID()){//if the item has the smallest ID in the list
        if(list[head]->next == head){list[head]->next = first_free;}//if there is 1 item in list
        item->next = head;
        list[first_free] = item;
        head = first_free;
        list[tail]->next = first_free;
        for(int i = first_free; i<20; i++){if(list[i]==NULL){first_free=i;i=99;}}
        return;
        }
        
    Link* temp = list[list[head]->next];
    Link* temp2 = list[head];
    int inserted = 0;
    while(inserted != 1){
        if(item->info.getID() < temp->info.getID()){//if element to be added is in not at bottom or top of the list
            item->next =temp2->next;
            temp2->next = first_free;
            list[first_free] =item;
            for(int i = first_free; i<20; i++){if(list[i]==NULL){first_free=i;i=99;}}
            inserted = 1;
            }
        else if(temp->next == head){//if the element to be added has the biggest ID in the list
            list[first_free] =item;
            temp->next = first_free;
            item->next = head;
            tail = first_free;
            for(int i = first_free; i<20; i++){if(list[i]==NULL){first_free=i;i=99;}}
            inserted = 1;
            }
    temp2 = temp;
    temp = list[temp->next];
        }
    
    }

Link* CircularList::control(int position){
    return list[position];
    }
Link* CircularList::getHead(){
    return list[head];
    }
Link* CircularList::getTail(){
    return list[tail];
    }
    
bool CircularList::isEmpty(){
    return empty;
    }
void CircularList::remove(int ID){//to remove head
    if(list[head]->info.getID() == ID){
        if(first_free>head){first_free = head;} //if we removed head
        if(list[head]->next == head){
            delete list[head];
            list[head] = NULL;
            head = 0;
            tail = 0;
            empty = true;
            return;
            }
        int next = list[head]->next;
        delete list[head];
        list[head] = NULL;
        head = next;
        list[tail]->next = head;
        return;
        }
    Link* temp = list[list[head]->next];//current element
    Link* temp2 = list[head];//prev element
    int found = 0;
    while(found != 1){
        if(temp->info.getID()== ID){
            if(first_free > temp2->next){first_free = temp2->next;}
            if(temp2->next == tail){setTail(temp2->info.getID());}//if tail deleted new tail will be set
            delete list[temp2-> next];
            list[temp2->next] = NULL;
            temp2->next = temp->next;
            found = 1;
            return;
            }
        temp2 = temp;
        temp = list[temp->next];
    }
    
    }
 
 void CircularList::updCoef(int ID, double coef, string Title){
    Link* temp= list[head];
    int found = 0;
    while(found != 1){
        if(temp->info.getID() == ID){
            temp->info.setSalary(coef);
            temp->info.setTitle(Title);
            found=1;
            return;
            }
        temp = list[temp->next];
       }
    
};

void CircularList::tag(int ID){
    Link* temp = list[head];
    while(true){
        if(temp->info.getID() == ID){
            cout << "----LISTING INFORMATION----" << endl;
            cout << temp->info;
            return;
            }
        temp = list[temp->next];
        }
    
    }
CircularList::~CircularList()
{};

