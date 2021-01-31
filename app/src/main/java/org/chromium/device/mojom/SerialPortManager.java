
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/mojom/serial.mojom
//

package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface SerialPortManager extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends SerialPortManager, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<SerialPortManager, SerialPortManager.Proxy> MANAGER = SerialPortManager_Internal.MANAGER;


    void getDevices(

GetDevicesResponse callback);

    interface GetDevicesResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<SerialPortInfo[]> { }



    void getPort(
org.chromium.mojo_base.mojom.UnguessableToken token, org.chromium.mojo.bindings.InterfaceRequest<SerialPort> portRequest);


}
