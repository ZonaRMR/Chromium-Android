
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/appcache/appcache.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AppCacheEventId {


    public static final int APPCACHE_CHECKING_EVENT = (int) (0L);

    public static final int APPCACHE_ERROR_EVENT = APPCACHE_CHECKING_EVENT + 1;

    public static final int APPCACHE_NO_UPDATE_EVENT = APPCACHE_ERROR_EVENT + 1;

    public static final int APPCACHE_DOWNLOADING_EVENT = APPCACHE_NO_UPDATE_EVENT + 1;

    public static final int APPCACHE_PROGRESS_EVENT = APPCACHE_DOWNLOADING_EVENT + 1;

    public static final int APPCACHE_UPDATE_READY_EVENT = APPCACHE_PROGRESS_EVENT + 1;

    public static final int APPCACHE_CACHED_EVENT = APPCACHE_UPDATE_READY_EVENT + 1;

    public static final int APPCACHE_OBSOLETE_EVENT = APPCACHE_CACHED_EVENT + 1;

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

    private AppCacheEventId() {}

}