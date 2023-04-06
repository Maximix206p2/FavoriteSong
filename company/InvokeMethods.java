package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeMethods {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        System.setSecurityManager(new SecurityManager());

        Calc calc = new Calc();
        //public
        Method sum = Calc.class.getMethod("sum", int.class, double.class);
        double resSum = (double) sum.invoke(calc, 1,3.);
        System.out.println(resSum);

        //public static
        Method mult = Calc.class.getMethod("mult", float.class, long.class);
        System.out.println(mult.invoke(null, 2,2));

        //private
        Method and = Calc.class.getDeclaredMethod("and", boolean.class, boolean.class);
        System.out.println(and.canAccess(calc));
        and.setAccessible(true);
        System.out.println(and.invoke(calc, true,true));

        //protected int
        Method max = Calc.class.getDeclaredMethod("max", int.class, int.class);
        System.out.println(max.invoke(calc, 5,3));

    }
}