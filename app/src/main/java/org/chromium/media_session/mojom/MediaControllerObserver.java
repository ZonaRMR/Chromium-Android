
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/media_session/public/mojom/media_controller.mojom
//

package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface MediaControllerObserver extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends MediaControllerObserver, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<MediaControllerObserver, MediaControllerObserver.Proxy> MANAGER = MediaControllerObserver_Internal.MANAGER;


    void mediaSessionInfoChanged(
MediaSessionInfo info);



    void mediaSessionMetadataChanged(
MediaMetadata metadata);



    void mediaSessionActionsChanged(
int[] action);


}
