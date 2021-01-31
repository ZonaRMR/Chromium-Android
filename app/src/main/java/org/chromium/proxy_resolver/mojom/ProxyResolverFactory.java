
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/proxy_resolver/public/mojom/proxy_resolver.mojom
//

package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface ProxyResolverFactory extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends ProxyResolverFactory, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<ProxyResolverFactory, ProxyResolverFactory.Proxy> MANAGER = ProxyResolverFactory_Internal.MANAGER;


    void createResolver(
String pacScript, org.chromium.mojo.bindings.InterfaceRequest<ProxyResolver> resolver, ProxyResolverFactoryRequestClient client);


}
