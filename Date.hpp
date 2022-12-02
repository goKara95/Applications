#ifndef DATE_HPP
#define DATE_HPP
#include <string>
#include <iostream>
using namespace std;

class Date
{
private:
const int day;
const int month;
const int year;

public:
    Date();
    Date(string date);// takes a string and divides it into day,month and year fields
    int getYear();
    int getMonth();
    int getDay();
    bool operator<(Date d2); //returns if left hand side date is smaller than right hand side date
    bool operator>(Date d2); //returns if left hand side date is smaller than right hand side date
    friend ostream& operator<<(ostream& os, const Date& d);
    ~Date();
   

};

#endif // DATE_HPP
