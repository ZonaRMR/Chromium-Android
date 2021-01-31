
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/cookie_store/cookie_store.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface CookieStore extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends CookieStore, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<CookieStore, CookieStore.Proxy> MANAGER = CookieStore_Internal.MANAGER;


    void appendSubscriptions(
long serviceWorkerRegistrationId, CookieChangeSubscription[] subscriptions, 
AppendSubscriptionsResponse callback);

    interface AppendSubscriptionsResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void getSubscriptions(
long serviceWorkerRegistrationId, 
GetSubscriptionsResponse callback);

    interface GetSubscriptionsResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<CookieChangeSubscription[], Boolean> { }


}
