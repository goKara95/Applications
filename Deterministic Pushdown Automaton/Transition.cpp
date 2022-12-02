#include "Transition.h"

Transition::Transition(string start, string input, string expected, string next, string push)
:state{start},input{input}, expected{expected}, next_state{next}, push{push}{};

Transition::~Transition()
{
}

