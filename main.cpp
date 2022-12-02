#include<iostream>
#include <stdio.h>
#include <string>
#include <fstream>
#include <typeinfo>
#include "Date.hpp"
#include "Employee.hpp"
#include "PermanentEmployee.hpp"
#include "Node.hpp"
#include "LinkedList.hpp"
#include "Link.hpp"
#include "CircularList.hpp"
using namespace std;

void listbyID(LinkedList l1, CircularList l2){
    //take both lists and order them in ordered. print ordered and delete it. That way we eont occupy memory.
    LinkedList ordered = LinkedList();//temporary list to order both lists in an another linked list
    Node* head1 = l1.getHead();
    Link*   head2 = l2.getHead();
    bool l2_traversed = false;
    
    while(head1 != nullptr){
        Node* temp = new Node(head1->info);//created a new node in order to not alter the original this node only has data of the original
        ordered.inID(temp);
        head1 = head1->next;
        }
    while(!l2_traversed&& !l2.isEmpty()){
        if(head2 == l2.getTail()){l2_traversed = true;}
        Node* temp2 = new Node(head2->info);//converted Link object to node by just copying its data content to node. Node only has the data of Link object
        ordered.inID(temp2);
        head2 = l2.control(head2->next);
        }
    cout << "-------------------------LISTING ALL EMPLOYEES IN ASCENDING ORDER BY ID---------------------------------"<<endl;
    cout << ordered;
    }

void listbyDate(LinkedList l1, CircularList l2){
    //check listbyID comments
    LinkedList ordered = LinkedList();
    Node* head1 = l1.getHead();
    Link*   head2 = l2.getHead();
    bool l2_traversed = false;
    
    while(head1 != nullptr){
        Node* temp = new Node(head1->info);
        ordered.insert(temp);
        head1 = head1->next;
        }
    while(!l2_traversed && !l2.isEmpty()){
        if(head2 == l2.getTail()){l2_traversed = true;}
        Node* temp2 = new Node(head2->info);
        ordered.insert(temp2);
        head2 = l2.control(head2->next);
        }
    cout << "--------------------LISTING ALL EMPLOYEES IN ASCENDING ORDER BY APPOINTMENT DATE--------------------" << endl;
    cout << ordered;
    
    
    }

void bornSameMonth(LinkedList l1,CircularList l2, int month){
    //check listbyID comments
    LinkedList ordered = LinkedList();
    Node* head1 = l1.getHead();
    Link*   head2 = l2.getHead();
    bool l2_traversed = false;
    
    while(head1 != nullptr){
        if(head1->info.getBirthday().getMonth() == month){
            Node* temp = new Node(head1->info);
            ordered.inID(temp);}
        head1 = head1->next;
        }
    while(!l2_traversed && !l2.isEmpty()){
        if(head2 == l2.getTail()){l2_traversed = true;}
        if(head2->info.getBirthday().getMonth() == month){
            Node* temp2 = new Node(head2->info);
            ordered.inID(temp2);}
        head2 = l2.control(head2->next);
        }
    if(ordered.getHead() == nullptr){
       cout << "Sorry, couldn't find anyone that have born in this month" << endl;
       }
    else{
        cout << "-----------LISTING EMPLOYEES BORN IN THE GIVEN MONTH----------------" << endl;
        cout << ordered;
        }
    }

void bornBefore(LinkedList l1,CircularList l2, string dt){
    //check listbyID comments
    Date date1 = Date(dt);
    LinkedList ordered = LinkedList();
    Node* head1 = l1.getHead();
    Link*   head2 = l2.getHead();
    bool l2_traversed = false;
    
    while(head1 != nullptr){
        if(head1->info.getBirthday() < date1){
            Node* temp = new Node(head1->info);
            ordered.inID(temp);}
        head1 = head1->next;
        }
    while(!l2_traversed && !l2.isEmpty()){
        if(head2 == l2.getTail()){l2_traversed = true;}
        if(head2->info.getBirthday() < dt){
            Node* temp2 = new Node(head2->info);
            ordered.inID(temp2);}
        head2 = l2.control(head2->next);
        }
    if(ordered.getHead() == nullptr){
       cout << "Sorry, couldn't find anyone that have born before this date" << endl;
       }
    else{
    cout << "------LISTING EMPLOYEES THAT HAVE BORN BEFORE GIVEN DATE--------"<<endl;
    cout << ordered;
        }
    }

void sameTerm(LinkedList l1, CircularList l2, int year){
    //check listbyID comments
    LinkedList ordered = LinkedList();
    Node* head1 = l1.getHead();
    Link*   head2 = l2.getHead();
    bool l2_traversed = false;
    
    while(head1 != nullptr){
        if(head1->info.getEnrolldate().getYear() == year){
            Node* temp = new Node(head1->info);
            ordered.insert(temp);}
        head1 = head1->next;
        }
    while(!l2_traversed && !l2.isEmpty()){
        if(head2 == l2.getTail()){l2_traversed = true;}
        if(head2->info.getEnrolldate().getYear() == year){
            Node* temp2 = new Node(head2->info);
            ordered.insert(temp2);
            }
        head2 = l2.control(head2->next);
        }
    if(ordered.getHead() == nullptr){
       cout << "Sorry, couldn't find anyone that appointed in this year" << endl;
       }
    else{
    cout << "--------------LISTING EMPLOYEES APPOINTED IN GIVEN YEAR------------------" << endl;
    cout << ordered;}
    }    

