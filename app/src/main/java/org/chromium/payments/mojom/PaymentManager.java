
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/payments/payment_app.mojom
//

package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface PaymentManager extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends PaymentManager, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<PaymentManager, PaymentManager.Proxy> MANAGER = PaymentManager_Internal.MANAGER;


    void init(
org.chromium.url.mojom.Url contextUrl, String serviceWorkerScope);



    void deletePaymentInstrument(
String instrumentKey, 
DeletePaymentInstrumentResponse callback);

    interface DeletePaymentInstrumentResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }



    void getPaymentInstrument(
String instrumentKey, 
GetPaymentInstrumentResponse callback);

    interface GetPaymentInstrumentResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<PaymentInstrument, Integer> { }



    void keysOfPaymentInstruments(

KeysOfPaymentInstrumentsResponse callback);

    interface KeysOfPaymentInstrumentsResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<String[], Integer> { }



    void hasPaymentInstrument(
String instrumentKey, 
HasPaymentInstrumentResponse callback);

    interface HasPaymentInstrumentResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }



    void setPaymentInstrument(
String instrumentKey, PaymentInstrument instrument, 
SetPaymentInstrumentResponse callback);

    interface SetPaymentInstrumentResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }



    void clearPaymentInstruments(

ClearPaymentInstrumentsResponse callback);

    interface ClearPaymentInstrumentsResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }



    void setUserHint(
String userHint);


}
