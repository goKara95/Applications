#include<iostream>
#include <stdio.h>
#include "string"
#include <vector>
#include <fstream>
#include "Transition.h"
#include <algorithm>
#include <stack>

using namespace std;
string start_state{0};
string current_state{0};
int first = 1;
vector<string> final_states;
vector<string> state_list;
vector<Transition> rules; // holds transition rule objects
vector<string>  input_alphabet;
vector<string>  stack_symbols;
vector<string>  initializer; //stores necessary fields to initialize a transition object
vector<string>  input_chars; //stores the chars in inputline
stack  <string>  mystack;
stack  <string> temp; //temporary stack to copy values of mystack
stack  <string> r_stack;//reversed version of temp. Will be used to print values
int main(int argc, char **argv)
{   
    ofstream writer;
    writer.open(argv[3],ios::out);
    string line;
    string q_left;
    string q_right;
    fstream reader{argv[1], ios::in};
    fstream reader2{argv[2],ios::in};
     while(!reader.eof()){
         getline(reader,line);
         if(line.at(0) == 'Q'){
             for(int i=0; i<line.length(); i++){
                 //divided first line to make the process easier
                 if(line.substr(i,4)==" => "){
                     q_left = line.substr(2,i-2);
                     q_right = line.substr(i+4, line.length());
                     i = line.length();
                }
            }
             for(int i=0; i<q_left.length(); i++){//q_left for loop
                if(q_left.at(i) == ','){
                    state_list.push_back(q_left.substr(0,i));
                    q_left = q_left.substr(i+1, q_left.length());
                    i = -1;
                }
             }
             state_list.push_back(q_left);
             for(int i = 0; i<q_right.length();i++){//q_right for loop
                 if(q_right.at(i) == '(' ){
                     start_state = q_right.substr(i+1, state_list[0].length());
                     q_right = q_right.substr(state_list[0].length()+3, q_right.length());
                     i = -1;
                }
                else if(q_right.at(i) == '['){
                    final_states.push_back(q_right.substr(i+1,state_list[0].length()));
                    if(state_list[0].length()+3 < q_right.length()){
                        q_right = q_right.substr(state_list[0].length()+3, q_right.length());
                        i =-1;
                    }
                    else{
                        i = q_right.length();
                    }
                }
                 
            }
     }
         if(line.at(0) == 'A'){
            line = line.substr(2,line.length());
            for(int i=0; i<line.length(); i++){
                if(line.at(i) == ','){
                    input_alphabet.push_back(line.substr(0,1));
                    line = line.substr(i+1,line.length());
                    i = -1;
                }
                else if(line.length() == 1){
                    input_alphabet.push_back(line);
                    i = line.length();
                }
            }
        }
         if(line.at(0) == 'Z'){
            line = line.substr(2,line.length());
            for(int i=0; i<line.length(); i++){
                if(line.at(i) == ','){
                    stack_symbols.push_back(line.substr(0,1));
                    line = line.substr(i+1,line.length());
                    i = -1;
                }
                else if(line.length() == 1){
                    stack_symbols.push_back(line);
                    i = line.length();
                }
            }
        }
         if(line.at(0) == 'T'){
             line = line.substr(2,line.length());
             for(int i = 0; i<line.length(); i++){
                 if(line.at(i) == ','){
                     initializer.push_back(line.substr(0,i));
                     line = line.substr(i+1, line.length());
                     i= -1;
                }
                else if(line.length()==1){
                    initializer.push_back(line);
                    i = line.length();
                }
            }
            //,
            /*initializer[0] = current state of rule(T), 
                initializer[1]= input of T, 
                initializer[2]= symbol to be popped,
                initializer[3]= next state of T,
                initizlizer[4]= symbol to write in stack*/
                
            if (find(state_list.begin(), state_list.end(), initializer[0]) == state_list.end()) {
                //gives error if initializer's name field isn't in state list (Q)
                writer << "Error [1]:DPDA description is invalid!";
                return 0;
            }
            else if (find(state_list.begin(), state_list.end(), initializer[3]) == state_list.end()) {
                //gives error if next state isn't in Q
                writer << "Error [1]:DPDA description is invalid!";
                return 0;
            }
            else if (find(stack_symbols.begin(), stack_symbols.end(), initializer[4]) == stack_symbols.end() && initializer[4] != "e") {
                //gives error if element to be written isn't in stack symbols
                writer << "Error [1]:DPDA description is invalid!";
                return 0;
            }
            else if (find(stack_symbols.begin(), stack_symbols.end(), initializer[2]) == stack_symbols.end() && initializer[2] != "e") {
                //gives error if element to be remove isn't in stack symbols
                writer << "Error [1]:DPDA description is invalid!";
                return 0;
            }
            else if (find(input_alphabet.begin(), input_alphabet.end(), initializer[1]) == input_alphabet.end() && initializer[1] != "e") {
                //gives error if input isn't in input alphabet
                writer << "Error [1]:DPDA description is invalid!";
                return 0;
            }
            rules.push_back(Transition(initializer[0], initializer[1], initializer[2], initializer[3], initializer[4]));
            initializer.clear();
            }
    }
    reader.close();
    /*reader2 will read input line and store them in input_chars
     in while loop if matching transition rule is found input_char's first element will be deleted
     that way we weill apply every rule until the input line ends*/
     
    while(!reader2.eof()){
        getline(reader2, line);
        if(line.empty()){
            //accept if in final state else reject
            if(find(final_states.begin(), final_states.end(), start_state) != final_states.end()){
                writer << "ACCEPT" <<endl<<endl;
            }
            else{
                writer << "REJECT" << endl <<endl;
            }
        }        
        for(int i =0; i<line.length(); i++){
            if(line.at(i) == ','){
                input_chars.push_back(line.substr(0,i));
                line = line.substr(i+1, line.length());
                i=-1;
            }
            else if(line.length() == 1){
                input_chars.push_back(line);
                i= line.length();
            }
        }
        while(input_chars.size() != 0){
            //loop to execute initial transition rule
            if(first == 1){
                for(int i=0;i<rules.size();i++){
                    if(rules[i].state == start_state){
                        current_state = rules[i].next_state;
                        if(rules[i].expected != "e" && mystack.size()!=0 && rules[i].expected == mystack.top()){
                            mystack.pop();
                        }
                        if(rules[i].push != "e"){
                            mystack.push(rules[i].push);
                        }
                        first = 0;
                        writer << rules[i].state << "," << rules[i].input << "," << rules[i].expected << " => " << rules[i].next_state << "," << rules[i].push 
                        << " [STACK]:" ;
                        if(mystack.empty()){
                            writer << " " << endl;
                        }
                        else{
                            writer << mystack.top() << endl;
                        }
                        if(rules[i].input == input_chars[0]){input_chars.erase(input_chars.begin());}
                        i = rules.size();
                    }
                }
                if(first != 0){
                    input_chars.clear();
                    writer << "REJECT";
                }
            }
            int found = 0;//whether appropriate transition rule is found. found = 1 when found.
            if(found == 0){//if both input and  expected are a match
                for(int i =0; i<rules.size(); i++){
                    if(rules[i].state == current_state && rules[i].input == input_chars[0] && mystack.size()!=0 && rules[i].expected == mystack.top()){
                        if(rules[i].expected != "e"){mystack.pop();}
                        if(rules[i].push != "e"){mystack.push(rules[i].push);}
                        current_state = rules[i].next_state;
                        input_chars.erase(input_chars.begin());
                        writer << rules[i].state << "," << rules[i].input << "," << rules[i].expected << " => " << rules[i].next_state << "," << rules[i].push 
                        << " [STACK]:" ;
                        if(mystack.empty()){
                            writer << " "<< endl;
                        }
                        else{
                            temp = mystack;
                            while(!temp.empty()){r_stack.push(temp.top());temp.pop();}
                            while(!r_stack.empty()){writer << r_stack.top();r_stack.pop();if(!r_stack.empty()){writer << ",";}}
                            writer << endl;
                        }
                    i = rules.size();
                    found = 1;
                    }
                }
            }
            if(found == 0){//if input matches but expected is e
                for(int i =0; i<rules.size(); i++){
                    if(rules[i].state == current_state && rules[i].input == input_chars[0] && rules[i].expected == "e"){
                        if(rules[i].push != "e"){mystack.push(rules[i].push);}
                        current_state = rules[i].next_state;
                        input_chars.erase(input_chars.begin());
                        writer << rules[i].state << "," << rules[i].input << "," << rules[i].expected << " => " << rules[i].next_state << "," << rules[i].push 
                        << " [STACK]:" ;
                        if(mystack.empty()){
                            writer << " " << endl;
                        }
                         else{
                             temp = mystack;
                             while(!temp.empty()){r_stack.push(temp.top());temp.pop();}
                             while(!r_stack.empty()){writer << r_stack.top();r_stack.pop();if(!r_stack.empty()){writer << ",";}}
                             writer << endl;
                        }
                    i = rules.size();
                    found = 1;    
                    }
                }
            }
            if(found == 0 && input_chars.size() != 0){//if input couldn't be found but expected matches
            for(int i =0; i<rules.size(); i++){
                 if(rules[i].state == current_state && rules[i].input == "e" && mystack.size()!=0 && rules[i].expected == mystack.top()){
                     current_state = rules[i].next_state;
                     mystack.pop();
                     if(rules[i].push != "e"){mystack.push(rules[i].push);}
                      writer << rules[i].state << "," << rules[i].input << "," << rules[i].expected << " => " << rules[i].next_state << "," << rules[i].push 
                        << " [STACK]:" ;
                        if(mystack.empty()){
                            writer << " " <<endl;
                        }
                         else{
                             temp = mystack;
                             while(!temp.empty()){r_stack.push(temp.top());temp.pop();}
                             while(!r_stack.empty()){writer << r_stack.top();r_stack.pop();if(!r_stack.empty()){writer << ",";}}
                             writer << endl;
                        }
                    i = rules.size();
                    found = 1;
                }
            }
            }
            if(found == 0 && input_chars.size()!=0){//state,e,e
                for(int i =0; i<rules.size(); i++){
                     if(rules[i].state == current_state && rules[i].input == "e" && rules[i].expected == "e"){
                         current_state = rules[i].next_state;
                          if(rules[i].push != "e"){mystack.push(rules[i].push);}
                         writer << rules[i].state << "," << rules[i].input << "," << rules[i].expected << " => " << rules[i].next_state << "," << rules[i].push 
                        << " [STACK]:" ;
                        if(mystack.empty()){
                            writer << " " << endl;
                        }
                         else{
                             temp = mystack;
                             while(!temp.empty()){r_stack.push(temp.top());temp.pop();}
                             while(!r_stack.empty()){writer << r_stack.top();r_stack.pop();if(!r_stack.empty()){writer << ",";}}
                             writer << endl;
                        }
                    i = rules.size();
                    found = 1;    
                    }
                }
            }
            if(found == 0){input_chars.clear(); writer << "REJECT" <<endl << endl;}//if couldn't find appropriate transition rule at all we will reject it
            else if(input_chars.size() == 0){/*if we used all the characters we will check whether we reached the final state. If we didn't we will try to execute
             * rule with empty string input and check whether we are in the final state again*/
                if(find(final_states.begin(), final_states.end(), current_state) != final_states.end()){
                    if( (mystack.size() == 1 && mystack.top() == "$") || mystack.size()==0){
                        writer << "ACCEPT" << endl << endl;
                    }
                    else{
                        writer << "REJECT" <<endl << endl;
                    }
                }
                else if(find(final_states.begin(), final_states.end(), current_state) == final_states.end()){
                    found = 0;
                    /*for loop case 1: expected matches, info e*/for(int i = 0; i<rules.size(); i++){
                        if(rules[i].state == current_state && rules[i].input == "e" && mystack.size()!=0 && rules[i].expected == mystack.top()){
                            current_state = rules[i].next_state;
                            mystack.pop();
                            if(rules[i].push != "e"){mystack.push(rules[i].push);}
                            writer << rules[i].state << "," << rules[i].input << "," << rules[i].expected << " => " << rules[i].next_state << "," << rules[i].push 
                                << " [STACK]:" ;
                                if(mystack.empty()){
                                    writer << " " <<endl;
                                }
                                else{
                                   temp = mystack;
                                   while(!temp.empty()){
                                       r_stack.push(temp.top());
                                       temp.pop();
                                    }
                                    while(!r_stack.empty()){
                                        writer << r_stack.top();
                                        r_stack.pop();
                                        if(!r_stack.empty()){writer << ",";}
                                        }
                                    writer << endl;
                                }
                            i = rules.size();
                            found = 1;
                        }
                    }
                    /*for loop case 2 e,e*/if(found == 0){ 
                        for(int i =0; i<rules.size(); i++){
                            if(rules[i].state == current_state && rules[i].input == "e" && rules[i].expected == "e"){
                                current_state = rules[i].next_state;
                                if(rules[i].push != "e"){mystack.push(rules[i].push);}
                                writer << rules[i].state << "," << rules[i].input << "," << rules[i].expected << " => " << rules[i].next_state << "," << rules[i].push 
                                << " [STACK]:" ;
                                if(mystack.empty()){
                                    writer << " "<<endl;
                                }
                                else{
                                    temp = mystack;
                                    while(!temp.empty()){
                                        r_stack.push(temp.top());
                                        temp.pop();
                                    }
                                    while(!r_stack.empty()){
                                        writer << r_stack.top();
                                        r_stack.pop();
                                        if(!r_stack.empty()){writer << ",";}
                                        }
                                    writer << endl;
                                }
                                i = rules.size();
                                found = 1;    
                            }
                        }       
                    }
                    if(found == 0) {writer << "REJECT" << endl<< endl;}
                    if(found == 1){
                        if(find(final_states.begin(), final_states.end(), current_state) != final_states.end()){
                            if( (mystack.size() == 1 && mystack.top() == "$") || mystack.size()==0){
                                writer << "ACCEPT" << endl << endl;
                            }
                            else{
                                writer << "REJECT" << endl << endl;
                                }
                        }
                        else{
                            writer << "REJECT"<<endl << endl;
                            }
                    }
                }
            }
        }
        first =1;
        while(!mystack.empty()){
            mystack.pop();//reset stack
        }
    }
    reader2.close();
    
	return 0;
}
