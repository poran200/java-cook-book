package com.company.cp3stringthings;

import com.company.cp3stringthings.StringAlign.Justify;

public class StringAlignSimple {
    public static void main(String[] args) {
        StringAlign formatter = new StringAlign(70, Justify. CENTER);
        System.out.println(formatter.format("- i -"));
        System.out.println(formatter.format(Integer.toString(4)));
    }

}
