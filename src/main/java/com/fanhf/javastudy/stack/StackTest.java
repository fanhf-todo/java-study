package com.fanhf.javastudy.stack;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-12-03 09:46
 */
public class StackTest {
    public static void main(String[] args){
      int i =  9 + (3 - 1) * 3 + 10 / 2;
      /**
       * 计算过程：
       * 1、9 3 1 入栈时，遇到第一个减号，将3，1和减号出栈，调用执行引擎执行3-1得到2，将2入栈
       * 遇到 * 号，将2和3出栈，调用执行引擎执行2*3=6，将6入栈
       * 此时，栈中从下至上，是 9 6
       * 遇到第一个+号，9和6出栈，调用执行引擎执行9+6，得到15，将15入栈
       * 此时，栈中从下至上，是 15
       * 将10 2 入栈，遇到除号 / ，10和2出栈，调用执行引擎执行10/2，得到5，将5入栈
       * 此时，栈中从下至上，是 15 5
       * 遇到第二个+号，将15 5 出栈，调用执行引擎执行15+5 ，得到20，将20入栈
       *
       **/

        System.out.println(i);
    }
}   
