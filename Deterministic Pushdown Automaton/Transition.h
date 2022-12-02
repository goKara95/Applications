#ifndef TRANSITION_H
#define TRANSITION_H
#include "string"
using namespace std;

class Transition
{
public:
    string state;//current state
    string input; //line in input.txt
    string expected;//popped element of stack
    string next_state;//next state
    string push;//character to be pushed
    Transition(string start, string input, string expected, string next, string push);
    ~Transition();

};

#endif // TRANSITION_H
