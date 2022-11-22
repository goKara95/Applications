#ifndef NODE_HPP
#define NODE_HPP
#include "PermanentEmployee.hpp"

class Node
{
public:
    Employee info;//Stores permanent or temporary employees. If I haven't had to add the elements in the circular list to a linked list to sort them it would be Permanent employee type
    Node* next;
    Node* prev;
    Node(Employee e);//takes an employee object to conver Link types to Node. Info will be set to Link.info. Next and prev will be nullptr
    //constructors below are take Employee object parameters to initialize info field
    Node(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date);
    Node(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date, int service_length);
    ~Node();

};

#endif // NODE_HPP
