#ifndef TEMPORARYEMPLOYEE_HPP
#define TEMPORARYEMPLOYEE_HPP
#include "Employee.hpp"

class TemporaryEmployee : public Employee{
public:
    TemporaryEmployee();
    // constructors doesn't have type parameters it is set to 0 by default
    // << operator overloaded in Employee class for both Temporary and Permanent employees. There is no need to define it here again
    TemporaryEmployee(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date);
    TemporaryEmployee(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date, int service_length);
    
    ~TemporaryEmployee();

};

#endif // TEMPORARYEMPLOYEE_HPP
