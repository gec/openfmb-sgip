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

import com.rti.dds.subscription.DataReader;
import com.greenenergycorp.openfmb.dds.ReadResult;
import com.greenenergycorp.openfmb.dds.SubscriptionHandler;
import com.greenenergycorp.openfmb.dds.TypedTopicSubscription;
import org.openfmb.model.dds.rti.common.SetPoint;
import org.openfmb.model.dds.rti.recloser.RecloserControlModule;
import com.greenenergycorp.openfmb.dds.handle.RecloserControlModuleHandle;
import com.greenenergycorp.openfmb.mapping.Control;
import com.greenenergycorp.openfmb.mapping.ControlAdapter;
import com.greenenergycorp.openfmb.mapping.ControlHandler;
import com.greenenergycorp.openfmb.mapping.ControlMapping;

import java.io.IOException;
import java.util.List;

public class RecloserControlAdapter implements ControlAdapter {
    private final TypedTopicSubscription<RecloserControlModule> subscription;
    private final String adapterName;
    private final ControlMapping handlerMap;

    public RecloserControlAdapter(TypedTopicSubscription<RecloserControlModule> subscription, String adapterName, ControlMapping handlerMap) {
        this.subscription = subscription;
        this.adapterName = adapterName;
        this.handlerMap = handlerMap;
    }

    public static RecloserControlAdapter build(final DataReader reader, final String adapterName, final ControlMapping handlerMap) {
        final TypedTopicSubscription<RecloserControlModule> subscription =
                new TypedTopicSubscription<RecloserControlModule>(reader, new RecloserControlModuleHandle());

        return new RecloserControlAdapter(subscription, adapterName, handlerMap);
    }

    public void start() throws IOException {

        subscription.subscribe(new SubscriptionHandler<RecloserControlModule>() {
            public void handle(ReadResult<RecloserControlModule> readResult) {

                for (RecloserControlModule v : readResult.getResults()) {

                    if (!v.recloserControl.endDeviceControlType.action.equals("")) {

                        final Control.EndDeviceControl endDeviceControl =
                                new Control.EndDeviceControl(
                                        adapterName,
                                        v.recloserControl.endDeviceControlType.action,
                                        v.recloserControl.endDeviceControlType.type);

                        final List<ControlHandler> controlHandlers = handlerMap.getDeviceControlMap().get(endDeviceControl);
                        if (controlHandlers != null) {
                            for (ControlHandler handler : controlHandlers) {
                                handler.handle(endDeviceControl);
                            }
                        }

                    }

                    for (Object obj : v.recloserControl.setPoints.userData) {
                        SetPoint sp = (SetPoint) obj;

                        final Control.SetpointId setpointId = new Control.SetpointId(adapterName, sp.controlType, sp.unit, sp.multiplier);

                        final Control.SetpointControl setpointControl = new Control.SetpointControl(setpointId, sp.value);

                        final List<ControlHandler> controlHandlers = handlerMap.getSetpointControlMap().get(setpointId);
                        if (controlHandlers != null) {
                            for (ControlHandler handler : controlHandlers) {
                                handler.handle(setpointControl);
                            }
                        }
                    }
                }
            }
        });
    }

}
