
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.common;

import com.rti.dds.typecode.*;

public class  SetPointTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[4];

        sm[__i]=new  StructMember("controlType", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),0 , false);__i++;
        sm[__i]=new  StructMember("multiplier", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.common.unitmultiplier.UnitMultiplierKindTypeCode.VALUE,1 , false);__i++;
        sm[__i]=new  StructMember("unit", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.common.unitsymbol.UnitSymbolKindTypeCode.VALUE,2 , false);__i++;
        sm[__i]=new  StructMember("value", false, (short)-1,  false,(TypeCode) TypeCode.TC_FLOAT,3 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("common::SetPoint",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);        
        return tc;
    }
}

