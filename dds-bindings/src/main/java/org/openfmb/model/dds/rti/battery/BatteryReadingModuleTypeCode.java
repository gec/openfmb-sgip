
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.battery;

import com.rti.dds.typecode.*;

public class  BatteryReadingModuleTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[5];

        sm[__i]=new  StructMember("logicalDeviceID", false, (short)-1, true,(TypeCode) new TypeCode(TCKind.TK_STRING,255),0 , false);__i++;
        sm[__i]=new  StructMember("timestamp", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.common.DateTimeTypeTypeCode.VALUE,1 , false);__i++;
        sm[__i]=new  StructMember("batteryStatus", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.battery.BatteryStatusTypeCode.VALUE,2 , false);__i++;
        sm[__i]=new  StructMember("batterySystem", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.battery.BatterySystemTypeCode.VALUE,3 , false);__i++;
        sm[__i]=new  StructMember("readings", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.battery.SequenceOfBatteryReadingsTypeCode.VALUE,4 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("battery::BatteryReadingModule",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);        
        return tc;
    }
}

