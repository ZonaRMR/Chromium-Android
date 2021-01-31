
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/payments/payment_request.mojom
//

package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PaymentErrorReason {


    public static final int UNKNOWN = 0;

    public static final int USER_CANCEL = UNKNOWN + 1;

    public static final int NOT_SUPPORTED = USER_CANCEL + 1;

    public static final int ALREADY_SHOWING = NOT_SUPPORTED + 1;

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 3;

    private static final boolean IS_EXTENSIBLE = false;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value))
            return;

        throw new DeserializationException("Invalid enum value.");
    }

    private PaymentErrorReason() {}

}