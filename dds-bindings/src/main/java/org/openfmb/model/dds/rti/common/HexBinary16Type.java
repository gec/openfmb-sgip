

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.common;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class HexBinary16Type   implements Copyable, Serializable{

    public byte [] data=  new byte [2];

    public HexBinary16Type() {

    }
    public HexBinary16Type (HexBinary16Type other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        HexBinary16Type self;
        self = new  HexBinary16Type();
        self.clear();
        return self;

    }

    public void clear() {

        for(int i1__ = 0; i1__< 2; ++i1__){

            data[i1__] =  0;
        }

    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        HexBinary16Type otherObj = (HexBinary16Type)o;

        for(int i1__ = 0; i1__< 2; ++i1__){

            if(data[i1__] != otherObj.data[i1__]) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        for(int i1__ = 0; i1__< 2; ++i1__){

            __result += (int)data[i1__];
        }

        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>HexBinary16TypeTypeSupport</code>
    * rather than here by using the <code>-noCopyable</code> option
    * to rtiddsgen.
    * 
    * @param src The Object which contains the data to be copied.
    * @return Returns <code>this</code>.
    * @exception NullPointerException If <code>src</code> is null.
    * @exception ClassCastException If <code>src</code> is not the 
    * same type as <code>this</code>.
    * @see com.rti.dds.infrastructure.Copyable#copy_from(java.lang.Object)
    */
    public Object copy_from(Object src) {

        HexBinary16Type typedSrc = (HexBinary16Type) src;
        HexBinary16Type typedDst = this;

        System.arraycopy(typedSrc.data,0,
        typedDst.data,0,
        typedSrc.data.length); 

        return this;
    }

    public String toString(){
        return toString("", 0);
    }

    public String toString(String desc, int indent) {
        StringBuffer strBuffer = new StringBuffer();        

        if (desc != null) {
            CdrHelper.printIndent(strBuffer, indent);
            strBuffer.append(desc).append(":\n");
        }

        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("data: ");
        for(int i1__ = 0; i1__< 2; ++i1__){

            strBuffer.append(data[i1__]).append(", ");
        }

        strBuffer.append("\n");

        return strBuffer.toString();
    }

}
