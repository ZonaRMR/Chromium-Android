
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/platform/modules/webshare/webshare.mojom
//

package org.chromium.webshare.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface ShareService extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends ShareService, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<ShareService, ShareService.Proxy> MANAGER = ShareService_Internal.MANAGER;


    void share(
String title, String text, org.chromium.url.mojom.Url url, 
ShareResponse callback);

    interface ShareResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


}
