
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


public interface PaymentHandlerResponseCallback extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends PaymentHandlerResponseCallback, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<PaymentHandlerResponseCallback, PaymentHandlerResponseCallback.Proxy> MANAGER = PaymentHandlerResponseCallback_Internal.MANAGER;


    void onResponseForAbortPayment(
boolean paymentAborted);



    void onResponseForCanMakePayment(
boolean canMakePayment);



    void onResponseForPaymentRequest(
PaymentHandlerResponse response);


}
