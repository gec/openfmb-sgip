

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.solar;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class SolarReadingModule   implements Copyable, Serializable{

    public String logicalDeviceID=  "" ; /* maximum length = (255) */
    public long timestamp= 0;
    public org.openfmb.model.dds.rti.solar.SequenceOfSolarReadings readings = (org.openfmb.model.dds.rti.solar.SequenceOfSolarReadings)org.openfmb.model.dds.rti.solar.SequenceOfSolarReadings.create();
    public org.openfmb.model.dds.rti.solar.SolarInverter solarInverter = (org.openfmb.model.dds.rti.solar.SolarInverter)org.openfmb.model.dds.rti.solar.SolarInverter.create();
    public org.openfmb.model.dds.rti.solar.SolarInverterStatus solarInverterStatus = (org.openfmb.model.dds.rti.solar.SolarInverterStatus)org.openfmb.model.dds.rti.solar.SolarInverterStatus.create();

    public SolarReadingModule() {

    }
    public SolarReadingModule (SolarReadingModule other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        SolarReadingModule self;
        self = new  SolarReadingModule();
        self.clear();
        return self;

    }

    public void clear() {

        logicalDeviceID=  ""; 
        timestamp= 0;
        if (readings != null) {
            readings.clear();
        }
        if (solarInverter != null) {
            solarInverter.clear();
        }
        if (solarInverterStatus != null) {
            solarInverterStatus.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        SolarReadingModule otherObj = (SolarReadingModule)o;

        if(!logicalDeviceID.equals(otherObj.logicalDeviceID)) {
            return false;
        }
        if(timestamp != otherObj.timestamp) {
            return false;
        }
        if(!readings.equals(otherObj.readings)) {
            return false;
        }
        if(!solarInverter.equals(otherObj.solarInverter)) {
            return false;
        }
        if(!solarInverterStatus.equals(otherObj.solarInverterStatus)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += logicalDeviceID.hashCode(); 
        __result += (int)timestamp;
        __result += readings.hashCode(); 
        __result += solarInverter.hashCode(); 
        __result += solarInverterStatus.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>SolarReadingModuleTypeSupport</code>
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

        SolarReadingModule typedSrc = (SolarReadingModule) src;
        SolarReadingModule typedDst = this;

        typedDst.logicalDeviceID = typedSrc.logicalDeviceID;
        typedDst.timestamp = typedSrc.timestamp;
        typedDst.readings = (org.openfmb.model.dds.rti.solar.SequenceOfSolarReadings) typedDst.readings.copy_from(typedSrc.readings);
        typedDst.solarInverter = (org.openfmb.model.dds.rti.solar.SolarInverter) typedDst.solarInverter.copy_from(typedSrc.solarInverter);
        typedDst.solarInverterStatus = (org.openfmb.model.dds.rti.solar.SolarInverterStatus) typedDst.solarInverterStatus.copy_from(typedSrc.solarInverterStatus);

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
        strBuffer.append(readings.toString("readings ", indent+1));
        strBuffer.append(solarInverter.toString("solarInverter ", indent+1));
        strBuffer.append(solarInverterStatus.toString("solarInverterStatus ", indent+1));

        return strBuffer.toString();
    }

}
