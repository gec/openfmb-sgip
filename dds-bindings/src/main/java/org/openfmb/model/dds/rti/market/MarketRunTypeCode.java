
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.market;

import com.rti.dds.typecode.*;

public class  MarketRunTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[6];

        sm[__i]=new  StructMember("executionType", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.market.ExecutionTypeKindTypeCode.VALUE,0 , false);__i++;
        sm[__i]=new  StructMember("marketEndTime", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.common.DateTimeTypeTypeCode.VALUE,1 , false);__i++;
        sm[__i]=new  StructMember("marketID", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),2 , false);__i++;
        sm[__i]=new  StructMember("marketRunID", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),3 , false);__i++;
        sm[__i]=new  StructMember("marketStartTime", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.common.DateTimeTypeTypeCode.VALUE,4 , false);__i++;
        sm[__i]=new  StructMember("marketType", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.market.MarketTypeKindTypeCode.VALUE,5 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("market::MarketRun",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);        
        return tc;
    }
}

