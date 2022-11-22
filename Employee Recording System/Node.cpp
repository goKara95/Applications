#include "Node.hpp"
#include "PermanentEmployee.hpp"
Node::Node(Employee e):
info{e}, next(nullptr), prev(nullptr){};

Node::Node(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date):
info{PermanentEmployee(ID, name, surname, title, salary_coef, birthdate, enroll_date)},next{nullptr},prev{nullptr}{};

Node::Node(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date, int service_length):
info{PermanentEmployee(ID, name, surname, title, salary_coef, birthdate, enroll_date, service_length)},next{nullptr},prev{nullptr}{};

Node::~Node()
{

}

