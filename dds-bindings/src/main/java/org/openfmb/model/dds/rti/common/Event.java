

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

public class Event   implements Copyable, Serializable{

    public String mRID=  "" ; /* maximum length = (255) */
    public String description=  "" ; /* maximum length = (255) */
    public String name=  "" ; /* maximum length = (255) */
    public long timestamp= 0;
    public String type=  "" ; /* maximum length = (255) */
    public String value=  "" ; /* maximum length = (255) */

    public Event() {

    }
    public Event (Event other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        Event self;
        self = new  Event();
        self.clear();
        return self;

    }

    public void clear() {

        mRID=  ""; 
        description=  ""; 
        name=  ""; 
        timestamp= 0;
        type=  ""; 
        value=  ""; 
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        Event otherObj = (Event)o;

        if(!mRID.equals(otherObj.mRID)) {
            return false;
        }
        if(!description.equals(otherObj.description)) {
            return false;
        }
        if(!name.equals(otherObj.name)) {
            return false;
        }
        if(timestamp != otherObj.timestamp) {
            return false;
        }
        if(!type.equals(otherObj.type)) {
            return false;
        }
        if(!value.equals(otherObj.value)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += mRID.hashCode(); 
        __result += description.hashCode(); 
        __result += name.hashCode(); 
        __result += (int)timestamp;
        __result += type.hashCode(); 
        __result += value.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>EventTypeSupport</code>
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

        Event typedSrc = (Event) src;
        Event typedDst = this;

        typedDst.mRID = typedSrc.mRID;
        typedDst.description = typedSrc.description;
        typedDst.name = typedSrc.name;
        typedDst.timestamp = typedSrc.timestamp;
        typedDst.type = typedSrc.type;
        typedDst.value = typedSrc.value;

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
        strBuffer.append("mRID: ").append(mRID).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("description: ").append(description).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("name: ").append(name).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("timestamp: ").append(timestamp).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("type: ").append(type).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("value: ").append(value).append("\n");  

        return strBuffer.toString();
    }

}
