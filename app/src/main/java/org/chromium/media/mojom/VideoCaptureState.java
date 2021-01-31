
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/capture/mojom/video_capture.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class VideoCaptureState {


    public static final int STARTED = 0;

    public static final int PAUSED = STARTED + 1;

    public static final int RESUMED = PAUSED + 1;

    public static final int STOPPED = RESUMED + 1;

    public static final int FAILED = STOPPED + 1;

    public static final int ENDED = FAILED + 1;

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 5;

    private static final boolean IS_EXTENSIBLE = false;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value))
            return;

        throw new DeserializationException("Invalid enum value.");
    }

    private VideoCaptureState() {}

}