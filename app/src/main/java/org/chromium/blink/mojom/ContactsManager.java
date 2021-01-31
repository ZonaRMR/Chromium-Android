
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/contacts/contacts_manager.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface ContactsManager extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends ContactsManager, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<ContactsManager, ContactsManager.Proxy> MANAGER = ContactsManager_Internal.MANAGER;


    void select(
boolean multiple, boolean includeNames, boolean includeEmails, boolean includeTel, 
SelectResponse callback);

    interface SelectResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<ContactInfo[]> { }


}
