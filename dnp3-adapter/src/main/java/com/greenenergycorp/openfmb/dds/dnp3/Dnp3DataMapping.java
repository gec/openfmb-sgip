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
package com.greenenergycorp.openfmb.dds.dnp3;

import com.greenenergycorp.openfmb.mapping.DeviceKeyId;
import com.greenenergycorp.openfmb.mapping.DeviceReadingId;

import java.util.Map;

public class Dnp3DataMapping {
    private final Map<Long, DeviceKeyId> statusKeyMap;
    private final Map<Long, DeviceKeyId> analogKeyMap;
    private final Map<Long, DeviceKeyId> counterKeyMap;
    private final Map<Long, DeviceKeyId> controlStatusKeyMap;
    private final Map<Long, DeviceKeyId> setpointStatusKeyMap;
    
    private final Map<Long, DeviceReadingId> statusReadingMap;
    private final Map<Long, DeviceReadingId> analogReadingMap;
    private final Map<Long, DeviceReadingId> counterReadingMap;
    private final Map<Long, DeviceReadingId> controlStatusReadingMap;
    private final Map<Long, DeviceReadingId> setpointStatusReadingMap;

    public Dnp3DataMapping(Map<Long, DeviceKeyId> statusKeyMap, Map<Long, DeviceKeyId> analogKeyMap, Map<Long, DeviceKeyId> counterKeyMap, Map<Long, DeviceKeyId> controlStatusKeyMap, Map<Long, DeviceKeyId> setpointStatusKeyMap, Map<Long, DeviceReadingId> statusReadingMap, Map<Long, DeviceReadingId> analogReadingMap, Map<Long, DeviceReadingId> counterReadingMap, Map<Long, DeviceReadingId> controlStatusReadingMap, Map<Long, DeviceReadingId> setpointStatusReadingMap) {
        this.statusKeyMap = statusKeyMap;
        this.analogKeyMap = analogKeyMap;
        this.counterKeyMap = counterKeyMap;
        this.controlStatusKeyMap = controlStatusKeyMap;
        this.setpointStatusKeyMap = setpointStatusKeyMap;
        this.statusReadingMap = statusReadingMap;
        this.analogReadingMap = analogReadingMap;
        this.counterReadingMap = counterReadingMap;
        this.controlStatusReadingMap = controlStatusReadingMap;
        this.setpointStatusReadingMap = setpointStatusReadingMap;
    }

    public Map<Long, DeviceKeyId> getStatusKeyMap() {
        return statusKeyMap;
    }

    public Map<Long, DeviceKeyId> getAnalogKeyMap() {
        return analogKeyMap;
    }

    public Map<Long, DeviceKeyId> getCounterKeyMap() {
        return counterKeyMap;
    }

    public Map<Long, DeviceKeyId> getControlStatusKeyMap() {
        return controlStatusKeyMap;
    }

    public Map<Long, DeviceKeyId> getSetpointStatusKeyMap() {
        return setpointStatusKeyMap;
    }

    public Map<Long, DeviceReadingId> getStatusReadingMap() {
        return statusReadingMap;
    }

    public Map<Long, DeviceReadingId> getAnalogReadingMap() {
        return analogReadingMap;
    }

    public Map<Long, DeviceReadingId> getCounterReadingMap() {
        return counterReadingMap;
    }

    public Map<Long, DeviceReadingId> getControlStatusReadingMap() {
        return controlStatusReadingMap;
    }

    public Map<Long, DeviceReadingId> getSetpointStatusReadingMap() {
        return setpointStatusReadingMap;
    }
}