void appAfter(LinkedList l1, CircularList l2, string dt){
    //check listbyID comments
    LinkedList ordered = LinkedList();
    Node* head1 = l1.getHead();
    Link*   head2 = l2.getHead();
    Date date1 = Date(dt);
    bool l2_traversed = false;
    
    while(head1 != nullptr){
        if(head1->info.getEnrolldate() > date1){
            Node* temp = new Node(head1->info);
            ordered.reverse(temp);}
        head1 = head1->next;
        }
    while(!l2_traversed && !l2.isEmpty()){
        if(head2 == l2.getTail()){l2_traversed = true;}
        if(head2->info.getEnrolldate() >date1){
            Node* temp2 = new Node(head2->info);
            ordered.reverse(temp2);}
        head2 = l2.control(head2->next);
        }
   if(ordered.getHead() == nullptr){
       cout << "Sorry, couldn't find anyone that appointed after this date" << endl;
       }
    else{
        cout << "---------------LISTING EMPLOYEES APPOINTED AFTER A CERTAIN DATE------------------"<<endl;
        cout <<ordered;  
        }
    }

void lastApp(LinkedList l1, CircularList l2, string title){
    //check listbyID comments
    LinkedList ordered = LinkedList();
    Node* head1 = l1.getHead();
    Link*   head2 = l2.getHead();
    bool l2_traversed = false;
    
    while(head1 != nullptr){
        Node* temp = new Node(head1->info);
        ordered.reverse(temp);
        head1 = head1->next;
        }
    while(!l2_traversed && !l2.isEmpty()){
        if(head2 == l2.getTail()){l2_traversed = true;}
        Node* temp2 = new Node(head2->info);
        ordered.reverse(temp2);
        head2 = l2.control(head2->next);
        }
    Node* print = ordered.getHead();
    while(print != nullptr){
        if(print->info.getTitle() == title){
            cout << "--------------- SHOWING LAST APPOINTED  EMPLOYEE WITH THIS TITLE--------------"<<endl;
            cout << print->info <<endl << endl; return;}
        print = print->next;
        }
        cout << "---------------------------------------------" <<endl;
        cout << "Couldn't find an employee with that title" << endl;
    }    
    
