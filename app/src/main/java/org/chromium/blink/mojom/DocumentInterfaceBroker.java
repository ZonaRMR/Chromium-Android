
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/frame/document_interface_broker.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface DocumentInterfaceBroker extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends DocumentInterfaceBroker, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<DocumentInterfaceBroker, DocumentInterfaceBroker.Proxy> MANAGER = DocumentInterfaceBroker_Internal.MANAGER;


    void getFrameHostTestInterface(
org.chromium.mojo.bindings.InterfaceRequest<FrameHostTestInterface> request);


}
