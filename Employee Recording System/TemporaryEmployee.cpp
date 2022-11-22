#include "TemporaryEmployee.hpp"
TemporaryEmployee::TemporaryEmployee(){};
//constructors call parent class constructors because since member fields are private we can't reach them from here
TemporaryEmployee::TemporaryEmployee(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date)
: Employee{ID, 0, name, surname, title, salary_coef, birthdate, enroll_date}{ };

TemporaryEmployee::TemporaryEmployee(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date, int service_length)
: Employee{ID, 0, name, surname, title, salary_coef, birthdate, enroll_date, service_length}{ };

TemporaryEmployee::~TemporaryEmployee(){}

