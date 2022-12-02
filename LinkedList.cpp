#include "LinkedList.hpp"
#include<iostream>

LinkedList::LinkedList(){head = nullptr;}
Node* LinkedList::getHead(){
    return head;
    }

void LinkedList::insert(Node* element){//liste boşsa
    if(head == nullptr){
        head = element;
        return;}
    else if(element->info.getEnrolldate() < head->info.getEnrolldate()){// eğer insert edilen en küçük elemansa
        head->prev = element;
        element->next = head;
        head = element;
        return;
        }
    else if(head->next ==nullptr){
        head->next = element;
        element->prev = head;
        return;
        }
    Node* temp = head;
    Node* temp2 = head->next;
    int inserted = 0;
    while(inserted !=1){
        if(element->info.getEnrolldate() < temp2->info.getEnrolldate()){
            temp2->prev = element;
            element->next = temp2;
            element->prev = temp;
            temp->next = element;
            return;
            }
        if(temp2->next ==nullptr){
            element->prev = temp2;
            temp2->next = element;
            inserted = 1;
            return;
            }
        temp = temp2;
        temp2 = temp2->next;
        }
    }

void LinkedList::changeCoef(int ID, double coef, string Title){
    Node* temp= head;
    int found = 0;
    while(found != 1){
        if(temp->info.getID() == ID){
            temp->info.setSalary(coef);
            temp->info.setTitle(Title);
            found=1;}
        else if(temp->next == nullptr){found=1; std::cout << "Sorry, couldn't find the employee" << endl;}
        if(found != 1){temp = temp->next;}
       }
};

void LinkedList::remove(int ID){
    Node* temp= head;
    int found = 0;
    while(found != 1){
        if(temp->info.getID() == ID){
            if(temp->prev == nullptr && temp->next == nullptr ){head = nullptr;}
            else if(temp->prev == nullptr && temp->next != nullptr){temp->next->prev = nullptr; head = temp->next;}
            else if(temp->prev != nullptr && temp->next == nullptr){temp->prev->next = nullptr;}
            else if(temp->prev != nullptr && temp->next != nullptr){temp->next->prev = temp->prev; temp->prev->next = temp->next;}
            delete temp;
            found=1;}
        else if(temp->next == nullptr){found=1; std::cout << "Sorry, couldn't find the employee" << endl;}
        if(found != 1){temp = temp->next;}
       }
    };


bool LinkedList::search(int ID){
    if(head == nullptr){
        return false;
        }
    Node* temp = head;    
    while(true){
        if(temp->info.getID() == ID){
            return true;
            }
        else if(temp->next == nullptr){
            return false;
            }
        temp = temp->next;
        }
    }

void LinkedList::tag(int ID){
    Node* temp = head;    
    while(true){
        if(temp->info.getID() == ID){
            cout << "----LISTING INFORMATION----" << endl;
            cout << temp->info;
            return;
            }
        temp = temp->next;
        }
    }
   
void LinkedList::inID(Node* element){//if list is empty
    if(head == nullptr){
        head = element;
        return;}
    else if(element->info.getID() < head->info.getID()){//if inserted element will have the smallest ID
        head->prev = element;
        element->next = head;
        head = element;
        return;
        }
    else if(head->next ==nullptr){
        head->next = element;
        element->prev = head;
        return;
        }
    Node* temp = head;
    Node* temp2 = head->next;
    int inserted = 0;
    while(inserted !=1){
        if(element->info.getID() < temp2->info.getID()){
            temp2->prev = element;
            element->next = temp2;
            element->prev = temp;
            temp->next = element;
            return;
            }
        if(temp2->next ==nullptr){
            element->prev = temp2;
            temp2->next = element;
            inserted = 1;
            return;
            }
        temp = temp2;
        temp2 = temp2->next;
        }
    }

 
 void LinkedList::reverse(Node* element){//if list is empty
    if(head == nullptr){
        head = element;
        return;}
    else if(element->info.getEnrolldate() > head->info.getEnrolldate()){//if inserted element is the biggest
        head->prev = element;
        element->next = head;
        head = element;
        return;
        }
    else if(head->next ==nullptr){
        head->next = element;
        element->prev = head;
        return;
        }
    Node* temp = head;
    Node* temp2 = head->next;
    int inserted = 0;
    while(inserted !=1){
        if(element->info.getEnrolldate() > temp2->info.getEnrolldate()){
            temp2->prev = element;
            element->next = temp2;
            element->prev = temp;
            temp->next = element;
            return;
            }
        if(temp2->next ==nullptr){
            element->prev = temp2;
            temp2->next = element;
            inserted = 1;
            return;
            }
        temp = temp2;
        temp2 = temp2->next;
        }
    }
 
 ostream& operator<<(ostream& os, LinkedList list)
{
    Node* head = list.getHead();
    while(head != nullptr){
        cout << head->info <<endl << endl;
        head = head->next;
        }
    return os;
}
 
LinkedList::~LinkedList()
{}

