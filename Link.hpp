#ifndef LINK_HPP
#define LINK_HPP
#include "TemporaryEmployee.hpp"
class Link
{
public:
    //data type for CircularList
    TemporaryEmployee info;
    int next;
    Link();
    Link(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date);
    Link(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date, int service_length);
    ~Link();

};

#endif // LINK_HPP
