
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/restricted_cookie_manager.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface RestrictedCookieManager extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends RestrictedCookieManager, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<RestrictedCookieManager, RestrictedCookieManager.Proxy> MANAGER = RestrictedCookieManager_Internal.MANAGER;


    void getAllForUrl(
org.chromium.url.mojom.Url url, org.chromium.url.mojom.Url siteForCookies, CookieManagerGetOptions options, 
GetAllForUrlResponse callback);

    interface GetAllForUrlResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<CanonicalCookie[]> { }



    void setCanonicalCookie(
CanonicalCookie cookie, org.chromium.url.mojom.Url url, org.chromium.url.mojom.Url siteForCookies, 
SetCanonicalCookieResponse callback);

    interface SetCanonicalCookieResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void addChangeListener(
org.chromium.url.mojom.Url url, org.chromium.url.mojom.Url siteForCookies, CookieChangeListener listener, 
AddChangeListenerResponse callback);

    interface AddChangeListenerResponse extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


}
