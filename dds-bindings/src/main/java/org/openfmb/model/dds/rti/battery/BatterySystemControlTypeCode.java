
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.battery;

import com.rti.dds.typecode.*;

public class  BatterySystemControlTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[6];

        sm[__i]=new  StructMember("isIslanded", false, (short)-1,  false,(TypeCode) TypeCode.TC_BOOLEAN,0 , false);__i++;
        sm[__i]=new  StructMember("issueID", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),1 , false);__i++;
        sm[__i]=new  StructMember("name", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),2 , false);__i++;
        sm[__i]=new  StructMember("EndDeviceControlType", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.common.EndDeviceControlTypeTypeCode.VALUE,3 , false);__i++;
        sm[__i]=new  StructMember("scheduledInterval", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.common.DateTimeIntervalTypeCode.VALUE,4 , false);__i++;
        sm[__i]=new  StructMember("setPoints", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.battery.SequenceOfBatterySystemControlSetPointsTypeCode.VALUE,5 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("battery::BatterySystemControl",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);        
        return tc;
    }
}

