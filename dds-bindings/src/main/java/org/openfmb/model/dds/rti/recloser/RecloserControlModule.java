

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.recloser;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class RecloserControlModule   implements Copyable, Serializable{

    public String logicalDeviceID=  "" ; /* maximum length = (255) */
    public long timestamp= 0;
    public org.openfmb.model.dds.rti.recloser.Recloser recloser = (org.openfmb.model.dds.rti.recloser.Recloser)org.openfmb.model.dds.rti.recloser.Recloser.create();
    public org.openfmb.model.dds.rti.recloser.RecloserControl recloserControl = (org.openfmb.model.dds.rti.recloser.RecloserControl)org.openfmb.model.dds.rti.recloser.RecloserControl.create();

    public RecloserControlModule() {

    }
    public RecloserControlModule (RecloserControlModule other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        RecloserControlModule self;
        self = new  RecloserControlModule();
        self.clear();
        return self;

    }

    public void clear() {

        logicalDeviceID=  ""; 
        timestamp= 0;
        if (recloser != null) {
            recloser.clear();
        }
        if (recloserControl != null) {
            recloserControl.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        RecloserControlModule otherObj = (RecloserControlModule)o;

        if(!logicalDeviceID.equals(otherObj.logicalDeviceID)) {
            return false;
        }
        if(timestamp != otherObj.timestamp) {
            return false;
        }
        if(!recloser.equals(otherObj.recloser)) {
            return false;
        }
        if(!recloserControl.equals(otherObj.recloserControl)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += logicalDeviceID.hashCode(); 
        __result += (int)timestamp;
        __result += recloser.hashCode(); 
        __result += recloserControl.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>RecloserControlModuleTypeSupport</code>
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

        RecloserControlModule typedSrc = (RecloserControlModule) src;
        RecloserControlModule typedDst = this;

        typedDst.logicalDeviceID = typedSrc.logicalDeviceID;
        typedDst.timestamp = typedSrc.timestamp;
        typedDst.recloser = (org.openfmb.model.dds.rti.recloser.Recloser) typedDst.recloser.copy_from(typedSrc.recloser);
        typedDst.recloserControl = (org.openfmb.model.dds.rti.recloser.RecloserControl) typedDst.recloserControl.copy_from(typedSrc.recloserControl);

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
        strBuffer.append("logicalDeviceID: ").append(logicalDeviceID).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("timestamp: ").append(timestamp).append("\n");  
        strBuffer.append(recloser.toString("recloser ", indent+1));
        strBuffer.append(recloserControl.toString("recloserControl ", indent+1));

        return strBuffer.toString();
    }

}
