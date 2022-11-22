#include <iostream>
#include "Employee.hpp"
Employee::Employee():
ID(0), type(0), name("john"), surname("doe"), title("no"), salary_coef(0.0), birth_date(Date("05-05-0005")), enroll_date(Date("05-05-0005")), service_length(0){};

//both constructors use initializer list because employee class have constants variables
Employee::Employee(int ID, int type, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date)://constructor of nontransferred employee
ID(ID), type(type), name(name), surname(surname), title(title), salary_coef(salary_coef), birth_date(Date(birthdate)), enroll_date(Date(enroll_date)), service_length(0){};

Employee::Employee(int ID, int type, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date, int service_length): //constructor of transferred employee
ID(ID), type(type), name(name), surname(surname), title(title), salary_coef(salary_coef), birth_date(Date(birthdate)), enroll_date(Date(enroll_date)), service_length(service_length){};

Date Employee::getBirthday(){
    return birth_date;
    };
Date Employee::getEnrolldate(){
    return enroll_date;
    };
int Employee::getID(){
    return ID;
    };
string Employee::getTitle(){
    return title;
    };

void Employee::setTitle(string newtit){
    title = newtit;
    }

void Employee::setSalary(double coef){
    salary_coef=coef;
    };

double Employee::getSalary(){
    return salary_coef;
    };

ostream& operator<<(ostream& os, const Employee& e)
{
    if(e.type==0){// << overload for temporary employee
        os << "ID: " << e.ID <<endl << "Type: Temporary"<< endl << "Name: "<<e.name << endl << "Surname: " << e.surname << endl <<"Title: " << e.title << endl <<
        "Salary coefficient: " << e.salary_coef << endl << "Birthday: " << e.birth_date <<endl << "Appointment Date: "<< e.enroll_date << endl <<
        "Length of Service in other instutions: " << e.service_length << endl;
        } 
    else if(e.type == 1){// << overload for permanent employee
        os << "ID: " << e.ID <<endl << "Type: Permanent"<< endl << "Name: "<<e.name << endl << "Surname: " << e.surname << endl <<"Title: " << e.title << endl <<
        "Salary coefficient: " << e.salary_coef << endl << "Birthday: " << e.birth_date <<endl << "Appointment Date: "<< e.enroll_date << endl <<
        "Length of Service in other instutions: " << e.service_length << endl;
        }
    
    return os;
}
    
Employee::~Employee()
{
}

