#ifndef EMPLOYEE_HPP
#define EMPLOYEE_HPP
#include <string>
#include <iostream>
#include "Date.hpp"

using namespace std;


class Employee
{
private:
const int ID;
const int type;
const string name;
const string surname;
string title;
double salary_coef;
const Date birth_date;
const Date enroll_date;
const int service_length;

public:
    Employee();
    Employee(int ID, int type, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date);
    Employee(int ID, int type, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date, int service_length);
    int getID();
    Date getBirthday();
    Date getEnrolldate();
    string getTitle();
    void setSalary(double coef);
    void setTitle(string newtit);
    double getSalary();
    friend ostream& operator<<(ostream& os, const Employee& e);
    ~Employee();

};

#endif // EMPLOYEE_HPP
