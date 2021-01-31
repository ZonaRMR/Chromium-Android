
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/background_fetch/background_fetch.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public final class BackgroundFetchRegistration extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 64;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(64, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String developerId;
    public String uniqueId;
    public long uploadTotal;
    public long uploaded;
    public long downloadTotal;
    public long downloaded;
    public int result;
    public int failureReason;

    private BackgroundFetchRegistration(int version) {
        super(STRUCT_SIZE, version);
        this.result = BackgroundFetchResult.UNSET;
        this.failureReason = BackgroundFetchFailureReason.NONE;
    }

    public BackgroundFetchRegistration() {
        this(0);
    }

    public static BackgroundFetchRegistration deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static BackgroundFetchRegistration deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static BackgroundFetchRegistration decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        BackgroundFetchRegistration result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new BackgroundFetchRegistration(elementsOrVersion);
                {
                    
                result.developerId = decoder0.readString(8, false);
                }
                {
                    
                result.uniqueId = decoder0.readString(16, false);
                }
                {
                    
                result.uploadTotal = decoder0.readLong(24);
                }
                {
                    
                result.uploaded = decoder0.readLong(32);
                }
                {
                    
                result.downloadTotal = decoder0.readLong(40);
                }
                {
                    
                result.downloaded = decoder0.readLong(48);
                }
                {
                    
                result.result = decoder0.readInt(56);
                    BackgroundFetchResult.validate(result.result);
                }
                {
                    
                result.failureReason = decoder0.readInt(60);
                    BackgroundFetchFailureReason.validate(result.failureReason);
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
        
        encoder0.encode(this.developerId, 8, false);
        
        encoder0.encode(this.uniqueId, 16, false);
        
        encoder0.encode(this.uploadTotal, 24);
        
        encoder0.encode(this.uploaded, 32);
        
        encoder0.encode(this.downloadTotal, 40);
        
        encoder0.encode(this.downloaded, 48);
        
        encoder0.encode(this.result, 56);
        
        encoder0.encode(this.failureReason, 60);
    }
}