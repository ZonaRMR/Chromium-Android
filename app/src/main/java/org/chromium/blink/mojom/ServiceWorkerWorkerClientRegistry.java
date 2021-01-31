
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/service_worker/service_worker_provider.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface ServiceWorkerWorkerClientRegistry extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends ServiceWorkerWorkerClientRegistry, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<ServiceWorkerWorkerClientRegistry, ServiceWorkerWorkerClientRegistry.Proxy> MANAGER = ServiceWorkerWorkerClientRegistry_Internal.MANAGER;


    void registerWorkerClient(
ServiceWorkerWorkerClient client);



    void cloneWorkerClientRegistry(
org.chromium.mojo.bindings.InterfaceRequest<ServiceWorkerWorkerClientRegistry> host);


}
