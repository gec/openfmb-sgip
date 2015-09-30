/**
 * Copyright 2015 Green Energy Corp.
 *
 * Licensed to Green Energy Corp (www.greenenergycorp.com) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. Green Energy
 * Corp licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.greenenergycorp.openfmb.mapping.device;

import com.rti.dds.infrastructure.InstanceHandle_t;
import org.openfmb.model.dds.rti.common.HexBinary16Type;
import org.openfmb.model.dds.rti.recloser.*;
import com.greenenergycorp.openfmb.mapping.DeviceAdapter;
import com.greenenergycorp.openfmb.mapping.MeasValue;
import com.greenenergycorp.openfmb.mapping.ReadingId;

import java.util.Map;

public class RecloserEventModuleAdapter implements DeviceAdapter {

    private final RecloserEventModuleDataWriter writer;

    private final String logicalDeviceId;
    private final Recloser deviceDescription;

    public final static String isBlockedKey = "isBlocked";
    public final static String switchStatusKey = "SwitchStatus";

    public final static String[] keys = { isBlockedKey, switchStatusKey };

    public RecloserEventModuleAdapter(RecloserEventModuleDataWriter writer, String logicalDeviceId, Recloser deviceDescription) {
        this.writer = writer;
        this.logicalDeviceId = logicalDeviceId;
        this.deviceDescription = deviceDescription;
    }

    public void update(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        final RecloserEventModule message = mapToStruct(readingValues, keyValues);
        if (message != null) {
            writer.write(message, InstanceHandle_t.HANDLE_NIL);
        }
    }


    public RecloserEventModule mapToStruct(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        for (String key: keys) {
            if (!keyValues.containsKey(key)) {
                return null;
            }
        }

        Boolean isBlocked = keyValues.get(isBlockedKey).asBoolean();
        if (isBlocked == null) {
            return null;
        }

        final Long switchStatusInt = keyValues.get(switchStatusKey).asLong();
        if (switchStatusInt == null) {
            return null;
        }
        final SwitchStatusKind statusEnum = SwitchStatusKind.valueOf(switchStatusInt.intValue());
        if (statusEnum == null) {
            return null;
        }

        final RecloserEventModule recloserEventModule = new RecloserEventModule();

        final long now = System.currentTimeMillis();

        recloserEventModule.logicalDeviceID = logicalDeviceId;
        recloserEventModule.timestamp = now;

        recloserEventModule.recloser = deviceDescription;

        final RecloserStatus recloserStatus = new RecloserStatus();

        recloserStatus.isBlocked = isBlocked;
        recloserStatus.switchStatus = statusEnum;

        recloserStatus.timestamp = now;
        recloserStatus.value = "";

        final HexBinary16Type quality = new HexBinary16Type();
        quality.data[0] = 0;
        quality.data[1] = 0;

        recloserStatus.qualityFlag = quality;

        recloserEventModule.recloserStatus = recloserStatus;

        return recloserEventModule;
    }

}
