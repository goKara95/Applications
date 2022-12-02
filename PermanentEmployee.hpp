#ifndef PERMANENTEMPLOYEE_HPP
#define PERMANENTEMPLOYEE_HPP
#include "Employee.hpp"


class PermanentEmployee : public Employee{
public:
    PermanentEmployee();
    // constructors doesn't have type parameters it is set to 1 by default
    // << operator overloaded in Employee class for both Temporary and Permanent employees. There is no need to define it here again
    PermanentEmployee(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date);
    PermanentEmployee(int ID, string name, string surname, string title, double salary_coef, string birthdate, string enroll_date, int service_length);
    ~PermanentEmployee();

};

#endif // PERMANENTEMPLOYEE_HPP
