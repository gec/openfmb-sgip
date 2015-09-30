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
import org.openfmb.model.dds.rti.common.DateTimeInterval;
import org.openfmb.model.dds.rti.common.HexBinary16Type;
import org.openfmb.model.dds.rti.common.Reading;
import org.openfmb.model.dds.rti.common.ReadingType;
import org.openfmb.model.dds.rti.recloser.RecloserReadingModule;
import org.openfmb.model.dds.rti.recloser.RecloserReadingModuleDataWriter;
import com.greenenergycorp.openfmb.mapping.DeviceAdapter;
import com.greenenergycorp.openfmb.mapping.MeasValue;
import com.greenenergycorp.openfmb.mapping.ReadingId;

import java.util.Map;

public class RecloserReadingModuleAdapter implements DeviceAdapter {

    private final RecloserReadingModuleDataWriter writer;

    private final String messageId;

    public RecloserReadingModuleAdapter(RecloserReadingModuleDataWriter writer, String messageId) {
        this.writer = writer;
        this.messageId = messageId;
    }


    public void update(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        final RecloserReadingModule message = mapToStruct(readingValues, keyValues);
        if (message != null) {
            writer.write(message, InstanceHandle_t.HANDLE_NIL);
        }
    }

    public RecloserReadingModule mapToStruct(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        if (readingValues != null && !readingValues.isEmpty()) {

            final RecloserReadingModule module = new RecloserReadingModule();

            final long now = System.currentTimeMillis();

            module.logicalDeviceID = messageId;
            module.timestamp = now;

            for (Map.Entry<ReadingId, MeasValue> entry : readingValues.entrySet()) {

                final HexBinary16Type quality = new HexBinary16Type();
                quality.data[0] = 0;
                quality.data[1] = 0;

                final DateTimeInterval timeInterval = new DateTimeInterval();
                timeInterval.start = now;
                timeInterval.end = now;

                final ReadingType readingType = new ReadingType();

                readingType.unit = entry.getKey().getUnit();
                readingType.multiplier = entry.getKey().getMultiplier();
                readingType.flowDirection = entry.getKey().getFlowDirection();
                readingType.phases = entry.getKey().getPhases();

                final Reading reading = new Reading();
                reading.qualityFlag = quality;
                reading.source = "";
                reading.timePeriod = timeInterval;
                reading.readingType = readingType;

                final Double value = entry.getValue().asDouble();
                if (value != null) {
                    reading.value = value.floatValue();
                    module.readings.userData.add(reading);
                }
            }

            return module;

        } else {
            return null;
        }

    }
}
