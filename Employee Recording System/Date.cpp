#include "Date.hpp"
#include <iostream>
Date::Date():day(30),month(11),year(2021){
    }

Date::Date(string date):day{stoi(date.substr(0,2))},month{stoi(date.substr(3,2))},year{stoi(date.substr(6,4))}
{
}
int Date::getYear(){
    return year;
};

int Date::getMonth(){
    return month;
    };

int Date::getDay(){
    return day;
    }

bool Date::operator<(Date d2){//ie: 2000 > 1999
    if(this->getYear() > d2.getYear()){return false;}
    else if(this->getYear() < d2.getYear()){return true;}
    else if(this->getMonth() > d2.getMonth()){return false;}
    else if(this->getMonth()< d2.getMonth()){return true;}
    return this->getDay()<d2.getDay();
    }
bool Date::operator>(Date d2){//ie: 05-12-1980 < 06-12-1980
    if(this->getYear() > d2.getYear()){return true;}
    else if(this->getYear() < d2.getYear()){return false;}
    else if(this->getMonth() > d2.getMonth()){return true;}
    else if(this->getMonth()< d2.getMonth()){return false;}
    return this->getDay()>d2.getDay();
    }


ostream& operator<<(ostream& os, const Date& d)
{
    os << d.day << "-" << d.month << "-" << d.year;
    return os;
}

Date::~Date()
{
}

