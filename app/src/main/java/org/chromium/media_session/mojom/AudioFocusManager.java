
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/media_session/public/mojom/audio_focus.mojom
//

package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface AudioFocusManager extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends AudioFocusManager, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<AudioFocusManager, AudioFocusManager.Proxy> MANAGER = AudioFocusManager_Internal.MANAGER;


    void requestAudioFocus(
org.chromium.mojo.bindings.InterfaceRequest<AudioFocusRequestClient> client, MediaSession mediaSession, MediaSessionInfo sessionInfo, int type, 
RequestAudioFocusResponse callback);

    interface RequestAudioFocusResponse extends org.chromium.mojo.bindings.Callbacks.Callback0 { }



    void requestGroupedAudioFocus(
org.chromium.mojo.bindings.InterfaceRequest<AudioFocusRequestClient> client, MediaSession mediaSession, MediaSessionInfo sessionInfo, int type, org.chromium.mojo_base.mojom.UnguessableToken groupId, 
RequestGroupedAudioFocusResponse callback);

    interface RequestGroupedAudioFocusResponse extends org.chromium.mojo.bindings.Callbacks.Callback0 { }



    void getFocusRequests(

GetFocusRequestsResponse callback);

    interface GetFocusRequestsResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<AudioFocusRequestState[]> { }



    void addObserver(
AudioFocusObserver observer);



    void setSourceName(
String name);



    void setEnforcementMode(
int mode);


}
