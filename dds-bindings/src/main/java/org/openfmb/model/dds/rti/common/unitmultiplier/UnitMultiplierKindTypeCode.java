
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.common.unitmultiplier;

import com.rti.dds.typecode.*;

public class  UnitMultiplierKindTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int i=0;
        EnumMember em[] = new EnumMember[11];

        int[] ordinals = UnitMultiplierKind.getOrdinals();
        for (i=0;i<11;i++) {
            em[i]=new EnumMember(UnitMultiplierKind.valueOf(ordinals[i]).toString(),ordinals[i]);
        }

        tc = TypeCodeFactory.TheTypeCodeFactory.create_enum_tc("common::unitmultiplier::UnitMultiplierKind",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  em);        
        return tc;
    }
}

