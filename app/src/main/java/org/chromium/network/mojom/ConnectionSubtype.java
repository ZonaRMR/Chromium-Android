
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_change_manager.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ConnectionSubtype {


    public static final int SUBTYPE_UNKNOWN = (int) (0L);

    public static final int SUBTYPE_NONE = SUBTYPE_UNKNOWN + 1;

    public static final int SUBTYPE_OTHER = SUBTYPE_NONE + 1;

    public static final int SUBTYPE_GSM = SUBTYPE_OTHER + 1;

    public static final int SUBTYPE_IDEN = SUBTYPE_GSM + 1;

    public static final int SUBTYPE_CDMA = SUBTYPE_IDEN + 1;

    public static final int SUBTYPE_1XRTT = SUBTYPE_CDMA + 1;

    public static final int SUBTYPE_GPRS = SUBTYPE_1XRTT + 1;

    public static final int SUBTYPE_EDGE = SUBTYPE_GPRS + 1;

    public static final int SUBTYPE_UMTS = SUBTYPE_EDGE + 1;

    public static final int SUBTYPE_EVDO_REV_0 = SUBTYPE_UMTS + 1;

    public static final int SUBTYPE_EVDO_REV_A = SUBTYPE_EVDO_REV_0 + 1;

    public static final int SUBTYPE_HSPA = SUBTYPE_EVDO_REV_A + 1;

    public static final int SUBTYPE_EVDO_REV_B = SUBTYPE_HSPA + 1;

    public static final int SUBTYPE_HSDPA = SUBTYPE_EVDO_REV_B + 1;

    public static final int SUBTYPE_HSUPA = SUBTYPE_HSDPA + 1;

    public static final int SUBTYPE_EHRPD = SUBTYPE_HSUPA + 1;

    public static final int SUBTYPE_HSPAP = SUBTYPE_EHRPD + 1;

    public static final int SUBTYPE_LTE = SUBTYPE_HSPAP + 1;

    public static final int SUBTYPE_LTE_ADVANCED = SUBTYPE_LTE + 1;

    public static final int SUBTYPE_BLUETOOTH_1_2 = SUBTYPE_LTE_ADVANCED + 1;

    public static final int SUBTYPE_BLUETOOTH_2_1 = SUBTYPE_BLUETOOTH_1_2 + 1;

    public static final int SUBTYPE_BLUETOOTH_3_0 = SUBTYPE_BLUETOOTH_2_1 + 1;

    public static final int SUBTYPE_BLUETOOTH_4_0 = SUBTYPE_BLUETOOTH_3_0 + 1;

    public static final int SUBTYPE_ETHERNET = SUBTYPE_BLUETOOTH_4_0 + 1;

    public static final int SUBTYPE_FAST_ETHERNET = SUBTYPE_ETHERNET + 1;

    public static final int SUBTYPE_GIGABIT_ETHERNET = SUBTYPE_FAST_ETHERNET + 1;

    public static final int SUBTYPE_10_GIGABIT_ETHERNET = SUBTYPE_GIGABIT_ETHERNET + 1;

    public static final int SUBTYPE_WIFI_B = SUBTYPE_10_GIGABIT_ETHERNET + 1;

    public static final int SUBTYPE_WIFI_G = SUBTYPE_WIFI_B + 1;

    public static final int SUBTYPE_WIFI_N = SUBTYPE_WIFI_G + 1;

    public static final int SUBTYPE_WIFI_AC = SUBTYPE_WIFI_N + 1;

    public static final int SUBTYPE_WIFI_AD = SUBTYPE_WIFI_AC + 1;

    public static final int SUBTYPE_LAST = ConnectionSubtype.SUBTYPE_WIFI_AD;

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 32;

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
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value))
            return;

        throw new DeserializationException("Invalid enum value.");
    }

    private ConnectionSubtype() {}

}