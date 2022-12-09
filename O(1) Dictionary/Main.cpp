#include<iostream>
#include <stdio.h>
#include "string"
#include <vector>
#include <fstream>
#include <algorithm>
using namespace std;
string prefix = "-";
string op_word;//since functions are recursive this will be made equal to the parameter in function calls to keep track of original key

struct Trie{
    char data{0};//letter of node
    Trie* children[26]{0};//holds pointers to nodes. Letter a is accessed by children[0], z = children[25] etc.
    string value;//English equivalent of the dothraki word
    int branch_size = 0;//0 means no child and 1 means no branch
    vector<int> branches;//position of branches in children array. If root has c,d,e as children branches will store 2,3,4.
    //I created the branches vector because if I didn't I would have to traverse 26 elements for every node. This way I know where and how many the children nodes are
    //At first I needed 26n array accesses. Now with the help of branches vector I only need n-1 accesses where n is node number 
    };

vector<Trie*> path;//takes the path taken in depth first search. DFS is performed on delete operation


int map(char letter){//maps letters to array indexes
    if(letter == 'a'){return 0;}
    else if(letter == 'b'){return 1;}
    else if(letter == 'c'){return 2;}
    else if(letter == 'd'){return 3;}
    else if(letter == 'e'){return 4;}
    else if(letter == 'f'){return 5;}
    else if(letter == 'g'){return 6;}
    else if(letter == 'h'){return 7;}
    else if(letter == 'i'){return 8;}
    else if(letter == 'j'){return 9;}
    else if(letter == 'k'){return 10;}
    else if(letter == 'l'){return 11;}
    else if(letter == 'm'){return 12;}
    else if(letter == 'n'){return 13;}
    else if(letter == 'o'){return 14;}
    else if(letter == 'p'){return 15;}
    else if(letter == 'q'){return 16;}
    else if(letter == 'r'){return 17;}
    else if(letter == 's'){return 18;}
    else if(letter == 't'){return 19;}
    else if(letter == 'u'){return 20;}
    else if(letter == 'v'){return 21;}
    else if(letter == 'w'){return 22;}
    else if(letter == 'x'){return 23;}
    else if(letter == 'y'){return 24;}
    else if(letter == 'z'){return 25;}
    return -1;
    }
    
void insert(Trie* root, string key, string value, ofstream& writer){
    //will check if first char of key is child of the root of the trie
    if(root->children[map(key.at(0))] ==0){//default value of children[i] = 0. If not 0 that means key is not a child of root
        //first char will be added to the children of root
        Trie* temp = new Trie;//creating new node with first char being it's data
        temp->data = key.at(0);
        root->children[map(key.at(0))] = temp;
        root->branch_size+=1;
        root->branches.push_back(map(key.at(0)));
        sort(root->branches.begin(), root->branches.end());//branches vector sorted so when we use list nodes will be visited in alphabetical order
        //if at the end of key we add value to the last node else we call the function again for next char
        if(key.length() == 1){
            writer << '"'<< op_word << '"'<<  " was added" << endl;
            temp->value = value;}
        else if(key.length()>1){insert(temp, key.substr(1,key.length()), value,writer);}
    }
    else{//meaning first char is children of root
        if(key.length() == 1){
            if(root->children[map(key.at(0))]->value.empty()){writer << '"'<< op_word << '"'<<  " was added" << endl;}
            else  if(root->children[map(key.at(0))]->value == value){writer << '"'<< op_word << '"'<<  " already exist" << endl;}
            else if(root->children[map(key.at(0))]->value != value){writer << '"'<< op_word << '"'<<  " was updated" << endl;}
            root->children[map(key.at(0))]->value = value;}
        else{insert(root->children[map(key.at(0))], key.substr(1, key.length()),value,writer);}
    }
}

void list(Trie* root,int depth,ofstream& writer){
    //this function takes trie root and depth. Depth is always 0 at initial call
    //if element has multiple children and not the root(meaning data is not empty) 
    if(root->branch_size >1){
        if(root->data !=0){
            for(int i=0; i<depth; i++){writer << "\t";}
            writer << prefix << root->data;
             if(!root->value.empty()){writer << "(" << root->value << ")";}
             writer << endl;
        }
    }
    else if(!root->value.empty()){//if node has a English equivalent for dothraki word, print it
        for(int i=0; i<depth; i++){writer << "\t";}
        writer << prefix << root->data;
        if(!root->value.empty()){writer << "(" << root->value << ")";}
        writer << endl;
    }
    for(int i=0; i<root->branch_size;i++){
        //this loop ads data to the back of the prefix
        //for every loop it travels all the children of that node
        //if a node has multiple children and not the root node, depth will be incremented by 1 else it will stay the same and a recursive call be made
        //after arriving at a children which doesn't have any node, prefix will be popped to go up
        if(root->data !=0){prefix.push_back(root->data);}
        if(root->branch_size < 2|| root->data == 0){list(root->children[root->branches[i]], depth,writer);}
        else if(root->data !=0 && root->branch_size > 1){depth +=1; list(root->children[root->branches[i]], depth,writer);}
        if(root->data !=0 && root->branch_size >1){depth -=1;}
        if(prefix.length() >1&&prefix.back() != '-'){prefix.pop_back();}
    }
}

