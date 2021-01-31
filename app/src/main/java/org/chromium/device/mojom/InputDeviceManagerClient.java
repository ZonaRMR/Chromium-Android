
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/mojom/input_service.mojom
//

package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface InputDeviceManagerClient extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends InputDeviceManagerClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<InputDeviceManagerClient, InputDeviceManagerClient.Proxy> MANAGER = InputDeviceManagerClient_Internal.MANAGER;


    void inputDeviceAdded(
InputDeviceInfo deviceInfo);



    void inputDeviceRemoved(
String id);


}