int main(int argc, char **argv)
{   
    LinkedList employees = LinkedList();//doubly linked list
    CircularList temps = CircularList();//circular list array implementation
     // dates are taken as string in terminal but converted to date objects in object constructors, you can check
    int choice{0};
    int year{0};
    int month{0};
    int ID{0};
    int Type{0};
    int service{0}; //service length
    double coef{0}; // salary coefficien
    string name{0};
    string s_name{0};
    string pst{0}; // position/job title
    string b_date{0}; //birthdate
    string a_date{0}; //appointment date
    
    while(true){
        cout << endl << "____Employee Recording System____"<< endl << 
        "Please select for the following Menu Operation: "<<endl << 
        "1) Appointment of a new employee" <<endl << 
        "2) Appointment of a transferred employee" << endl <<
        "3) Updating the title and salary coefficient of an employee" << endl << 
        "4) Deletion of an employee" << endl << 
        "5) Listing the information of an employee" << endl <<
        "6) Listing employees ordered by employee number" << endl <<
        "7) Listing employees ordered by appointment day" << endl <<
        "8) Listing employees appointed after a certain date" << endl <<
        "9) Listing employees assigned in a given year" << endl <<
        "10) Listing employees born before a certain date" << endl <<
        "11) Listing employees born in a particular month" << endl <<
        "12) Listing the information of the last assigned employee with the given title" << endl;
        cin >> choice;
        if(choice == 1){
            cout << "Type Employee Number:" << endl;
            cin >> ID;
            if(employees.search(ID) || temps.search(ID)){
                cout << "Sorry, there is an employee with this number";
                continue;
                }
            cout << "Type Employee Type: " << endl;
            cin >> Type;
            cout << "Type name:" << endl;
            cin.ignore();
            getline(cin, name);
            cout << "Type surname: " << endl;
            getline(cin, s_name);
            cout << "Type title:" << endl;
            getline(cin, pst);
            cout << "Type salary coefficient:" << endl;
            cin >> coef;
            cout << "Type birth date:" << endl;
            cin >> b_date;
            cout << "Type appointment date:" << endl;
            cin >> a_date;
            if(Type == 0){
                Link* t_emp =new Link(ID, name, s_name, pst, coef, b_date, a_date);
                temps.add(t_emp);
                continue;
                }
            else if(Type == 1){
                Node* p_emp =new Node(ID, name, s_name, pst, coef, b_date, a_date);
                employees.insert(p_emp);
                continue;
                }
            }
        else if(choice == 2){
            cout << "Type Employee Number:" << endl;
            cin >> ID;
            if(employees.search(ID) || temps.search(ID)){
                cout << "Sorry, there is an employee with this number" << endl;
                continue;
                }
            cout << "Type Employee Type: " << endl;
            cin >> Type;
            cout << "Type name:" << endl;
            cin.ignore();
            getline(cin, name);
            cout << "Type surname: " << endl;
            getline(cin, s_name);
            cout << "Type title:" << endl;
            getline(cin, pst);
            cout << "Type salary coefficient:" << endl;
            cin >> coef;
            cout << "Type birth date:" << endl;
            cin >> b_date;
            cout << "Type appointment date:" << endl;
            cin >> a_date;
            cout << "Type length of service days" <<endl;
            cin >> service;
            if(Type == 0){
                Link* t_emp =new Link(ID, name, s_name, pst, coef, b_date, a_date, service);
                temps.add(t_emp);
                continue;
                }
            else if(Type == 1){
                Node* p_emp =new Node(ID, name, s_name, pst, coef, b_date, a_date, service);
                employees.insert(p_emp);
                continue;
                }
            }
        else if(choice == 3){
            cout << "Type employee number:" << endl;
            cin >> ID;
            if(employees.search(ID)){
                cout << "Enter the coefficient you want to upgrade to:" << endl;
                cin >> coef;
                cout << "Type new title of employee:" << endl;
                cin.ignore();
                getline(cin,pst);
                employees.changeCoef(ID, coef, pst);
                continue;
                }
            else if(temps.search(ID)){
                cout << "Enter the coefficient you want to update to:" << endl;
                cin >> coef;
                cout << "Type new title of employee:" << endl;
                cin.ignore();
                getline(cin,pst);
                temps.updCoef(ID,coef, pst);
                continue;
                }
            else{
                cout << "------------------------------------------------" << endl;
                cout << "Couldn't find employee with this number" << endl;
                continue;
                }
            }
        else if(choice == 4){
            cout << "Type Employee Number:" << endl;
            cin >> ID;
            if(employees.search(ID)){
                employees.remove(ID);
                continue;
                }
            else if(temps.search(ID)){
                temps.remove(ID);
                continue;
                }
            else{
                cout << "------------------------------------------------" << endl;
                cout << "Couldn't find employee with this number" << endl;
                continue;
                }
            
            }
        else if(choice == 5){
            cout << "Type Employee Number:" << endl;
            cin >> ID;
            if(employees.search(ID)){
                employees.tag(ID);
                continue;
                }
            else if(temps.search(ID)){
                temps.tag(ID);
                continue;
                }
            else{
                cout << "------------------------------------------------" << endl;
                cout << "Couldn't find employee with this number" << endl;
                continue;
                }
            }
        else if(choice == 6){
            if(employees.getHead() != nullptr ||  !temps.isEmpty()){
                listbyID(employees, temps);
                continue;
                }
            else{
                cout << "There are currently no employees in the instution" << endl;
                continue;
                }
            }
        else if(choice == 7){
             if(employees.getHead() != nullptr ||  !temps.isEmpty()){
                listbyDate(employees, temps);
                continue;
                }
            else{
                cout << "There are currently no employees in the instution" << endl;
                continue;
                }
            }
        else if(choice == 8){
             if(employees.getHead() != nullptr ||  !temps.isEmpty()){
                cout << "Enter the date format: DD-MM-YYYY" << endl;
                cin >> a_date;
                appAfter(employees, temps, a_date);
                continue;
                }
            else{
                cout << "There are currently no employees in the instution" << endl;
                continue;
                }
            }
        else if(choice == 9){
            if(employees.getHead() != nullptr ||  !temps.isEmpty()){
                cout << "Enter the year" << endl;
                cin >> year;
                sameTerm(employees, temps, year);
                continue;
                }
            else{
                cout << "There are currently no employees in the instution" << endl;
                continue;
                }
            }
        else if(choice == 10){
            if(employees.getHead() != nullptr ||  !temps.isEmpty()){
                cout << "Enter the date. format: DD-MM-YYYY" << endl;
                cin >> b_date;
                bornBefore(employees, temps, b_date);
                continue;
                }
            else{
                cout << "There are currently no employees in the instution" << endl;
                continue;
                }
            }
        else if(choice == 11){
            if(employees.getHead() != nullptr ||  !temps.isEmpty()){
                cout << "Enter a month. Just enter an integer. ie: 12 for december" << endl;
                cin >> month;
                bornSameMonth(employees, temps, month);
                continue;
                }
            else{
                cout << "There are currently no employees in the instution" << endl;
                continue;
                }
            }
        else if(choice == 12){
            if(employees.getHead() != nullptr ||  !temps.isEmpty()){
                cout << "Enter the title" << endl;
                cin >> pst;
                lastApp(employees, temps, pst);
                continue;
                }
            else{
                cout << "There are currently no employees in the instution" << endl;
                continue;
                }
            }
        }
    
    return 0;
}