void search(Trie* node, string key, ofstream& writer){
    if(node->data == 0){//if the node at hand is root node
        if(node->children[map(key.at(0))]==0){//instead of searching branches vector I just look at map value of the char. If children[map(char)] is zero it is not a child of the node.
            writer << '"' << "no record" << '"'<<endl;
            return;
        }
        else{
            search(node->children[map(key.at(0))], key.substr(1,key.length()),writer);
            }
    }
    else if(node->children[map(key.at(0))]!=0){
        if(key.length() ==1){
            if(node->children[map(key.at(0))]->value.empty()){writer <<'"' << "not enough Dothraki word" << '"'<<endl; return;}
            else{writer <<'"' << "The English equivalent is " << node->children[map(key.at(0))]->value << '"'<<endl; return;}
        }
        else{search(node->children[map(key.at(0))], key.substr(1,key.length()),writer);}
    }
    else if(node->children[map(key.at(0))] == 0){
        writer << '"' << "incorrect Dothraki word" << '"'<<endl;
        }
}

void del(Trie* node, string key, ofstream& writer){
    if(node->data == 0){
        if(node->children[map(key.at(0))]==0){
            path.clear();
            writer << '"' << "no record" << '"'<<endl;
            return;
        }
        else{
            del(node->children[map(key.at(0))], key.substr(1,key.length()),writer);
        }
    }
    else if(node->children[map(key.at(0))] == 0){
        path.clear();
        writer << '"' << "incorrect Dothraki word" << '"'<<endl;
    }
    else if(node->children[map(key.at(0))]!=0){
        if(key.length() ==1){
            if(node->children[map(key.at(0))]->value.empty()){path.clear();writer <<'"' << "not enough Dothraki word" << '"'<<endl; return;}
            else if(!node->children[map(key.at(0))]->value.empty()&&node->children[map(key.at(0))]->branch_size >0){
                path.clear();
                writer <<'"'<< op_word << '"' <<" deletion is successful"<<endl;
                node->children[map(key.at(0))]->value.clear();
            }
            else if(node->children[map(key.at(0))]->branch_size ==0){
                Trie* parent =node;
                Trie* child=node->children[map(key.at(0))];
                while(path.size() !=0){
                    if(child->branch_size==0){
                        parent->children[map(child->data)] = 0;//child removed from parents children list
                        for(int i=0;i<parent->branches.size(); i++){//child removed from branch positions list
                            if(parent->branches[i] == map(child->data)){
                                parent->branches.erase(parent->branches.begin()+i); 
                                i=parent->branches.size();//termination
                            }
                        }
                        if(parent->branch_size !=0){parent->branch_size-=1;}//branch size reduced since we removed one
                        if(path.size()!=0){path.pop_back();}
                        child = parent;
                        if(path.size()!=0){parent = path.back();}
                    }
                    else{path.clear();}
                }
             writer << '"' << op_word << '"'<< " deletion is successful" << endl;
            }
        }
        else{
            path.push_back(node);
            del(node->children[map(key.at(0))], key.substr(1,key.length()),writer);}
    }
}

int main(int argc, char **argv)
{   
    Trie* root = new Trie;
    fstream reader{argv[1], ios::in};
    ofstream writer{argv[2], ios::out};
    string line;
    string left;//key
    string right;//value
    while(!reader.eof()){
        getline(reader,line);
        if(line.at(0) == 'i'){
            line = line.substr(7,line.length());//ignored "insert(" 
            line.pop_back();//deleted the parantheses at most right
            for(int i=0; i<line.length(); i++){
                if(line.at(i)== ','){left = line.substr(0,i);right = line.substr(i+1,line.length()); i=line.length();}
                }
            op_word = left;
            insert(root,left,right,writer);
        }
        else if(line.at(0)=='s'){
            line = line.substr(7,line.length());
            line.pop_back();
            search(root,line,writer);
        }
        else if(line.at(0)=='l'){
            list(root,0,writer);
        }
        else if(line.at(0)=='d'){
            line=line.substr(7,line.length());
            line.pop_back();
            op_word = line;
            del(root,line,writer);
        }
    }
    reader.close();
    writer.close();
	return 0;
    
}
