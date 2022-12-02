#include "Link.hpp"
#include "TemporaryEmployee.hpp"
Link::Link(){
    };
Link::Link(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date):
info{TemporaryEmployee(ID, name, surname, title, salary_coef, birthdate, enroll_date)},next{-1}{};

Link::Link(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date, int service_length):
info{TemporaryEmployee(ID, name, surname, title, salary_coef, birthdate, enroll_date, service_length)},next{-1}{};

Link::~Link()
{
}

