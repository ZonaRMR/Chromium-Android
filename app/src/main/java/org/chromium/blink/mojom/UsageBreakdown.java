
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/quota/quota_types.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public final class UsageBreakdown extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 64;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(64, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public long fileSystem;
    public long webSql;
    public long appcache;
    public long indexedDatabase;
    public long serviceWorkerCache;
    public long serviceWorker;
    public long backgroundFetch;

    private UsageBreakdown(int version) {
        super(STRUCT_SIZE, version);
        this.fileSystem = 0L;
        this.webSql = 0L;
        this.appcache = 0L;
        this.indexedDatabase = 0L;
        this.serviceWorkerCache = 0L;
        this.serviceWorker = 0L;
        this.backgroundFetch = 0L;
    }

    public UsageBreakdown() {
        this(0);
    }

    public static UsageBreakdown deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static UsageBreakdown deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static UsageBreakdown decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        UsageBreakdown result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new UsageBreakdown(elementsOrVersion);
                {
                    
                result.fileSystem = decoder0.readLong(8);
                }
                {
                    
                result.webSql = decoder0.readLong(16);
                }
                {
                    
                result.appcache = decoder0.readLong(24);
                }
                {
                    
                result.indexedDatabase = decoder0.readLong(32);
                }
                {
                    
                result.serviceWorkerCache = decoder0.readLong(40);
                }
                {
                    
                result.serviceWorker = decoder0.readLong(48);
                }
                {
                    
                result.backgroundFetch = decoder0.readLong(56);
                }

        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
        org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        
        encoder0.encode(this.fileSystem, 8);
        
        encoder0.encode(this.webSql, 16);
        
        encoder0.encode(this.appcache, 24);
        
        encoder0.encode(this.indexedDatabase, 32);
        
        encoder0.encode(this.serviceWorkerCache, 40);
        
        encoder0.encode(this.serviceWorker, 48);
        
        encoder0.encode(this.backgroundFetch, 56);
    }
}