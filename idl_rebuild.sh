#/bin/sh

if [ -z "$RTIDDSGEN" ]; then
    echo "Must set RTIDDSGEN"
    exit 1
fi

rm -rf mg-dds-bindings/src/main/java/*
$RTIDDSGEN -d dds-bindings/src/main/java/ -language Java -package org.openfmb.model.dds.rti idl/OpenFMB.idl
