
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/capture/mojom/video_capture_types.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class VideoCaptureTransportType {


    public static final int MACOSX_USB_OR_BUILT_IN = 0;

    public static final int OTHER_TRANSPORT = MACOSX_USB_OR_BUILT_IN + 1;

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 1;

    private static final boolean IS_EXTENSIBLE = false;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value))
            return;

        throw new DeserializationException("Invalid enum value.");
    }

    private VideoCaptureTransportType() {}

}