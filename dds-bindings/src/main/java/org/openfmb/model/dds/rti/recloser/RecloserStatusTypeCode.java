
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.recloser;

import com.rti.dds.typecode.*;

public class  RecloserStatusTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[5];

        sm[__i]=new  StructMember("isBlocked", false, (short)-1,  false,(TypeCode) TypeCode.TC_BOOLEAN,0 , false);__i++;
        sm[__i]=new  StructMember("switchStatus", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.recloser.SwitchStatusKindTypeCode.VALUE,1 , false);__i++;
        sm[__i]=new  StructMember("timestamp", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.common.DateTimeTypeTypeCode.VALUE,2 , false);__i++;
        sm[__i]=new  StructMember("value", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),3 , false);__i++;
        sm[__i]=new  StructMember("qualityFlag", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.common.HexBinary16TypeTypeCode.VALUE,4 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("recloser::RecloserStatus",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);        
        return tc;
    }
}

