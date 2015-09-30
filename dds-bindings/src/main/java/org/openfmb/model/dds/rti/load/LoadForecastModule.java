

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.load;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class LoadForecastModule   implements Copyable, Serializable{

    public String logicalDeviceID=  "" ; /* maximum length = (255) */
    public long timestamp= 0;
    public org.openfmb.model.dds.rti.load.EnergyConsumer energyConsumer = (org.openfmb.model.dds.rti.load.EnergyConsumer)org.openfmb.model.dds.rti.load.EnergyConsumer.create();
    public org.openfmb.model.dds.rti.common.ForecastSchedule forecastSchedule = (org.openfmb.model.dds.rti.common.ForecastSchedule)org.openfmb.model.dds.rti.common.ForecastSchedule.create();

    public LoadForecastModule() {

    }
    public LoadForecastModule (LoadForecastModule other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        LoadForecastModule self;
        self = new  LoadForecastModule();
        self.clear();
        return self;

    }

    public void clear() {

        logicalDeviceID=  ""; 
        timestamp= 0;
        if (energyConsumer != null) {
            energyConsumer.clear();
        }
        if (forecastSchedule != null) {
            forecastSchedule.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        LoadForecastModule otherObj = (LoadForecastModule)o;

        if(!logicalDeviceID.equals(otherObj.logicalDeviceID)) {
            return false;
        }
        if(timestamp != otherObj.timestamp) {
            return false;
        }
        if(!energyConsumer.equals(otherObj.energyConsumer)) {
            return false;
        }
        if(!forecastSchedule.equals(otherObj.forecastSchedule)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += logicalDeviceID.hashCode(); 
        __result += (int)timestamp;
        __result += energyConsumer.hashCode(); 
        __result += forecastSchedule.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>LoadForecastModuleTypeSupport</code>
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

        LoadForecastModule typedSrc = (LoadForecastModule) src;
        LoadForecastModule typedDst = this;

        typedDst.logicalDeviceID = typedSrc.logicalDeviceID;
        typedDst.timestamp = typedSrc.timestamp;
        typedDst.energyConsumer = (org.openfmb.model.dds.rti.load.EnergyConsumer) typedDst.energyConsumer.copy_from(typedSrc.energyConsumer);
        typedDst.forecastSchedule = (org.openfmb.model.dds.rti.common.ForecastSchedule) typedDst.forecastSchedule.copy_from(typedSrc.forecastSchedule);

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
        strBuffer.append(energyConsumer.toString("energyConsumer ", indent+1));
        strBuffer.append(forecastSchedule.toString("forecastSchedule ", indent+1));

        return strBuffer.toString();
    }

}
