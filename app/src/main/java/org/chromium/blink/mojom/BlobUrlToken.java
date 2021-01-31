
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/blob/blob_url_store.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface BlobUrlToken extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends BlobUrlToken, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<BlobUrlToken, BlobUrlToken.Proxy> MANAGER = BlobUrlToken_Internal.MANAGER;


    void clone(
org.chromium.mojo.bindings.InterfaceRequest<BlobUrlToken> token);



    void getToken(

GetTokenResponse callback);

    interface GetTokenResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<org.chromium.mojo_base.mojom.UnguessableToken> { }


}
