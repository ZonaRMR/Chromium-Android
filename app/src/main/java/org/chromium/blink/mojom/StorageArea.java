
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/dom_storage/storage_area.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface StorageArea extends org.chromium.mojo.bindings.Interface {


    
    int PER_STORAGE_AREA_QUOTA = (int) 10485760L;



    
    int PER_STORAGE_AREA_OVER_QUOTA_ALLOWANCE = (int) 102400L;




    interface Proxy extends StorageArea, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<StorageArea, StorageArea.Proxy> MANAGER = StorageArea_Internal.MANAGER;


    void addObserver(
org.chromium.mojo.bindings.AssociatedInterfaceNotSupported observer);



    void put(
byte[] key, byte[] value, byte[] clientOldValue, String source, 
PutResponse callback);

    interface PutResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void delete(
byte[] key, byte[] clientOldValue, String source, 
DeleteResponse callback);

    interface DeleteResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void deleteAll(
String source, 
DeleteAllResponse callback);

    interface DeleteAllResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void get(
byte[] key, 
GetResponse callback);

    interface GetResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Boolean, byte[]> { }



    void getAll(
org.chromium.mojo.bindings.AssociatedInterfaceNotSupported completeCallback, 
GetAllResponse callback);

    interface GetAllResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Boolean, KeyValue[]> { }


}
