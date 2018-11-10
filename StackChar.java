package com.example.user.mycalculator;
import java.io.*;
import java.util.*;
public class StackChar {
        char a[]=new char[100];
        public int top=-1;
        public void push(char data)
        {
            if(top<99)
            {
                top++;
                a[top]=data;
            }
            else
            {
                System.out.println("Stack is ful");
            }
        }
        public char pop()
        {
            char ch=1;
            if(top!=-1)
            {
                ch=a[top];
                top--;
            }
            return ch;
        }
    }
