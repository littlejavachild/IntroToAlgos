// SOURCE: http://www.c4learn.com/data-structure/c-program-convert-infix-expression-to-postfix-using-stack/
// http://www.cs.man.ac.uk/~pjj/cs212/fix.html
boolean isAlphaNumeric(char token){
    if(Character.isLetter(token)) return true
    if(Character.isDigit(token)) return true
    return false
}
//------------------------------------------------------------------------------
int getPriority(char token){
    if(token == '(') 
        return 0
    if(token == '+' || token == '-')
        return 1
    if(token == '*' || token == '/' || token == '%')
        return 2
    return 3 
}
//------------------------------------------------------------------------------
// EXAMPLES
// Infix: A*B+C/D     Postfix: AB*CD/+
// Infix: A*(B+C)/D   Postfix: ABC+*D/
// Infix: A*(B+C/D)   Postfix: ABCD/+*
final def infix = "A*(B+C/D)"
final def stack = []
int i = 0
char x
//------------------------------------------------------------------------------
while(i < infix.size()){
    char token = infix[i++] // read a character from input
    if(isAlphaNumeric(token)){
        print token
    }else if(token == '('){
        stack.push(token)
    }else if(token == ')'){
        while((x=stack.pop())!='('){
            print x
        }
    }else{
        while(!stack.isEmpty() && (getPriority(token)<=getPriority(stack[stack.size()-1]))){
            x = stack.pop()
            printf "$x"
        }
        stack.push(token)
    }
}

while(!stack.isEmpty()){
    printf "${stack.pop()}"
}
//------------------------------------------------------------------------------