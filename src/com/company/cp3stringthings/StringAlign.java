package com.company.cp3stringthings;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class StringAlign extends Format {

    private static final  long serialVersionUID = 1L;

     public enum  Justify{
        LEFT,
        RIGHT,
        CENTER
    }

    private  Justify just;
    private  int maxChars;

    public StringAlign( int maxChars,Justify just) {
        switch (just){
            case LEFT:
            case CENTER:
            case RIGHT:
                this.just = just;
                 break;
            default:
                throw  new IllegalArgumentException("invalid Justification  arg");
        }
        if (maxChars < 0)
            throw  new IllegalArgumentException(" maxChars must be positive");
         else
           this.maxChars = maxChars;
    }

    @Override
    public StringBuffer format(Object input, StringBuffer where, FieldPosition pos) {
        String  s =  input.toString();
        String wanted = s.substring(0,Math.min(s.length(), maxChars));
        switch (just){
            case RIGHT:
                pad(where, maxChars - wanted.length());
                where.append(wanted);
                break;
            case CENTER:
                int toAdd = maxChars - wanted.length();
                pad(where, toAdd/2);
                where.append(wanted);
                pad(where,toAdd- toAdd/2);
                break;
            case LEFT:
                where.append(wanted);
                pad(where, maxChars- wanted.length());
                break;
        }
        return where;
    }
    public  String  format(String s){
        return   format(s, new StringBuffer(),null).toString();
    }

    private void pad(StringBuffer to, int howMany) {
        to.append("*".repeat(Math.max(0, howMany)));
    }

    @Override
    public Object parseObject(String source, ParsePosition pos) {
        return source;
    }
}
