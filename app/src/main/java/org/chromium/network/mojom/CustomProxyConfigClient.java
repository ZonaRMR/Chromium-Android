
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_context.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface CustomProxyConfigClient extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends CustomProxyConfigClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<CustomProxyConfigClient, CustomProxyConfigClient.Proxy> MANAGER = CustomProxyConfigClient_Internal.MANAGER;


    void onCustomProxyConfigUpdated(
CustomProxyConfig proxyConfig);



    void markProxiesAsBad(
org.chromium.mojo_base.mojom.TimeDelta bypassDuration, ProxyList badProxies, 
MarkProxiesAsBadResponse callback);

    interface MarkProxiesAsBadResponse extends org.chromium.mojo.bindings.Callbacks.Callback0 { }



    void clearBadProxiesCache(
);


}
