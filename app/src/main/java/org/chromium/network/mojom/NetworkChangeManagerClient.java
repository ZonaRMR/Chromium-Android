
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_change_manager.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface NetworkChangeManagerClient extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends NetworkChangeManagerClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<NetworkChangeManagerClient, NetworkChangeManagerClient.Proxy> MANAGER = NetworkChangeManagerClient_Internal.MANAGER;


    void onInitialConnectionType(
int type);



    void onNetworkChanged(
int type);


}
