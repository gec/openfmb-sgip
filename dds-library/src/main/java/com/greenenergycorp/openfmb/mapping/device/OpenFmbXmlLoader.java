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

import com.greenenergycorp.openfmb.dds.mapping.xml.*;
import com.rti.dds.subscription.DataReader;
import org.openfmb.model.dds.rti.recloser.Recloser;
import org.openfmb.model.dds.rti.recloser.RecloserEventModuleDataWriter;
import org.openfmb.model.dds.rti.recloser.RecloserReadingModuleDataWriter;
import com.greenenergycorp.openfmb.mapping.ControlAdapter;
import com.greenenergycorp.openfmb.mapping.ControlMapping;
import com.greenenergycorp.openfmb.mapping.DeviceAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenFmbXmlLoader {

    public static Map<String, DeviceAdapter> loadPublishers(final PublishersType xml, final OpenFmbDeviceFactory factory) throws IOException {

        final HashMap<String, DeviceAdapter> map = new HashMap<String, DeviceAdapter>();

        if (xml.getElements() != null) {
            for (Object elem: xml.getElements()) {

                if (elem instanceof RecloserEventModule) {
                    final RecloserEventModule entry = (RecloserEventModule)elem;
                    final String name = "RecloserEventModule";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    if (entry.getMRID() == null) {
                        throw new IllegalArgumentException(name + " must have mRID");
                    }
                    if (entry.getName() == null) {
                        throw new IllegalArgumentException(name + " must have name");
                    }
                    if (entry.getDescription() == null) {
                        throw new IllegalArgumentException(name + " must have description");
                    }
                    if (entry.getNormalOpen() == null) {
                        throw new IllegalArgumentException(name + " must have normalOpen");
                    }

                    final Recloser recloser = new Recloser();
                    recloser.mRID = entry.getMRID();
                    recloser.name = entry.getName();
                    recloser.description = entry.getDescription();
                    recloser.normalOpen = entry.getNormalOpen();

                    final RecloserEventModuleDataWriter writer = factory.getRecloserEventModuleWriter();

                    final RecloserEventModuleAdapter recloserEventModuleAdapter =
                            new RecloserEventModuleAdapter(writer, entry.getLogicalDeviceId(), recloser);

                    map.put(entry.getAdapterName(), recloserEventModuleAdapter);

                } else if (elem instanceof RecloserReadingModule) {
                    final RecloserReadingModule entry = (RecloserReadingModule) elem;
                    final String name = "RecloserReadingModule";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }

                    final RecloserReadingModuleDataWriter writer = factory.getRecloserReadModuleWriter();

                    final RecloserReadingModuleAdapter recloserReadingModuleAdapter =
                            new RecloserReadingModuleAdapter(writer, entry.getLogicalDeviceId());

                    map.put(entry.getAdapterName(), recloserReadingModuleAdapter);

                }

            }
        }

        return map;
    }

    public static List<ControlAdapter> loadSubscribers(final SubscribersType xml, final OpenFmbDeviceFactory factory, final ControlMapping controlMapping) throws IOException {
        final List<ControlAdapter> list = new ArrayList<ControlAdapter>();

        if (xml.getElements() != null) {
            for (Object elem: xml.getElements()) {

                if (elem instanceof RecloserControlModule) {
                    final RecloserControlModule entry = (RecloserControlModule) elem;
                    final String name = "RecloserControlModule";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }

                    final DataReader reader = factory.getRecloserControlModuleReader();

                    final RecloserControlAdapter adapter = RecloserControlAdapter.build(reader, entry.getAdapterName(), controlMapping);
                    list.add(adapter);
                }
            }
        }

        return list;
    }
}
