package com.spsoft.leetcode.medium.stack;

import java.util.*;

public class L20ValidParentheses {

    public boolean isValid(String s) {
        if(s.length()==1)
            return false;

        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){

            if(c == '(' || c == '{' || c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty())
                    return false;
                char inStack = stack.pop();
                if(c == ')' && inStack != '(')
                    return false;
                if(c == '}' && inStack != '{')
                    return false;
                if(c == ']' && inStack != '[')
                    return false;

            }

        }
        return stack.isEmpty();

    }

}
