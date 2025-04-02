package com.willdev.collections;

import java.util.LinkedList;
import java.util.List;

public class Lists {

    public void performDemo() {

        List list = new LinkedList();
        list.add(1);
        list.add(10.0);
        list.add("Will");
        list.add(1,"casa");

        Object dato  = list.get(0);
        Integer entero = (Integer) dato;

        System.out.println(entero);


        for (int i =  0;i<list.size();i++)
{
    System.out.println(list.get(i));
}

        for (var element : list){
            System.out.println(element);
        }

        



    }

}
