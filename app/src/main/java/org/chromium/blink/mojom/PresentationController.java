
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/presentation/presentation.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface PresentationController extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends PresentationController, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<PresentationController, PresentationController.Proxy> MANAGER = PresentationController_Internal.MANAGER;


    void onScreenAvailabilityUpdated(
org.chromium.url.mojom.Url url, int availability);



    void onDefaultPresentationStarted(
PresentationConnectionResult result);



    void onConnectionStateChanged(
PresentationInfo presentationInfo, int newState);



    void onConnectionClosed(
PresentationInfo presentationInfo, int reason, String message);


}
