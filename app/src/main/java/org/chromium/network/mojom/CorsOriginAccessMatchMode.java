
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/cors_origin_pattern.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CorsOriginAccessMatchMode {


    public static final int ALLOW_SUBDOMAINS = 0;

    public static final int ALLOW_REGISTERABLE_DOMAINS = ALLOW_SUBDOMAINS + 1;

    public static final int DISALLOW_SUBDOMAINS = ALLOW_REGISTERABLE_DOMAINS + 1;

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 2;

    private static final boolean IS_EXTENSIBLE = false;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value))
            return;

        throw new DeserializationException("Invalid enum value.");
    }

    private CorsOriginAccessMatchMode() {}

}