
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     skia/public/interfaces/image_info.mojom
//

package org.chromium.skia.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ColorType {


    public static final int UNKNOWN = 0;

    public static final int ALPHA_8 = UNKNOWN + 1;

    public static final int RGB_565 = ALPHA_8 + 1;

    public static final int ARGB_4444 = RGB_565 + 1;

    public static final int RGBA_8888 = ARGB_4444 + 1;

    public static final int BGRA_8888 = RGBA_8888 + 1;

    public static final int INDEX_8 = BGRA_8888 + 1;

    public static final int GRAY_8 = INDEX_8 + 1;

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 7;

    private static final boolean IS_EXTENSIBLE = false;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value))
            return;

        throw new DeserializationException("Invalid enum value.");
    }

    private ColorType() {}

}