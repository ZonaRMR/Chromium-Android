
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/appcache/appcache.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface AppCacheFrontend extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends AppCacheFrontend, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<AppCacheFrontend, AppCacheFrontend.Proxy> MANAGER = AppCacheFrontend_Internal.MANAGER;


    void cacheSelected(
int hostId, AppCacheInfo info);



    void statusChanged(
int[] hostIds, int status);



    void eventRaised(
int[] hostIds, int eventId);



    void progressEventRaised(
int[] hostIds, org.chromium.url.mojom.Url url, int total, int complete);



    void errorEventRaised(
int[] hostIds, AppCacheErrorDetails errorDetails);



    void logMessage(
int hostId, int logLevel, String message);



    void contentBlocked(
int hostId, org.chromium.url.mojom.Url manifestUrl);



    void setSubresourceFactory(
int hostId, org.chromium.network.mojom.UrlLoaderFactory urlLoaderFactory);


}
