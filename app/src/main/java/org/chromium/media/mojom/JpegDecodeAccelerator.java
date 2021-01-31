
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/jpeg_decode_accelerator.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface JpegDecodeAccelerator extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends JpegDecodeAccelerator, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<JpegDecodeAccelerator, JpegDecodeAccelerator.Proxy> MANAGER = JpegDecodeAccelerator_Internal.MANAGER;


    void initialize(

InitializeResponse callback);

    interface InitializeResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void decode(
BitstreamBuffer inputBuffer, org.chromium.gfx.mojom.Size codedSize, org.chromium.mojo.system.SharedBufferHandle outputHandle, int outputBufferSize, 
DecodeResponse callback);

    interface DecodeResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, Integer> { }



    void decodeWithFd(
int bufferId, org.chromium.mojo.system.UntypedHandle inputFd, int inputBufferSize, int codedSizeWidth, int codedSizeHeight, org.chromium.mojo.system.UntypedHandle outputFd, int outputBufferSize, 
DecodeWithFdResponse callback);

    interface DecodeWithFdResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, Integer> { }



    void uninitialize(
);


}
