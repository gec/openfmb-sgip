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

import org.openfmb.model.dds.rti.common.flowdirection.FlowDirectionKind;
import org.openfmb.model.dds.rti.common.phasecode.PhaseCodeKind;
import org.openfmb.model.dds.rti.common.unitmultiplier.UnitMultiplierKind;
import org.openfmb.model.dds.rti.common.unitsymbol.UnitSymbolKind;
import com.greenenergycorp.openfmb.dds.mapping.xml.*;
import com.greenenergycorp.openfmb.mapping.DeviceKeyId;
import com.greenenergycorp.openfmb.mapping.DeviceReadingId;
import com.greenenergycorp.openfmb.mapping.ReadingId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataMappingReader {

    public static Dnp3DataMapping load(IndexMapping xml) {

        final Map<Long, DeviceKeyId> binaryKeyMap = new HashMap<Long, DeviceKeyId>();
        final Map<Long, DeviceKeyId> analogKeyMap = new HashMap<Long, DeviceKeyId>();
        final Map<Long, DeviceKeyId> counterKeyMap = new HashMap<Long, DeviceKeyId>();
        final Map<Long, DeviceKeyId> controlStatusKeyMap = new HashMap<Long, DeviceKeyId>();
        final Map<Long, DeviceKeyId> setpointKeyMap = new HashMap<Long, DeviceKeyId>();

        final Map<Long, DeviceReadingId> binaryReadingMap = new HashMap<Long, DeviceReadingId>();
        final Map<Long, DeviceReadingId> analogReadingMap = new HashMap<Long, DeviceReadingId>();
        final Map<Long, DeviceReadingId> counterReadingMap = new HashMap<Long, DeviceReadingId>();
        final Map<Long, DeviceReadingId> controlStatusReadingMap = new HashMap<Long, DeviceReadingId>();
        final Map<Long, DeviceReadingId> setpointReadingMap = new HashMap<Long, DeviceReadingId>();

        if (xml.getBinaries() != null && xml.getBinaries().getMapping() != null) {
            loadMappings(binaryKeyMap, binaryReadingMap, xml.getBinaries().getMapping());
        }

        if (xml.getAnalogs() != null && xml.getAnalogs().getMapping() != null) {
            loadMappings(analogKeyMap, analogReadingMap, xml.getAnalogs().getMapping());
        }

        if (xml.getCounters() != null && xml.getCounters().getMapping() != null) {
            loadMappings(counterKeyMap, counterReadingMap, xml.getCounters().getMapping());
        }

        if (xml.getControlStatuses() != null && xml.getControlStatuses().getMapping() != null) {
            loadMappings(controlStatusKeyMap, controlStatusReadingMap, xml.getControlStatuses().getMapping());
        }

        if (xml.getSetpointStatuses() != null && xml.getSetpointStatuses().getMapping() != null) {
            loadMappings(setpointKeyMap, setpointReadingMap, xml.getSetpointStatuses().getMapping());
        }

        return new Dnp3DataMapping(binaryKeyMap, analogKeyMap, counterKeyMap, controlStatusKeyMap, setpointKeyMap,
                binaryReadingMap, analogReadingMap, counterReadingMap, controlStatusReadingMap, setpointReadingMap);
    }

    private static void loadMappings(Map<Long, DeviceKeyId> keyMap, Map<Long, DeviceReadingId> readMap, List<MappingSeq.Mapping> xmlList) {
        for (MappingSeq.Mapping mapping : xmlList) {
            if (mapping.getAdapterName() != null && mapping.getIndex() != null) {
                if (mapping.getKey() != null) {
                    keyMap.put(mapping.getIndex(), new DeviceKeyId(mapping.getAdapterName(), mapping.getKey()));
                } else {
                    final UnitSymbol unitXml = mapping.getUnit();
                    if (unitXml == null) {
                        throw new IllegalArgumentException("Mapping must have key or all of unit, multiplier, flowDirection, and phases");
                    }
                    final UnitSymbolKind unit = convertFromXml(unitXml);
                    if (unit == null) {
                        throw new IllegalArgumentException("Unit mapping " + unitXml + " did not match DDS enum");
                    }

                    final UnitMultiplier multiplierXml = mapping.getMultiplier();
                    if (multiplierXml == null) {
                        throw new IllegalArgumentException("Mapping must have key or all of unit, multiplier, flowDirection, and phases");
                    }
                    final UnitMultiplierKind multiplier = convertFromXml(multiplierXml);
                    if (multiplier == null) {
                        throw new IllegalArgumentException("Unit multiplier mapping " + multiplierXml + " did not match DDS enum");
                    }

                    final com.greenenergycorp.openfmb.dds.mapping.xml.FlowDirection flowDirectionXml = mapping.getFlowDirection();
                    if (flowDirectionXml == null) {
                        throw new IllegalArgumentException("Mapping must have key or all of unit, multiplier, flowDirection, and phases");
                    }
                    final FlowDirectionKind flowDirection = convertFromXml(flowDirectionXml);
                    if (flowDirection == null) {
                        throw new IllegalArgumentException("Flow direction mapping " + flowDirectionXml + " did not match DDS enum");
                    }

                    final PhaseCode phasesXml = mapping.getPhases();
                    if (phasesXml == null) {
                        throw new IllegalArgumentException("Mapping must have key or all of unit, multiplier, flowDirection, and phases");
                    }
                    final PhaseCodeKind phases = convertFromXml(phasesXml);
                    if (phases == null) {
                        throw new IllegalArgumentException("Phase code mapping " + flowDirectionXml + " did not match DDS enum");
                    }

                    final ReadingId readingId = new ReadingId(unit, multiplier, flowDirection, phases, "");

                    readMap.put(mapping.getIndex(), new DeviceReadingId(mapping.getAdapterName(), readingId));
                }
            }
        }
    }

    public static UnitSymbolKind convertFromXml(UnitSymbol xml) {

        if (xml == UnitSymbol.AMP) {
            return UnitSymbolKind.Amp;
        } else if (xml == UnitSymbol.DEG) {
            return UnitSymbolKind.deg;
        } else if (xml == UnitSymbol.DEG_C) {
            return UnitSymbolKind.degC;
        } else if (xml == UnitSymbol.FARAD) {
            return UnitSymbolKind.Farad;
        } else if (xml == UnitSymbol.GRAM) {
            return UnitSymbolKind.gram;
        } else if (xml == UnitSymbol.HOUR) {
            return UnitSymbolKind.hour;
        } else if (xml == UnitSymbol.HENRY) {
            return UnitSymbolKind.Henry;
        } else if (xml == UnitSymbol.HZ) {
            return UnitSymbolKind.Hz;
        } else if (xml == UnitSymbol.JOULE) {
            return UnitSymbolKind.Joule;
        } else if (xml == UnitSymbol.METER) {
            return UnitSymbolKind.meter;
        } else if (xml == UnitSymbol.M_2) {
            return UnitSymbolKind.m2;
        } else if (xml == UnitSymbol.M_3) {
            return UnitSymbolKind.m3;
        } else if (xml == UnitSymbol.MIN) {
            return UnitSymbolKind.min;
        } else if (xml == UnitSymbol.NEWTON) {
            return UnitSymbolKind.Newton;
        } else if (xml == UnitSymbol.NONE) {
            return UnitSymbolKind.none;
        } else if (xml == UnitSymbol.OHM) {
            return UnitSymbolKind.ohm;
        } else if (xml == UnitSymbol.PA) {
            return UnitSymbolKind.Pa;
        } else if (xml == UnitSymbol.RAD) {
            return UnitSymbolKind.rad;
        } else if (xml == UnitSymbol.SIEMENS) {
            return UnitSymbolKind.Siemens;
        } else if (xml == UnitSymbol.SEC) {
            return UnitSymbolKind.sec;
        } else if (xml == UnitSymbol.V) {
            return UnitSymbolKind.V;
        } else if (xml == UnitSymbol.VA) {
            return UnitSymbolKind.VA;
        } else if (xml == UnitSymbol.V_AH) {
            return UnitSymbolKind.VAh;
        } else if (xml == UnitSymbol.V_AR) {
            return UnitSymbolKind.VAr;
        } else if (xml == UnitSymbol.V_ARH) {
            return UnitSymbolKind.VArh;
        } else if (xml == UnitSymbol.W) {
            return UnitSymbolKind.W;
        } else if (xml == UnitSymbol.WH) {
            return UnitSymbolKind.Wh;
        } else if (xml == UnitSymbol.W_PER_VA) {
            return UnitSymbolKind.wPerVA;
        } else {
            return null;
        }
    }

    public static UnitMultiplierKind convertFromXml(UnitMultiplier xml) {

        if (xml == UnitMultiplier.CENTI) {
            return UnitMultiplierKind.centi;
        } else if (xml == UnitMultiplier.DECI) {
            return UnitMultiplierKind.deci;
        } else if (xml == UnitMultiplier.GIGA) {
            return UnitMultiplierKind.Giga;
        } else if (xml == UnitMultiplier.KILO) {
            return UnitMultiplierKind.kilo;
        } else if (xml == UnitMultiplier.MEGA) {
            return UnitMultiplierKind.Mega;
        } else if (xml == UnitMultiplier.MILLI) {
            return UnitMultiplierKind.milli;
        } else if (xml == UnitMultiplier.MICRO) {
            return UnitMultiplierKind.micro;
        } else if (xml == UnitMultiplier.NANO) {
            return UnitMultiplierKind.nano;
        } else if (xml == UnitMultiplier.NONE) {
            return UnitMultiplierKind.none;
        } else if (xml == UnitMultiplier.PICO) {
            return UnitMultiplierKind.pico;
        } else if (xml == UnitMultiplier.TERA) {
            return UnitMultiplierKind.Tera;
        } else {
            return null;
        }
    }

    public static FlowDirectionKind convertFromXml(FlowDirection xml) {

        if (xml == FlowDirection.FORWARD) {
            return FlowDirectionKind.forward;
        } else if (xml == FlowDirection.LAGGING) {
            return FlowDirectionKind.lagging;
        } else if (xml == FlowDirection.LEADING) {
            return FlowDirectionKind.leading;
        } else if (xml == FlowDirection.NET) {
            return FlowDirectionKind.net;
        } else if (xml == FlowDirection.NONE) {
            return FlowDirectionKind.none;
        } else if (xml == FlowDirection.Q_1_MINUS_Q_4) {
            return FlowDirectionKind.q1minusQ4;
        } else if (xml == FlowDirection.Q_1_PLUS_Q_2) {
            return FlowDirectionKind.q1plusQ2;
        } else if (xml == FlowDirection.Q_1_PLUS_Q_3) {
            return FlowDirectionKind.q1plusQ3;
        } else if (xml == FlowDirection.Q_1_PLUS_Q_4) {
            return FlowDirectionKind.q1plusQ4;
        } else if (xml == FlowDirection.Q_2_MINUS_Q_3) {
            return FlowDirectionKind.q2minusQ3;
        } else if (xml == FlowDirection.Q_2_PLUS_Q_3) {
            return FlowDirectionKind.q2plusQ3;
        } else if (xml == FlowDirection.Q_2_PLUS_Q_4) {
            return FlowDirectionKind.q2plusQ4;
        } else if (xml == FlowDirection.Q_3_MINUS_Q_2) {
            return FlowDirectionKind.q3minusQ2;
        } else if (xml == FlowDirection.Q_3_PLUS_Q_4) {
            return FlowDirectionKind.q3plusQ4;
        } else if (xml == FlowDirection.QUADRANT_1) {
            return FlowDirectionKind.quadrant1;
        } else if (xml == FlowDirection.QUADRANT_2) {
            return FlowDirectionKind.quadrant2;
        } else if (xml == FlowDirection.QUADRANT_3) {
            return FlowDirectionKind.quadrant3;
        } else if (xml == FlowDirection.QUADRANT_4) {
            return FlowDirectionKind.quadrant4;
        } else if (xml == FlowDirection.REVERSE) {
            return FlowDirectionKind.reverse;
        } else if (xml == FlowDirection.TOTAL) {
            return FlowDirectionKind.total;
        } else if (xml == FlowDirection.TOTAL_BY_PHASE) {
            return FlowDirectionKind.totalByPhase;
        } else {
            return null;
        }
    }

    public static PhaseCodeKind convertFromXml(PhaseCode xml) {

        if (xml == PhaseCode.A) {
            return PhaseCodeKind.A;
        } else if (xml == PhaseCode.AB) {
            return PhaseCodeKind.AB;
        } else if (xml == PhaseCode.ABC) {
            return PhaseCodeKind.ABC;
        } else if (xml == PhaseCode.ABCN) {
            return PhaseCodeKind.ABCN;
        } else if (xml == PhaseCode.ABN) {
            return PhaseCodeKind.ABN;
        } else if (xml == PhaseCode.AC) {
            return PhaseCodeKind.AC;
        } else if (xml == PhaseCode.ACN) {
            return PhaseCodeKind.ACN;
        } else if (xml == PhaseCode.AN) {
            return PhaseCodeKind.AN;
        } else if (xml == PhaseCode.B) {
            return PhaseCodeKind.B;
        } else if (xml == PhaseCode.BC) {
            return PhaseCodeKind.BC;
        } else if (xml == PhaseCode.BCN) {
            return PhaseCodeKind.BCN;
        } else if (xml == PhaseCode.BN) {
            return PhaseCodeKind.BN;
        } else if (xml == PhaseCode.C) {
            return PhaseCodeKind.C;
        } else if (xml == PhaseCode.CN) {
            return PhaseCodeKind.CN;
        } else if (xml == PhaseCode.N) {
            return PhaseCodeKind.N;
        } else if (xml == PhaseCode.S_1) {
            return PhaseCodeKind.s1;
        } else if (xml == PhaseCode.S_12) {
            return PhaseCodeKind.s12;
        } else if (xml == PhaseCode.S_12_N) {
            return PhaseCodeKind.s12N;
        } else if (xml == PhaseCode.S_1_N) {
            return PhaseCodeKind.s1N;
        } else if (xml == PhaseCode.S_2) {
            return PhaseCodeKind.s2;
        } else if (xml == PhaseCode.S_2_N) {
            return PhaseCodeKind.s2N;
        } else {
            return null;
        }
    }
}
