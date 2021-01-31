
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/mojom/wake_lock.mojom
//

package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface WakeLock extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends WakeLock, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<WakeLock, WakeLock.Proxy> MANAGER = WakeLock_Internal.MANAGER;


    void requestWakeLock(
);



    void cancelWakeLock(
);



    void addClient(
org.chromium.mojo.bindings.InterfaceRequest<WakeLock> wakeLock);



    void changeType(
int type, 
ChangeTypeResponse callback);

    interface ChangeTypeResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void hasWakeLockForTests(

HasWakeLockForTestsResponse callback);

    interface HasWakeLockForTestsResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


}
